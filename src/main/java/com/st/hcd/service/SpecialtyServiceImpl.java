package com.st.hcd.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.entity.Specialty;
import com.st.hcd.repository.SpecialtyRepository;

@Service
public class SpecialtyServiceImpl  implements SpecialtyService {

	@Resource 
	SpecialtyRepository specialtyRepository;

	@Override
	public Specialty getSpecialtyById(Integer specialtyId) {
		return specialtyRepository.findSpecialtyById(specialtyId);
	}

	@Override
	public List<Specialty> getSpecialties() {
		return specialtyRepository.findSpecialties();
	}

}

