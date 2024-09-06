package com.spring.practiceSpring;

import com.spring.practiceSpring.service.RoutingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class PracticeSpringApplication {

	public static void main(String[] args) {
		String defaultPath="www.google.com";

		RoutingService routingService=new RoutingService(defaultPath);
		routingService.putPath("/foo/bar","firstFunc");
		routingService.putPath("/ujjwal/jindal","secondFunc");
		routingService.putPath("/shubham","sharma");

		routingService.putRegexPattern("*/kohli/bar","regex");

		System.out.println(routingService.invokeFunc("/foo/bar"));
		System.out.println(routingService.invokeFunc("/ujjwal/jindal"));
		System.out.println(routingService.invokeFunc("/shubham"));

		//invalid path
		System.out.println(routingService.invokeFunc("/"));

		//regex path

		System.out.println(routingService.invokeFunc("shubham/kohli/bar"));



	}

}
