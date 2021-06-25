package dk.nuuday.product.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dk.nuuday.product.dto.Product;
import dk.nuuday.product.dto.SimplifiedProduct;

public class ProductService {
	
	private static final Logger logger = LogManager.getLogger(ProductService.class);
	public String getAllProducts() {
		
		Map<String, Product> productMap = Collections.synchronizedMap(new HashMap<>());

		List<SimplifiedProduct> simplifiedProductList = new ArrayList<SimplifiedProduct>();
		SimplifiedProduct simplifiedProduct;
		
		ProductAggregatorImpl _ProductAggregatorImpl = new ProductAggregatorImpl();
		productMap = _ProductAggregatorImpl.aggregatedProducts();
		
		for (Map.Entry<String,Product> entry : productMap.entrySet()) {
			simplifiedProduct = new SimplifiedProduct();
			simplifiedProduct.setProductCode(entry.getKey());
			simplifiedProduct.setProductName(entry.getValue().getProductName());
			simplifiedProductList.add(simplifiedProduct);
		}
            
		
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String jsonString = gson.toJson(simplifiedProductList);
		
		//logger.debug(jsonString);
		return jsonString;
		
		
	}
	
	
	public Product getProductByCode(String productCode) {
		
		
		
		Map<String, Product> productMap = Collections.synchronizedMap(new HashMap<>());
		ProductAggregatorImpl _ProductAggregatorImpl = new ProductAggregatorImpl();
		productMap = _ProductAggregatorImpl.aggregatedProducts();		
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String jsonString = gson.toJson(productMap.get(productCode));
		
		logger.debug(jsonString);
		logger.info("------++++ inside get product by code ++++-------------"+new Date());
		return productMap.get(productCode);
		
	}
	
	
}
