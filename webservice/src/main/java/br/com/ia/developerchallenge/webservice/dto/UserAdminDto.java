package br.com.ia.developerchallenge.webservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAdminDto extends UserDto {

    @JsonProperty("admin")
    protected Boolean isAdmin;

    public Boolean isAdmin() {
        return isAdmin;
    }

}
