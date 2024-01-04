import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Users {

	private LinkedList<Account> myList;
	
	public Users()
	{
		String line;
		Account tempAccount;
		String temp[] = new String[6];
		myList = new LinkedList<Account>();
		
		//Populated the list from the file...
		try 
		{
			FileReader fR = new FileReader("Accounts.txt");
			BufferedReader bR = new BufferedReader(fR);
			
			while((line=bR.readLine())!=null)
			{
				StringTokenizer st = new StringTokenizer(line," ");
				
				for(int i=0;i<6;i++)
				{
					temp[i] = st.nextToken();
				}
				
				tempAccount = new Account(temp[0],temp[1],temp[2],temp[3],temp[4],Float.parseFloat(temp[5]));
				myList.add(tempAccount);
			}
		} 
		
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void addAccount(String n, String pps, String e, String pass, String a, String bal)
    {
        Account temp = new Account(n,pps,e,pass,a,Float.parseFloat(bal));
        String line;
        myList.add(temp);
        
        try 
        {
            FileWriter fR = new FileWriter("Accounts.txt",true);
            BufferedWriter bR = new BufferedWriter(fR);
            line = n+" "+pps+" "+e+" "+pass+" "+a+" "+bal+"\n";
            bR.append(line);
            bR.close();
            fR.close();
            
            
            
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }
	
	public synchronized String searchAccount(String t)
	{
		Account temp;
		int found = 0;
		Iterator<Account> i = myList.iterator();
		String result = "Not found";
		
		while(i.hasNext() && found==0)
		{
			temp = (Account) i.next();
			System.out.println(temp.toString());
			if(temp.getPpsNumber().equalsIgnoreCase(t))
			{
				result = temp.toString();
				found = 1;
			}
		}
		
		return result;
	}
	
	public synchronized String[] listOfAccounts()
	{
		Account temp;
		Iterator<Account> i = myList.iterator();
		String[] result = new String[myList.size()];
		int count=0;
		
		while(i.hasNext())
		{
			temp = (Account) i.next();
			result[count] = temp.toString();
			count++;
		}
		
		return result;
	}
	
}
