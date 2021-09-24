package TweetsPackage;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("hello");
		//Tweet t1 = new Tweet();
		Twitter t1 = new Twitter("./TweetsPackage/Tweets.txt");
		
		t1.readFile();
		
		System.out.println(t1);
	
	}

}
