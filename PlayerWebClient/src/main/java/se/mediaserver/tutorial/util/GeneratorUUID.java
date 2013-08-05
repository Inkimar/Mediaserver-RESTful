/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.util;

import java.util.UUID;

/**
 * @author ingimar
 */
public class GeneratorUUID {
    /**
     * Wrapper around java.util.UUID.randomUUID()
     * Static factory to retrieve a type 4 (pseudo randomly generated) UUID. 
     * The UUID is generated using a cryptographically strong pseudo random number generator. 
     * @return 
     */
    public static String createUUID(){
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString();
    }
}
