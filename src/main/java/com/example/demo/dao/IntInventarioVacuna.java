/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.domain.InventarioVacunas;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author ajvasquez
 */
public interface IntInventarioVacuna extends CrudRepository<InventarioVacunas, Long>{
    
}
