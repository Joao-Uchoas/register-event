package br.facens.registerevent.service;


import java.util.Optional;

import br.facens.registerevent.dto.event.SeatDTO;
import br.facens.registerevent.entities.Seat;
import br.facens.registerevent.enums.Category;
import br.facens.registerevent.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.facens.registerevent.dto.event.EventDTO;
import br.facens.registerevent.dto.event.EventInsertDTO;
import br.facens.registerevent.entities.Event;
import br.facens.registerevent.entities.Place;
import br.facens.registerevent.repository.EventRepository;
import br.facens.registerevent.repository.PlaceRepository;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repo;

    @Autowired
    private PlaceService servicePlace;

    @Autowired
    private PlaceRepository placeRepository;

    public Page<EventDTO> getEvents(PageRequest pageRequest, String category, String emailContact, String name, Double priceTicket){
        Page<Event> list = repo.find(pageRequest, category, emailContact, name, priceTicket);
        return list.map( r -> new EventDTO(r));
    }

    public EventDTO getEventById(Long id){
        Optional<Event> op = repo.findById(id);
        Event reg = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not foud"));
        return new EventDTO(reg);
    }

    public EventDTO insert(Long placeId, EventInsertDTO eventDto){
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new ResourceNotFoundException("Place not found"));

        Event entity = new Event(eventDto);
        entity.setPlace(place);

        for (SeatDTO seatDTO : eventDto.getSeats()) {
            Seat seat = new Seat();
            seat.setRow(seatDTO.getRow());
            seat.setNumber(seatDTO.getNumber());
            entity.getSeats().add(seat);
        }

        if (entity.getCategory() == Category.CINEMA || entity.getCategory() == Category.TEATRO ) {
            entity.setAmountVIPTickets(0l);
        }

        // Verifica se o preço do ingresso é válido
        if (entity.getPriceTicket() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor do ingresso deve ser maior que zero.");
        }

        // Verifica se a quantidade de ingressos é válida
        if (entity.getAmountCommonTickets() <= 0 && entity.getAmountVIPTickets() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Deve haver pelo menos um ingresso disponível para o evento.");
        }


       // Servira para quando o usuario tentar comprar o ingresso
//        // Regras específicas para Teatro e Cinema
//        if (entity.getCategory() == Category.TEATRO || entity.getCategory() == Category.CINEMA) {
//            String desiredRow = eventDto.getRow();
//            Integer desiredNumber = eventDto.getNumber();
//
//            if (!entity.isSeatAvailable(desiredRow, desiredNumber)) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O lugar escolhido não está disponível.");
//            }
//        }
//
//        // Regras específicas para Shows
//        if (entity.getCategory() == Category.SHOW) {
//            // Se for um show, você pode querer verificar se os ingressos são VIP ou comuns.
//            // Por exemplo:
//            if (entity.getAmountVIPTickets() > 0 && entity.getAmountCommonTickets() > 0) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Para shows, os ingressos devem ser ou VIP ou comuns, não ambos.");
//            }
//        }

        entity = repo.save(entity);

        return new EventDTO(entity);
    }


    public void delete(Long id){
        try{
            repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Event not found");
        }
    }

}

