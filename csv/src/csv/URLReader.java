package csv;

import java.net.*;
import java.io.*;

public class URLReader {
	public static void main(String[] args) throws Exception {

		URL template = new URL("file:///E:/Java/csv/Template.html");
		BufferedReader in = new BufferedReader(new InputStreamReader(template.openStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}
}