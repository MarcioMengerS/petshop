package br.com.projetodevum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetodevum.entity.Servico;

@Repository
@Transactional
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}
