/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;


import com.example.demo.dao.IntAplicacionDosisDao;
import com.example.demo.domain.AplicacionDosis;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ajvasquez
 */
@Service
public class AplicacionDosisServiceImple implements AplicacionDosisService {
    @Autowired
    private IntAplicacionDosisDao aplicacionesDosis;

    @Override
    @Transactional(readOnly=true)
    public List<AplicacionDosis> listarAplicacionDosis() {
        return (List<AplicacionDosis>) aplicacionesDosis.findAll();
    }

    @Override
     @Transactional
    public void guardar(AplicacionDosis aplicacionDosis) {
        aplicacionesDosis.save(aplicacionDosis);
        
    }

    @Override
    @Transactional
    public void eliminar(AplicacionDosis aplicacionDosis) {
        aplicacionesDosis.delete(aplicacionDosis);
    }

    @Override
    @Transactional(readOnly=true)
    public AplicacionDosis encontrarAplicacionDosis(AplicacionDosis aplicacionDosis) {
         return aplicacionesDosis.findById(aplicacionDosis.getIdAplicacion()).orElse(null);
    }

  
    
}
