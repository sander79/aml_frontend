package it.sander.aml.infrastructure.rest;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class BaseClientRest {
		
	protected final DozerBeanMapper mapper = new DozerBeanMapper();
	
	protected final HttpHeaders headers = new HttpHeaders();
	protected final HttpEntity<?> entity = new HttpEntity<>(headers);
	
	@Autowired
	private transient RestTemplate restTemplate;

	protected RestTemplate getRestTemplate() {
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);	
		return restTemplate;
	}

}
