/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Mipcra98
 */
@Entity
@Data
@Table(name="entrada")
public class Entrada implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entrada;
    
    @NotEmpty
    private String categoria;
    
    @NotEmpty
    private Long monto;
    
    @NotEmpty
    private String descripcion;
    
    @NotEmpty
    private Date fecha;
    
    @NotEmpty
    private Long id_metodo;
}
