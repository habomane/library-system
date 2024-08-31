package com.library.services;

import com.library.dtos.UserDTO;
import com.library.dtos.UserRequestDTO;
import com.library.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public UserDTO find(Map<String, String> filterParams) {
        return new UserDTO(userRepository.find(filterParams));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    @Override
    public UserDTO post(UserRequestDTO user) {
        return new UserDTO(userRepository.post(user.toUserEntity()));
    }

    @Override
    public UserDTO update(UserDTO user) {
        return new UserDTO(userRepository.update(user.toUserEntity()));
    }

    @Override
    public Map<String, String> delete(String id) {
        return userRepository.delete(id);
    }
}
