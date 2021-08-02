package br.com.ia.developerchallenge.webservice.dto.response;

import br.com.ia.developerchallenge.webservice.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class UserResponseDto {

    //region Private Fields
    @JsonProperty("name")
    protected String name;
    @JsonProperty("create_date")
    protected Date createDate;
    @JsonProperty("update_date")
    protected Date updateDate;
    @JsonProperty("email")
    protected String email;
    //endregion

    //region Constructors
    public UserResponseDto(String name, Date createDate, Date updateDate, String email) {
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.email = email;
    }

    public UserResponseDto(User user) {
        this(user.getName(), user.getCreateDate(), user.getUpdateDate(), user.getEmail());
    }
    //endregion

}
