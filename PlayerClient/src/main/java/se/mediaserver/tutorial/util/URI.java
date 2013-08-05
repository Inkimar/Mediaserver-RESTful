/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 *
 * @author ingimar
 */
public class URI {

    public static final String BASE_URI = "http://localhost:8080/Playerserver/webresources";

    public static WebResource getPlayerWebResource() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(URI.BASE_URI).path("com.playerentity.player");
        return webResource;
    }
    public static WebResource getMediaWebResource() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(URI.BASE_URI).path("se.mediaserver.tutorial.domain.image");
        return webResource;
    }
}
