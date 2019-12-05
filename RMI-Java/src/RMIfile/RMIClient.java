package RMIfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;;

@SuppressWarnings("serial")
public class RMIClient implements Serializable {
	/*
	 * Tạo 2 folder ClinetFile và ServerFile trước khi chạy nhé...! Code by: Linh
	 * Nguyễn
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String hostname;
		int portnumber;
		String clientpath;
		String serverpath;

		try {

			hostname = "localhost";

			portnumber = 9999;
			System.out.println("Connect to server: " + portnumber);

			Registry myreg = LocateRegistry.getRegistry(hostname, portnumber);
			RmiInterface inter = (RmiInterface) myreg.lookup("remoteObject");
			int n;
			do {
				System.out.print("(1)Upload\n(2)Download\n(0)Exit\nPlease choose:");
				n = new Scanner(System.in).nextInt();
				// send a file
				if (n == 1) {
					System.out.print("File Path:");
					clientpath = new Scanner(System.in).next();
					File clientpathfile = new File(clientpath);
					serverpath = "D:/ServerFile/" + clientpathfile.getName();
					byte[] mydata = new byte[(int) clientpathfile.length()];
					FileInputStream in = new FileInputStream(clientpathfile);
					System.out.println("uploading to server...");
					in.read(mydata, 0, mydata.length);
					inter.uploadFileToServer(mydata, serverpath, (int) clientpathfile.length());
					in.close();
				}
				// download a file (Chỉ download những File mà Server quản lý trong thư mục
				// ServerFile )
				if (n == 2) {
					serverpath = "D:/ServerFile/";
					System.out.print("FileDownload Path: D:/ServerFile/");
					serverpath = serverpath + new Scanner(System.in).next();
					File fileserver = new File(serverpath);
					clientpath = "D:/ClientFile/" + fileserver.getName();
					byte[] mydata = inter.downloadFileFromServer(serverpath);
					System.out.println("downloading...");
					File clientpathfile = new File(clientpath);
					FileOutputStream out = new FileOutputStream(clientpathfile);
					out.write(mydata);
					out.flush();
					out.close();
				}
				if (n == 0) {
					System.out.println("Client has shutdown. Close the console");
					break;
				}

			} while (true);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error with connection or command. Check your hostname or command");
		}
	}

}
