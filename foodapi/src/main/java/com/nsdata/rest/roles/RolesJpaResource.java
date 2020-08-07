package com.nsdata.rest.roles;

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

@CrossOrigin(origins = "${angular.url}")
@RestController
public class RolesJpaResource {

	/*
	 * @Autowired private UsersHardcodedService todoService;
	 */
	BcryptEncoder be = new BcryptEncoder();
	@Autowired
	private RolesJpaRepository rolesJpaRepository;

	@GetMapping("/jpa/users/{username}/roles")
	public List<Roles> getAllRoles(@PathVariable String username) {
		return rolesJpaRepository.findAll();
		// return todoService.findAll();
	}

	@GetMapping("/jpa/users/{username}/roles/{roleid}")
	public Roles getUser(@PathVariable String username, @PathVariable long roleid) {
		return rolesJpaRepository.findById(roleid).get();
		// return todoService.findById(id);
	}

	// DELETE /users/{username}/todos/{id}
	@DeleteMapping("/jpa/users/{username}/roles/{roleid}")
	public ResponseEntity<Void> deleteUser(@PathVariable String username, @PathVariable long roleid) {

		// User user = todoService.deleteById(id);
		rolesJpaRepository.deleteById(roleid);

		return ResponseEntity.noContent().build();
		// return ResponseEntity.notFound().build();
	}

	// Edit/Update a User
	// PUT /users/{user_name}/users/{user_id}
	@PutMapping("/jpa/users/{username}/roles/{roleid}")
	public ResponseEntity<Roles> updateUser(@PathVariable String username, @PathVariable long roleid,
			@RequestBody Roles roles) {
		
		Roles rolesUpdated = rolesJpaRepository.save(roles);

		return new ResponseEntity<Roles>(rolesUpdated, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{username}/roles")
	public ResponseEntity<Void> createUser(@PathVariable String username, @RequestBody Roles roles) {
		Long NoofCount = rolesJpaRepository.count();
		roles.setRoleid(NoofCount+1);
		Roles createdRoles = rolesJpaRepository.save(roles);
		// Location
		// Get current resource url
		// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{roleid}")
				.buildAndExpand(createdRoles.getRoleid()).toUri();

		return ResponseEntity.created(uri).build();

	}

}
