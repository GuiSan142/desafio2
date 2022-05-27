package br.com.saks.imovelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ImovelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImovelServiceApplication.class, args);
	}

}
