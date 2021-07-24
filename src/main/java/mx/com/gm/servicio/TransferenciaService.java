package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Transferencia;

/**
 *
 * @author Willian Führ
 */

public interface TransferenciaService {
    
    public List<Transferencia> listarTransferencias();
    
    public void guardarTransferencia(Transferencia transferencia);
    
    public void eliminarTransferencia(Transferencia transferencia);
    
    public Transferencia encontrarTransferencia(Transferencia transferencia);
}
