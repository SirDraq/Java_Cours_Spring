package com.AndrzejJarosz.core.module.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping("/")
	public GreetingDto getHome() {
		return homeService.getGreetings();
	}
}

