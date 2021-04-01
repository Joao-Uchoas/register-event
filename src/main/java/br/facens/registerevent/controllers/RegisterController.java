package br.facens.registerevent.controllers;

import java.net.URI;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.facens.registerevent.dto.RegisterDTO;
import br.facens.registerevent.dto.RegisterInsertDTO;
import br.facens.registerevent.dto.RegisterUpdateDTO;
import br.facens.registerevent.service.RegisterService;

@RestController
@RequestMapping("/registers")
public class RegisterController {
    
    @Autowired
    private RegisterService service;

    @GetMapping
    public ResponseEntity<Page<RegisterDTO>> getRegister(

        @RequestParam(value = "page",           defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage",   defaultValue = "5") Integer linesPerPage,
        @RequestParam(value = "direction",      defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",        defaultValue = "id") String orderBy,
        @RequestParam(value = "name",           defaultValue = "") String  name,
        @RequestParam(value = "place",          defaultValue = "") String  place,
        @DateTimeFormat(iso = ISO.DATE) LocalDate startDate,// a data tem que colocar "ano/mes/dia" e não só um valor... 
                                                            //exemplo 01, ele não vai achar o dia 01 ou o mes 01,
                                                            //mas acharia 2022-01-01.
        @RequestParam(value = "description",    defaultValue = "") String  description


    ){

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page<RegisterDTO> list = service.getRegisters(pageRequest, name, place, startDate, description);
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<RegisterDTO> getRegisterById(@PathVariable Long id){
        RegisterDTO dto = service.getRegisterById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<RegisterDTO> insert(@RequestBody RegisterInsertDTO insertDto){
        RegisterDTO dto = service.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<RegisterDTO> update(@PathVariable Long id, @RequestBody RegisterUpdateDTO updateDto){
        RegisterDTO dto = service.update(id, updateDto);
        return ResponseEntity.ok().body(dto);
    }
    
    

}
