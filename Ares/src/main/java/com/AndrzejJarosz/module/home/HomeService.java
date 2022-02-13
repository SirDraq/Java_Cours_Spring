package com.AndrzejJarosz.module.home;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
	public GreetingDto getGreetings() {
		return new GreetingDto("Hello world");
	}
}
