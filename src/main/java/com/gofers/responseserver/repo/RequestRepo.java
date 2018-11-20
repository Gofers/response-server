package com.gofers.responseserver.repo;

import com.gofers.requestserver.bean.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Request,Integer> {
}
