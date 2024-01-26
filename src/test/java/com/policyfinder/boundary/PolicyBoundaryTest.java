package com.policyfinder.boundary;

import static com.policyfinder.utils.TestUtils.boundaryTestFile;
import static com.policyfinder.utils.TestUtils.currentTest;
import static com.policyfinder.utils.TestUtils.testReport;
import static com.policyfinder.utils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.policyfinder.dto.PolicyDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class PolicyBoundaryTest {

	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testNameNotBlank() throws IOException {
		PolicyDTO policyDTO = new PolicyDTO();
		policyDTO.setName("");
		Set<ConstraintViolation<PolicyDTO>> violations = validator.validate(policyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testTenureNotNull() throws IOException {
		PolicyDTO policyDTO = new PolicyDTO();
		policyDTO.setTenure(null);
		Set<ConstraintViolation<PolicyDTO>> violations = validator.validate(policyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testAmountNotNull() throws IOException {
		PolicyDTO policyDTO = new PolicyDTO();
		policyDTO.setAmount(null);
		Set<ConstraintViolation<PolicyDTO>> violations = validator.validate(policyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testInterestRateNotNull() throws IOException {
		PolicyDTO policyDTO = new PolicyDTO();
		policyDTO.setInterestRate(null);
		Set<ConstraintViolation<PolicyDTO>> violations = validator.validate(policyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testCoverageNotBlank() throws IOException {
		PolicyDTO policyDTO = new PolicyDTO();
		policyDTO.setCoverage("");
		Set<ConstraintViolation<PolicyDTO>> violations = validator.validate(policyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}
}
