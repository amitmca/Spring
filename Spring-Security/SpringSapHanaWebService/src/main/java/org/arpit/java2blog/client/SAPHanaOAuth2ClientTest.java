package org.arpit.java2blog.client;

import java.util.ArrayList;
import java.util.List;

import org.arpit.java2blog.bean.Country;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;



public class SAPHanaOAuth2ClientTest {
	private static final String CRM_OAUTH2_URI = "https://springsaphanawep1943041361tria.hanatrial.ondemand.com/SpringSapHanaWebService/countries/";
	private static final String CRM_OAUTH2_URI1 = "https://springsaphanawep1943041361tria.hanatrial.ondemand.com/SpringSapHanaWebService/country/";
	
	private OAuth2RestTemplate oauth2RestTemplate = null;

	public static void main(String[] args) {
		SAPHanaOAuth2ClientTest oauth2Client = new SAPHanaOAuth2ClientTest();
		oauth2Client.runOAuth2Client();
	}

	public void runOAuth2Client() {
		oauth2RestTemplate = restTemplate();
		System.out.println("\nToken=" + oauth2RestTemplate.getAccessToken());
		getCountries();
		getCountry(5L);
		createCountry();
		getCountries();
	}

	/**
	 * 
	 * get all Countries
	 * 
	 */
	private void getCountries() {
		Country[] countries = oauth2RestTemplate.getForObject(CRM_OAUTH2_URI,
				Country[].class);
		System.out.println("\nId\tName\tPopulation");
		for (Country country : countries) {
			System.out
					.println(country.getId() + "\t" + country.getCountryName()
							+ "\t" + country.getPopulation());
		}
	}
	
	/**
	 * 
	 * get a particular Country
	 * 
	 * @param countryId
	 * @return
	 */
	private Country getCountry(Long countryId) {
		Country country = oauth2RestTemplate.getForObject(CRM_OAUTH2_URI1
				+ "/{countryId}", Country.class, countryId);
		System.out.println("\nId\tName\tPopulation");
		System.out
		.println(country.getId() + "\t" + country.getCountryName()
				+ "\t" + country.getPopulation());
		return country;
	}
	
	/**
	 * 
	 * add a new Country
	 * 
	 */
	private void createCountry() {
		Country country = new Country();
		
		country.setId(6);
		country.setCountryName("Canada");
		country.setPopulation(50000);
		
		Country savedCountry = oauth2RestTemplate.postForObject(CRM_OAUTH2_URI, country, Country.class);
		
		//System.out.println("savedCountry: " + savedCountry);
	}


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
		// resourceDetails.setScope(scopes);

		// -- set Resource Owner info
		resourceDetails.setUsername("P1943041361");
		resourceDetails.setPassword("Kasturi12#$");

		return new OAuth2RestTemplate(resourceDetails);
	}

}