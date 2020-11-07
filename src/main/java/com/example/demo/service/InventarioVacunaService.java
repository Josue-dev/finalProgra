/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.domain.InventarioVacunas;
import java.util.List;

/**
 *
 * @author ajvasquez
 */
public interface InventarioVacunaService {
     public List<InventarioVacunas>listarInventarioVacunas();
    
    public void guardar(InventarioVacunas inventarioVacunas);
    
    public void eliminar(InventarioVacunas inventarioVacunas);
    
    public InventarioVacunas encontrarLaboratorio(InventarioVacunas inventarioVacunas);
    
}
