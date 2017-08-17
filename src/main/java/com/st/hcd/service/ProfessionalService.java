package com.st.hcd.service;

import com.st.hcd.entity.Professional;

public interface ProfessionalService {
	
	Professional getProfessionalById(Integer professionalId);

	Professional updateProfessional(Professional professional);
}
