package TweetsPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

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

	public void readFile () {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line;
			while ((line = lineReader.readLine())!=null) {
				String polarity = lineReader.readLine();
				String id = lineReader.readLine();
				String user = lineReader.readLine();
				String tweet = lineReader.readLine();
				if (polarity.equals("0")) {
					new Tweet(polarity, id, tweet, user);
				}
				else {
					System.err.println("error: unnknown person type");
				}			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String line = null;
				while ((line = lineReader.readLine())!=null) {
					String polarity = lineReader.readLine();
					String user = lineReader.readLine();
					String name = lineReader.readLine();
					String id = lineReader.readLine();
					if (line.equals("0")) {
						String tweet = lineReader.readLine();
						new Tweet(polarity, id, tweet, user);
					}
					else {
						System.err.println("error: unnknown person type");
					}				}
			} catch (Exception e2) {
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
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