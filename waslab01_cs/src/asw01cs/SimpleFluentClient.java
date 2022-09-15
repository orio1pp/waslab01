package asw01cs;


import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
//This code uses the Fluent API

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;

public class SimpleFluentClient {

	private static String URI = "http://localhost:8080/waslab01_ss/";

	public final static void main(String[] args) throws Exception {
    	
    	/* Insert code for Task #4 here */
		String nextTweet = Request.Post(URI)
	    .bodyForm(Form.form().add("author", "alex").add("tweet_text", "FirstTweet").build())
	    .addHeader("Accept", "text/plain").execute().returnContent().toString();
		System.out.println(nextTweet);
		
    	System.out.println(Request.Get(URI).addHeader("Accept", "text/plain").execute().returnContent());
    	
    	/* Insert code for Task #5 here */
    	Request.Post(URI).addHeader("Accept", "text/plain")
    	.bodyForm(Form.form().add("tweetID", nextTweet).build()).execute().returnContent();
    	
    	System.out.println(nextTweet + " has been deleted.");
    }
	
}

