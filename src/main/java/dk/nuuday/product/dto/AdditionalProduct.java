package dk.nuuday.product.dto;

import java.util.List;

public class AdditionalProduct {
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public String getCmsReference() {
		return cmsReference;
	}

	public void setCmsReference(String cmsReference) {
		this.cmsReference = cmsReference;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public List<ProductParameter> getProductParameters() {
		return productParameters;
	}

	public void setProductParameters(List<ProductParameter> productParameters) {
		this.productParameters = productParameters;
	}

	public List<AdditionalProduct> getAdditionalProducts() {
		return additionalProducts;
	}

	public void setAdditionalProducts(List<AdditionalProduct> additionalProducts) {
		this.additionalProducts = additionalProducts;
	}

	String productCode;
	String productName;
	String productGroup;
	String productClass;
	String cmsReference;
	String productCategory;
	boolean forSale;
	boolean visible;
	List<ProductParameter> productParameters;
	List<AdditionalProduct> additionalProducts;
}
