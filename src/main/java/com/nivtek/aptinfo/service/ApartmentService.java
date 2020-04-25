package com.nivtek.aptinfo.service;

import java.util.Optional;

import com.nivtek.aptinfo.entity.Apartment;

/**
 * @author AsimSubedi
 *
 */
public interface ApartmentService {

	/**
	 * This method returns the apartment object if found in the database.
	 * 
	 * @param apartmentId
	 * @return Optional<Apartment>
	 */
	Optional<Apartment> findById(Long apartmentId);

}
