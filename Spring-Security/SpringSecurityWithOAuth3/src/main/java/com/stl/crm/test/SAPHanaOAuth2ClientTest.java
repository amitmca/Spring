package com.stl.crm.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

import com.stl.crm.domain.Customer;

public class SAPHanaOAuth2ClientTest {
	private static final String CRM_OAUTH2_URI = "http://localhost:8085/SpringSecurityWithOAuth2/api/customers/";
	private OAuth2RestTemplate oauth2RestTemplate = null;

	public static void main(String[] args) {
		SAPHanaOAuth2ClientTest oauth2Client = new SAPHanaOAuth2ClientTest();
		oauth2Client.runOAuth2Client();
	}

	public void runOAuth2Client() {
		oauth2RestTemplate = restTemplate();
		System.out.println("\nToken=" + oauth2RestTemplate.getAccessToken());
		/*createCustomer();
		getCustomers();
		getCustomer(7L);
		updateCustomer();
		deleteCustomer(5L);
		getCustomerEntity(7L);*/

	}

	/**
	 * 
	 * get all Customers
	 * 
	 */
	private void getCustomers() {
		Customer[] customers = oauth2RestTemplate.getForObject(CRM_OAUTH2_URI,
				Customer[].class);
		System.out.println("\nId\tName\tAddress\tPhone\tContact");
		for (Customer customer : customers) {
			System.out.println(customer.getId() + "\t" + customer.getName()
					+ "\t" + customer.getAddress() + "\t" + customer.getPhone()
					+ "\t" + customer.getContact());
		}
	}

	/**
	 * 
	 * get a particular Customer
	 * 
	 * @param customerId
	 * @return
	 */
	private Customer getCustomer(Long customerId) {
		Customer customer = oauth2RestTemplate.getForObject(CRM_OAUTH2_URI
				+ "/{customerId}", Customer.class, customerId);
		System.out.println("customer: " + customer);

		return customer;
	}

	/**
	 * 
	 * add a new Customer
	 * 
	 */
	private void createCustomer() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(
					"C:\\Users\\AMIT\\Downloads\\customer.json"));
			JSONObject jsonObject = (JSONObject) obj;
			Customer customer = new Customer();

			customer.setName((String) jsonObject.get("name"));
			customer.setAddress((String) jsonObject.get("address"));
			customer.setPhone((String) jsonObject.get("phone"));
			customer.setContact((String) jsonObject.get("contact"));

			Customer savedCustomer = oauth2RestTemplate.postForObject(
					CRM_OAUTH2_URI, customer, Customer.class);

			System.out.println("savedCostomer: " + savedCustomer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * update an existing Customer
	 * 
	 */
	private void updateCustomer() {
		Customer customer = getCustomer(6L);
		customer.setAddress("Kapil Dreams");

		oauth2RestTemplate.put(CRM_OAUTH2_URI + "/{customerId}", customer,
				customer.getId());

		Customer updatedCustomer = getCustomer(4L);
		System.out.println("updatedCostomer: " + updatedCustomer);

	}

	/**
	 * 
	 * delete a Customer
	 * 
	 * @param customerId
	 * 
	 */
	private void deleteCustomer(Long customerId) {
		oauth2RestTemplate.delete(CRM_OAUTH2_URI + "/{customerId}", customerId);
	}

	/**
	 * 
	 * get a particular Customer using getForEntity
	 * 
	 * @param customerId
	 * @return
	 */
	private Customer getCustomerEntity(Long customerId) {
		ResponseEntity entity = oauth2RestTemplate.getForEntity(CRM_OAUTH2_URI
				+ "/{customerId}", Customer.class, customerId);
		Customer customer = (Customer) entity.getBody();
		System.out.println("customer: " + customer);

		// -- getting response header info
		HttpHeaders responseHeaders = entity.getHeaders();
		/*
		 * responseHeaders.entrySet().forEach(header-> {
		 * System.out.println(header.getKey() + ":" + header.getValue()); });
		 */

		// -- getting response status info
		System.out.println("status name: " + entity.getStatusCode().name());
		System.out.println("status value: " + entity.getStatusCode().value());

		return customer;
	}

	/**
	 * 
	 * OAuth2 Rest template
	 * 
	 * @return
	 */
	private OAuth2RestTemplate restTemplate() {
		System.out.println("getting OAuth2RestTemplate ...");

		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setGrantType("password");
		resourceDetails
				.setAccessTokenUri("https://oauthasservices-p1943041361trial.hanatrial.ondemand.com/oauth2/api/v1/token");

		// -- set the clients info
		resourceDetails.setClientId("8cd9c017-92f5-3dc5-8218-0fe8bd3c2583");
		resourceDetails.setClientSecret("123456");

		// set scopes
		List<String> scopes = new ArrayList<>();
		scopes.add("read");
		scopes.add("write");
		scopes.add("trust");
		//resourceDetails.setScope(scopes);

		// -- set Resource Owner info
		resourceDetails.setUsername("P1943041361");
		resourceDetails.setPassword("Kasturi12#$");

		return new OAuth2RestTemplate(resourceDetails);
	}

}