package br.com.projetodevum.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetodevum.entity.Animal;
import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.service.AnimalService;
import br.com.projetodevum.service.ClienteService;

@Controller
public class AnimalController {
    @Autowired
    private ClienteService cs;

    @Autowired
    private AnimalService as;

    //mostra detalhes do cliente no formulário de cadastro de animal
    @RequestMapping(path="pet/animal/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesAnimal(@PathVariable ("id") Long id){
        Cliente cliente = new Cliente();
        cliente = cs.buscarClientePorId(id);
        //envia o conteudo do objeto cliente para a pagina formAnimal
        ModelAndView mv = new ModelAndView("/formAnimal");
        mv.addObject("clienteId", cliente);

        //Busca Animais de um cliente específico
        Set<Animal> animais = cliente.getAnimais();
        mv.addObject("listaAnimais", animais);
        return mv;
    }

    //Método de cadastro de Animal no Objeto Cliente
    @RequestMapping(path="/pet/animal/{id}", method = RequestMethod.POST)
    public String testemanytomany(@PathVariable("id") Long id, Animal animal){
        Cliente cliente = new Cliente();
        cliente = cs.buscarClientePorId(id);
        cliente.getAnimais().add(animal);
        cs.salvar(cliente);
        return "redirect:/pet/animal/{id}";
    }
    // Método que calcula média de animais por cliente
    @GetMapping("/pet/media")
    public String mediaPetCliente(Model model) {
        model.addAttribute("listaPessoas", cs.listarClientes());
        List<Cliente> quantosClientes = cs.listarClientes();
        List<Animal> quantosAnimais = as.listarAnimais();
        double media = (double) quantosAnimais.size() / (double) quantosClientes.size();
        String m = String.format("%.2f", media);
        model.addAttribute("nomeDoAtributo", m);
        return "rh/form2";
    }
}
