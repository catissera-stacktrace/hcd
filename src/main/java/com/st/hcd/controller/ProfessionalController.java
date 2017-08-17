package com.st.hcd.controller;

import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.st.hcd.entity.Professional;
import com.st.hcd.service.ProfessionalService;

@RestController
@RequestMapping("/secure")
public class ProfessionalController {

	@Resource
	ProfessionalService professionalService;

	@RequestMapping(value = "/professional/{professionalId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Professional getProfessionalById(@PathVariable Integer professionalId) {

		return professionalService.getProfessionalById(professionalId);
	}
	
	@RequestMapping(value = "/professional", method = RequestMethod.PUT, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Professional updateProfessional(@RequestBody Professional professional) {
		
		return professionalService.updateProfessional(professional);
	}
	
}
