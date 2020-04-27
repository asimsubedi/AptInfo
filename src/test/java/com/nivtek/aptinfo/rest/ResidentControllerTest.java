package com.nivtek.aptinfo.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.nivtek.aptinfo.entity.Address;
import com.nivtek.aptinfo.entity.Resident;
import com.nivtek.aptinfo.service.ResidentService;

/**
 * @author AsimSubedi
 *
 */

@WebMvcTest(ResidentController.class)
class ResidentControllerTest {

	@MockBean
	private ResidentService residentService;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * Test method for
	 * {@link com.nivtek.aptinfo.rest.ResidentController#getResidentById(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName("GET - /api/v1/resident/{id} RETURN RESIDENT")
	void testGetResidentById() throws Exception {

		// setup mocked service
		Resident mockResident = new Resident();
		Address mockAddress = new Address();
		mockAddress.setId(1);
		mockAddress.setLine1("1234 Street Ln");
		mockAddress.setLine2("");
		mockAddress.setCity("Whittier");
		mockAddress.setState("ca");
		mockAddress.setZip("90602");
		mockResident.setAddress(mockAddress);
		mockResident.setId(1);

		when(residentService.findById(1)).thenReturn(Optional.of(mockResident));

		// execute mock request
		mockMvc.perform(get("/api/v1/resident/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(mockResident.getId())));
	}

}
