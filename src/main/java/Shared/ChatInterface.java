package Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;

public interface ChatInterface extends Remote {
    public void updateChat(String userName, String chatMessage)throws RemoteException;

    public void passIDentity(RemoteRef ref)throws RemoteException;

    public void registerListener(String[] details)throws RemoteException, RemoteException;

    public void leaveChat(String userName)throws RemoteException;

    public void sendPM(int[] privateGroup, String privateMessage)throws RemoteException;
    public void messageFromServer(String message) throws RemoteException;

    public void updateUserList(String[] currentUsers) throws RemoteException;
}
