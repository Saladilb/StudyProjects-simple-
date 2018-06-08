package ru.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.demo.service.DemoService;

@SpringBootApplication
public class ServicedescApplication {

	public static void main(String[] args) {


		ApplicationContext applicationContext =
				SpringApplication.run(ServicedescApplication.class, args);

		DemoService service =
				applicationContext.getBean(DemoService.class);

		service.demo();
	}
}

// /opt/app/v1
