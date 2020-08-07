package com.nsdata.rest.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author nagesh.divatagi
 *
 *@CreateDate 06-Aug-2020 9:47:23 pm
 *@FileNam UsersJpaRepository.java
 */
@Repository
public interface UsersJpaRepository extends JpaRepository<Users, Long> {

	List<Users> findByUserId(Long userId);

	Users findByUsername(String username);

}
