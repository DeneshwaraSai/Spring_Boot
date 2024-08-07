package com.pharmacy.code.dto;

public class SimpleCodeValue {
	private String code;

	private String value;

	public SimpleCodeValue() {

	}

	public SimpleCodeValue(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SimpleCodeValue [code=" + code + ", value=" + value + "]\n";
	}
}
