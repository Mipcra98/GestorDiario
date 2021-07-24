package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.TransferenciaDao;
import mx.com.gm.domain.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Willian Führ
 */

@Service
public class TransferenciaServiceImplements implements TransferenciaService {

    @Autowired
    private TransferenciaDao TransferenciaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Transferencia> listarTransferencias() {
        return (List<Transferencia>) TransferenciaDao.findAll();
    }

    @Override
    @Transactional
    public void guardarTransferencia(Transferencia transferencia) {
        TransferenciaDao.save(transferencia);
    }

    @Override
    @Transactional
    public void eliminarTransferencia(Transferencia transferencia) {
        TransferenciaDao.delete(transferencia);
    }

    @Override
    @Transactional(readOnly = true)
    public Transferencia encontrarTransferencia(Transferencia transferencia) {
        return TransferenciaDao.findById(transferencia.getId_transferencia()).orElse(null);
    }
}
