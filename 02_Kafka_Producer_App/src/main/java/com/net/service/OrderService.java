package com.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.net.binding.Order;
import com.net.constants.AppConstant;

@Service
public class OrderService {
	
	@Autowired
	private KafkaTemplate<String ,Order>kafkaTemplate;
	
	public String addMsg(Order order) {
		kafkaTemplate.send(AppConstant.TOPIC_NAME,order);
		return "Msg Published to Kafka Topic";
	}

}
