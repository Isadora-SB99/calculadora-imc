package redoing.imc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.stylesheets.LinkStyle;
import redoing.imc.model.IMC;
import redoing.imc.repository.ImcRepository;

//import java.security.Principal;
//import java.util.List;
//
//@Controller
//@RequestMapping("/usuario")
//public class UsuarioController {
//
//    @Autowired
//    private ImcRepository imcRepository;
//
//    @GetMapping("/imc")
//    public String home(Model model, Principal principal){
//        List<IMC> listaIMC = imcRepository.findAllByUsuario(principal.getName());
////        List<IMC> listaIMC = imcRepository.findAll();
//        model.addAttribute("listaImc", listaIMC);
//        return "usuario/home";
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public String onError(){
//        return "redirect:/usuario/home";
//    }
//
//}
