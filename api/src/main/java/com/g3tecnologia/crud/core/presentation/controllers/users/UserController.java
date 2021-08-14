package com.g3tecnologia.crud.core.presentation.controllers.users;

import com.g3tecnologia.crud.core.domain.business.users.UserModel;
import com.g3tecnologia.crud.core.infrastructure.repositories.users.IUserRepository;
import com.g3tecnologia.crud.core.presentation.controllers.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController extends BaseController {

    public MessageSource _messageSource;

    @Autowired
    IUserRepository _userRepository;

    @Autowired(required = true)
    PasswordEncoder passwordEncoder;

    public UserController (IUserRepository userRepository, MessageSource messageSource){
        this._userRepository = userRepository;
        this._messageSource =  messageSource;
    }


    @GetMapping("/")
    public ResponseEntity<?> findAll(){
       try {
           List<UserModel> response = _userRepository.findAll();
           return Ok(response);
       }catch (Exception ex){
           return BadRequest(ex);
       }
    }

    @GetMapping("/ativo")
    public ResponseEntity<?> findAllActive(){
        try {
            List<UserModel> response = _userRepository.findAllActive();
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> findAllCpf(@PathVariable String cpf){
        try {
            UserModel response = _userRepository.findByCpf(cpf);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UserModel user){
        try {
            UserModel response = _userRepository.save(user);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody UserModel user){
        try {
            UserModel response = _userRepository.save(user);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            Boolean response = _userRepository.logicDelete(id);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @PostMapping("")
    public ResponseEntity<?>  save(@RequestBody UserModel user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            _userRepository.save(user);
            return Ok(user);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @PostMapping("pass_encode")
    public ResponseEntity<?>  pass_encode(@RequestBody UserModel user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return Ok(user);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

}


