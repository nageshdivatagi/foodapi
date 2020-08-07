package com.nsdata.rest.users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nsdata.rest.BcryptEncoder;
/**
 * @author nagesh.divatagi
 *
 *@CreateDate 06-Aug-2020 9:47:23 pm
 *@FileNam UsersJpaResource.java
 */
@CrossOrigin(origins = "${angular.url}")
@RestController
public class UsersJpaResource {

	/*
	 * @Autowired private UsersHardcodedService todoService;
	 */
	BcryptEncoder be = new BcryptEncoder();
	@Autowired
	private UsersJpaRepository userJpaRepository;

	@GetMapping("/jpa/users/{username}/user")
	public List<Users> getAllUsers(@PathVariable String username) {
		return userJpaRepository.findAll();
		// return todoService.findAll();
	}

	@GetMapping("/jpa/users/{username}/user/{id}")
	public Users getUser(@PathVariable String username, @PathVariable long id) {
		return userJpaRepository.findById(id).get();
		// return todoService.findById(id);
	}

	// DELETE /users/{username}/todos/{id}
	@DeleteMapping("/jpa/users/{username}/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String username, @PathVariable long id) {

		// User user = todoService.deleteById(id);
		userJpaRepository.deleteById(id);

		return ResponseEntity.noContent().build();
		// return ResponseEntity.notFound().build();
	}

	// Edit/Update a User
	// PUT /users/{user_name}/users/{user_id}
	@PutMapping("/jpa/users/{username}/user/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable String username, @PathVariable long id,
			@RequestBody Users user) {
		user.setUserId(id);
		user.setPassword(be.getBcryptEncoderPassword(user.getPassword()));
		Users userUpdated = userJpaRepository.save(user);

		return new ResponseEntity<Users>(userUpdated, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{username}/user")
	public ResponseEntity<Void> createUser(@PathVariable String username, @RequestBody Users user) {

		Long NoofCount = userJpaRepository.count();
		user.setUserId(NoofCount + 1);
		user.setPassword(be.getBcryptEncoderPassword(user.getPassword()));

		Users createdUsers = userJpaRepository.save(user); // Location
		// Get current resource url
		// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUsers.getUserId()).toUri();

		/*
		 * Long NoofCount = userJpaRepository.count(); user.setUserId(NoofCount+1);
		 * user.setPassword(be.getBcryptEncoderPassword(user.getPassword()));
		 * SessionFactory sessionFactory = new
		 * Configuration().configure().buildSessionFactory(); Session session =
		 * sessionFactory.openSession();
		 * 
		 * session.beginTransaction(); session.save(user);
		 * session.getTransaction().commit(); // {id} URI uri =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		 * .buildAndExpand(createdUsers.getUserId()).toUri();
		 */
		return ResponseEntity.created(uri).build();

	}

}
