package com.st.hcd.service;

import java.util.List;
import com.st.hcd.entity.HealthCenter;

public interface HealthCenterService {
	
	List<HealthCenter> getAllHealthCenter();

	HealthCenter getHealthCenterById(Integer id);
	
}
