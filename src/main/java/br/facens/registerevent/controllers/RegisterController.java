package br.facens.registerevent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.registerevent.dto.RegisterDTO;
import br.facens.registerevent.service.RegisterService;

@RestController
@RequestMapping("/registers")
public class RegisterController {
    
    @Autowired
    private RegisterService service;

    @GetMapping
    public ResponseEntity<List<RegisterDTO>> getRegister(){
        List<RegisterDTO> list = service.getRegisters();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<RegisterDTO> getRegisterById(@PathVariable Long id){
        RegisterDTO dto = service.getRegisterById(id);
        return ResponseEntity.ok(dto);
    }

}
