package com.gofers.responseserver.repo;

import com.gofers.responseserver.bean.Response;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 73956
 */
public interface ResponseRepo extends JpaRepository<Response,Integer> {



    Response findByRequestId(int requestId);
}
