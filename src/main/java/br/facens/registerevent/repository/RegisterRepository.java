package br.facens.registerevent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.facens.registerevent.entities.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Long>{
    
    
}
