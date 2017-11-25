
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Condominio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Vitor Mateus T
 * Condominio Vila Bella
 * ondominio Da Bento
 */
public class TestePersistirCondominio {
    
    
    EntityManagerFactory emf;
    EntityManager em;    
    
    public TestePersistirCondominio() {
    
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
            Condominio c = new Condominio();
            c.setNome("Condominio Da Bento");
            c.setEndereco("Av. Brasil");
            c.setNumero("999");
            c.setCep("99010000");
            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false,exception);
    }
    
}
