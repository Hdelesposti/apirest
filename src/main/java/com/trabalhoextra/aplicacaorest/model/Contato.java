/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoextra.aplicacaorest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Heloiza DelEsposti
 */
@Document
public class Contato {
    @Id
    private String id;
    private String nome;
    private String telefone;

    public Contato( String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}


