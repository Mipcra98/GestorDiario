package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Salida;

/**
 *
 * @author Willian Führ
 */

public interface SalidaService {
    
    public List<Salida> listarSalidas();
    
    public void guardarSalida(Salida salida);
    
    public void eliminarSalida(Salida salida);
    
    public Salida encontrarSalida(Salida salida);
}
