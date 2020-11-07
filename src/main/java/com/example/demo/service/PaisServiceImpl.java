/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.IntPaisDao;
import com.example.demo.domain.Pais;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ajvasquez
 */
@Service
public class PaisServiceImpl implements PaisService{
    @Autowired
    private IntPaisDao intPaisDao;

    @Override
    @Transactional(readOnly=true)
    public List<Pais> listarPaises() {
        return (List<Pais>) intPaisDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Pais pais) {
       intPaisDao.save(pais);
    }

    @Override
    @Transactional
    public void eliminar(Pais pais) {
        intPaisDao.delete(pais);
    }

    @Override
    @Transactional(readOnly=true)
    public Pais encontrarPais(Pais pais) {
         return intPaisDao.findById(pais.getIdPais()).orElse(null);
    }
    
}
