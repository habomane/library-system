package com.library.services;

import com.library.dtos.UserDTO;
import com.library.dtos.UserRequestDTO;

import java.util.*;

public interface UserService {

    UserDTO find(Map<String, String> filterParams);

    List<UserDTO> findAll();

    UserDTO post(UserRequestDTO user);

    UserDTO update(UserDTO user);

    Map<String, String> delete(String id);

}
