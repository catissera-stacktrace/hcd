package com.st.hcd.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.repository.ServicesRepository;
import com.st.hcd.entity.Services;

@Service
public class ServicesServiceImpl  implements ServicesService {

	@Resource 
	ServicesRepository servicesRepository;
	
	@Override
	public Services getServiceById(Integer serviceId) {
		return servicesRepository.findServiceById(serviceId);
	}

	@Override
	public List<Services> getServiceByHealthCenterId(Integer healthCenterId) {
		return servicesRepository.findServicesByHealthCenterId(healthCenterId);
	}
}

