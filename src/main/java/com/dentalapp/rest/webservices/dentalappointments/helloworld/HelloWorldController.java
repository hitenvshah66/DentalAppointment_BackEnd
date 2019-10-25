package com.dentalapp.rest.webservices.dentalappointments.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {

	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}

	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldPath(@PathVariable String name) {
		//return new HelloWorldBean(String.format("Hello World, %s",name));
		throw new RuntimeException("Something went wrong");
	}

}
