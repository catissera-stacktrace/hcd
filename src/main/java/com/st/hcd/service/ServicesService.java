package com.st.hcd.service;

import java.util.List;
import com.st.hcd.entity.Services;

public interface ServicesService {
	
	List<Services> getServiceByHealthCenterId(Integer healthCenterId);

	Services getServiceById(Integer serviceId);
	
}
