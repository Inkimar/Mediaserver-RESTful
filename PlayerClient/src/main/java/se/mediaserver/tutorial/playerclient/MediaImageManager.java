/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.mediaserver.tutorial.playerclient;

import com.playerentity.Player;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.ArrayList;
import java.util.List;
import se.mediaserver.tutorial.domain.Image;
import se.mediaserver.tutorial.domain.Media;
import se.mediaserver.tutorial.domain.Mediatext;
import se.mediaserver.tutorial.util.RestfulImage;
import se.mediaserver.tutorial.util.RestfulPlayer;

/**
 *
 * @author ingimar
 */
public class MediaImageManager {

    public static void main(String args[]) throws UniformInterfaceException {
        System.out.println("Running MediaImageManager");
//        createImage();
        createImageWithMediaText();
//        get();
//        update();

    }

    private static void createImage() throws UniformInterfaceException {
        RestfulImage restful = new RestfulImage();

        Media media = new Image();

        media.setFilename("scorpio.jpg");
        media.setOwner("actus");
        media.setVisibility("private");
        System.out.println("Media:Image " + media);
        restful.create_XML(media);
    }

    private static void createImageWithMediaText() throws UniformInterfaceException {
        RestfulImage restful = new RestfulImage();

        Media media = new Image();

        media.setFilename("scorpio.jpg");
        media.setOwner("actus");
        media.setVisibility("private");
        Mediatext meditext = new Mediatext("a yellow butterfly", "sv_SE");
        media.setMediaText(meditext);
        System.out.println("Media:Image " + media);
        restful.create_XML(media);
    }

    private static void get() {
        RestfulImage restful = new RestfulImage();

        ClientResponse response = restful.findAll_XML(ClientResponse.class);

        GenericType<List<Image>> genericType = new GenericType<List<Image>>() {
        };

        // Returns an ArrayList of Players from the web service
        List<Image> images = new ArrayList<Image>();
        images = (response.getEntity(genericType));
        System.out.println("Retreiving and Displaying Players Details");
        for (Image image : images) {
            System.out.println("Filename: " + image.getFilename());
            System.out.println(" Owner is: " + image.getOwner());

        }
    }

    private static void update() {
        RestfulImage restful = new RestfulImage();

        ClientResponse response = restful.find_XML(ClientResponse.class, "3");


//        CreatePlayerJerseyClient client1 = new CreatePlayerJerseyClient();
//        ClientResponse response1 = client1.find_XML(ClientResponse.class, "3");
        GenericType<Image> genericType = new GenericType<Image>() {
        };
        Image image = response.getEntity(genericType);
        System.out.println("FirstName: " + image.getFilename());
        image.setOwner("Erlingsson");
        restful.edit_XML(image);

//        player.setJerseynumber(101);
//        player.setLastspokenwords(" I will be retiring soon -updated");
//        restful.edit_XML(player);
    }
}
