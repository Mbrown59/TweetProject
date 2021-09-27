package TweetsPackage;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("hello");
		//Tweet t1 = new Tweet();
		Twitter t1 = new Twitter("./TweetsPackage/Tweets.txt");
		Twitter t2 = new Twitter("./TweetsPackage/Tweets.txt");

		t1.readFile();
		t1.retrieveTweetById();
		t1.retrieveAllIds();
		t1.retrieveIdsByUser();
		
		//t1.addTweet();
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
