package org.service.ribbon.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Autowired
	RestTemplate restTemplate;

	/**
	 * url中使用serviceID,而非IP,由Ribbon来实现负载均衡
	 * 
	 * @return
	 */
	public String getUser(String name) {
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		return restTemplate.getForObject("http://eureka-service/getUser?name={name}", String.class, params);

	}

	/**
	 * 使用LoadBalancerClient实现负载均衡,此时RestTemplate不需要加 @LoadBalanced
	 * 
	 * @return
	 */
	public String getUser2(String name) {
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);

		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-service");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getUser?name={name}";
		return restTemplate.getForObject(url, String.class, params);

	}
}
