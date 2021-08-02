package br.com.ia.developerchallenge.webservice.services;

import br.com.ia.developerchallenge.webservice.dto.UserAdminDto;
import br.com.ia.developerchallenge.webservice.dto.UserDto;
import br.com.ia.developerchallenge.webservice.dto.response.UserResponseDto;
import br.com.ia.developerchallenge.webservice.models.User;
import br.com.ia.developerchallenge.webservice.repositories.interfaces.IUserRepository;
import br.com.ia.developerchallenge.webservice.services.interfaces.IUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDataService implements IUserDataService {

    protected IUserRepository repository;

    @Autowired
    public UserDataService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(UserDto dto) {
        return this.repository.save(new User(dto));
    }

    @Override
    public List<UserResponseDto> findAll() {
        return this.repository.findAll().stream().map(UserResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findById(String id) {
        return this.repository.findById(id).map(UserResponseDto::new).orElse(null);
    }

    @Override
    public User update(String id, UserAdminDto dto) {
        Optional<User> result = this.repository.findById(id);
        if (result.isPresent()) {
            User user = result.get();
            user.getContentFromDto(dto);
            return this.repository.save(user);
        }
        return null;
    }

}
