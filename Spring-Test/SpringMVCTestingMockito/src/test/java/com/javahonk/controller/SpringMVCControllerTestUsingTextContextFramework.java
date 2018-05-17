package com.javahonk.controller;

import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javahonk.services.IPersonService;

//If you want to load multiple files use below:

/*@ContextConfiguration
(
  {
   "classpath:beans.xml",
   "file:src/main/webapp/WEB-INF/dispatcher-data-servlet.xml",
   "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"
  }
)*/

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:dispatcher-servlet.xml"}) // If keep context file in resource folder then user this
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"}) // Reading context file from WEB-INF folder
public class SpringMVCControllerTestUsingTextContextFramework {
	
	@Autowired
	IPersonService transformService;

	//@Test
	public void testFirstPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testDatabasetest() {
		
		for (Map<String, Object> map : transformService.selectAllPerson()) {
			for (Map.Entry entry : map.entrySet()) {
			    System.out.println("Key:" + entry.getKey() + ",Value: " +  entry.getValue());
			}
		}	
				
	}

	//@Test
	public void testGetSampleJSONData() {
		fail("Not yet implemented");
	}

}
