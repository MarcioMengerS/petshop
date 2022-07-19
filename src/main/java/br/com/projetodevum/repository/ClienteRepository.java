package br.com.projetodevum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetodevum.entity.Cliente;

//Interface que estende a classe JpaRepository
@Repository
@Transactional
public interface ClienteRepository extends JpaRepository <Cliente, Long>{
}