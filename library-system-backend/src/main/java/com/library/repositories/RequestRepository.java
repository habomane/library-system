package com.library.repositories;

import java.util.*;

import com.library.dtos.RequestDTO;
import com.library.models.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository {

    RequestEntity find(String id);

    List<RequestEntity> findAll(List<Map<String, String>> filters);

    RequestEntity save(RequestEntity request);

    List<RequestEntity> saveAll(List<RequestEntity> requests);

    RequestEntity update(RequestEntity request);

    List<RequestEntity> updateAll(List<RequestEntity> requests);

    Map<String, String>  delete(String requestId);

    List<Map<String, String> > deleteAll(List<String> requestIds);

}
