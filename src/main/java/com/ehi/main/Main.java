package com.ehi.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehi.dao.CommonDAO;

@RestController
@EnableAutoConfiguration
@ComponentScan("com")
public class Main {
	@Autowired
	private CommonDAO commonDAO;

	@RequestMapping("/")
	String ping() {
		return commonDAO.getNetwork();
	}
	
	@RequestMapping("/test")
	String test() {
		return commonDAO.getNetwork();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

}
