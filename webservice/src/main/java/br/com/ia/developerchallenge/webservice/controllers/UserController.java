package br.com.ia.developerchallenge.webservice.controllers;

import br.com.ia.developerchallenge.webservice.dto.UserAdminDto;
import br.com.ia.developerchallenge.webservice.dto.UserDto;
import br.com.ia.developerchallenge.webservice.dto.response.UserResponseDto;
import br.com.ia.developerchallenge.webservice.models.User;
import br.com.ia.developerchallenge.webservice.services.interfaces.IUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    protected IUserDataService dataService;

    @Autowired
    public UserController(IUserDataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<User> createUser(@RequestBody UserDto dto) {
        return new ResponseEntity<>(this.dataService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("users")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(this.dataService.findAll());
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String id) {
        return ResponseEntity.ok(this.dataService.findById(id));
    }

    @PutMapping(value = "/user/{id}", consumes = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserAdminDto dto) {
        return new ResponseEntity<>(this.dataService.update(id, dto), HttpStatus.CREATED);
    }

}
