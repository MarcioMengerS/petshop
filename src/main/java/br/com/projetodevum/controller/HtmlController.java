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
import org.springframework.web.servlet.ModelAndView;

import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.entity.Telefone;
import br.com.projetodevum.service.ClienteService;
import br.com.projetodevum.service.TelefoneService;

@Controller
public class HtmlController {
    @Autowired
    private ClienteService cs;

    @Autowired
    private TelefoneService tels;
    
    //Método listar clientes
    //@RequestMapping(path = "/rh/clientes", method = RequestMethod.GET)
    @GetMapping("/rh/clientes")
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
        return "rh/index2";
    }

    //Método que exclui cliente
    @GetMapping("/rh/clientes/excluir/{id}")
    //@DeleteMapping("/rh/clientes/excluir/{id}") - Não aceita o verbo delete
    public String excluir(@PathVariable("id") Long id) {
        Optional<Cliente> clienteOpt = cs.buscarPorId(id);
        if(clienteOpt.isEmpty()){
            throw new IllegalArgumentException("pessoa não existe");
        }
        cs.removerObj(clienteOpt.get());
        return "redirect:/rh/clientes";
    }

    //Método que mostra detalhes do cliente
    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesCliente(@PathVariable ("id") Long id){
        Optional<Cliente> clienteOpt = cs.buscarPorId(id);
        ModelAndView mv =new ModelAndView("rh/detalhesCliente");
        mv.addObject("clienteId", clienteOpt.get());
        //Busca telefone de um cliente específico
        Iterable<Telefone> telefones = tels.buscarTelClientes(clienteOpt.get());
        mv.addObject("listaTelefones", telefones);

        return mv;
    }

    //Método de cadastro de Telefone e mostra detalhes do cliente
    //@RequestMapping(path="{id}", method = RequestMethod.POST)
    @RequestMapping(path="{id}", method = RequestMethod.POST)
    public String cadastroTelefonePorId(@PathVariable ("id") Long id, Telefone telefone){
        Optional<Cliente> clienteOpt = cs.buscarPorId(id);
        telefone.setCliente(clienteOpt.get());
        tels.salvar(telefone);
        return "redirect:/{id}";
    }
}
