package com.nivtek.aptinfo.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.nivtek.aptinfo.entity.Address;
import com.nivtek.aptinfo.entity.Apartment;
import com.nivtek.aptinfo.service.ApartmentService;

/**
 * @author AsimSubedi
 *
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApartmentControllerTest {

	@MockBean
	private ApartmentService apartmentService;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * Test method for
	 * {@link com.nivtek.aptinfo.rest.ApartmentController#getAllApartments()}.
	 */
	@Test
	@Disabled
	@DisplayName("GET - /api/v1/apartment - RETURN ALL Apartments")
	void testGetAllApartments() {
	}

	/**
	 * Test method for
	 * {@link com.nivtek.aptinfo.rest.ApartmentController#getApartmentById(java.lang.Long)}.
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName("GET - /api/v1/apartment/{id} - RETURN Apartment")
	void testGetApartmentById() throws Exception {

		// setup our mocked Service
		Apartment mockApartment = new Apartment();
		Address mockAddress = new Address();
		mockAddress.setId(1);
		mockAddress.setLine1("1234 Street Ln");
		mockAddress.setLine2("");
		mockAddress.setCity("Whittier");
		mockAddress.setState("ca");
		mockAddress.setZip("90602");
		mockApartment.setId(1);
		mockApartment.setNumOfResidents(3);
		mockApartment.setNumOfRooms(3);
		mockApartment.setRentedOn(new Date());
		mockApartment.setAddress(mockAddress);
		
		when(apartmentService.findById(1)).thenReturn(Optional.of(mockApartment));

		// Execute the Mock Request
		mockMvc.perform(get("/api/v1/apartment/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(mockApartment.getId())))
				.andExpect(jsonPath("$.numOfRooms", is(mockApartment.getNumOfRooms())));
	}

}
