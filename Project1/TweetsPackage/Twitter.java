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
	Map<String, String> map = new HashMap<String, String>();
	Map<String, String> map1 = new HashMap<String, String>();
	private String fileName;
	private Tweet T;

	public Twitter()
	{
		fileName = null;
	}

	public Twitter(String fn)
	{
		fileName = fn;
		collection = new ArrayList<>();
		map = new HashMap<String, String>();
		map1 = new HashMap<String, String>();
		T = new Tweet();

	}
	
	public void retrieveTweetById()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the id of tweet you would like to retrieve?");
		String i = scan.nextLine();
		
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
	
	public void retrieveIdsByUser()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to retrieve all of a user's Ids? (Yes or No)");
		String B = scan.nextLine();
		
		if(B.equalsIgnoreCase("yes"))
		{
			System.out.println("What is the user name?");
			String U = scan.nextLine();
			
			for(Tweet T : collection)
			{
				if(T.getUser().equalsIgnoreCase(U))
				{
					map1.put(T.getUser(), T.getId());
				}
			}
			System.out.println("Map Elements");
			System.out.println("\t" + map1);
		}
		
	}
	
	public void retrieveAllIds()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to see all of the Ids? (Yes or No)");
		String A = scan.nextLine();
		
		if(A.equalsIgnoreCase("Yes"))
		{
			for(Tweet T : collection)
			{
				System.out.println(T.getId());
			}
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
	private void writeFile(String fn)
	{
		try
		{
			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);

			Tweet tweet = newTweet;
			myOutfile.write(tweet.getId() + ", " + tweet.getUser() + ", " + tweet.getTweet());
			myOutfile.flush();
			myOutfile.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Didn't save to" + fn);
		}
	}



}