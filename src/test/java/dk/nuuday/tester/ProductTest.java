package dk.nuuday.tester;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import dk.nuuday.product.controller.ProductController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProductTest {
	private static final Logger logger = LogManager.getLogger(ProductController.class);

	@Test
	public void givenUriValidator()
	  throws ClientProtocolException, IOException {
		String jsonMimeType = "application/json";
	 
		logger.info("------Checking voice.json-----");
	    HttpUriRequest request = new HttpGet("https://products-json-example.s3.eu-central-1.amazonaws.com/voice.json");

	    
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	    logger.info("------Response code----->"+httpResponse);
	    
	    assertEquals(200,httpResponse.getStatusLine().getStatusCode());
	    
	    String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
	    logger.info("------mimeType----->"+mimeType);
	    assertEquals( jsonMimeType, mimeType );
	    
	    logger.info("------Checking data.json-----");
	    HttpUriRequest request1 = new HttpGet("https://products-json-example.s3.eu-central-1.amazonaws.com/data.json");

	    
	    HttpResponse httpResponse1 = HttpClientBuilder.create().build().execute( request1 );
	    logger.info("------Response code----->"+httpResponse1);
	    assertEquals(200,httpResponse1.getStatusLine().getStatusCode());
	    
	    String mimeType1 = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
	    logger.info("------mimeType----->"+mimeType1);
	    assertEquals( jsonMimeType, mimeType1 );
	}
}
