/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Recurso;
import br.edu.ifsul.modelo.UnidadeCondominal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Vitor Mateus T
 */
public class TestePersistirUnidadeCondominal {
    
    
    EntityManagerFactory emf;
    EntityManager em;    
    
    public TestePersistirUnidadeCondominal() {
    
    }
    
     @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-5N1-2017-MODEL-TRABALHO");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testar(){
        boolean exception = false;
        try{
            Condominio c = em.find(Condominio.class, 2);
            //1 - "Condominio Vila Bella"
            Pessoa p = em.find(Pessoa.class, 2);
            //1 -  VITOR
            UnidadeCondominal uc = new UnidadeCondominal();//Predio. 
            uc.setNumero("305");
            uc.setDescricao("Ap 3 piso");
            uc.setArea(50.0);
            uc.setNumeroQuarto(50);
            uc.setProprietario(p);
            uc.setCondominio(c);
           
            em.getTransaction().begin();
            em.persist(uc);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false,exception);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
