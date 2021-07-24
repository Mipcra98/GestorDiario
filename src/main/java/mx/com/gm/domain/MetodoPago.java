/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Mipcra98
 */
@Entity
@Data
@Table(name="metodo_pago")
public class MetodoPago implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_metodos_pago;
    
    @NotEmpty
    private String nombre;
    
    @OneToOne
    public Entrada entrada;
    
    @OneToOne
    public Salida salida;
    
    @OneToOne
    public Transferencia tranferencia;
}
