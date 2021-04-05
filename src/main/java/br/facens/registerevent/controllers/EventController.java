package br.facens.registerevent.controllers;

import java.net.URI;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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

import br.facens.registerevent.dto.EventDTO;
import br.facens.registerevent.dto.EventInsertDTO;
import br.facens.registerevent.dto.EventUpdateDTO;
import br.facens.registerevent.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvent(

        @RequestParam(value = "page",           defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage",   defaultValue = "5") Integer linesPerPage,
        @RequestParam(value = "direction",      defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",        defaultValue = "id") String orderBy,
        @RequestParam(value = "name",           defaultValue = "") String  name,
        @RequestParam(value = "place",          defaultValue = "") String  place,
        @RequestParam(value = "startDate",      defaultValue = "01/01/0001") LocalDate startDate,// a data tem que colocar "dia/mes/ano" e não só um valor... 
                                                                                                 //exemplo: 01 não vai achar o dia 01 ou o mes 01,
                                                                                                 //mas acharia 01/01/0001.
        @RequestParam(value = "description",    defaultValue = "") String  description


    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page<EventDTO> list = service.getEvents(pageRequest, name, place, startDate, description);
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id){
        EventDTO dto = service.getEventById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EventDTO> insert(@Valid @RequestBody EventInsertDTO insertDto){
        EventDTO dto = service.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id,@Valid @RequestBody EventUpdateDTO updateDto){
        EventDTO dto = service.update(id, updateDto);
        return ResponseEntity.ok().body(dto);
    }
    
    

}
