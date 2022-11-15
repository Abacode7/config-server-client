package com.example.configserverclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigServerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerClientApplication.class, args);
	}

}

@RefreshScope
@RestController
class Controller {

	@Value("${rate.vehicle1}")
	private String vehicle1Rate;

	@Value("${rate.unit}")
	private String rateUnit;

	// @Value("${perf.line1}")
	// private String perfLine;

	@Value("${connection.key}")
	private String connectionKey;

	@GetMapping("/rate/vehicle1")
	public String rateVehicleOne(){
		return vehicle1Rate;
	}
	
	@GetMapping("/rate/unit")
	public String rateUnit(){
		return rateUnit;
	}

	@GetMapping("/connection/key")
	public String connectionKey(){
		return connectionKey;
	}

	// @GetMapping("/perf/line")
	// public String perfLine(){
	// 	return perfLine;
	// }
}