package com.alumini.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class BaseTelephone {
	
	@Column(name = "TYPE")
	@NotNull(message = "The type cannot be null")
	@NotEmpty(message = "The type cannot be empty")
	@Size(min = 1, max = 1, message = "The length of type is more than 1")
	private String type;
	
	@Column(name = "DIAL_NUMBER")
	@NotNull(message = "The dialNumber cannot be null")
	@NotEmpty(message = "The dialNumber cannot be empty")
	@Size(min = 1, max = 12, message = "The length of type is more than 12")
	private String dialNumber;
	
	@Column(name = "COUNTRY_DIALING")
	@NotNull(message = "The countryDialing cannot be null")
	@NotEmpty(message = "The countryDialing cannot be empty")
	@Size(min = 1, max = 5, message = "The countryDialing of type is more than 5")
	private String countryDialing;
	
	@Column(name = "AREA_DIALING", length = 5)
	private String areaDialing;
	
	@Column(name = "EXTENSION", length = 5)
	private String extension;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDialNumber() {
		return dialNumber;
	}
	
	public void setDialNumber(String dialNumber) {
		this.dialNumber = dialNumber;
	}
	
	public String getCountryDialing() {
		return countryDialing;
	}
	
	public void setCountryDialing(String countryDialing) {
		this.countryDialing = countryDialing;
	}
	
	public String getAreaDialing() {
		return areaDialing;
	}
	
	public void setAreaDialing(String areaDialing) {
		this.areaDialing = areaDialing;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "Telephone [type=" + type + ", dialNumber=" + dialNumber + ", countryDialing=" + countryDialing
				+ ", areaDialing=" + areaDialing + ", extension=" + extension + "]";
	}	
}
