package com.nsdata.rest.food;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String hotel;
	private String foodName;
	private String foodType;
	private String foodDescription;
	private String prize;
	private boolean isAvailable;

	public Food() {
	}

	public Food(Long id, String hotel, String foodname, String foodtype, String fooddescription, String prize,
			boolean isAvailable) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.foodName = foodname;
		this.foodType = foodtype;
		this.foodDescription = fooddescription;
		this.prize = prize;
		this.isAvailable = isAvailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodname(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodtype(String foodType) {
		this.foodType = foodType;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFooddescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", hotel=" + hotel + ", foodname=" + foodName + ", foodtype=" + foodType
				+ ", fooddescription=" + foodDescription + ", prize=" + prize + ", isAvailable=" + isAvailable + "]";
	}

}
