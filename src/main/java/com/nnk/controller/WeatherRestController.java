package com.nnk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nnk.ws.WeatherClient;

@Controller
public class WeatherRestController {

	@Autowired
	WeatherClient weatherClient;
	
	@RequestMapping(
			  value = "/getWeatherForZipCode", 
			  method = RequestMethod.GET
			  )
	@ResponseBody
	public String getValidation(){
		return weatherClient.getCityWeatherByZip("06095").getGetCityWeatherByZIPResult().getCity();
	}
}
