package br.com.projetodevum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.entity.Telefone;

//Interface que estende a classe Jparepository
@Repository
@Transactional
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
    Iterable<Telefone> findByCliente(Cliente cliente);
}
