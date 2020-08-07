package com.nsdata.rest.food;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

	@Autowired
	private FoodJpaRepository foodJpaRepository;

	public List<Food> findByHotelName(String restorentname) {

		return foodJpaRepository.findAll(new Specification<Food>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Food> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (restorentname != null) {
					predicates.add((Predicate) criteriaBuilder
							.and(criteriaBuilder.equal(root.get("hotel"), restorentname)));

				}

				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}

}
