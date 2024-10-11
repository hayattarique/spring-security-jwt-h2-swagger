package org.restapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String productName;
    private String manufacturer;
    private String category;

}
