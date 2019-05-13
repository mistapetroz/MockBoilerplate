package com.mista.petroz.netflixeurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
/**
 * Currency Calculation Solution
 * Overview Diagram
 * 
 * @startuml
 * [CurrencyCalculation] --> [EurekaNamingServer]
 * [CurrencyExchange] --> [EurekaNamingServer]
 * [LimitService] --> [EurekaNamingServer]
 * @enduml
 */
public class NetflixEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixEurekaNamingServerApplication.class, args);
	}
}
