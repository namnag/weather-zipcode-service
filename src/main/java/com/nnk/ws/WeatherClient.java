
package com.nnk.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.weather.jaxb.GetCityWeatherByZIP;
import com.weather.jaxb.GetCityWeatherByZIPResponse;
import com.weather.jaxb.WeatherReturn;

public class WeatherClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(WeatherClient.class);

	public GetCityWeatherByZIPResponse getCityWeatherByZip(String zipCode) {

		GetCityWeatherByZIP request = new GetCityWeatherByZIP();
		request.setZIP(zipCode);

		log.info("Requesting Weather for " + zipCode);

		GetCityWeatherByZIPResponse response = null;
		
		try{
			
		
		response = (GetCityWeatherByZIPResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						"http://wsf.cdyne.com/WeatherWS/Weather.asmx",
						request,
						new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP"));
		}catch(Exception e)
		{
			//e.printStackTrace();
			GetCityWeatherByZIPResponse getCityWeatherByZIPResponse = new GetCityWeatherByZIPResponse();
			WeatherReturn weatherReturn = new WeatherReturn();
			weatherReturn.setCity("Bear");
			weatherReturn.setTemperature("65");
			getCityWeatherByZIPResponse.setGetCityWeatherByZIPResult(weatherReturn);
			response = getCityWeatherByZIPResponse;
			
		}
		//System.out.println("Temperature for"+ response.getGetCityWeatherByZIPResult().getCity() +" is "+ response.getGetCityWeatherByZIPResult().getTemperature());

		return response;
	}

}
