package dk.nuuday.product.controller;



import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import dk.nuuday.product.core.ProductService;
import dk.nuuday.product.dto.Product;
import dk.nuuday.product.exceptionhandling.ProductNotFoundException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RestController
@RequestMapping("/product")
public class ProductController {
	private static final Logger logger = LogManager.getLogger(ProductController.class);
	ProductService productService=new ProductService();
	
	
	

	@GetMapping(value = "/getAllProducts" ,produces = APPLICATION_JSON_VALUE)
	public String getAllProducts() {
		logger.info("------inside getAllProducts----");
		return productService.getAllProducts();
	}
	
	

	@Cacheable("products")
	@GetMapping(value = "/getProductByCode",produces = APPLICATION_JSON_VALUE)
	public Product getProductByCode(@RequestParam(value = "productcode", defaultValue = "null")String productcode) {
		
		logger.info("productService.getProductByCode" + productService.getProductByCode(productcode));
		
		if (productService.getProductByCode(productcode) == null) {
			throw new ProductNotFoundException("Invalid product code : " + productcode);
		}
			
		
		
		logger.info("------inside getProductByCode----");
		//return new ResponseEntity<Product>(productService.getProductByCode(productcode), HttpStatus.OK);
		return productService.getProductByCode(productcode);
	}

	



}
