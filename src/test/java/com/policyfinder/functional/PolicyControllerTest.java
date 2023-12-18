package com.policyfinder.functional;

import static com.policyfinder.utils.MasterData.getPolicyDTO;
import static com.policyfinder.utils.MasterData.getPolicyDTOList;
import static com.policyfinder.utils.TestUtils.asJsonString;
import static com.policyfinder.utils.TestUtils.businessTestFile;
import static com.policyfinder.utils.TestUtils.currentTest;
import static com.policyfinder.utils.TestUtils.testReport;
import static com.policyfinder.utils.TestUtils.yakshaAssert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.policyfinder.controller.PolicyController;
import com.policyfinder.dto.PolicyDTO;
import com.policyfinder.service.PolicyService;

@WebMvcTest(PolicyController.class)
@AutoConfigureMockMvc
public class PolicyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PolicyService policyService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetAllPolicies() throws Exception {
		List<PolicyDTO> policyDTOs = getPolicyDTOList();

		when(this.policyService.getAllPolicies()).thenReturn(policyDTOs);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/policies").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(policyDTOs)) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testGetPolicyById() throws Exception {
		PolicyDTO policyDTO = getPolicyDTO();
		when(this.policyService.getPolicyById(policyDTO.getId())).thenReturn(policyDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/policies/" + policyDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(policyDTO)) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testCreatePolicy() throws Exception {
		PolicyDTO policyDTO = getPolicyDTO();

		when(this.policyService.createPolicy(any())).thenReturn(policyDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/policies").content(asJsonString(policyDTO))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		System.out.println("======");
		System.out.println(asJsonString(policyDTO));
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(policyDTO)) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testUpdatePolicy() throws Exception {
		PolicyDTO policyDTO = getPolicyDTO();

		when(this.policyService.updatePolicy(eq(policyDTO.getId()), any())).thenReturn(policyDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/policies/" + policyDTO.getId())
				.content(asJsonString(policyDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(policyDTO)) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testDeletePolicy() throws Exception {
		PolicyDTO policyDTO = getPolicyDTO();
		when(this.policyService.deletePolicy(policyDTO.getId())).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/policies/" + policyDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getContentAsString().contentEquals("") ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testSearchPoliciesByName() throws Exception {
		String name = "Life Insurance";
		List<PolicyDTO> policyDTOList = getPolicyDTOList();

		when(this.policyService.searchPoliciesByName(name)).thenReturn(policyDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/policies/searchByName?name=" + name)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(policyDTOList)) ? "true"
						: "false"),
				businessTestFile);
	}

	@Test
	public void testSearchPoliciesByCoverage() throws Exception {
		String coverage = "Life cover";
		List<PolicyDTO> policyDTOList = getPolicyDTOList();

		when(this.policyService.searchPoliciesByCoverage(coverage)).thenReturn(policyDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/policies/searchByCoverage?coverage=" + coverage)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(policyDTOList)) ? "true"
						: "false"),
				businessTestFile);
	}

}
