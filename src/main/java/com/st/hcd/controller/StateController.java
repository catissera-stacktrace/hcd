package com.st.hcd.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.st.hcd.entity.State;
import com.st.hcd.service.StateService;

@RestController
@RequestMapping("/secure")
public class StateController {

	@Resource
	StateService stateService;

	@RequestMapping(value = "/state/{stateId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public State getStateById(@PathVariable Integer stateId) {

		return stateService.getStateById(stateId);
	}

	@RequestMapping(value = "/statesbycountry/{countryId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public List<State> getStateByCountryId(@PathVariable Integer countryId) {

		return stateService.getStateByCountryId(countryId);
	}
	
}
