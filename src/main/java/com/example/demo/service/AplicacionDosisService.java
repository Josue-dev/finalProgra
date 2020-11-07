/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.domain.AplicacionDosis;
import java.util.List;

/**
 *
 * @author ajvasquez
 */
public interface AplicacionDosisService {
     public List<AplicacionDosis>listarAplicacionDosis();
    
    public void guardar(AplicacionDosis aplicacionDosis);
    
    public void eliminar(AplicacionDosis aplicacionDosis);
    
    public AplicacionDosis encontrarAplicacionDosis(AplicacionDosis aplicacionDosis);
    
}
