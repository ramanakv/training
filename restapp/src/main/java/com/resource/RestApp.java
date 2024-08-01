package com.resource;


import java.util.HashSet;
import java.util.Set;

import com.resource.EmployeeResource;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/app")
public class RestApp  extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(EmployeeResource.class);
		return set;
	}
	
}
