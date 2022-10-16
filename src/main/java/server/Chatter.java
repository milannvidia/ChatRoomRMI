package server;

import Shared.ChatInterface;

public class Chatter {
    public String name;
    public ChatInterface client;

    //constructor
    public Chatter(String name, ChatInterface client){
        this.name = name;
        this.client = client;
    }


    //getters and setters
    public String getName(){
        return name;
    }
    public ChatInterface getClient(){
        return client;
    }
}
