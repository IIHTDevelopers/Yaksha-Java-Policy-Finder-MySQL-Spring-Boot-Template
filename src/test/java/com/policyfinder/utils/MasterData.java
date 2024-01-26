package com.policyfinder.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.policyfinder.dto.PolicyDTO;

public class MasterData {

	public static PolicyDTO getPolicyDTO() {
		PolicyDTO policyDTO = new PolicyDTO();
		policyDTO.setId(1L);
		policyDTO.setName("Life Insurance");
		policyDTO.setTenure(24);
		policyDTO.setAmount(100000.0);
		policyDTO.setInterestRate(5.0);
		policyDTO.setCoverage("Life cover");

		return policyDTO;
	}

	public static List<PolicyDTO> getPolicyDTOList() {
		List<PolicyDTO> policyDTOList = new ArrayList<>();

		PolicyDTO policyDTO = new PolicyDTO();
		policyDTO.setId(1L);
		policyDTO.setName("Life Insurance");
		policyDTO.setTenure(24);
		policyDTO.setAmount(100000.0);
		policyDTO.setInterestRate(5.0);
		policyDTO.setCoverage("Life cover");

		policyDTOList.add(policyDTO);

		return policyDTOList;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String randomStringWithSize(int size) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < size; i++) {
			s.append("A");
		}
		return s.toString();
	}
}
