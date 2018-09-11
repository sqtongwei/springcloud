package org.eureka.service.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	
	private String name;
	
	@JSONField(serialize = false)
	private Integer age;
	
    @JSONField(format = "yyyy-MM-dd")
	private Date birth;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}
	
	
	
	

}
