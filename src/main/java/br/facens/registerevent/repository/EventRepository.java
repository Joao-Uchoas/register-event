package br.facens.registerevent.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.facens.registerevent.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long>{
    
    //Consulta JPQL!!!
    @Query("SELECT r FROM Register r " + 
            "WHERE"+ 
            "(r.name LIKE CONCAT('%', :name, '%')) AND " +
            "(r.place LIKE CONCAT('%', :place, '%')) AND"+
            "(r.startDate LIKE CONCAT('%', :startDate, '%')) AND"+
            "(r.description LIKE CONCAT('%', :description, '%'))"
    )
    public Page<Event> find(Pageable pageRequest, String name, String place, LocalDate startDate,String description);
    
}
