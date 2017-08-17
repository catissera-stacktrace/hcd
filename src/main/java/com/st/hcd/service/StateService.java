package com.st.hcd.service;

import java.util.List;

import com.st.hcd.entity.State;

public interface StateService {
	
	State getStateById(Integer stateId);
	
	List<State> getStateByCountryId(Integer countryId);

}
