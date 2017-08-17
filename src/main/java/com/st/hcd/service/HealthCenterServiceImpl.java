package com.st.hcd.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.st.hcd.entity.HealthCenter;
import com.st.hcd.repository.HealthCenterRepository;

@Service
public class HealthCenterServiceImpl  implements HealthCenterService {

	@Resource 
	HealthCenterRepository healthCenterRepository;
	
	@Override
	public HealthCenter getHealthCenterById(Integer id) {
		return healthCenterRepository.findHealtCenterById(id);
	}

	@Override
	public List<HealthCenter> getAllHealthCenter() {
		return healthCenterRepository.findAll();
	}
}

