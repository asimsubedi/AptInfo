package com.nivtek.aptinfo.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nivtek.aptinfo.entity.Resident;

/**
 * @author AsimSubedi
 *
 */
@Repository
public interface ResidentRepository {

	/**
	 * @param id
	 * @return Resident object for given id
	 */
	Optional<Resident> findById(int id);

}
