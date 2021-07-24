package mx.com.gm.dao;

import mx.com.gm.domain.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaDao extends JpaRepository<Transferencia, Long>{
    
}
