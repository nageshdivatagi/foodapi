package com.nsdata.rest.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesJpaRepository extends JpaRepository<Roles, Long> {

	Roles findByRoleid(Long roleid);

	Roles findByRolename(String rolename);

}
