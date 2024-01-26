package com.policyfinder.service;

import java.util.List;

import com.policyfinder.dto.PolicyDTO;

public interface PolicyService {
	PolicyDTO createPolicy(PolicyDTO policyDTO);

	PolicyDTO getPolicyById(Long id);

	List<PolicyDTO> getAllPolicies();

	PolicyDTO updatePolicy(Long id, PolicyDTO policyDTO);

	boolean deletePolicy(Long id);

	List<PolicyDTO> searchPoliciesByName(String name);

	List<PolicyDTO> searchPoliciesByCoverage(String coverage);
}
