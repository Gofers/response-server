package com.gofers.responseserver.service;

import com.gofers.requestserver.bean.Request;
import com.gofers.responseserver.bean.Response;

/**
 * @author 73956
 */
public interface ResponseService {

    Response save(Response response);

    Request update(int requestId,Response response);

}
