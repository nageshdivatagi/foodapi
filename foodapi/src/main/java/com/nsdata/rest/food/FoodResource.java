package com.nsdata.rest.food;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.nsdata.rest.roles.Roles;

@CrossOrigin(origins = "${angular.url}")
@RestController
public class FoodResource {

	@Autowired
	private FoodJpaRepository foodJpaRepository;
	
	@Autowired
	private FoodService foodService;

	@Autowired
	private OrderJpaRepository orderJpaRepository;

	@GetMapping("/jpa/users/{username}/food")
	public List<Food> getAllFood(@PathVariable String username) {
		return foodJpaRepository.findAll();
	}

	@GetMapping("/jpa/users/{username}/getfoodlist/{hotelname}")
	public List<Food> getFoodByHotel(@PathVariable String username, @PathVariable String hotelname) {
		return foodService.findByHotelName(hotelname);
	}

	@GetMapping("/jpa/users/{username}/food/{id}")
	public Optional<Food> getFood(@PathVariable String username, @PathVariable long id) {
		return foodJpaRepository.findById(id);
	}

	// DELETE /users/{username}/food/{id}
	@DeleteMapping("/jpa/users/{username}/food/{id}")
	public ResponseEntity<Void> deleteFood(@PathVariable String username, @PathVariable long id) {

		/*
		 * Food food = foodJpaRepository.deleteById(id);
		 * 
		 * if (food != null) { return ResponseEntity.noContent().build(); }
		 */

		return ResponseEntity.notFound().build();
	}

	// Edit/Update a Food
	// PUT /users/{user_name}/food/{todo_id}
	@PutMapping("/jpa/users/{username}/food/{id}")
	public ResponseEntity<Food> updateFood(@PathVariable String username, @PathVariable long id,
			@RequestBody Food food) {
		food.setId(id);
		Food foodUpdated = foodJpaRepository.save(food);

		return new ResponseEntity<Food>(foodUpdated, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{username}/order/{id}")
	public ResponseEntity<Orders> orderFood(@PathVariable String username, @PathVariable long id,
			@RequestBody Orders order) {
		order.setId(id);
		order.setCustomername(username);
		Orders createdOrder = orderJpaRepository.save(order);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdOrder.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/jpa/users/{username}/order/{id}")
	public Optional<Food> getOrderList(@PathVariable String username, @PathVariable long id,
			@RequestBody Orders order) {
		return foodJpaRepository.findById(id);
	}

	@PostMapping("/jpa/users/{username}/food")
	public ResponseEntity<Void> createFood(@PathVariable String username, @RequestBody Food food) {
		Long NoofCount = foodJpaRepository.count();
		food.setId(NoofCount + 1);
		Food createdFood = foodJpaRepository.save(food);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdFood.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
