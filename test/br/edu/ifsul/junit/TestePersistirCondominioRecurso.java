package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Recurso;
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
public class TestePersistirCondominioRecurso {
    
    
    EntityManagerFactory emf;
    EntityManager em;    
    
    public TestePersistirCondominioRecurso() {
    
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
            Recurso r = em.find(Recurso.class,2);
            Condominio c = em.find(Condominio.class, 2);
            
            
            System.out.println(c.getNome());
            c.getcRecurso().add(r);
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
