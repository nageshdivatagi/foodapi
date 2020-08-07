package com.nsdata.rest.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author nagesh.divatagi
 *
 * @CreateDate 06-Aug-2020 9:47:23 pm
 * @FileNam UsersHardcodedService.java
 */

@Service
public class UsersHardcodedService {

	private static List<Users> users = new ArrayList<>();
	private static long idCounter = 0;

	static {

		/*
		 * users.add(index, element);
		 * users.add(++idCounter,"","","","","","",0,0,false,false,new Date(),new
		 * Date(),new Date(),0,new Date(),new Date());
		 */
		// Long userId, String username, String password, String firstname, String
		// lastname, String emailId,
		// String mobileNo, int genderId, int roleId, boolean tempBlock, boolean block,
		// Date tempblockDate,
		// Date blockDate, Date passwordChangeDate, int addUser, Date lastLoggedIn, Date
		// addedDate
	}

}
