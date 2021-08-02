package br.com.ia.developerchallenge.webservice.repositories.interfaces;

import br.com.ia.developerchallenge.webservice.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<User, String> {

    @Override
    List<User> findAll();

}
