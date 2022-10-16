package server;
import Shared.ChatInterface;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;


public class ChatServer extends UnicastRemoteObject implements ChatInterface {
    private Vector<Chatter> chatters;

    public ChatServer() throws RemoteException{
        super();
        chatters =new Vector<Chatter>(10,1);
    }

    public static void main(){
        startRMIRegistry();
        String hostName = "localhost";
        String serviceName = "GroupChatService";

        try{
            ChatInterface hello = new ChatServer();
            Naming.rebind("rmi://" + hostName + "/" + serviceName, hello);
            System.out.println("Group Chat RMI Server is running...");
        }
        catch(Exception e){
            System.out.println("Server had problems starting");
        }
    }

    private static void startRMIRegistry() {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI Server ready");
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

    public void updateChat(String name, String nextPost) throws RemoteException {
        String message =  name + " : " + nextPost + "\n";
        sendToAll(message);
    }

    @Override
    public void passIDentity(RemoteRef ref) throws RemoteException {
        try{
            System.out.println(ref.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void registerListener(String[] details) throws RemoteException {

    }

    private void updateUserList() {
        String[] currentUsers = getUserList();
        for(Chatter c : chatters){
            try {
                c.getClient().updateUserList(currentUsers);
            }
            catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private String[] getUserList(){
        String[] allUsers = new String[chatters.size()];
        for(int i = 0; i< allUsers.length; i++){
            allUsers[i] = chatters.elementAt(i).getName();
        }
        return allUsers;
    }

    public void sendToAll(String newMessage){
        for(Chatter c : chatters){
            try {
                c.getClient().messageFromServer(newMessage);
            }
            catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void leaveChat(String userName) throws RemoteException{

        for(Chatter c : chatters){
            if(c.getName().equals(userName)){
                System.out.println(userName + " left the chat session");
                System.out.println(new Date(System.currentTimeMillis()));
                chatters.remove(c);
                break;
            }
        }
        if(!chatters.isEmpty()){
            updateUserList();
        }
    }


}
