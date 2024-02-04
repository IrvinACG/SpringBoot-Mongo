package com.iacg.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase POJO de Direccion
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
	
	/**
	 * Variable country
	 */
	private String country;
	
	/**
	 * Variable postCode
	 */
	private String postCode;
	
	/**
	 * Variable city
	 */
	private String city;

}//Fin de clase
