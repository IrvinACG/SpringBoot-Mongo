package com.iacg.services;

import java.util.List;

import com.iacg.document.Student;

/*
 * Interface que contiene los metodos
 * del servicio StudentService
 */
public interface StudentService {

	/**
	 * Metodo para inserter un nuevo estudiante
	 * @param student estudiante
	 * @return Student
	 */
	Student insert(Student student);
	
	/**
	 * Metodo que busca un estudiante por su correo
	 * @param email correo
	 * @return Student
	 */
	Student findByEmail(String email);
	
	/**
	 * Metodo que lista todos los estudiantes
	 * @return List<Student> 
	 */
	List<Student> findAllStudents();
	
	/**
	 * Metodo que actualiza los datos del estudiante
	 * @param student
	 * @return Student
	 */
	Student update(Student student);
	
	/**
	 * Metodo que elimina los datos de un estudiante por su correo
	 * @param email
	 * @return boolean
	 */
	boolean delete (String email);
	
}//Fin de clase
