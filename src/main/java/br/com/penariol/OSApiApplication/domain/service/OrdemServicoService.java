/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.penariol.OSApiApplication.domain.service;

import br.com.penariol.OSApiApplication.domain.exception.DomainException;
import br.com.penariol.OSApiApplication.domain.model.OrdemServico;
import br.com.penariol.OSApiApplication.domain.model.StatusOrdemServico;
import br.com.penariol.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjatb
 */
@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    public OrdemServico criar (OrdemServico ordemServico){
       ordemServico.setStatus(StatusOrdemServico.ABERTA); 
       ordemServico.setDataAbertura(LocalDateTime.now());
       
       return ordemServicoRepository.save(ordemServico);
    }
    
     public OrdemServico salvar (OrdemServico ordemServico){
       OrdemServico ordemServicoExistente = ordemServicoRepository.findById(ordemServico.getId());
       
       if (ordemServicoExistente != null && !ordemServicoExistente.equals(ordemServico)){
           throw new DomainException("Já existe uma ordem de serviço cadastrado com esse Id!");
       }
       return ordemServicoRepository.save(ordemServico);
   }
   
   public void excluir (Long id){
       ordemServicoRepository.deleteById(id);
   }
}
