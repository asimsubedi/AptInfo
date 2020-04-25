/**
 * 
 */
package com.nivtek.aptinfo.service;

import java.util.Optional;

import com.nivtek.aptinfo.entity.Apartment;

/**
 * @author AsimSubedi
 *
 */
public interface ApartmentService {

	Optional<Apartment> findById(Long apartmentId);

}
