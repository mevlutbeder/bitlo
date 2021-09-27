package com.bitlo.controller;

import com.bitlo.model.User;
import com.bitlo.repository.UserRepository;
import com.bitlo.utils.HeaderUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@Api(value = "User Api documentation")
public class UserController extends ApiController {

    private final UserRepository userRepository;

    private static final String ENTITY_NAME = "User";

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users")
    @ApiOperation(value = "Get all Users pagination method")
    public ResponseEntity<List<User>> getAllUsers(@ApiParam Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        System.out.println("REST request to deleted " + ENTITY_NAME + " id : " + id);
        userRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) throws URISyntaxException {
        System.out.println("REST request to update " + ENTITY_NAME + " id : " + user);
        if (user.getId() == null) {
            return createUser(user);
        }
        User result = userRepository.save(user);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, user.getId().toString())).body(result);
    }

    @PostMapping("/user")
    @ApiOperation(value = "New User adding method")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        System.out.println("REST request to save " + ENTITY_NAME);
        if (user.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new user cannot already have an ID")).body(null);
        }
        User result = userRepository.save(user);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        System.out.println("REST request to get " + ENTITY_NAME + " id : " + id);
        User user = userRepository.findUserById(id);
        if (user.getId() == null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "User not have an ID")).body(null);
        }
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, user.getId().toString())).body(user);
    }

}