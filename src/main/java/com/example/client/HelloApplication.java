package com.example.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.RemoteException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

 /*   public static void main(String[] args) {
        launch();
    }
    public void registerWithServer(String[] details) {
        try{
            serverIF.passIDentity(this.ref);//now redundant ??
            serverIF.registerListener(details);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void messageFromServer(String message) throws RemoteException {
        System.out.println( message );
        chatGUI.textArea.append( message );
        //make the gui display the last appended text, ie scroll to bottom
        chatGUI.textArea.setCaretPosition(chatGUI.textArea.getDocument().getLength());
    }
    @Override
    public void updateUserList(String[] currentUsers) throws RemoteException {

        if(currentUsers.length < 2){
            chatGUI.privateMsgButton.setEnabled(false);
        }
        chatGUI.userPanel.remove(chatGUI.clientPanel);
        chatGUI.setClientPanel(currentUsers);
        chatGUI.clientPanel.repaint();
        chatGUI.clientPanel.revalidate();
    }*/
}