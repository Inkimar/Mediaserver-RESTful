/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.util;

import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ingimar
 */
public class GeneratorUUIDTest {
    
    public GeneratorUUIDTest() {
    }
    
    /**
     * Test of createUUID method, of class GeneratorUUID.
     */
    @Test
    public void testCreateUUID() {
        System.out.println("createUUID");
        UUID expResult = null;
        String result = GeneratorUUID.createUUID();
        System.out.println(" result "+result);
        assertNotNull(result);
        
    }
}