package br.com.projetodevum.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.service.ClienteService;

@Controller
public class HtmlController {
    @Autowired
    private ClienteService cs;
    
    //Método listar clients
    @RequestMapping(path = "/rh/clientes", method = RequestMethod.GET)
    public String listarTodos(Model model){
        model.addAttribute("listaPessoas", cs.listarClientes());
        return "rh/form2";
    }

    //Método que retorna formulário html para cadastro novo de cliente
    @GetMapping("rh/clientes/novo")
    public String formCliente(@ModelAttribute("cli") Cliente cliente){
        return "rh/index2";
    }

    //Método para salvar cliente vindo do formulário
    @PostMapping("/rh/clientes/salvar")
    public String salvarCliente(@ModelAttribute("client") Cliente cliente) {
        cs.salvar(cliente);
        return "redirect:/rh/clientes";
    }

    //Método para alterar dados do cliente
    @GetMapping("/rh/clientes/atualizar/{id}")
    public String alterarCliente(@PathVariable("id") long id, Model model) {
        Optional<Cliente> clienteOpt = cs.buscarPorId(id);
        if(clienteOpt.isEmpty()){
            throw new IllegalArgumentException("pessoa não existe");
        }
        model.addAttribute("cli", clienteOpt.get());
        System.out.println("Classe..............................................."+model);
        return "rh/index2";
    }

    //Método que exclui cliente
    @GetMapping("/rh/clientes/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        Optional<Cliente> clienteOpt = cs.buscarPorId(id);
        if(clienteOpt.isEmpty()){
            throw new IllegalArgumentException("pessoa não existe");
        }
        cs.removerObj(clienteOpt.get());
        return "redirect:/rh/clientes";
    }
}
