package com.nivtek.aptinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nivtek.aptinfo.dao.ResidentRepository;
import com.nivtek.aptinfo.entity.Resident;

/**
 * @author AsimSubedi
 *
 */
@Service
public class ResidentServiceImpl implements ResidentService {

	@Autowired
	private ResidentRepository residentRepository;

	@Override
	public List<Resident> findAllResident() {
		return null;
	}

	@Override
	public Optional<Resident> findById(int residentId) {
		return residentRepository.findById(residentId);
	}

}
