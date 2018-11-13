package com.gofers.responseserver;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangzongzhou
 */
@SpringBootApplication
public class ResponseServerApplication {



	public static void main(String[] args) {
		SpringApplication.run(ResponseServerApplication.class, args);
	}
}
