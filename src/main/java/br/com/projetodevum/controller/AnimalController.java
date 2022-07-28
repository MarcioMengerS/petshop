package br.com.projetodevum.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetodevum.entity.Animal;
import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.service.AnimalService;
import br.com.projetodevum.service.ClienteService;

@Controller
//@RestController
public class AnimalController {

    @Autowired
    private ClienteService cs;

    @Autowired
    private AnimalService as;

    //mostra detalhes do cliente
    @RequestMapping(path="clientes/animal/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesAnimal(@PathVariable ("id") Long id){
        Optional<Cliente> clienteOpt = cs.buscarPorId(id);
        System.out.println("++++++++++++++++++++++entrou no método++++++++++++++++++++");
        ModelAndView mv =new ModelAndView("rh/formAnimal");
        mv.addObject("clienteId", clienteOpt.get());

        //Iterable<Animal> pets = as.buscarAnimClientes(clienteOpt.get());
        //mv.addObject("listaAnimais", pets);
        return mv;
    }

    //Método de cadastro de Animal e mostra detalhes do cliente
    @RequestMapping(path="clientes/animal/{id}", method = RequestMethod.POST)
    public String cadastroAnimalPorId(@PathVariable ("id") Long id, Animal animal){
        //Busca cliente pelo id
        Optional<Cliente> clienteOpt = cs.buscarPorId(id);

        //listaC.add(clienteOpt.get());
        //animal.setClientes(listaC);

       // as.salvar(animal);
    
        //coloca cliente dentro da variavel Animal
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(animal);
        System.out.println(animal.getNomeAnimal());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        //animal.setClientes(clienteOpt.get());
        //tels.salvar(telefone);
        return "redirect:/clientes/animal/{id}";
    }
}
