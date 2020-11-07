/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.IntInventarioVacuna;
import com.example.demo.domain.InventarioVacunas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ajvasquez
 */
@Service
public class InventarioVacunaServiceImpl implements InventarioVacunaService{
    @Autowired
    private IntInventarioVacuna inventarioVacuna;

    @Override
    @Transactional(readOnly=true)
    public List<InventarioVacunas> listarInventarioVacunas() {
        return (List<InventarioVacunas>) inventarioVacuna.findAll();
    }

    @Override
    @Transactional
    public void guardar(InventarioVacunas inventarioVacunas) {
        inventarioVacuna.save(inventarioVacunas);
    }

    @Override
    @Transactional
    public void eliminar(InventarioVacunas inventarioVacunas) {
        inventarioVacuna.delete(inventarioVacunas);
    }

    @Override
     @Transactional(readOnly=true)
    public InventarioVacunas encontrarLaboratorio(InventarioVacunas inventarioVacunas) {
          return inventarioVacuna.findById(inventarioVacunas.getIdInventarioVacuna()).orElse(null);
    }
    
}
