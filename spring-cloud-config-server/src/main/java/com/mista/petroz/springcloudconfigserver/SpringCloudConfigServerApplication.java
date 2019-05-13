package com.mista.petroz.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring Cloud Config Design
 * Overview Diagram
 * 
 * @startuml
 * 
 * [CurrencyCalculationService] as Comp5
 * [CurrencyExchangeService] as Comp4 
 * [LimitsService] as Comp3 
 * [SpringCloudConfigServer] as Comp2 
 * 
 * database "Git-Local" {
 *   frame "currency-calc-service" {
 * 	[currency-calc-service.properties]
 *   }
 *   frame "currency-exchange-service" {
 * 	[currency-exchange-service.properties]
 *   }
 *   frame "limit-service" {
 * 	[limit-service.properties]
 *   }
 * }
 *
 * [Comp4] --> [Comp2] 
 * [Comp3] --> [Comp2] 
 * [Comp5] --> [Comp2] 
 * 
 * [Comp2] ..> [currency-calc-service.properties]
 * [Comp2] ..> [currency-exchange-service.properties]
 * [Comp2] ..> [limit-service.properties]
 *
 * @enduml
 */

@EnableConfigServer	
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
}
