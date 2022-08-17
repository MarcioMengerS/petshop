package br.com.projetodevum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projetodevum.entity.Animal;
import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.entity.Servico;
import br.com.projetodevum.service.ClienteService;
import br.com.projetodevum.service.ServicoService;

@Controller
public class ServicoController {
    @Autowired
    private ServicoService ss;

    @Autowired
    private ClienteService cs;
    
    @GetMapping("/inclui/{id_cliente}/{id_animal}")
    @ResponseBody
    public Animal registrarServico(@PathVariable ("id_cliente") Long id1, @PathVariable ("id_animal") int id2){
        List<Animal> lista_animal;
        Animal animal = new Animal();
        Cliente cliente = new Cliente();
        Servico servico = new Servico();
        
        cliente = cs.buscarClientePorId(id1);
        lista_animal = cliente.getAnimais();

        for( int i=0; i < lista_animal.size(); i++ ){
            if(lista_animal.get(i).getId() == id2){
                animal = lista_animal.get(i);
                servico.setCliente(cliente);
                servico.setAnimal(animal);
                ss.salvar(servico);
                return animal;
            }
        }
        return null;
    }
}
