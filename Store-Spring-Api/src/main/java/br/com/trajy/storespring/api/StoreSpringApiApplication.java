package br.com.trajy.storespring.api;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class StoreSpringApiApplication {

	public static void main(String[] args) {
		run(StoreSpringApiApplication.class, args);
	}

}
