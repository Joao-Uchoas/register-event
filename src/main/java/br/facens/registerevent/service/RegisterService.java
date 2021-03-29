package br.facens.registerevent.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.facens.registerevent.dto.RegisterDTO;
import br.facens.registerevent.dto.RegisterInsertDTO;
import br.facens.registerevent.dto.RegisterUpdateDTO;
import br.facens.registerevent.entities.Register;
import br.facens.registerevent.repository.RegisterRepository;

@Service
public class RegisterService {
    
    @Autowired
    private RegisterRepository repo;

    public Page<RegisterDTO> getRegisters(PageRequest pageRequest, String name, String place, String description){
        Page<Register> list = repo.find(pageRequest, name, place, description);
        return list.map( r -> new RegisterDTO(r));
    }


//  toDTOList foi mudado para fazer a listagem paginada
    /*
    private List<RegisterDTO> toDTOList(List<Register> list) {
        List<RegisterDTO> listDTO = new ArrayList<>();
        for(Register r : list){
            RegisterDTO dto = new RegisterDTO(r.getId(), r.getName(), r.getDescription(), r.getEmailContact());
            listDTO.add(dto);
        }
        return listDTO;
    }
*/
    public RegisterDTO getRegisterById(Long id){
        Optional<Register> op = repo.findById(id);
        Register reg = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Register not foud"));
        return new RegisterDTO(reg);
    }

    public RegisterDTO insert(RegisterInsertDTO dto){
        Register entity = new Register(dto); 
        entity = repo.save(entity);
        return new RegisterDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    public RegisterDTO update(Long id, RegisterUpdateDTO dto){
        try {
            Register entity = repo.getOne(id);
            entity.setName(dto.getName());
            entity.setEmailContact(dto.getEmailContact());
            entity = repo.save(entity);
            return new RegisterDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    
}
