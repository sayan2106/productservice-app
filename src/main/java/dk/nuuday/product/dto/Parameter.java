package dk.nuuday.product.dto;

import java.util.List;

public class Parameter {
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isListInd() {
		return listInd;
	}

	public void setListInd(boolean listInd) {
		this.listInd = listInd;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public List<ParListEntry> getParListEntries() {
		return parListEntries;
	}

	public void setParListEntries(List<ParListEntry> parListEntries) {
		this.parListEntries = parListEntries;
	}

	public String getParamClass() {
		return paramClass;
	}

	public void setParamClass(String paramClass) {
		this.paramClass = paramClass;
	}

	public int getParamSize() {
		return paramSize;
	}

	public void setParamSize(int paramSize) {
		this.paramSize = paramSize;
	}

	public String getParamText() {
		return paramText;
	}

	public void setParamText(String paramText) {
		this.paramText = paramText;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getAdvisoryText() {
		return advisoryText;
	}

	public void setAdvisoryText(String advisoryText) {
		this.advisoryText = advisoryText;
	}

	public String getValidationExpr() {
		return validationExpr;
	}

	public void setValidationExpr(String validationExpr) {
		this.validationExpr = validationExpr;
	}

	boolean enable;
	boolean listInd;
	boolean mandatory;
	List<ParListEntry> parListEntries;
	String paramClass;
	int paramSize;
	String paramText;
	String paramType;
	String sortOrder;
	boolean visible;
	String advisoryText;
	String validationExpr;
}
