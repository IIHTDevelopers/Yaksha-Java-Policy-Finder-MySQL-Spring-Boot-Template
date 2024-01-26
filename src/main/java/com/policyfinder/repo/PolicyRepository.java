package com.policyfinder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policyfinder.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
	// write your logic here
}
