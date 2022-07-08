package br.com.projetodevum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.entity.Endereco;
import br.com.projetodevum.service.ClienteService;
import br.com.projetodevum.service.EnderecoService;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarCliente(/*@RequestBody*/ Cliente cliente, Endereco end){
        cliente.setEndereco(end);
        //cliente.setEndereco(enderecoService.salvar(end));
        System.out.println("TESTANDO NOME DO CLIENTE: "+cliente.getNome());
        return "OK";//clienteService.salvar(cliente);
    }

    @PutMapping("/clientes")
    public Cliente atualizarCliente(@RequestBody Cliente cliente ){
        return clienteService.salvar(cliente);
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable Long id){
        clienteService.buscarPorId(id)
            .map(cliente -> {
                clienteService.removerPorId(cliente.getId());
                return Void.TYPE;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CLIENTE NÃO ENCONTRADO!"));
    }

    @GetMapping("/listaclientes")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView todosClientes(){
        List<Cliente> clientes = clienteService.listarClientes();
        ModelAndView mv = new ModelAndView("allclients");
        mv.addObject("listaClientes", clientes);
        return mv;
    }
}
