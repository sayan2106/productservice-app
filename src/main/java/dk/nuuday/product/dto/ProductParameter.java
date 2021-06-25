package dk.nuuday.product.dto;

public class ProductParameter {
	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamGrp() {
		return paramGrp;
	}

	public void setParamGrp(String paramGrp) {
		this.paramGrp = paramGrp;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	String paramCode;
	String paramGrp;
	Parameter parameter;
}