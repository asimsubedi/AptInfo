package com.nivtek.aptinfo.dao;

import java.util.Optional;

import com.nivtek.aptinfo.entity.Resident;

/**
 * @author AsimSubedi
 *
 */
public interface ResidentRepository {

	/**
	 * @param id
	 * @return Resident object for given id
	 */
	Optional<Resident> findById(int id);

}
