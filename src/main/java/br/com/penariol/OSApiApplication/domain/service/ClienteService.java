/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.penariol.OSApiApplication.domain.service;

import br.com.penariol.OSApiApplication.domain.exception.DomainException;
import br.com.penariol.OSApiApplication.domain.model.Cliente;
import br.com.penariol.OSApiApplication.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjatb
 */
@Service
public class ClienteService {
    
   @Autowired
   private ClienteRepository clienteRepository;
   
   public Cliente salvar (Cliente cliente){
       Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
       
       if (clienteExistente != null && !clienteExistente.equals(cliente)){
           throw new DomainException("Já existe um cliente cadastrado com esse email!");
       }
       return clienteRepository.save(cliente);
   }
   
   public void excluir (Long clienteId){
       clienteRepository.deleteById(clienteId);
   }
}
