package br.com.penariol.OSApiApplication.api.controller;

import br.com.penariol.OSApiApplication.domain.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
public class ClienteController {
    
    @PersistenceContext
    private EntityManager manager;
    
    @GetMapping("/clientes")
    public List<Cliente> listas(){
              
        return manager.createQuery("From Cliente", Cliente.class).getResultList();
    }
}
