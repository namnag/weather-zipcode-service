package com.nnk.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.nnk.ws.WeatherClient;
import com.weather.jaxb.GetCityWeatherByZIPResponse;
import com.weather.produce.jaxb.GetWeatherRequest;
import com.weather.produce.jaxb.GetWeatherResponse;

@Component
public class ResponseMapper {

	@Autowired
	WeatherClient weatherClient;
	
	public GetWeatherResponse soapResponseMapper (GetWeatherRequest request){
		GetWeatherResponse getWeatherResponse = new GetWeatherResponse();
		
		if(!StringUtils.isEmpty(request.getZipCode()))
		{
			GetCityWeatherByZIPResponse weatherByZipResponse = weatherClient.getCityWeatherByZip(request.getZipCode());
			if(weatherByZipResponse != null && weatherByZipResponse.getGetCityWeatherByZIPResult().isSuccess()){
				
				getWeatherResponse.setCity(weatherByZipResponse.getGetCityWeatherByZIPResult().getCity());
				getWeatherResponse.setHumidity(weatherByZipResponse.getGetCityWeatherByZIPResult().getRelativeHumidity());
				getWeatherResponse.setPressure(weatherByZipResponse.getGetCityWeatherByZIPResult().getPressure());
				getWeatherResponse.setState(weatherByZipResponse.getGetCityWeatherByZIPResult().getState());
				getWeatherResponse.setTemperature(weatherByZipResponse.getGetCityWeatherByZIPResult().getTemperature());
				
			}else{
				getWeatherResponse.setResponsetext(weatherByZipResponse.getGetCityWeatherByZIPResult().getResponseText());

			}
		}

		return getWeatherResponse;
		
	}
}
