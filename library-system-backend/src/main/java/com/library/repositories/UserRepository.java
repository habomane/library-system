package com.library.repositories;

import com.library.models.UserEntity;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface UserRepository {

    UserEntity find(String userId);

    List<UserEntity> findAll();

    UserEntity post(UserEntity user);

    Map<String, String> delete(String userId);
}
