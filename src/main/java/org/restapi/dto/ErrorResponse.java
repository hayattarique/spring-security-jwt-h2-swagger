package org.restapi.dto;

import lombok.Data;

@Data
public class ErrorResponse {
	private String errorCode;
	private String errorMessage;

}
