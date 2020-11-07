/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author ajvasquez el @Data nos ayudara con los geters y seter y constructores
 * que haciamos a mano
 */
@Data
@Entity
@Table(name = "tb_persona")//para evitar la conversion de el nombre de la tabla de datos
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @NotEmpty
    private String cui;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String fechaNacimiento;

    @NotEmpty
    private String direccion;

    @NotEmpty
    private String telefonoMovil;

    @NotEmpty
    private String telefonoCasa;

    @NotEmpty
    private String nombreEncargado;

    @NotEmpty
    private String cuiEncargado;

}
