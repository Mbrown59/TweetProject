//final copy
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
	Map<String, String> map = new HashMap<String,String>();
	Map<String, String> map1 = new HashMap<String, String>();
	private String fileName;
	private Scanner scan;
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
		scan = new Scanner(System.in);
		T = new Tweet();
	}
	
	public void retrieveTweetById(String i)
	{
		
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
			
			for(Tweet T : collection)
			{
				if(T.getUser().equalsIgnoreCase(u))
				{
					map1.put(T.getUser(), T.getId());
					System.out.println("\t" + map1);
				}
			}System.out.println("\t" + map1);			
		}
		
	
	
	public void retrieveAllIds()
	{
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
	}

	
	public void doWrite(String fn)
	{
		try
		{
			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);
			for(Tweet T : collection)
			{
				myOutfile.write(T.getPolarity() + ", " + T.getId() + ", " + T.getUser() + ", " + T.getTweet() + "\n");

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

	public void addTweet(String i, String u, String t, String fn)
	{
		
		{
			Tweet newT = new Tweet();
			
			newT.setPolarity("4");
			
			newT.setId(i);
			
			newT.setUser(u);
			
			newT.setTweet(t);
						
			collection.add(newT);
			doWrite(fn);
			
			System.out.println("\n" + newT.toString());
		}
	}
	
	public void prediction()
	{
		double count = 0;
		double total = 0;
		double average;
		
		for(Tweet T: collection)
		{
			total++;
			if(T.getPolarity().equals("4"))
			{
				count++;
			}
		}
		
		average = (count / total) * 100;
		System.out.println("Total Tweets: " + total);
		System.out.println("Total correct predicted tweets: " + count);
		System.out.println("Average: " + average + "%");
		
	}

	public void removeTweet(String i)
	{
			if(T.getId().equalsIgnoreCase(i))
			{
				collection.remove(i);
			}
	}

}