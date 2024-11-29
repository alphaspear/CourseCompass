package com.CourseCompass.DatasourceAgent;

import com.CourseCompass.DatasourceAgent.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatasourceAgentApplication implements CommandLineRunner {

	// Autowire the AgentService
	@Autowired
	private AgentService agentService;

	public static void main(String[] args) {
		SpringApplication.run(DatasourceAgentApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		agentService.initializeAgent();
	}
}
