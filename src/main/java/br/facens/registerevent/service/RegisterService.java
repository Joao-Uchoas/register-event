package br.facens.registerevent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.facens.registerevent.dto.RegisterDTO;
import br.facens.registerevent.dto.RegisterInsertDTO;
import br.facens.registerevent.entities.Register;
import br.facens.registerevent.repository.RegisterRepository;

@Service
public class RegisterService {
    
    @Autowired
    private RegisterRepository repo;

    public List<RegisterDTO> getRegisters(){
        List<Register> list = repo.findAll();
        return toDTOList(list);
    }

    private List<RegisterDTO> toDTOList(List<Register> list) {
        List<RegisterDTO> listDTO = new ArrayList<>();
        for(Register r : list){
            RegisterDTO dto = new RegisterDTO(r.getId(), r.getName(), r.getDescription(), r.getPlace(), r.getStartDate(), r.getEndDate(), r.getStartTime(), r.getEndTime());
            listDTO.add(dto);
        }
        return listDTO;
    }

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


    
}
