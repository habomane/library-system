package com.library.repositories;

import com.library.models.UserEntity;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface UserRepository {

    UserEntity find(Map<String, String> filterParams);

    List<UserEntity> findAll();

    UserEntity post(UserEntity user);

    UserEntity update(UserEntity user);

    Map<String, String> delete(String userId);
}
