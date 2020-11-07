/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.domain.Laboratorio;
import java.util.List;

/**
 *
 * @author ajvasquez
 */
public interface LaboratorioService {
     public List<Laboratorio>listarLaboratorios();
    
    public void guardar(Laboratorio labortorio);
    
    public void eliminar(Laboratorio labortorio);
    
    public Laboratorio encontrarLaboratorio(Laboratorio laboratorio);
}
