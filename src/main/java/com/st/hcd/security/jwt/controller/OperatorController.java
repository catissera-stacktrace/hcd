package com.st.hcd.security.jwt.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.hcd.security.jwt.entity.Operator;
import com.st.hcd.security.jwt.service.OperatorService;

@RestController
@RequestMapping("/secure")
public class OperatorController {
	
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping(value = "/operator", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public List<Operator> getOperators() {
		return operatorService.getOperators();
	}

	@RequestMapping(value = "/operator/{id}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Operator getOperatorByUserId(@PathVariable Integer operatorId) {
		return operatorService.findByOperatorId(operatorId) ;
	}

}
