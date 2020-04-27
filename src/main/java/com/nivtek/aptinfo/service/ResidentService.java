package com.nivtek.aptinfo.service;

import java.util.List;
import java.util.Optional;

import com.nivtek.aptinfo.entity.Resident;

/**
 * @author AsimSubedi
 *
 */
public interface ResidentService {

	/**
	 * This method returns the List of Resident objects
	 * 
	 * @return List<Resident> i.e. all the residents residing in apartment as a
	 *         list.
	 */
	List<Resident> findAllResident();

	/**
	 * This method will return the Resident object for requested residentId passed.
	 * 
	 * @param residentId
	 * @return Resident Object of requested id.
	 */
	Optional<Resident> findById(int residentId);

}
