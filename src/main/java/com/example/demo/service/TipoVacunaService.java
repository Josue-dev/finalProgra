/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.domain.TipoVacuna;
import java.util.List;

/**
 *
 * @author ajvasquez
 */
public interface TipoVacunaService {
     public List<TipoVacuna>listarTipoVacuna();
    
    public void guardarV(TipoVacuna tipoVacuna);
    
    public void eliminarV(TipoVacuna tipoVacuna);
    
    public TipoVacuna encontrarTipoVacunaV(TipoVacuna tipoVacuna);
    
}
