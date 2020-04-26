package com.nivtek.aptinfo.service;

import java.util.List;
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

	/**
	 * This method returns all the apartment objects from the database as an List.
	 * 
	 * @return List<Apartment> which contains the list of All Apartment Objects
	 *         stored in the Database
	 */
	List<Apartment> findAllApartment();

}
