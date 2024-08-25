package com.library.services;

import com.library.dtos.RequestDTO;
import com.library.dtos.RequestRequestDTO;

import com.library.models.RequestEntity;
import com.library.repositories.RequestRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RequestServiceImpl implements RequestService{

    private final RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository)
    {
        this.requestRepository = requestRepository;
    }

    @Override
    public RequestDTO find(String id) {
        return new RequestDTO(requestRepository.find(id));
    }

    @Override
    public List<RequestDTO> findAll(List<Map<String, String>> filters) {
        return requestRepository.findAll(filters).stream().map(RequestDTO::new).toList();
    }

    @Override
    public RequestDTO post(RequestRequestDTO request) {
        return new RequestDTO(requestRepository.save(request.toRequestEntity()));
    }

    @Override
    public List<RequestDTO> postAll(List<RequestRequestDTO> requests) {
        return requestRepository.saveAll(requests.stream().map(RequestRequestDTO::toRequestEntity).toList()).stream().map(RequestDTO::new).toList();
    }

    @Override
    public RequestDTO update(RequestDTO request) {
        return new RequestDTO(requestRepository.update(request.toRequestEntity()));
    }

    @Override
    public List<RequestDTO> updateAll(List<RequestDTO> requests) {
        return requestRepository.updateAll(requests.stream().map(RequestDTO::toRequestEntity).toList()).stream().map(RequestDTO::new).toList();
    }

    @Override
    public Map<String, String> delete(String id) {
        return requestRepository.delete(id);
    }

    @Override
    public List<Map<String, String>> deleteAll(List<String> ids) {
        return requestRepository.deleteAll(ids);
    }
}
