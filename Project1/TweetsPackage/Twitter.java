package TweetsPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Twitter
{
	ArrayList<Tweet> collection = new ArrayList<>(); 
	//ArrayList<Tweet> collection2 = new ArrayList<>();
	Map<String, String> map = new HashMap<String,String>();
	Map<String, String> map1 = new HashMap<String, String>();
	private String fileName;
	//private String ID;
	//private String TWEET;
	//private String UNAME;
	private Scanner scan;
	//private String className;
	private Tweet T; 
	//private Tweet newT;

	public Twitter()
	{
		fileName = null;
		//ID = null;
		//TWEET = null;
		//UNAME = null;
		
		//className = null;
	}

	public Twitter(String fn)
	{
		fileName = fn;
		//className = cn;
		collection = new ArrayList<>();
		//collection = new ArrayList<>();
		map = new HashMap<String, String>();
		map1 = new HashMap<String, String>();
		scan = new Scanner(System.in);
		T = new Tweet();
		//newT = new Tweet();

	}
	
	public void retrieveTweetById(String i)
	{
		//Scanner scan = new Scanner(System.in);
		//System.out.println("What is the id of tweet you would like to retrieve?");
		//String i = scan.nextLine();
		
		for(Tweet T : collection)
		{
			if(T.getId().equals(i))
			{
				map.put(T.getId(), T.getTweet());
			}
		}
		System.out.println("Map Elements");
		System.out.println("\t" + map);
	}
	
	public void retrieveIdsByUser(String u)
	{
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Do you want to retrieve all of a user's Ids? (Yes or No)");
		//String B = scan.nextLine();
		
		//if(B.equalsIgnoreCase("yes"))
		{
			//System.out.println("What is the user name?");
			//String U = scan.nextLine();
			
			for(Tweet T : collection)
			{
				if(T.getUser().equalsIgnoreCase(u))
				{
					map1.put(T.getUser(), T.getId());
					System.out.println("\t" + map1);
				}
			}System.out.println("\t" + map1);			
		}
		
	}
	
	public void retrieveAllIds()
	{
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Would you like to see all of the Ids? (Yes or No)");
		//String A = scan.nextLine();
		
		//if(A.equalsItgnoreCase("Yes"))
			for(Tweet T : collection  )
			{
				System.out.println(T.getId());
			}
	}

	

		
		
	

	public void readFile () {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line = null;
			while ((line = lineReader.readLine())!=null) 
			{
				//System.out.println(line);
				
				String[] fullTweet = line.split(",");
				
				String polarity = fullTweet[fullTweet.length - 4];
				String id = fullTweet[fullTweet.length - 3];
				String user = fullTweet[fullTweet.length - 2];
				String tweet = fullTweet[fullTweet.length - 1];
				
				Tweet T = new Tweet();

				T.setPolarity(polarity);
				T.setId(id);
				T.setUser(user);
				T.setTweet(tweet);
				collection.add(T);
				
				//System.out.println(T);
			}	
		} catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
		//System.out.println(collection);

	} // end of readFile method
	
	public void writeFile () {
		// overloaded method: this calls doWrite with file used to read data
		// use this for saving data between runs
		doWrite(fileName);
	} // end of writeFile method

	public void writeFile(String altFileName) {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite(altFileName);		
	}// end of writeFile method
	
	public void doWrite(String fn)
	{
		try
		{
			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);
			//myOutfile.write("It works");
			//myOutfile.write();
			
			///use iterator
			
		
		
				//addTweet(ID, UNAME, TWEET);
			//myOutfile.write("hello");
			while(collection.iterator().hasNext())
			{
				myOutfile.write(T.getPolarity() + ", " + T.getId() + ", " + T.getUser() + ", " + T.getTweet());

			}
			
			myOutfile.flush();
			myOutfile.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Didn't save to" + fn);
		}
	}

	public void addTweet(String i, String u, String t)
	{
		
		{
			//System.out.println("What is the polarity?");
			//String POLARITY = scan.nextLine();
			T.setPolarity(prediction());
			
			//System.out.println("What is the ID?");
			//String ID = scan.nextLine();
			T.setId(i);
			
			//System.out.println("What is the user name?");
			//String UNAME = scan.nextLine();
			T.setUser(u);
			
			//System.out.println("What is the tweet?");
			//String TWEET = scan.nextLine();
			T.setTweet(t);
			
			//T.setPolarity(prediction());
			
			
			collection.add(T);
			
			System.out.println("\n" + T.toString());
			
			//return T;
			
			//System.out.println(newT.getUser());
			//doWrite(fn);
			//System.out.println(collection2);
		}
	}
	
	public String prediction()
	{
		return ("4");
	}

	public void removeTweet(String i)
	{
		//System.out.println("What is the id of the tweet you would like to remove?");
		//String id = scan.nextLine();
		
		if(T.getId().equalsIgnoreCase(i))
		{
			collection.remove(T);
		}
	}

}