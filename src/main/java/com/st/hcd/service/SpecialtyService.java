package com.st.hcd.service;

import java.util.List;

import com.st.hcd.entity.Specialty;

public interface SpecialtyService {
	
	Specialty getSpecialtyById(Integer specialtyId);
	
	List<Specialty> getSpecialties();

}
