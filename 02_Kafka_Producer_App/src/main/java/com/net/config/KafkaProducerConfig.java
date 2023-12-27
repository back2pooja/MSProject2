package com.net.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.net.binding.Order;
import com.net.constants.AppConstant;

@Configuration	
public class KafkaProducerConfig {
	
	
	@Bean
	public ProducerFactory<String ,Order> producerFactory(){
		
		Map<String ,Object> configProps = new HashMap<>();
		
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConstant.HOST_URL);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory(configProps);		
		
	}
	@Bean 
	public KafkaTemplate<String,Order> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}

}
