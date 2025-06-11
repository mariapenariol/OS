/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.penariol.OSApiApplication.api.controller;

import br.com.penariol.OSApiApplication.domain.model.OrdemServico;
import br.com.penariol.OSApiApplication.domain.repository.OrdemServicoRepository;
import br.com.penariol.OSApiApplication.domain.service.OrdemServicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoService ordemServicoService;
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar (@RequestBody OrdemServico ordemServico){
        return ordemServicoService.criar(ordemServico);
    }
    
    @GetMapping("/ordem-servico")
    public List<OrdemServico> listas(){
              
        return ordemServicoRepository.findAll();
    }
    
}
