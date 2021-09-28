//final copy
package TweetsPackage;

public class Tweet {

	private String polarity;
	private String id;
	private String tweet;
	private String user;
	
	public Tweet()
	{
		id = "not set";
		tweet = "not set";
		user = "not set";
		polarity = "not set";
	}
	
	public Tweet(String p, String i, String t, String u)
	{
		id = i;
		tweet = t;
		user = u;
		polarity = p;
	}
	
	public String getPolarity()
	{
		return polarity;
	}
	
	public void setPolarity(String p)
	{
		polarity = p;
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
	
	public void setTweet(String t)
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
		return polarity + ", " + id + ", " + user + ", " + tweet;
	}
	
	
	public boolean equals(Object rhs)
	{
		Tweet rhsT = (Tweet)rhs;
		return rhsT.getId().equals(this.getId());
	}

}
