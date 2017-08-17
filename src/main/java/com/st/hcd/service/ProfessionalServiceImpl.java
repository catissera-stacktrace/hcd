package com.st.hcd.service;

import java.util.Date;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.entity.Professional;
import com.st.hcd.repository.ProfessionalRepository;

@Service
public class ProfessionalServiceImpl  implements ProfessionalService {

	@Resource 
	ProfessionalRepository professionalRepository;


	@Override
	public Professional getProfessionalById(Integer professionalId) {
		return professionalRepository.findProfessionalById(professionalId);
	}

	@Override
	public Professional updateProfessional(Professional professional) {
		Professional oldProfessional = professionalRepository.findOne(professional.getId());
		
		if(oldProfessional != null) {
			professional.setDateCreated(oldProfessional.getDateCreated());
			professional.setCreatedBy(oldProfessional.getCreatedBy());
			professional.setDateModified( new Date());
		}
		else {
			professional.setDateCreated(new Date());
		}
		
		return professionalRepository.save(professional);
	}

}

