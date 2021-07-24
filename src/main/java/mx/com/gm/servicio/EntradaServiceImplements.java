package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.EntradaDao;
import mx.com.gm.domain.Entrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Willian Führ
 */

@Service
public class EntradaServiceImplements implements EntradaService {

    @Autowired
    private EntradaDao EntradaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Entrada> listarEntradas() {
        return (List<Entrada>) EntradaDao.findAll();
    }

    @Override
    @Transactional
    public void guardarEntrada(Entrada entrada) {
        EntradaDao.save(entrada);
    }

    @Override
    @Transactional
    public void eliminarEntrada(Entrada entrada) {
        EntradaDao.delete(entrada);
    }

    @Override
    @Transactional(readOnly = true)
    public Entrada encontrarEntrada(Entrada entrada) {
        return EntradaDao.findById(entrada.getId_entrada()).orElse(null);
    }
}
