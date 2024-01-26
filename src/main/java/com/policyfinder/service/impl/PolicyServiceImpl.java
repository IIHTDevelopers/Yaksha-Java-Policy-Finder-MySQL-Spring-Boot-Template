package com.policyfinder.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.policyfinder.dto.PolicyDTO;
import com.policyfinder.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Override
	public PolicyDTO createPolicy(PolicyDTO policyDTO) {
		// write your logic here
		return null;
	}

	@Override
	public PolicyDTO getPolicyById(Long id) {
		// write your logic here
		return null;
	}

	@Override
	public List<PolicyDTO> getAllPolicies() {
		// write your logic here
		return null;
	}

	@Override
	public PolicyDTO updatePolicy(Long id, PolicyDTO policyDTO) {
		// write your logic here
		return null;
	}

	@Override
	public boolean deletePolicy(Long id) {
		// write your logic here
		return false;
	}

	@Override
	public List<PolicyDTO> searchPoliciesByName(String name) {
		// write your logic here
		return null;
	}

	@Override
	public List<PolicyDTO> searchPoliciesByCoverage(String coverage) {
		// write your logic here
		return null;
	}
}
