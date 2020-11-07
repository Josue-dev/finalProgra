/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.InterfPersonaDao;
import com.example.demo.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ajvasquez
 */
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private InterfPersonaDao personaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Persona> listarPersonas() {
      return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional//estos metodos modifican datos 
    public void guardar(Persona persona) {
       personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
     personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly=true)//este metodo solo consulta no modifica
    public Persona encontrarPersona(Persona persona) {
      return personaDao.findById(persona.getIdPersona()).orElse(null);//sino encuentra el dato buscado regresara null
    }
    
}
