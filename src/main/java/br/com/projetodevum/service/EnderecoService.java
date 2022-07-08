package br.com.projetodevum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetodevum.entity.Endereco;
import br.com.projetodevum.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarClientes(){
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarPorId(Long id){
        return enderecoRepository.findById(id);
    }
    
    public void removerPorId(Long id){
       enderecoRepository.deleteById(id);
    }
}
