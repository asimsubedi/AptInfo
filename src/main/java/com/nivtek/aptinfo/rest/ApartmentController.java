package com.nivtek.aptinfo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nivtek.aptinfo.entity.Apartment;
import com.nivtek.aptinfo.exception.ResourceNotFoundException;
import com.nivtek.aptinfo.service.ApartmentService;

/**
 * @author AsimSubedi
 *
 */
@RestController
@RequestMapping("api/v1/apartment/")
public class ApartmentController {

	@Autowired
	private ApartmentService apartmentService;

	/**
	 * This method handles the request for getting the information about all the
	 * apartments from the database. This method will return information about all
	 * the apartments as a list.
	 * 
	 * @return List<Apartment> which contains all the apartments as a list
	 */
	@GetMapping("all/")
	public List<Apartment> getAllApartments() {
		return apartmentService.findAllApartment();

	}

	/**
	 * The <i>getApartmentById()</i> method takes apartmentId as parameter and it
	 * returns the apartment object if found. Else, Apartment Not Found message is
	 * returned with appropriate status code and information.
	 * 
	 * @param apartmentId
	 * @return ResponseEntity as HttpResponse containing the status code, header and
	 *         response body
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("{id}")
	public ResponseEntity<Apartment> getApartmentById(@PathVariable(value = "id") int apartmentId)
			throws ResourceNotFoundException {

		Apartment apartment = apartmentService.findById(apartmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Apartment Not Found!"));

		return ResponseEntity.ok().body(apartment);

	}

}
