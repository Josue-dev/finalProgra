/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;
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
@Table(name = "cat_laboratorio")
public class Laboratorio {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idLaboratorio;

     
     private int idPais;
     
     
     @NotEmpty
     private String nombreLaboratorio;
    
}
