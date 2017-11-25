
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirPessoa {
    
    
    EntityManagerFactory emf;
    EntityManager em;    
    
    public TestePersistirPessoa() {
    
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
            Pessoa p = new Pessoa();
            p.setCpf("00601469070");
            p.setEmail("ana@hotmail.com");
            p.setNome("ANA");
            p.setTelefone("54 87119837");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false,exception);
    }
   
}
