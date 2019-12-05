package RMIfile;

import java.rmi.*;

public interface RmiInterface extends Remote {
	
	public void uploadFileToServer(byte[] mybyte, String serverpath, int length) throws RemoteException;
	public byte[] downloadFileFromServer(String servername) throws RemoteException;
}
