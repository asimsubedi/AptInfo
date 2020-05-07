package com.nivtek.aptinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nivtek.aptinfo.dao.ApartmentRepository;
import com.nivtek.aptinfo.entity.Apartment;

/**
 * @author AsimSubedi
 *
 */
@Service
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentRepository apartmentRepository;

	@Override
	public Optional<Apartment> findById(int apartmentId) {

		return apartmentRepository.findById(apartmentId);

	}

	@Override
	public List<Apartment> findAllApartment() {

		return apartmentRepository.findAll();

	}

}
