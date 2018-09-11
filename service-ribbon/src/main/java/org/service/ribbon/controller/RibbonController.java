package org.service.ribbon.controller;

import org.service.ribbon.service.FeignService;
import org.service.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

	@Autowired
	RibbonService ribbonService;
	@Autowired
	FeignService feignService;
	
	@GetMapping(value="/getUser")
	public String getUser(@RequestParam(value = "name") String name) {
		
		return ribbonService.getUser(name);
	}
	@GetMapping(value="/getUser2")
	public String getUser2(@RequestParam(value = "name") String name) {
		
		return ribbonService.getUser2(name);
	}
	@GetMapping(value="/getUser3")
	public String getUser3(@RequestParam(value = "name") String name) {
		
		return feignService.getUser(name);
	}
}
