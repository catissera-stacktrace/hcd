package com.st.hcd.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.st.hcd.entity.Specialty;
import com.st.hcd.service.SpecialtyService;

@RestController
@RequestMapping("/secure")
public class SpecialtyController {

	@Resource
	SpecialtyService specialtyService;

	@RequestMapping(value = "/specialty/{specialtyId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Specialty getSpecialtyById(@PathVariable Integer specialtyId) {

		return specialtyService.getSpecialtyById(specialtyId);
	}

	@RequestMapping(value = "/specialty", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public List<Specialty> getSpecialties() {

		return specialtyService.getSpecialties();
	}
	
}
