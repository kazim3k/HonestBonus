package com.github.groupproject.dto;

import com.github.groupproject.entities.User;

public class UserDto {

    private String uuid;
    private String companyName;
    private String email;

    public UserDto(String uuid, String companyName, String email) {
        this.uuid = uuid;
        this.companyName = companyName;
        this.email = email;
    }

    public UserDto(User user){
        this.uuid = user.getUuid();
        this.companyName = user.getCompanyName();
        this.email = user.getEmail();
    }

    public String getUuid() {
        return uuid;
    }



    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email;
    }
}
