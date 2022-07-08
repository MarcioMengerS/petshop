package br.com.projetodevum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HtmlController {

    @GetMapping("/filme")
    public String filme(){
        return "filme";
    }

    @GetMapping("/formcadastro")
    public String form(Model model){
        model.addAttribute("nome", "márcio");
        return "form_cadastro";
    }
}
