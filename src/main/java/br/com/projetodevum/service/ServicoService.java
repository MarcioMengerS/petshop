package br.com.projetodevum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetodevum.entity.Servico;
import br.com.projetodevum.repository.ServicoRepository;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepository servicoRepository;

    public Servico salvar(Servico servico){
        return servicoRepository.save(servico);
    }

    public List<Servico> listarAnimais(){
        return servicoRepository.findAll();
    }

    public Servico buscarPorId(Long id){
        return servicoRepository.findById(id).get();
    }
    public Servico buscarAnimalPorId(Long id){
        return servicoRepository.findById(id).get();
    }

    public void removerPorId(Long id){
        servicoRepository.deleteById(id);
    }

    public void removerObj(Servico servico){
        servicoRepository.delete(servico);
    }
}
