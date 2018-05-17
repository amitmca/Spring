package com.technicalkeeda.restclient;

import java.net.URI;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.technicalkeeda.bean.Employee;

public class SpringRestTestClient {
	public static final String REST_SERVICE_URI = "http://localhost:8085/SpringHibernateRest";
	
	/* POST */
    private static void createEmployee() {
        System.out.println("Testing createEmployee");
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = new Employee(31l,"Test","Bhalerao",02l);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/employee/", emp, Employee.class);
    }
    
    /* PUT */
    private static void updateEmployee() {
        System.out.println("Testing updateEmployee");
        RestTemplate restTemplate = new RestTemplate();
        Employee emp  = new Employee(34l,"Testing","Testing",22l);
        restTemplate.put(REST_SERVICE_URI+"/employee/34", emp);
    }
    
    /* DELETE */
    private static void deleteEmployee() {
        System.out.println("Testing deleteEmployee");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/employee/delete/34");
    }
 
	
	 /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllEmployees(){
        System.out.println("Testing listAllEmployees API");
         
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        List<LinkedHashMap<String, Object>> empMap = restTemplate.getForObject(REST_SERVICE_URI+"/employee/", List.class);
         
        if(empMap!=null){
            for(LinkedHashMap<String, Object> map : empMap){
                System.out.println("Id="+map.get("employeeId")+", First Name="+map.get("firstName")+", Last Name="+map.get("lastName")+", Age="+map.get("age"));
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
    
    public static void main(String args[]){
    	//createEmployee();
    	//updateEmployee();
    	deleteEmployee();
    	listAllEmployees();
    }
}
