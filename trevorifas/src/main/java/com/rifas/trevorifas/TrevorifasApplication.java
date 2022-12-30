package com.rifas.trevorifas;

import com.rifas.trevorifas.common.config.FileStorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
		FileStorageConfig.class
})
@SpringBootApplication
public class TrevorifasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrevorifasApplication.class, args);
	}

}
