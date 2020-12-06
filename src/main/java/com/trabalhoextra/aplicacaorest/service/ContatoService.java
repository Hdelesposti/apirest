/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoextra.aplicacaorest.service;

import com.trabalhoextra.aplicacaorest.model.Contato;
import com.trabalhoextra.aplicacaorest.repository.ContatoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Heloiza DelEsposti
 */
@Service
public class ContatoService {
    
    @Autowired
    private ContatoRepository repository;
    
    public List<Contato> findAll() {
        return this.repository.findAll();
    }
    
    public Optional<Contato> findById(String id) {
        return this.repository.findById(id);
        
    }
    
    public void delete(Contato contato) {
        this.repository.delete(contato);
        
    }
    
    public Contato salvar(Contato contato){
    
        return this.repository.save(contato);
    }
    
}
