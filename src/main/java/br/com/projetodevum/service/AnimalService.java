package br.com.projetodevum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetodevum.entity.Animal;
import br.com.projetodevum.repository.AnimalRepository;

@Service
public class AnimalService {
    /*Segundo documentação é recomendado criar construtor para o atributo abaixo
    private final ClienteRepository clienteRepository;
    puclic ClienteService (ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }*/
    @Autowired
    private AnimalRepository animalRepository;

    public Animal salvar(Animal animal){
        return animalRepository.save(animal);
    }

    public List<Animal> listarAnimais(){
        return animalRepository.findAll();
    }

    public Optional<Animal> buscarPorId(Long id){
        return animalRepository.findById(id);
    }

    public void removerPorId(Long id){
        animalRepository.deleteById(id);
    }

    public void removerObj(Animal animal){
        animalRepository.delete(animal);
    }
}
