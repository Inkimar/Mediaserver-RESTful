/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author ingimar
 */
public class URI {

    public static final String BASE_URI = "http://localhost:8080/Playerserver/webresources";

    public static WebResource getWebResource() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(URI.BASE_URI).path("com.playerentity.player");
        return webResource;
    }
}
