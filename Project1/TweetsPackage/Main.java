package TweetsPackage;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("hello");
		//Tweet t1 = new Tweet();
		Twitter t1 = new Twitter("./TweetsPackage/Tweets.txt");
		Twitter t2 = new Twitter("./TweetsPackage/Tweets.txt");

		t1.readFile();
		
		System.out.println("Retrieving tweet by id");
		t1.retrieveTweetById("446");
		
		System.out.println("Printing all ids");
		t1.retrieveAllIds();
		
		System.out.println("Retrieving all ids from a single user");
		t1.retrieveIdsByUser("ronjo");
		
		//System.out.println("Removing tweet from collection");
		//t1.removeTweet("3");
		
		t1.addTweet("123456789", "MiaB", "Adding Tweet!!");
		
		
		t1.doWrite("./TweetsPackage/dataWriteTest.txt");
		t2.doWrite("TweetsPackage/dataWriteTest.txt");
		
		
	
		
		//t1.writeFile("./TweetsPackage/dataWriteTest.txt");
		//t1.readFile();
		//Twitter testWrite = new Twitter("./Tweetspackage/dataWriteTest.txt");
		//testWrite.addTweet("./TweetsPackage/dataWriteTest.txt");
		//testWrite.doWrite("./TweetsPackage/dataWriteTest.txt");
		
		
		//Twitter t2 = new Twitter("./Tweetspackage/dataWriteTest.txt");
		//t2.doWrite("./TweetsPackage.dataWriteTest.txt");
				
		//t1.doWrite("./TweetsPackage/dataWriteTest.txt");
		
		//testWrite.addTweet();
		//System.out.println(testWrite);
	
		
	
	}

}
