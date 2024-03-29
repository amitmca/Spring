package com.technicalkeeda.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicalkeeda.controller.EmployeeController;
import com.technicalkeeda.bean.Employee;
import com.technicalkeeda.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmployeeControllerTest {
	
	 private static final int UNKNOWN_ID = Integer.MAX_VALUE;

	 private MockMvc mockMvc;
	 
	 @Mock
	 EmployeeService employeeService;
	 
	 @InjectMocks
	 EmployeeController employeeController;
	 
	 @Before
	    public void init(){
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders
	                .standaloneSetup(employeeController)
	                .build();
	    }

	 // =========================================== Get All Employees ==========================================

	  /*  @Test
	    public void test_get_all_success() throws Exception {
	        List<Employee> employees = Arrays.asList(
	                new Employee(21L, "Amey Amit","Bhalerao",2L));

	        when(employeeService.getEmployees()).thenReturn(employees);

	        mockMvc.perform(get("/employee"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	                .andExpect(jsonPath("$", hasSize(1)))
	                .andExpect(jsonPath("$[0].employeeId", is(21)))
	                .andExpect(jsonPath("$[3].age", is(2)));

	        verify(employeeService, times(1)).getEmployees();
	        verifyNoMoreInteractions(employeeService);
	    }
*/
}
