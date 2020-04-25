/**
 * 
 */
package com.nivtek.aptinfo.rest;

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
@RequestMapping("api/v1/")
public class ApartmentController {

	@Autowired
	private ApartmentService apartmentService;

	@GetMapping("apartment/{id}")
	public ResponseEntity<Apartment> getApartmentById(@PathVariable(value = "id") Long apartmentId)
			throws ResourceNotFoundException {

		Apartment apartment = apartmentService.findById(apartmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Apartment Not Found!"));

		return ResponseEntity.ok().body(apartment);

	}

}
