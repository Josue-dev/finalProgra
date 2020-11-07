/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "tb_aplicacion_dosis")
public class AplicacionDosis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAplicacion;

    @NotEmpty
    private String idInventarioVacuna;
    @NotEmpty
    private String idPersona;
    @NotEmpty
    private String fechaAplicacion;
    @NotEmpty
    private String cantidadAplicada;

}
