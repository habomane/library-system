package com.library.services;

import com.library.dtos.*;
import java.util.*;

public interface RequestService {

    RequestDTO find(String id);

    List<RequestDTO> findAll();

    RequestDTO post(RequestRequestDTO request);

    List<RequestDTO> postAll(List<RequestRequestDTO> requests);

    RequestDTO update(RequestDTO request);

    List<RequestDTO> updateAll(List<RequestDTO> requests);

    Map<String, String> delete(String id);

    List<Map<String, String>> deleteAll(List<String> ids);

}
