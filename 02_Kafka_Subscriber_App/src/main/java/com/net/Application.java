package com.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

import com.net.constant.AppConstant;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@KafkaListener(topics=AppConstant.TOPIC_NAME,groupId = "group_net_order")
	public void subcribeMsg(String order) {
		System.out.println("Msg Received from Kafka:::");
		System.out.println(order);
		
	}

}
