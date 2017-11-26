/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.UnidadeCondominal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vitor Mateus T
 */
public class utilRelatorios {
    
    public static List<Condominio> carregaCondominios() {
            List<Condominio> lista = new ArrayList<>();
            Pessoa p = new Pessoa();
            p.setId(1);
            p.setNome("Vitor");
            p.setCpf("000.111.222-77");
            p.setTelefone("54-981001969");
            p.setEmail("v_m_ft@hotmail.com");
            
            UnidadeCondominal uc = new UnidadeCondominal();
            uc.setId(1);
            uc.setNumero("101");
            uc.setDescricao("Ap_Terreo");
            uc.setNumeroQuarto(3);
            uc.setArea(70.00);
            uc.setProprietario(p);
            
            Condominio c = new Condominio();
            c.setId(1);
            c.setNome("Condominio vila Bella");
            c.setEndereco("Av. Parque Farroupinha");
            c.setNumero("1450");
            c.setCep("99150-000");
                       
           
            lista.add(c);
            return lista;
    
    }
    
}
