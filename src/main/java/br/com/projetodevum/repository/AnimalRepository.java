package br.com.projetodevum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetodevum.entity.Animal;
import br.com.projetodevum.entity.Cliente;

@Repository
@Transactional
public interface AnimalRepository extends JpaRepository<Animal, Long>{
    //Iterable<Animal> findByAnimal(Cliente cliente);
}
