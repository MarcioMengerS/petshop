package br.com.projetodevum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetodevum.entity.Cliente;
import br.com.projetodevum.repository.ClienteRepository;

@Service
public class ClienteService {
    
    /*Segundo documentação é recomendado criar construtor para o atributo abaixo
    private final ClienteRepository clienteRepository;
    puclic ClienteService (ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }*/
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }
    //public Cliente buscarClientePorId(Long id){
    //    return clienteRepository.findById(id);
    //}
    
    public void removerPorId(Long id){
        clienteRepository.deleteById(id);
    }
    public void removerObj(Cliente cliente){
        clienteRepository.delete(cliente);
    }
}
