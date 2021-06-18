package com.tutorialspoint.demo1.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler2 {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Scheduled(fixedRate = 4000)
	public void fixedRateSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Fixed Rate scheduler:: " + strDate);
		sendMessage("Hi Welcome to Spring For Apache Kafka");

	}

	public void sendMessage(String msg) {
		System.out.println("Send Messasge by Kafka  : " + msg);
		kafkaTemplate.send("tutorialspoint-topic", msg);
	}


}