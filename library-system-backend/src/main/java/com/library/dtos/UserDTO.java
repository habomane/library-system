package com.library.dtos;

import com.library.models.UserEntity;

public class UserDTO {
    private String id;
    public String userId;
    public String privateKey;
    public String dateCreation;

    public UserDTO() {}

    public UserDTO(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.privateKey = userEntity.getPrivateKey();
        this.userId = userEntity.getUserId();
        this.dateCreation = userEntity.getDateCreation();
    }

    public UserEntity toUserEntity()
    {
        return new UserEntity(id, userId, privateKey, dateCreation);
    }

    public boolean isValid()
    {
        return privateKey == null || privateKey.isEmpty() || userId == null
                || userId.isEmpty() || dateCreation == null || dateCreation.isEmpty() ? false : true;
    }
}
