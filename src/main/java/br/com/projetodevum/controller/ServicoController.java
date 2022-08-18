package br.com.projetodevum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetodevum.entity.Animal;
import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.entity.Servico;
import br.com.projetodevum.service.ClienteService;
import br.com.projetodevum.service.ServicoService;

@RestController
public class ServicoController {
    @Autowired
    private ServicoService ss;

    @Autowired
    private ClienteService cs;
    
    //efetua criação de serviço destinado a um cliente e um animal
    @PostMapping("/inclui/{id_cliente}/{id_animal}")
    @ResponseStatus(HttpStatus.CREATED)
    public Servico registrarServico(@PathVariable ("id_cliente") Long id1, @PathVariable ("id_animal") int id2, @RequestBody Servico servico){
        List<Animal> lista_animal;
        Animal animal = new Animal();
        Cliente cliente = new Cliente();
        
        cliente = cs.buscarClientePorId(id1);
        lista_animal = cliente.getAnimais();

        for( int i=0; i < lista_animal.size(); i++ ){
            if(lista_animal.get(i).getId() == id2){
                animal = lista_animal.get(i);
                servico.setCliente(cliente);
                //servico.setAnimal(animal);
                ss.salvar(servico);
                return servico;
            }
        }
        return null;
    }
}
