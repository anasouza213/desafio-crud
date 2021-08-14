package com.g3tecnologia.crud.core.presentation.controllers.email;
import com.g3tecnologia.crud.core.domain.business.email.EmailModel;
import com.g3tecnologia.crud.core.domain.business.users.UserModel;
import com.g3tecnologia.crud.core.infrastructure.repositories.email.IEmailRepository;
import com.g3tecnologia.crud.core.presentation.controllers.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/email")
public class EmailController extends BaseController {

    @Autowired
    IEmailRepository _emailRepository;

    public EmailController (IEmailRepository emailRepository){
        this._emailRepository = emailRepository;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        try {
            List<EmailModel> response = _emailRepository.findAll();
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @GetMapping("/ativo")
    public ResponseEntity<?> findAllActive(){
        try {
            List<EmailModel> response = _emailRepository.findAllActive();
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody EmailModel email){
        try {
            EmailModel response = _emailRepository.save(email);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody EmailModel email){
        try {
            EmailModel response = _emailRepository.save(email);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            Boolean response = _emailRepository.logicDelete(id);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }
}
