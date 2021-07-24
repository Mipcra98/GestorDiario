package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Entrada;

/**
 *
 * @author Willian Führ
 */

public interface EntradaService {
    
    public List<Entrada> listarEntradas();
    
    public void guardarEntrada(Entrada entrada);
    
    public void eliminarEntrada(Entrada entrada);
    
    public Entrada encontrarEntrada(Entrada entrada);
}
