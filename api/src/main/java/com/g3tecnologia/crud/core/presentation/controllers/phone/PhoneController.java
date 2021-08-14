package com.g3tecnologia.crud.core.presentation.controllers.phone;
import com.g3tecnologia.crud.core.domain.business.phone.PhoneModel;
import com.g3tecnologia.crud.core.infrastructure.repositories.phone.IPhoneRepository;
import com.g3tecnologia.crud.core.presentation.controllers.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/phone")
public class PhoneController extends BaseController {

    @Autowired
    IPhoneRepository _phoneRepository;


    public PhoneController (IPhoneRepository phoneRepository){
        this._phoneRepository = phoneRepository;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        try {
            List<PhoneModel> response = _phoneRepository.findAll();
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @GetMapping("/ativo")
    public ResponseEntity<?> findAllActive(){
        try {
            List<PhoneModel> response =  _phoneRepository.findAllActive();
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody PhoneModel phone){
        try {
            PhoneModel response = _phoneRepository.save(phone);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody PhoneModel phone){
        try {
            PhoneModel response = _phoneRepository.save(phone);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            Boolean response = _phoneRepository.logicDelete(id);
            return Ok(response);
        }catch (Exception ex){
            return BadRequest(ex);
        }
    }
}
