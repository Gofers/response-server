package com.gofers.responseserver.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("qwer")
public class testController {
	@RequestMapping(value = "asdf",method = RequestMethod.POST)
	public String asdf(Req req) {
		System.out.println(req.toString());
		return "adsfasdf";
	}
	@Getter
	@Setter
	@ToString
	public class Req {
		String xiao;
		int da;
	}

}
