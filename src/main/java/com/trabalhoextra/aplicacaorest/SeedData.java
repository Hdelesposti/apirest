
package com.trabalhoextra.aplicacaorest;

import com.trabalhoextra.aplicacaorest.model.Contato;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.trabalhoextra.aplicacaorest.repository.ContatoRepository;

/**
 *
 * @author Heloiza DelEsposti
 */
@Component
public class SeedData implements CommandLineRunner {
    
    private final ContatoRepository repository;
    
    public SeedData(ContatoRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.deleteAll();
        List<Contato> contatos = new ArrayList();
        contatos.add(new Contato( "Heloiza","99899999999"));
        contatos.add(new Contato( "Helo","9454599999"));
        contatos.add(new Contato( "Heloi","945459999999"));
        contatos.add(new Contato( "Heloiz","99454545999"));
        contatos.add(new Contato( "Heloizaaaaa","99899999956"));
        
        this.repository.saveAll(contatos);
        contatos.forEach(System.out::println);
        
        
    }
    
    
    
    
}
