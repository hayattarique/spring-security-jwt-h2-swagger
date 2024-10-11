package org.restapi.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductDetails {
	private String productName;
	private String manufacturer;
	private String category;
	private LocalDate manufacturingDate;
	private double price;
}
