package dk.nuuday.product.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dk.nuuday.product.dto.Product;
import dk.nuuday.product.dto.Root;

/*
 * This method using for reading data from the URIs of mobile Broadband and mobile Voice
 */

public class ProductAggregatorImpl {    

	String mobileBroadbandJson = ConfigurationProperty.dataUrl;
	String mobileVoiceJson = ConfigurationProperty.voiceUrl;
	List<Product> aggregatedProduct;
	Map<String, Product> productMap = Collections.synchronizedMap(new HashMap<>());

	public String readContentFromUrl(String jsonUrl) {
		StringBuilder content = new StringBuilder();
		try {
			URL url = new URL(jsonUrl);
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	/*
	 * This method used for aggregation of both the files for mobile Broadband and mobile Voice
	 */

	public Map<String, Product> aggregatedProducts() {
		String mobileBroadbandJsonString = readContentFromUrl(mobileBroadbandJson);
		GsonBuilder mobileBroadbandbuilder = new GsonBuilder();
		mobileBroadbandbuilder.setPrettyPrinting();
		Gson mobileBroadbandGson = mobileBroadbandbuilder.create();
		Root mobileBroadbandRoot = mobileBroadbandGson.fromJson(mobileBroadbandJsonString, Root.class);
		List<Product> mobileBroadbandProducts = mobileBroadbandRoot.getProduct();


		String mobileVoiceJsonString = readContentFromUrl(mobileVoiceJson);
		GsonBuilder mobileVoiceJsondbuilder = new GsonBuilder();
		mobileVoiceJsondbuilder.setPrettyPrinting();
		Gson mobileVoiceGson = mobileVoiceJsondbuilder.create();
		Root mobileVoiceRoot = mobileVoiceGson.fromJson(mobileVoiceJsonString, Root.class);		

		aggregatedProduct = new ArrayList<Product>();

		for (int i = 0; i < mobileBroadbandProducts.size(); i++) {
			productMap.put(mobileBroadbandProducts.get(i).getProductCode(),  mobileBroadbandProducts.get(i));
		}

		for (int j = 0; j < mobileVoiceRoot.getProduct().size(); j++) {
			productMap.put(mobileVoiceRoot.getProduct().get(j).getProductCode(), (Product) mobileVoiceRoot.getProduct().get(j));
		}

		return productMap;

	}


}
