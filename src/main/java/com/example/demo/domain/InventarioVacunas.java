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
import lombok.Data;

/**
 *
 * @author ajvasquez
 */
@Data
@Entity
@Table(name = "tb_inventario_vacunas")
public class InventarioVacunas implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idInventarioVacuna;
     
     private String idTipoVacuna;
     private String idLaboratorio;
     private String fechaCompra;
     private String fechaCaducidad;
     private String numeroLote;
     private String precioLote;
     private String cantidadLote;
    
}
