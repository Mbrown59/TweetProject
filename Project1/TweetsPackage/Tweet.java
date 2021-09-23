package TweetsPackage;

public class Tweet {

	private int polarity;
	private String id;
	private String tweet;
	private String user;
	
	public Tweet()
	{
		id = "not set";
		tweet = "not set";
		user = "not set";
	}
	
	public Tweet(String i, String t, String u)
	{
		id = i;
		tweet = t;
		user = u;
	}

	public String getId()
	{
		return id;
	}
	
	public void setId(String i)
	{
		id = i;
	}
	
	public String getTweet()
	{
		return tweet;
	}
	
	public void setTweet()
	{
		tweet = t;
	}
	
	public String getUser()
	{
		return user;
	}
	
	public void setUser(String u)
	{
		user = u;
	}
	
	public String toString()
	{
		return id + ", " + user + ", " + tweet;
	} 
}
