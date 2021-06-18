package com.tutorialspoint.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Demo1Application implements ApplicationRunner, CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Demo1Application.class);

	public static void main(String[] args) {

		System.out.println("linia 0");
		SpringApplication.run(Demo1Application.class, args);
		logger.info("info log");
		logger.warn("warn log");
		logger.error("error log");
		logger.debug("debug log");
		logger.trace("trace log");
		System.out.println("linia 1");

	}


	@KafkaListener(topics = "tutorialspoint-topic", groupId = "group-id")
	public void listen(String message) {
		System.out.println("Received Messasge by Kafka in group - group-id: " + message);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("ApplicationRunner run.");

	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Hello world from Command Line Runner");
	}

}
