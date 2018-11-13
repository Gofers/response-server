package com.gofers.responseserver.Receiver;

import com.gofers.requestserver.bean.Request;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangzongzhou
 */
@Component
@RabbitListener(queues = {"request"})
public class RequestReceiver {

	@RabbitHandler
	public void process(Request request){
		//return;

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> httpEntity = new HttpEntity<>(request.getRequestBody(),headers);

		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://127.0.0.1:8080"+request.getPath(), httpEntity, String.class);
		System.out.println(responseEntity.getBody());
		System.out.println(request.toString());
	}
}
