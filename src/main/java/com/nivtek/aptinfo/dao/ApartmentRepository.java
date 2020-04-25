/**
 * Apartment Repository
 */
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
	
	Optional<Apartment> findById(long id);

}
