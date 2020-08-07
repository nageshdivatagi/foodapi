package com.nsdata.rest.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nsdata.rest.roles.Roles;
import com.nsdata.rest.roles.RolesJpaRepository;
import com.nsdata.rest.users.Users;
import com.nsdata.rest.users.UsersJpaRepository;

/**
 * @author nagesh.divatagi
 *
 *@CreateDate 06-Aug-2020 9:33:08 pm
 *@FileNam JwtInMemoryUserDetailsService.java
 */

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	@Autowired
	private UsersJpaRepository userRepository;
	@Autowired
	private RolesJpaRepository rolesRopository;
	JwtUserDetails jwtUserDetails;
	/*
	 * static { inMemoryUserList.add(new JwtUserDetails(1L, "nagesh",
	 * "$2a$10$8DMI8rBKqn4ompY8yVz/euqxDrFLrw/8/B/6NywZJo2twTfsv2Yqu",
	 * "ROLE_USER_2")); inMemoryUserList.add(new JwtUserDetails(2L, "user",
	 * "$2a$10$8DMI8rBKqn4ompY8yVz/euqxDrFLrw/8/B/6NywZJo2twTfsv2Yqu",
	 * "ROLE_USER_2"));
	 * 
	 * //$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm }
	 */

	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepository.findByUsername(username);
		Roles roles = rolesRopository.findByRoleid((long) users.getRoleId());
		String RoleName = roles.getRolename();
		if(!users.isBlock() ) {
			inMemoryUserList.add(new JwtUserDetails(users.getUserId(), users.getUsername(), users.getPassword(), RoleName));
		}else {
			
			throw new UsernameNotFoundException(String.format("This User is Blocked Please Contact Admistator '%s'.", username));
		}
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
