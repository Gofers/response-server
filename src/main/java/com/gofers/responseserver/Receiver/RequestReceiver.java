package com.gofers.responseserver.Receiver;

import com.gofers.requestserver.bean.Request;

import com.gofers.responseserver.bean.Response;
import com.gofers.responseserver.service.ResponseService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangzongzhou
 */
@Component
@RabbitListener(queues = {"request"})
public class RequestReceiver {
	@Value("${biz_server_port}")
	String bizPort;

	@Autowired
	ResponseService responseService;

	@RabbitHandler
	public void process(Request request){
		//return;

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> httpEntity = new HttpEntity<>(request.getRequestBody(),headers);
		System.out.println(request.toString());
		if (request.getMethod().equals(RequestMethod.POST)) {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://127.0.0.1:"+bizPort + request.getPath(), httpEntity, String.class);
			Response response = responseService.save(Response.builder()
					.requestId(request.getId())
					.response(responseEntity.getBody())
					.build());
			responseService.update(request.getId(), response);
			System.out.println(responseEntity.getBody());
		}
		if (request.getMethod().equals(RequestMethod.GET)) {
			ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://127.0.0.1:"+bizPort +request.getPath() + "?" + request.getRequestBody(), String.class);
			Response response = responseService.save(Response.builder()
					.requestId(request.getId())
					.response(responseEntity.getBody())
					.build());
			responseService.update(request.getId(), response);
			System.out.println(responseEntity.getBody());
		}

	}
}
