/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;


import com.example.demo.dao.IntTipoVacuna;
import com.example.demo.domain.TipoVacuna;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ajvasquez
 */
@Service
public class TipoVacunaServiceImpl implements TipoVacunaService{
    @Autowired
    private IntTipoVacuna intTipoVacuna;

    @Override
    @Transactional(readOnly=true)
    public List<TipoVacuna> listarTipoVacuna() {
        return (List<TipoVacuna>) intTipoVacuna.findAll();
    }

    @Override
    @Transactional
    public void guardarV(TipoVacuna tipoVacuna) {
        intTipoVacuna.save(tipoVacuna);
    }

    @Override
    @Transactional
    public void eliminarV(TipoVacuna tipoVacuna) {
        intTipoVacuna.delete(tipoVacuna);
    }

    @Override
    @Transactional(readOnly=true)
    public TipoVacuna encontrarTipoVacunaV(TipoVacuna tipoVacuna) {
         return intTipoVacuna.findById(tipoVacuna.getIdTipoVacuna()).orElse(null);
    }
   
}
