package com.st.hcd.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.entity.State;
import com.st.hcd.repository.StateRepository;

@Service
public class StateServiceImpl  implements StateService {

	@Resource 
	StateRepository stateRepository;

	@Override
	public State getStateById(Integer stateId) {
		return stateRepository.findStateById(stateId);
	}

	@Override
	public List<State> getStateByCountryId(Integer countryId) {
		return stateRepository.findStateByCountryId(countryId);
	}

}

