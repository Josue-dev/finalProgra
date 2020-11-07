/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.IntLaboratorioDao;
import com.example.demo.domain.Laboratorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ajvasquez
 */
@Service
public class LaboratorioServiceImpl implements LaboratorioService{
    @Autowired
    private IntLaboratorioDao intLaboratorioDao;

    @Override
    @Transactional(readOnly=true)
    public List<Laboratorio> listarLaboratorios() {
        return (List<Laboratorio>) intLaboratorioDao.findAll();
    }

    @Override
     @Transactional
    public void guardar(Laboratorio laboratorio) {
        intLaboratorioDao.save(laboratorio);
    }

    @Override
     @Transactional
    public void eliminar(Laboratorio labortorio) {
        intLaboratorioDao.delete(labortorio);
    }

    @Override
    @Transactional(readOnly=true)
    public Laboratorio encontrarLaboratorio(Laboratorio laboratorio) {
         return intLaboratorioDao.findById(laboratorio.getIdLaboratorio()).orElse(null);
    }
    
    
}
