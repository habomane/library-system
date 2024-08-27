package com.library.services;

import com.library.dtos.UserDTO;
import com.library.dtos.UserRequestDTO;

import java.util.*;

public interface UserService {

    UserDTO find(String id);

    List<UserDTO> findAll();

    UserDTO post(UserRequestDTO user);

    Map<String, String> delete(String id);

}
