package TweetsPackage;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("hello");
		//Tweet t1 = new Tweet();
		Twitter t1 = new Twitter("./TweetsPackage/Tweets.txt");
		
		t1.readFile();
		t1.retrieveTweetById();
		t1.retrieveAllIds();
		t1.retrieveIdsByUser();
		
		//t1.writeFile("./TweetsPackage/dataWriteTest.txt");
		//t1.readFile();
		Twitter testWrite = new Twitter("./Tweetspackage/dataWriteTest.txt");
		testWrite.doWrite("./TweetsPackage/dataWriteTest.txt");
		//System.out.println(testWrite);
	
		
	
	}

}
