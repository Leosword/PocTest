package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.example.demo.validation.ValidationResponse;

@Controller
public class UsuarioController {

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ValidationResponse> carregar(){
		return new ResponseEntity<ValidationResponse>(HttpStatus.OK);
	}
}
