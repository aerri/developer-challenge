package br.com.ia.developerchallenge.webservice.models;

import br.com.ia.developerchallenge.webservice.dto.UserAdminDto;
import br.com.ia.developerchallenge.webservice.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import java.util.Date;

@Data
@RedisHash(value = "user")
public class User {

    //region Private Fields
    @Id
    @Indexed
    protected String id;
    protected String name;
    protected String login;
    protected String password;
    @JsonProperty("create_date")
    protected Date createDate = new Date();
    @JsonProperty("update_date")
    protected Date updateDate;
    protected String email;
    protected boolean isAdmin = false;
    //endregion

    //region Constructors
    public User() {}

    public User(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(UserDto dto) {
        this(dto.getName(), dto.getLogin(), dto.getPassword(), dto.getEmail());
    }
    //endregion

    public void getContentFromDto(UserAdminDto dto) {
        this.name = dto.getName();
        this.login = dto.getLogin();
        this.password = dto.getPassword();
        this.updateDate = new Date();
        this.email = dto.getEmail();
        this.isAdmin = dto.isAdmin();
    }

}
