package mgureken.communication;

import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.io.*; 

public class server {
	private static String url="jdbc:postgresql://127.0.0.1:5432/KullaniciYonetimi";
	private static String username="postgres";
	private static String password="sifre123";
	private Connection conn;
	private Socket          socket   = null; 
	private ServerSocket    server   = null; 
	private DataInputStream in       =  null; 
	private int threadCount=-1, maxThreadNumber=10;
	private Thread[] threads = new Thread[maxThreadNumber];
	private boolean[] states = new boolean[maxThreadNumber];
	private HashMap<Socket, Integer> mapp;

	public server(int port) throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, username, password); //try/catch'e gerek yok, metot throwable yapildi.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=0; i<maxThreadNumber; i++)
		{
			states[i] = false;
		}
		
		while(true)
		{
			// starts server and waits for a connection 
			try
			{ 
				server = new ServerSocket(port); 
				System.out.println("Server started"); 

				System.out.println("Waiting for a client ..."); 

				socket = server.accept(); 
				System.out.println("Client accepted"); 

				//her accepten sonra bir thread olustur.
				if(threadCount<maxThreadNumber)
				{
					threadCount++;	
					 threads[threadCount] = new Thread()
					{
						public void run()
						{								
							for(;;)
							{
								if(states[threadCount])
								{
									
								}
								else
								{
									break;
								}
							}

						}
					};
					threads[threadCount].start();
				}

				// takes input from the client socket 
				in = new DataInputStream( 
						new BufferedInputStream(socket.getInputStream())); 

				String line = ""; 

				// reads message from client until "Over" is sent 
				while (!line.equals("Over")) 
				{ 
					try
					{ 
						line = in.readUTF(); 
						System.out.println(line); 

					} 
					catch(IOException i) 
					{ 
						System.out.println(i); 
					} 
				} 
				System.out.println("Closing connection"); 

				// close connection 
				socket.close(); 
				in.close(); 
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			}
		}
	}

	public void closeConnection() throws SQLException{
		conn.close();
	}
}
