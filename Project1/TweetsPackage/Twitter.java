package TweetsPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Twitter
{
	
	private String fileName;
	private Tweet newTweet;
	
	public Twitter()
	{
		fileName = null;
	}
	
	public Twitter(String fn)
	{
		fileName = fn;
	}
	
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
