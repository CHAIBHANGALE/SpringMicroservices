package com.example.microservices.netfixzullapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class NetfixZullApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetfixZullApiGatewayServerApplication.class, args);
	}
	
	@Bean
    public ZuulLoggingFilter preFilter() {
        return new ZuulLoggingFilter();
    }
    

}
