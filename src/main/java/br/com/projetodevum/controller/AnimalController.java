package br.com.projetodevum.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RestController
public class AnimalController {

    //incluir Pet para o cliente
    @PostMapping("/animal")
    public String cadastroAnimalPorId(@PathVariable ("id") Long id){//@RequestParam("raca") String raca){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        //System.out.println(animal.getClass());
        //System.out.println("Nome Animal= "+animal.getNomeAnimal());
        //System.out.println("Raça: "+animal.getRaca());
        //System.out.println("Cliente: "+cliente.getId());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
       return "teste";
    }
    /*@RequestMapping(path = "/animal", method = RequestMethod.POST)
    public String cadastroAnimalPorId2(@PathVariable("id") Long id, Animal animal){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(animal);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        return "teste";
    }*/
}
