package br.com.ia.developerchallenge.webservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

    //region Private Fields
    @JsonProperty("name")
    protected String name;
    @JsonProperty("login")
    protected String login;
    @JsonProperty("password")
    protected String password;
    @JsonProperty("email")
    protected String email;
    //endregion

    //region Getters
    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    //endregion
}
