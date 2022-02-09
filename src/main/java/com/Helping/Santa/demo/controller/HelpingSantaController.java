package com.Helping.Santa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Helping.Santa.demo.beans.SantaBean;
import com.Helping.Santa.demo.beans.SantaResponse;
import com.Helping.Santa.demo.service.HelpingSantaService;

//@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
public class HelpingSantaController {
	@Autowired
	HelpingSantaService helpingSantaService;

	@RequestMapping(value = "/hoodfiller", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SantaResponse> getHelpingSanta(@RequestBody SantaBean bean) {
		SantaResponse santaResponse  = helpingSantaService.performSanta(bean);

		return new ResponseEntity<SantaResponse>(santaResponse, HttpStatus.OK);

	}

}
