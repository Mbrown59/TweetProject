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
	private String fileName;
	//private Tweet newTweet;

	public Twitter()
	{
		fileName = null;
	}

	public Twitter(String fn)
	{
		fileName = fn;
		collection = new ArrayList<>();

	}
	
	public String retrieveById(String id)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the id of tweet you would like to retrieve?")
		String i = scan.nextLine();
		
		
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
				
				Tweet T = new Tweet(polarity, id, user, tweet);
				collection.add(T);
				
				//System.out.println(polarity);
				
				T.setPolarity(polarity);
				T.setId(id);
				T.setUser(user);
				T.setTweet(tweet);
				
				
				
				
				




				
				//double positiveTweet = Double.parseDouble(fullTweet[4]);
				//double negativeTweet = Double.parseDouble(fullTweet[0]);
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
		System.out.println(collection);

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