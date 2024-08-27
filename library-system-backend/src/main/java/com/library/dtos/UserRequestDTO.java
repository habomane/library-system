package com.library.dtos;

import com.library.models.UserEntity;

public class UserRequestDTO {
    public String privateKey;

    public UserRequestDTO() {}

    public UserRequestDTO(String privateKey) {
        this.privateKey = privateKey;
    }

    public UserEntity toUserEntity()
    {
        return new UserEntity(privateKey);
    }

    public boolean isValid()
    {
        return privateKey == null || privateKey.isEmpty() ? false : true;
    }

}
