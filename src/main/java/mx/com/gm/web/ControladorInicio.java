package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Entrada;
import mx.com.gm.domain.Salida;
import mx.com.gm.domain.Transferencia;
import mx.com.gm.servicio.EntradaService;
import mx.com.gm.servicio.SalidaService;
import mx.com.gm.servicio.TransferenciaService;
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
    private EntradaService entradaService;
    
    @Autowired
    private SalidaService salidaService;
    
    @Autowired
    private TransferenciaService transferenciaService;
    
    //Controlador del "Index"
    
    @GetMapping("/")
    public String listarTodas(Model model, @AuthenticationPrincipal User user){
        Iterable entradas = entradaService.listarEntradas();
        Iterable salidas = salidaService.listarSalidas();
        Iterable transferencias = transferenciaService.listarTransferencias();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("entradas", entradas);
        model.addAttribute("salidas", salidas);
        model.addAttribute("transferencias", transferencias);
        return "index";
    }
    
    
    //Controlador de "Entradas"
    
    
    
    @GetMapping("/Entradas")
    public String listarEntradas(Model model, @AuthenticationPrincipal User user){
        Iterable entradas = entradaService.listarEntradas();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("entradas", entradas);
        return "index";
    }
    
    @GetMapping("/editarEntrada/{id_entrada}")
    public String editarEntradas(Entrada entrada, Model model){
        entrada = entradaService.encontrarEntrada(entrada);
        model.addAttribute("entrada", entrada);
        return "mod_entradas";
    }
    
    @GetMapping("/eliminarEntrada")
    public String eliminarEntradas(Entrada entrada){
        entradaService.eliminarEntrada(entrada);
        return "redirect:/";
    }
    
    @GetMapping("/agregarEntrada")
    public String agregarEntrada(Entrada entrada){
        return "mod_entradas";
    }
    
    @PostMapping("/guardarEntrada")
    public String guardarEntrada(@Valid Entrada entrada, Errors errores){
        if(errores.hasErrors()){
            return "mod_entradas";
        }
        entradaService.guardarEntrada(entrada);
        return "redirect:/";
    }
    
    
    //Controlador de "Salidas"
    
    
    
    @GetMapping("/Salidas")
    public String listarSalidas(Model model, @AuthenticationPrincipal User user){
        Iterable salidas = salidaService.listarSalidas();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("salidas", salidas);
        return "index";
    }
    
    @GetMapping("/agregarSalida")
    public String agregarSalida(Salida salida){
        return "mod_salidas";
    }
    
    @PostMapping("/guardarSalida")
    public String guardarSalida(@Valid Salida salida, Errors errores){
        if(errores.hasErrors()){
            return "mod_salidas";
        }
        salidaService.guardarSalida(salida);
        return "redirect:/";
    }
    
    @GetMapping("/editarSalida/{idSalida}")
    public String editarSalida(Salida salida, Model model){
        salida = salidaService.encontrarSalida(salida);
        model.addAttribute("salida", salida);
        return "mod_salidas";
    }
    
    @GetMapping("/eliminarSalida")
    public String eliminarSalida(Salida salida){
        salidaService.eliminarSalida(salida);
        return "redirect:/";
    }
    
    
    //Controlador de "Tranferencias"
    
    
    
    @GetMapping("/Transferencias")
    public String listarTransferencias(Model model, @AuthenticationPrincipal User user){
        Iterable transferencias = transferenciaService.listarTransferencias();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("transferencias", transferencias);
        return "index";
    }
    
    @GetMapping("/agregarTransferencia")
    public String agregarTransferencia(Transferencia transferencia){
        return "mod_transferencias";
    }
    
    @PostMapping("/guardarTransferencia")
    public String guardarTransferencia(@Valid Transferencia transferencia, Errors errores){
        if(errores.hasErrors()){
            return "mod_transferencias";
        }
        transferenciaService.guardarTransferencia(transferencia);
        return "redirect:/";
    }
    
    @GetMapping("/editarTransferencia/{idTransferencia}")
    public String editarTransferencia(Transferencia transferencia, Model model){
        transferencia = transferenciaService.encontrarTransferencia(transferencia);
        model.addAttribute("transferencia", transferencia);
        return "mod_transferencias";
    }
    
    @GetMapping("/eliminarTransferencia")
    public String eliminarTransferencia(Transferencia transferencia){
        transferenciaService.eliminarTransferencia(transferencia);
        return "redirect:/";
    }
}
