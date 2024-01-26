package com.policyfinder.exception;

import static com.policyfinder.utils.MasterData.getPolicyDTO;
import static com.policyfinder.utils.TestUtils.currentTest;
import static com.policyfinder.utils.TestUtils.exceptionTestFile;
import static com.policyfinder.utils.TestUtils.testReport;
import static com.policyfinder.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.policyfinder.controller.PolicyController;
import com.policyfinder.dto.PolicyDTO;
import com.policyfinder.service.PolicyService;
import com.policyfinder.utils.MasterData;

@WebMvcTest(PolicyController.class)
@AutoConfigureMockMvc
public class PolicyExceptionTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PolicyService policyService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCreatePolicyInvalidDataException() throws Exception {
		PolicyDTO policyDTO = getPolicyDTO();
		policyDTO.setName(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/policies")
				.content(MasterData.asJsonString(policyDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testUpdatePolicyInvalidDataException() throws Exception {
		PolicyDTO policyDTO = getPolicyDTO();
		policyDTO.setName(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/policies/" + policyDTO.getId())
				.content(MasterData.asJsonString(policyDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testGetPolicyByIdResourceNotFoundException() throws Exception {
		PolicyDTO policyDTO = getPolicyDTO();
		ErrorResponse exResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Policy not found");

		when(this.policyService.getPolicyById(policyDTO.getId()))
				.thenThrow(new ResourceNotFoundException("Policy not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/policies/" + policyDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
	}
}
