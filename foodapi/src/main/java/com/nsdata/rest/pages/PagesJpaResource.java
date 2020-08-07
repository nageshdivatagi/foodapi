package com.nsdata.rest.pages;

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
public class PagesJpaResource {

	/*
	 * @Autowired private UsersHardcodedService todoService;
	 */
	BcryptEncoder be = new BcryptEncoder();
	@Autowired
	private PagesJpaRepository rolesJpaRepository;

	@GetMapping("/jpa/users/{username}/pages")
	public List<Pages> getAllRoles(@PathVariable String username) {
		return rolesJpaRepository.findAll();
		// return todoService.findAll();
	}

	@GetMapping("/jpa/users/{username}/pages/{pageid}")
	public Pages getUser(@PathVariable String username, @PathVariable long pageid) {
		return rolesJpaRepository.findById(pageid).get();
		// return todoService.findById(id);
	}

	// DELETE /users/{username}/todos/{id}
	@DeleteMapping("/jpa/users/{username}/pages/{pageid}")
	public ResponseEntity<Void> deleteUser(@PathVariable String username, @PathVariable long pageid) {

		// User user = todoService.deleteById(id);
		rolesJpaRepository.deleteById(pageid);

		return ResponseEntity.noContent().build();
		// return ResponseEntity.notFound().build();
	}

	// Edit/Update a User
	// PUT /users/{user_name}/users/{user_id}
	@PutMapping("/jpa/users/{username}/pages/{pageid}")
	public ResponseEntity<Pages> updateUser(@PathVariable String username, @PathVariable long pageid,
			@RequestBody Pages pages) {
		pages.setPageid(pageid);
		Pages rolesUpdated = rolesJpaRepository.save(pages);

		return new ResponseEntity<Pages>(rolesUpdated, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{username}/pages")
	public ResponseEntity<Void> createUser(@PathVariable String username, @RequestBody Pages pages) {

		Pages createdRoles = rolesJpaRepository.save(pages);
		// Location
		// Get current resource url
		// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{roleid}")
				.buildAndExpand(createdRoles.getPageid()).toUri();

		return ResponseEntity.created(uri).build();

	}

}
