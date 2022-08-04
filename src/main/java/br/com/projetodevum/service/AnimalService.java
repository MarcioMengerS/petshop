package br.com.projetodevum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetodevum.entity.Animal;
import br.com.projetodevum.repository.AnimalRepository;

@Service
public class AnimalService {
    
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
    public Animal buscarAnimalPorId(Long id){
        return animalRepository.findById(id).get();
    }

    public void removerPorId(Long id){
        animalRepository.deleteById(id);
    }

    public void removerObj(Animal animal){
        animalRepository.delete(animal);
    }
}
