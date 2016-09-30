package com.nnk.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nnk.mapper.ResponseMapper;
import com.weather.produce.jaxb.GetWeatherRequest;
import com.weather.produce.jaxb.GetWeatherResponse;

@Endpoint
public class WeatherEndpoint {
	private static final Logger log = LoggerFactory.getLogger(WeatherEndpoint.class);

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	@Autowired
	private ResponseMapper responseMapper;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWeatherRequest")
	@ResponsePayload
	public GetWeatherResponse getWeatherByZipCode(@RequestPayload GetWeatherRequest request) {
		System.out.println("Inside Endpoint");
	    System.out.println("zipcode From Request:"+request.getZipCode());
		return responseMapper.soapResponseMapper(request);
	}
}
