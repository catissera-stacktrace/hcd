package com.st.hcd.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.st.hcd.entity.HealthCenter;
import com.st.hcd.service.HealthCenterService;


@RestController
@RequestMapping("/secure")
public class HealthCenterController {

	@Resource
	HealthCenterService healthCenterService;
	
	@RequestMapping(value = "/healthCenter/{healthCenterId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public HealthCenter getHealthCenterById(@PathVariable Integer healthCenterId) {
		HealthCenter healthCenter = healthCenterService.getHealthCenterById(healthCenterId);
		return healthCenter;
	}

	@RequestMapping(value = "/healthCenter", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public List<HealthCenter> getAllHealthCenter() {
		List<HealthCenter> healthCenters = healthCenterService.getAllHealthCenter();
		return healthCenters;
	}
	
}
