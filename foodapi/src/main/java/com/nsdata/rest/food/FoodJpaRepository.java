package com.nsdata.rest.food;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodJpaRepository extends JpaRepository<Food, Long>, JpaSpecificationExecutor<Food> {


	
	public Optional<Food> findById(Long id);
	
	public List<Food> findByHotel(String hotelname);
	
}
