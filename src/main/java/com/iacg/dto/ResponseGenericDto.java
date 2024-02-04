package com.iacg.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseGenericDto<T> implements Serializable{

	/**
	 * Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variable data
	 */
	private T data;
	
	/**
	 * Variable list
	 */
	private List<T> list;
	
	/**
	 * Variable response
	 */
	private ResponseDto response;
	
	/**
	 * Constructor de clase
	 * @param data datos
	 * @param response response
	 */
	public ResponseGenericDto(T data, ResponseDto response){
		this.data = data;
		this.response = response;
	}	
	
	/**
	 * Constructor de clase
	 * @param list lista de datos
	 * @param response response
	 */
	public ResponseGenericDto(List<T> list, ResponseDto response){
		this.list = list;
		this.response = response;
	}
	
	/**
	 * Constructor de clase
	 * @param response response
	 */
	public ResponseGenericDto(ResponseDto response){
		this.response = response;
	}
	
}//Fin de clase
