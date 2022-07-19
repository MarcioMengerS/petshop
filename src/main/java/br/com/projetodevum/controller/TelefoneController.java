package br.com.projetodevum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.projetodevum.service.TelefoneService;

@Controller
public class TelefoneController {

    @Autowired
    private TelefoneService tels;

    //excluir telefone
    @GetMapping("telefone/excluir/{id}")
    public String excluiTelefone(@PathVariable ("id") Long id){
        tels.removerPorId(id);
        return "redirect:/rh/clientes";
    }
}
