package com.iacg.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.iacg.enums.StatusHttp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto implements Serializable{
	
	/**
	 * Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variable status
	 */
	private StatusHttp status;
	
	/**
	 * Variable de httpStatus
	 */
	HttpStatus httpStatus;
	
	/**
	 * Variable message
	 */
	private String message;

}//Fin de clase
