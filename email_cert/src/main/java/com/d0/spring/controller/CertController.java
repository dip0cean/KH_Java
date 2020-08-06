package com.d0.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.d0.spring.service.CertService;

@Controller
public class CertController {

	@Autowired
	private CertService certService;
}
