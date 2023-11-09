package br.facens.registerevent.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.facens.registerevent.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // Consulta JPQL corrigida
    @Query("SELECT r FROM Event r WHERE " +
            "LOWER(r.category) LIKE LOWER(CONCAT('%', :category, '%')) AND " +
            "LOWER(r.emailContact) LIKE LOWER(CONCAT('%', :emailContact, '%')) AND " +
            "LOWER(r.name) LIKE LOWER(CONCAT('%', :name, '%')) AND " +
            "(:priceTicket IS NULL OR r.priceTicket = :priceTicket)"
    )
    public Page<Event> find(Pageable pageRequest, String category, String emailContact, String name, Double priceTicket);
}
