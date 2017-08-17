package com.st.hcd.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.st.hcd.entity.Services;
import com.st.hcd.service.ServicesService;


@RestController
@RequestMapping("/secure")
public class ServiceController {

	@Resource
	ServicesService servicesService;
	
	@RequestMapping(value = "/service/{serviceId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Services getHealthCenterById(@PathVariable Integer serviceId) {
		Services service = servicesService.getServiceById(serviceId);
		return service;
	}

	@RequestMapping(value = "/servicesbyhealthcenterid/{healthCenterId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public List<Services> getServiceByHealthCenterId(@PathVariable Integer healthCenterId) {
		List<Services> services = servicesService.getServiceByHealthCenterId(healthCenterId);
		return services;
	}
	
}
