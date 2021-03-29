package br.facens.registerevent.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.facens.registerevent.entities.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Long>{
    
    //Consulta JPQL!!!
    @Query("SELECT r FROM Register r " + 
            "WHERE"+ 
            "(r.name LIKE CONCAT('%', :name, '%')) AND " +
            "(r.place LIKE CONCAT('%', :place, '%')) AND"+
            "(r.description LIKE CONCAT('%', :description, '%'))"
    )
    public Page<Register> find(Pageable pageRequest, String name, String place, String description);
    
}
