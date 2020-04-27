package com.nivtek.aptinfo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nivtek.aptinfo.entity.Resident;
import com.nivtek.aptinfo.exception.ResourceNotFoundException;
import com.nivtek.aptinfo.service.ResidentService;

/**
 * @author AsimSubedi
 *
 */
@RestController
@RequestMapping("api/v1/resident/")
public class ResidentController {

	@Autowired
	private ResidentService residentService;

	/**
	 * * The <i>getResidentById()</i> method takes residentId as parameter and it
	 * returns the resident object if found. Else, Resident Not Found message is
	 * returned with appropriate status code and information.
	 * 
	 * @param residentId
	 * @return ResponseEntity as HttpResponse containing status code, header and
	 *         body
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("{id}")
	public ResponseEntity<Resident> getResidentById(@PathVariable(value = "id") int residentId)
			throws ResourceNotFoundException {

		Resident resident = residentService.findById(residentId)
				.orElseThrow(() -> new ResourceNotFoundException("Resident Not Found!"));

		return ResponseEntity.ok().body(resident);

	}

}
