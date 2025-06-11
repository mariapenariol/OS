/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.penariol.OSApiApplication.domain.repository;

import br.com.penariol.OSApiApplication.domain.model.OrdemServico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjatb
 */
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    
    List<OrdemServico> findById(long id);
}
