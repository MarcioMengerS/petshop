package br.com.projetodevum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.entity.Telefone;
import br.com.projetodevum.repository.TelefoneRepository;

@Service
public class TelefoneService {
        
    /*Segundo documentação é recomendado criar construtor para o atributo abaixo
    private final TelefoneRepository telefoneRepository;
    public TelefoneService (TelefoneRepository telefoneRepository){
        this.telefoneRepository = telefoneRepository;
    }*/
    @Autowired
    private TelefoneRepository telefoneRepository;

    public Telefone salvar(Telefone telefone){
        return telefoneRepository.save(telefone);
    }

    public List<Telefone> listarTelefones(){
        return telefoneRepository.findAll();
    }

    public Optional<Telefone> buscarPorId(Long id){
        return telefoneRepository.findById(id);
    }
    
    public void removerPorId(Long id){
        telefoneRepository.deleteById(id);
    }
    public void removerObj(Telefone telefone){
        telefoneRepository.delete(telefone);
    }
    public Iterable<Telefone> buscarTelefonesCliente(Cliente cliente){
        return telefoneRepository.findAll();
    }
    public Iterable<Telefone> buscarTelClientes(Cliente cliente){
        return telefoneRepository.findByCliente(cliente);
    }

}
