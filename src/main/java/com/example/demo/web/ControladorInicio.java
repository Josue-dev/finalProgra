package com.example.demo.web;

import com.example.demo.domain.AplicacionDosis;
import com.example.demo.domain.InventarioVacunas;
import com.example.demo.domain.Laboratorio;
import com.example.demo.domain.Pais;
import com.example.demo.domain.Persona;
import com.example.demo.domain.TipoVacuna;
import com.example.demo.service.AplicacionDosisService;
import com.example.demo.service.InventarioVacunaService;
import com.example.demo.service.LaboratorioService;
import com.example.demo.service.PaisService;
import com.example.demo.service.PersonaService;
import com.example.demo.service.TipoVacunaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;
    @Autowired
    private PaisService paisService;
    @Autowired
    private LaboratorioService laboratorioService;
    @Autowired
    private TipoVacunaService tipoVacunaService;
    @Autowired
    private InventarioVacunaService inventarioVacunaService;
    @Autowired
    private AplicacionDosisService aplicacionDosisService;
    

    @GetMapping("/")//ruta de inicio
    public String Inicio(Model model,@AuthenticationPrincipal User user) {//con el @authencation sabremos que usuario esta logiado
        var personas = personaService.listarPersonas();
        var paises = paisService.listarPaises();
        var laboratorios =laboratorioService.listarLaboratorios();
        var tipoVacunas = tipoVacunaService.listarTipoVacuna();
        var inventarioVacunas = inventarioVacunaService.listarInventarioVacunas();
        var aplicacionDosis = aplicacionDosisService.listarAplicacionDosis();
        
        log.info("ejecutando desde el controlador");
        log.info("Usuario que esta logiado: "+user);
        
        model.addAttribute("personas", personas);
        model.addAttribute("totalClientes", personas.size());//nos llevamos el total de personas que tenemos registrads
        model.addAttribute("paises", paises);
        model.addAttribute("totalPaises", paises.size());
        model.addAttribute("laboratorios", laboratorios);
        model.addAttribute("totalLaboratorios", laboratorios.size());
        model.addAttribute("tipoVacunas", tipoVacunas);
        model.addAttribute("totalTipoVacuna", tipoVacunas.size());
        model.addAttribute("inventarioVacunas", inventarioVacunas);
        model.addAttribute("totalInventarioVacunas", inventarioVacunas.size());
        model.addAttribute("aplicacionesDosis", aplicacionDosis);
        model.addAttribute("totalAplicaciones", aplicacionDosis.size());
        return "index";//mandamos a llamar la pagina index.html
    }
    
    

  
    /*****MAPEAMOS LAS RUTAS AGREGAR******/
    @GetMapping("/agregar")//ruta de inicio///se cambio a agregar persona para que aparezca a un usuario normal
    public String agregar(Persona persona) {
        return "modificar";
    }
    
    @GetMapping("/agregarPais")
    public String agregarPais(Pais pais){
        return "layout/agregarPais";
    }
    
     @GetMapping("/agregarLaboratorio")
    public String agregarLaboratorio(Laboratorio laboratorio){
        
        return "layout/agregarCliente";
    }
    
    @GetMapping("/agregarTipoVacuna")
    public String agregarTipoVacuna(TipoVacuna tipoVacuna){
        return "layout/tipoVacuna";
    }
    
    @GetMapping ("/agregarInventarioVacuna")
    public String agregarInventarioVacuna(InventarioVacunas inventarioVacuna){
        return "layout/inventarioVacuna";
    }
    
    @GetMapping("/agregarAplicacionDosis")
    public String agregarAplicacionDosis(AplicacionDosis aplicacionDosis){
        return "layout/aplicacionDosis";
    }
    /*****MAPEAMOS LAS RUTAS PARA GUARDAR DATOS DEL FORMULARIO******/
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        } else {
            personaService.guardar(persona);
            return "redirect:/";//redireccionamos a la pagina de inicio
        }

    }
    
    @PostMapping("/guardarPais")
    public String guardarPais(@Valid Pais pais, Errors errores){
        if(errores.hasErrors()){
            return "layout/agregarPais";
        }else{
            paisService.guardar(pais);
            return "redirect:/";//redirigimos a la vista principal index
        }
    }
    
     @PostMapping("/guardarLaboratorio")
    public String guardarLaboratorio(@Valid Laboratorio laboratorio, Errors errores){
        if(errores.hasErrors()){
            return "layout/agregarCliente";
        }else{
            laboratorioService.guardar(laboratorio);
            return "redirect:/";//redirigimos a la vista principal index
        }
    }
    
    @PostMapping("/guardarTipoVacuna")
    public String guardarTipoVacuna(@Valid TipoVacuna tipoVacuna, Errors errores){
        if(errores.hasErrors()){
            return "layout/tipoVacuna";
        }else{
            tipoVacunaService.guardarV(tipoVacuna);
            return "redirect:/";
        }
    }
    
    @PostMapping("/guardarInventarioVacuna")
    public String guardarInventarioVacuna(@Valid InventarioVacunas inventarioVacuna, Errors errores){
        if(errores.hasErrors()){
            return "layout/inventarioVacuna";
        }else{
            inventarioVacunaService.guardar(inventarioVacuna);
            return "redirect:/";
        }
    }
    @PostMapping("/guardarAplicacionDosis")
    public String guardarAplicacionDosis(@Valid AplicacionDosis aplicacionDosis, Errors errores){
        if(errores.hasErrors()){
            return "layout/aplicacionDosis";
        }else{
            aplicacionDosisService.guardar(aplicacionDosis);
            return "redirect:/";
        }
    }

    /*****MAPEAMOS LAS RUTAS las rutas editar******/
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/editarPais/{idPais}")
    public String editarPais(Pais pais, Model model){
        pais = paisService.encontrarPais(pais);
        model.addAttribute("pais", pais);
        return "layout/agregarPais";
    }
    
    @GetMapping("/editarLaboratorio/{idLaboratorio}")
    public String editarLaboratorio(Laboratorio laboratorio, Model model){
        laboratorio = laboratorioService.encontrarLaboratorio(laboratorio);
        model.addAttribute("laboratorio", laboratorio);
        return "layout/agregarCliente";
    }
    
    @GetMapping("/editarTipoVacuna/{idTipoVacuna}")
    public String editarTipoVacuna(TipoVacuna tipoVacuna, Model model){
        tipoVacuna = tipoVacunaService.encontrarTipoVacunaV(tipoVacuna);
        model.addAttribute("tipoVacuna", tipoVacuna);
        return "layout/tipoVacuna";
    }
    @GetMapping("/editarInventarioVacuna/{idTipoVacuna}")
    public String editarInventarioVacuna(InventarioVacunas inventarioVacuna, Model model){
        inventarioVacuna = inventarioVacunaService.encontrarLaboratorio(inventarioVacuna);
        model.addAttribute("inventarioVacuna", inventarioVacuna);
        return "layout/inventarioVacuna";
    }
    
    @GetMapping("/editarAplicacionDosis/{idAplicacionDosis}")
    public String editarAplicacionDosis(AplicacionDosis aplicacionDosis, Model model){
        aplicacionDosis = aplicacionDosisService.encontrarAplicacionDosis(aplicacionDosis);
        model.addAttribute("aplicacionDosis", aplicacionDosis);
        return "layout/aplicacionDosis";
    }

    /*****MAPEAMOS LAS RUTAS eliminar******/
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/eliminarPais/{idPais}")
    public String eliminarPais(Pais pais){
        paisService.eliminar(pais);
        return "redirect:/";
    }
    
     @GetMapping("/eliminarLaboratorio/{idLaboratorio}")
    public String eliminarLaboratorio(Laboratorio laboratorio){
        laboratorioService.eliminar(laboratorio);
        return "redirect:/";
    }
    
    @GetMapping("/eliminarTipoVacuna/{idTipoVacuna}")
    public String eliminarTipoVacuna(TipoVacuna tipoVacuna){
        tipoVacunaService.eliminarV(tipoVacuna);
        return "redirect:/";
    }
    @GetMapping("/eliminarInventarioVacuna")
    public String eliminarInventarioVacuna(InventarioVacunas inventarioVacuna){
        inventarioVacunaService.eliminar(inventarioVacuna);
        return "redirect:/";
    }
    
    @GetMapping("/eliminarAplicacionDosis/{idAplicacionDosis}")
    public String eliminarAplicacionDosis(AplicacionDosis aplicacionDosis){
        aplicacionDosisService.eliminar(aplicacionDosis);
        return "redirect:/";
    }
}
