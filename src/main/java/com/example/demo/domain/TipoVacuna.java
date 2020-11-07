
package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author ajvasquez
 */
@Data
@Entity
@Table(name = "cat_tipo_vacuna")
public class TipoVacuna implements Serializable{
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoVacuna;
    
    @NotEmpty
    private String idLaboratorio;
    @NotEmpty
    private String nombreVacuna;
    @NotEmpty
    private String efectosAdversos;
    @NotEmpty
    private String modoAlmacen;
    @NotEmpty
    private String cantidadAplicaciones;
}
