package com.gofers.responseserver.controller;



import com.gofers.responseserver.bean.Req;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("qwer")
public class testController {
	@RequestMapping(value = "asdf",method = RequestMethod.POST)
	public String asdf(@RequestBody Req req) {
		System.out.println(req.toString());
		return req.toString();
	}


}
