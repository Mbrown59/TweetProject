//final copy
package TweetsPackage;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("hello");
		Twitter t1 = new Twitter("./TweetsPackage/Tweets.txt");

		//testing reading file (from testProcessed.txt)
		t1.readFile();
		
		//testing retrieving tweet by id
		System.out.println("Retrieving tweet by id");
		t1.retrieveTweetById("446");
		
		//testing printing all ids
		System.out.println("Printing all ids");
		t1.retrieveAllIds();
		
		//testing retrieving all ids from a single user
		System.out.println("Retrieving all ids from a single user");
		t1.retrieveIdsByUser("ronjo");
		
		//testing adding tweet
		t1.addTweet("123456789", "MiaB", "Adding Tweet!!", "./TweetsPackage/WriteTest.txt");
		t1.addTweet("303404" , "Mbrown59" , "I'm almost done!", "./TweetsPackage/WriteTest.txt");
		
		//testing removing tweet
		t1.removeTweet("303404");
		
		//testing tweet predictor
		System.out.println("Testing tweet predictor");
		t1.prediction();
		
		//testing writing to file
		t1.doWrite("./TweetsPackage/WriteTest.txt");
	
	}

}
