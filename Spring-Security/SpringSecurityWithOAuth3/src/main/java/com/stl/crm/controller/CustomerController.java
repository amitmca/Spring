package com.stl.crm.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stl.crm.domain.Customer;

@RestController
@RequestMapping("/api/")
public class CustomerController {
	private OAuth2RestTemplate oauth2RestTemplate = null;
	private static final String CRM_OAUTH2_URI = "http://localhost:8085/SpringSecurityWithOAuth2/api/customers/";

	@RequestMapping(value = "/mycustomers", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomers() {
		oauth2RestTemplate = restTemplate();
		System.out.println("\nToken=" + oauth2RestTemplate.getAccessToken());
		List<Customer> customerList = new ArrayList<Customer>();

		Customer[] customers = oauth2RestTemplate.getForObject(CRM_OAUTH2_URI,
				Customer[].class);

		for (Customer customer : customers) {
			customerList.add(customer);
		}
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value="/mycustomers", method = RequestMethod.POST) public
	 * ResponseEntity<?> addCustomer(@RequestBody Customer customer) { Customer
	 * newCustomer = oauth2RestTemplate.postForObject(CRM_OAUTH2_URI, customer,
	 * Customer.class); return new ResponseEntity<>(newCustomer,
	 * HttpStatus.CREATED); }
	 */

	@RequestMapping(value = "/mycustomers", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
			throws Exception {
		oauth2RestTemplate = restTemplate();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(
				"C:\\Users\\AMIT\\Downloads\\customer.json"));
		customer=new Customer();
		JSONObject jsonObject = (JSONObject) obj;
		customer.setName((String) jsonObject.get("name"));
		customer.setAddress((String) jsonObject.get("address"));
		customer.setPhone((String) jsonObject.get("phone"));
		customer.setContact((String) jsonObject.get("contact"));

		System.out.println("Name :" + (String) jsonObject.get("name"));
		System.out.println("Contact :" + (String) jsonObject.get("contact"));
		System.out.println("Address :" + (String) jsonObject.get("address"));
		System.out.println("Phone :" + (String) jsonObject.get("phone"));

		Customer newCustomer = oauth2RestTemplate.postForObject(CRM_OAUTH2_URI,
				customer, Customer.class);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/mycustomers/{customerId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@PathVariable long customerId,
			@RequestBody Customer customer) {
		oauth2RestTemplate = restTemplate();
		oauth2RestTemplate.put(CRM_OAUTH2_URI + "/{customerId}", customer,
				customer.getId());
		Customer updatedCustomer = getaCustomer(customerId);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}

	@RequestMapping(value = "/mycustomers/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomer(@PathVariable long customerId) {
		oauth2RestTemplate = restTemplate();
		Customer customer = oauth2RestTemplate.getForObject(CRM_OAUTH2_URI
				+ "/{customerId}", Customer.class, customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	public Customer getaCustomer(long customerId) {
		oauth2RestTemplate = restTemplate();
		Customer customer = oauth2RestTemplate.getForObject(CRM_OAUTH2_URI
				+ "/" + customerId, Customer.class, customerId);
		return customer;
	}

	@RequestMapping(value = "/mycustomers/{customerId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer(@PathVariable long customerId) {
		oauth2RestTemplate = restTemplate();
		oauth2RestTemplate.delete(CRM_OAUTH2_URI + "/{customerId}", customerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private OAuth2RestTemplate restTemplate() {
		System.out.println("getting OAuth2RestTemplate ...");

		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setGrantType("password");
		resourceDetails
				.setAccessTokenUri("http://localhost:8085/SpringSecurityWithOAuth2/oauth/token");

		// -- set the clients info
		resourceDetails.setClientId("crmClient1");
		resourceDetails.setClientSecret("crmSuperSecret");

		// set scopes
		List<String> scopes = new ArrayList<>();
		scopes.add("read");
		scopes.add("write");
		scopes.add("trust");
		resourceDetails.setScope(scopes);

		// -- set Resource Owner info
		resourceDetails.setUsername("crmadmin");
		resourceDetails.setPassword("crmpass");

		return new OAuth2RestTemplate(resourceDetails);
	}

}
