package br.com.ia.developerchallenge.webservice.services.interfaces;

import br.com.ia.developerchallenge.webservice.dto.UserAdminDto;
import br.com.ia.developerchallenge.webservice.dto.UserDto;
import br.com.ia.developerchallenge.webservice.dto.response.UserResponseDto;
import br.com.ia.developerchallenge.webservice.models.User;
import java.util.List;

public interface IUserDataService {

    List<UserResponseDto> findAll();
    UserResponseDto findById(String id);
    User create(UserDto dto);
    User update(String id, UserAdminDto dto);
}
