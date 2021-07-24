package mx.com.gm.dao;

import mx.com.gm.domain.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaDao extends JpaRepository<Entrada, Long>{
    
}
