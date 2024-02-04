package com.iacg.services.impl;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacg.document.Student;
import com.iacg.repository.StudentRepository;
import com.iacg.services.StudentService;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase que contiene los metodos del servicio de Estudiante
 * Conecta con el repositorio: StudentRepository
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService{
	
	/**
	 * Repositorio StudentRepository
	 */
	@Autowired
	private StudentRepository repository;
	
	/**
	 * Metodo para inserter un nuevo estudiante
	 * @param student estudiante
	 * @return Student
	 */
	@Override
	public Student insert(Student student) {
		//Buscar si el estudiante ya existe por correo
		Student studenFound = findByEmail(student.getEmail());
		if(!Objects.isNull(studenFound)) {
			log.warn("El estudiante con el correo: {}, ya existe", student.getEmail());
			return null;
		}
		//Llamar a repository
		student.setCreatedAt(LocalDateTime.now());
		student = this.repository.insert(student);
		return student;
	}

	/**
	 * Metodo que busca un estudiante por su correo
	 * @param email correo
	 * @return Student
	 */
	@Override
	public Student findByEmail(String email) {
		//Llama al repository
		Optional<Student> studentOpt = this.repository.findByEmail(email);
		if(!studentOpt.isPresent()) {
			log.warn("Estudiante con correo: {}, no existe", email);
			return null;
		}
		return studentOpt.get();
	}
	
	/**
	 * Metodo que lista todos los estudiantes
	 * @return List<Student> 
	 */
	public List<Student> findAllStudents(){
		//Llamar al respository
		List<Student> students = this.repository.findAll();
		return students;
	}

	/**
	 * Metodo que actualiza los datos del estudiante
	 * @param student
	 * @return Student
	 */
	@Override
	public Student update(Student student) {
		//Buscar el estudiante por correo
		Student studentFound = this.findByEmail(student.getEmail());
		
		if(Objects.isNull(studentFound)) {
			log.warn("El estudiante con correo: {}, no existe");
			return null;
		}
		//Actualizar datos
		studentFound.setFirstName(student.getFirstName());
		studentFound.setLastName(student.getLastName());
		studentFound.setGender(student.getGender());
		studentFound.setAddress(student.getAddress());
		studentFound.setFavoritesSubjects(student.getFavoritesSubjects());
		studentFound.setTotalSpentInBooks(student.getTotalSpentInBooks());
		
		//Llamar a repository
		studentFound = this.repository.save(studentFound);
		return studentFound;
	}

	/**
	 * Metodo que elimina los datos de un estudiante por su correo
	 * @param email
	 * @return boolean
	 */
	@Override
	public boolean delete(String email) {
		//Buscar el estudiante por correo
		Student studentFound = this.findByEmail(email);
		
		if(Objects.isNull(studentFound)) {
			log.warn("El estudiante con correo: {}, no existe");
			return false;
		}
		
		//Llamar a repository
		this.repository.delete(studentFound);
		log.info("El estudiante con correo: {}, ha sido eliminado");
		return true;
	}

}//Fin de clase
