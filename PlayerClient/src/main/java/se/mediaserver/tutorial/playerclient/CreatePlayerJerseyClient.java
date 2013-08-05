package se.mediaserver.tutorial.playerclient;

import com.sun.jersey.api.client.UniformInterfaceException;

import com.playerentity.Player;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import java.util.ArrayList;
import java.util.List;
import se.mediaserver.tutorial.util.RestfulPlayer;

/**
 * @author ingimar
 */
public class CreatePlayerJerseyClient {

    public static void main(String args[]) throws UniformInterfaceException {
        createPlayer();
        //get();
       // update();

    }

    private static void createPlayer() throws UniformInterfaceException {
        RestfulPlayer restful = new RestfulPlayer();

        Player player = new Player();
        player.setFirstname("ADAM");
        player.setLastname("gudmunds");
        player.setJerseynumber(51);
        player.setLastspokenwords("varsågod");
        restful.create_XML(player);
        
    }

    private static void get() {

        RestfulPlayer restful = new RestfulPlayer();
        ClientResponse response = restful.findAll_XML(ClientResponse.class);

        GenericType<List<Player>> genericType = new GenericType<List<Player>>() {
        };

        // Returns an ArrayList of Players from the web service
        List<Player> players = new ArrayList<Player>();
        players = (response.getEntity(genericType));
        System.out.println("Retreiving and Displaying Players Details");
        for (Player player : players) {
            System.out.println("FirstName: " + player.getFirstname());
            System.out.println(" Jerseyno: " + player.getJerseynumber());
            System.out.println("LastName: " + player.getLastname());
            System.out.println("Last Spoken Words:" + player.getLastspokenwords());
        }
    }
    
    /**
     * 2013-07-03: Får fel här
     */
    private  static void update() {
        RestfulPlayer restful = new RestfulPlayer();

        ClientResponse response = restful.find_XML(ClientResponse.class, "faea868e-b7a5-4d03-b323-fbed50621ab3");
        if ( response == null ){
            System.out.println("it is null");
        }

//        CreatePlayerJerseyClient client1 = new CreatePlayerJerseyClient();
//        ClientResponse response1 = client1.find_XML(ClientResponse.class, "3");
        GenericType<Player> genericType = new GenericType<Player>() {
        };
        Player player = response.getEntity(genericType);
        System.out.println("FirstName: " + player.getFirstname());
        System.out.println(" Jerseyno: " + player.getJerseynumber());
        System.out.println("LastName: " + player.getLastname());
        System.out.println("Last Spoken Words: " + player.getLastspokenwords());

//        player.setJerseynumber(101);
//        player.setLastspokenwords(" I will be retiring soon -updated");
//        restful.edit_XML(player);
    }
}