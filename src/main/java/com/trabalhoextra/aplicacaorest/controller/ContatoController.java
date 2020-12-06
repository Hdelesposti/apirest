/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoextra.aplicacaorest.controller;

import com.trabalhoextra.aplicacaorest.model.Contato;
import com.trabalhoextra.aplicacaorest.service.ContatoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Heloiza DelEsposti
 */
@RestController
@RequestMapping(value = "/api/v1/contatos")
public class ContatoController {

    @Autowired
    ContatoService service;

    @GetMapping
    public List<Contato> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable(value = "id") String id) {
        Optional<Contato> contato = this.service.findById(id);
        if (contato.isPresent()) {
            return new ResponseEntity<Contato>(contato.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Contato>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable(value = "id") String id, @RequestBody Contato contato) {
        Optional<Contato> optional = this.service.findById(id);
        if (!optional.isPresent()) {
            return new ResponseEntity<Contato>(HttpStatus.NOT_FOUND);
        } else {
            contato.setId(optional.get().getId());
            return new ResponseEntity<Contato>(this.service.salvar(contato), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Contato> salvar(@RequestBody Contato contato) {
        return new ResponseEntity<Contato>(service.salvar(contato), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
        Optional<Contato> contato = this.service.findById(id);
        if (contato.isPresent()) {
            service.delete(contato.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
