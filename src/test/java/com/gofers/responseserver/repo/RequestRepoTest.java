package com.gofers.responseserver.repo;

import com.gofers.requestserver.bean.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestRepoTest {

    @Autowired
    RequestRepo requestRepo;


    @Test
    public void queryOne() {

        System.out.println(requestRepo.findOne(Example.of(Request.builder().responseId(16).build())));
    }

}
