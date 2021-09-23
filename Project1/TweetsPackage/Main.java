package TweetsPackage;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("hello");
		//Tweet t1 = new Tweet();
		Twitter allTweets = new Twitter("allTweets" , " ./TweetsPackage/Tweets.txt");
		
		System.out.println(allTweets);
	}

}
