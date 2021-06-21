package com.example.consumingrest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO {

	private Double num;
	private String status;

	public Double getNum() {
		return num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ResponseDTO(double v, String asd) {
	}

	@Override
	public String toString() {
		return "Quote{" +
				"num=" + num +
				", status='" + status + '\'' +
				'}';
	}
}