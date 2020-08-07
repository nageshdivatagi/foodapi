package com.nsdata.rest.pages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagesJpaRepository extends JpaRepository<Pages, Long> {

	Pages findByPageid(Long pageid);

	Pages findByPagename(String pagename);

}
