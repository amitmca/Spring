package com.javahonk.controller;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.javahonk.services.IPersonService;

@RunWith(MockitoJUnitRunner.class)
public class SpringMVCControllerTestUsingMockito {
	
	@Mock
	IPersonService transformService;

	//@Test
	public void testFirstPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testDatabasetest() {
		
		List<Map<String, Object>> value = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> mapValue = new HashMap<String, Object>();
		mapValue.put("FirstName", "Java");
		mapValue.put("LastName", "Honk");		
		mapValue.put("street", "John St.");
		mapValue.put("city", "NY");
		mapValue.put("state", "NY");
		mapValue.put("country", "USA");
		value.add(mapValue);
		when(transformService.selectAllPerson()).thenReturn(value);
		
		for (Map<String, Object> map : transformService.selectAllPerson()) {
			for (Map.Entry entry : map.entrySet()) {
			    System.out.println("Key:" + entry.getKey() + ",Value: " +  entry.getValue());
			}
		}		
		Assert.assertNotNull(transformService.selectAllPerson());			
	}

	//@Test
	public void testGetSampleJSONData() {
		fail("Not yet implemented");
	}

}
