package redoing.imc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import redoing.imc.model.IMC;
import redoing.imc.repository.ImcRepository;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ImcRepository imcRepository;

    @GetMapping
    public String home(Model model){
        Sort sort = Sort.by("dataCalculo").descending();
        PageRequest paginacao = PageRequest.of(0, 5, sort);


        Page<IMC> listaImc = imcRepository.findAll(paginacao);
//        List<IMC> listaImc = imcRepository.findAll();
        model.addAttribute("listaImc", listaImc);
        return "home";
    }
}
