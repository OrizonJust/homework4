package edu.laverno.homework4;

import edu.laverno.homework4.service.PollService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Homework4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Homework4Application.class, args);

		PollService service = context.getBean(PollService.class);
		service.startPoll();
	}

}
