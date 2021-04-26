package com.voc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VoiceOfCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoiceOfCustomerApplication.class, args);
	}

}
