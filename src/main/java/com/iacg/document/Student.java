package com.iacg.document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iacg.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase POJO de Estudiante
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document
public class Student {

	/**
	 * Variable id
	 */
	@Id
	private String id;
	
	/**
	 * Variable firstName
	 */
	private String firstName;
	
	/**
	 * Variable lastName
	 */
	private String lastName;
	
	/**
	 * Variable email
	 */
	@Indexed(unique = true)
	private String email;
	
	/**
	 * Variable gender
	 */
	private Gender gender;
	
	/**
	 * Variable address
	 */
	private Address address;
	
	/**
	 * Variable createdAt
	 */
	@CreatedDate
	private LocalDateTime createdAt;
	
	/**
	 * Variable favoritesSubjects
	 */
	private List<String> favoritesSubjects;
	
	/**
	 * Variable totalSpentInBooks
	 */
	private BigDecimal totalSpentInBooks;
	
	
}//Fin de clase
