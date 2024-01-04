import java.net.Socket;
import java.io.*;


public class ServerThread extends Thread{

	Socket myConnection;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	String message1;
	String message2;
	String message3;
    String message4;
    String message5;
    String message6;
	Users usersCollection;
	
	public ServerThread(Socket s, Users users)
	{
		myConnection = s;
		usersCollection = users;
	}
	
	public void run()
	{
		try
		{
			out = new ObjectOutputStream(myConnection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(myConnection.getInputStream());
		
			//Server Comms
			do
			{
				sendMessage("Please enter 1 to CREATE AN ACCOUNT or 2 to SEARCH FOR ACCOUNT or 3 for a LIST OF ACCOUNTS");
				message = (String)in.readObject();
			
				if(message.equalsIgnoreCase("1"))
				{
					sendMessage("Please enter your name");
					message1 = (String)in.readObject();
					
					sendMessage("Please enter your PPS number");
					message2 = (String)in.readObject();
					
					sendMessage("Please enter your email");
					message3 = (String)in.readObject();

                    sendMessage("Please enter your password");
                    message4 = (String)in.readObject();

                    sendMessage("Please enter your address");
                    message5 = (String)in.readObject();

                    sendMessage("Please enter your initial balance");
                    message6 = (String)in.readObject();
					
					usersCollection.addAccount(message1, message2, message3, message4, message5, message6);
				}
				
				else if(message.equalsIgnoreCase("2"))
				{
					sendMessage("Please enter the book title");
					message1 = (String)in.readObject();
					
					String result = usersCollection.searchAccount(message1);
					sendMessage(result);
				}
				
				else if(message.equalsIgnoreCase("3"))
				{
					String[] temp = usersCollection.listOfAccounts();
					sendMessage(""+temp.length);
					
					for(int i=0;i<temp.length;i++)
					{
						sendMessage(temp[i]);
					}
					
				}
				
				sendMessage("Please enter 1 to repeat");
				message1 = (String)in.readObject();
				
			}while(message1.equalsIgnoreCase("1"));
			
			in.close();
			out.close();
		}
		catch(ClassNotFoundException classnot)
		{
					System.err.println("Data received in unknown format");
		}
		catch(IOException e)
		{
			
		}
		
		
	}
	
	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			System.out.println("server>" + msg);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
}
