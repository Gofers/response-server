package com.gofers.responseserver.service;

import com.gofers.requestserver.bean.Request;
import com.gofers.responseserver.bean.Response;
import com.gofers.responseserver.repo.RequestRepo;
import com.gofers.responseserver.repo.ResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 73956
 */

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    ResponseRepo responseRepo;
    @Autowired
    RequestRepo requestRepo;
    @Override
    public Response save(Response response) {

        return responseRepo.save(response);
    }

    @Override
    public Request update(int requestId,Response response) {
        Request request = requestRepo.findById(requestId).get();
        request.setResponseId(response.getId());

        return requestRepo.save(request);
    }
}
