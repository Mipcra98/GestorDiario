package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.SalidaDao;
import mx.com.gm.domain.Salida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Willian Führ
 */

@Service
public class SalidaServiceImplements implements SalidaService {

    @Autowired
    private SalidaDao SalidaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Salida> listarSalidas() {
        return (List<Salida>) SalidaDao.findAll();
    }

    @Override
    @Transactional
    public void guardarSalida(Salida salida) {
        SalidaDao.save(salida);
    }

    @Override
    @Transactional
    public void eliminarSalida(Salida salida) {
        SalidaDao.delete(salida);
    }

    @Override
    @Transactional(readOnly = true)
    public Salida encontrarSalida(Salida salida) {
        return SalidaDao.findById(salida.getId_salida()).orElse(null);
    }
}
