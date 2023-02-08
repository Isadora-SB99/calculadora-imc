package redoing.imc.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import redoing.imc.dto.ImcDto;
import redoing.imc.model.IMC;
import redoing.imc.model.User;
import redoing.imc.repository.ImcRepository;
import redoing.imc.repository.UsuarioRepository;

@Controller
@RequestMapping("/imc")
public class ImcController {

    @Autowired
    private ImcRepository imcRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/formulario")
    public String formulario (ImcDto imcDto){
        return "imc/formulario";
    }

    @PostMapping("/novo")
    public String novo (@Valid ImcDto imcDto, BindingResult result){
        if (result.hasErrors()){
            return "imc/formulario";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = usuarioRepository.findByUsername(username);

        IMC imc = imcDto.toIMC();
        imc.setUsuario(user);
        imcRepository.save(imc);
        return "redirect:/usuario/imc";
    }
}
