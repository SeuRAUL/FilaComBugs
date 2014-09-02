/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author teste
 */
public class NewEmptyJUnitTest {
    
    Fila f = new Fila();
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testAdd() {
        int posicao = f.getFim();
        f.insereNaFila(1);
        
        assertEquals(posicao+1, f.getFim());
    }
    
    @Test
    public void testRemove() {
        f.insereNaFila(1);
        
        assertNotNull(f.removeDaFila());
    }
    
    @Test
    public void testLimpaFila() {
        f.insereNaFila(1);
        f.insereNaFila(3);
        f.insereNaFila(2);
        f.limpaFila();
        
        assertEquals(f.getFim(), -1);
    }
    
    @Test
    public void testAvisoListaCheia() {
        for (int i = 0; i < 5; i++) {
            f.insereNaFila(i);
        }
        
        assertTrue(f.estaCheia());
    }
    
    @Test
    public void testAvisoListaVazia() {
        assertTrue(f.estaVazia());
    }
    
    @Test
    public void testRecebeElementoCerto() {
        f.insereNaFila(2);
        f.insereNaFila(3);
        f.insereNaFila(1);
        
        assertEquals(2, f.removeDaFila());
        assertEquals(3, f.removeDaFila());
    }
    
    @Test
    public void testNaoAddFilaCheia() {
        for(int i=0; i < 5; i++) {
            f.insereNaFila(i);
        }
        
        boolean b = false;
        try {
            f.insereNaFila(6);
        } catch (FilaCheiaException e) {
            System.out.println(e);
            b = true;
        }
        assertTrue(b);
   }
}
