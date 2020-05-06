package com.nivtek.aptinfo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nivtek.aptinfo.entity.Apartment;

/**
 * @author AsimSubedi
 *
 */
@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

//	Apartment saveApartment(Apartment apartment);

	/**
	 * This method finds the Apartment By requested Id.
	 * 
	 * @param id
	 * @return Optional<Apartment> so that NPE can be prevented
	 */
	Optional<Apartment> findById(int id);

}
