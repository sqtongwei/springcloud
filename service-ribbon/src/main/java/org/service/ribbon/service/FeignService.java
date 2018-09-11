package org.service.ribbon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-service")
public interface FeignService {


	/*
	Feign是一个声明式的Web Service客户端，它使得编写Web Serivce客户端变得更加简单。
	 我们只需要使用Feign来创建一个接口并用注解来配置它既可完成。它具备可插拔的注解支持，包括Feign注解和JAX-RS注解。
	Feign也支持可插拔的编码器和解码器。Spring Cloud为Feign增加了对Spring MVC注解的支持，
	还整合了Ribbon和Eureka来提供均衡负载的HTTP客户端实现。
	*/

	/**
	 * function: 调用eureka-service服务的getUser方法
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/getUser")
	String getUser(@RequestParam(value = "name") String name);
}
