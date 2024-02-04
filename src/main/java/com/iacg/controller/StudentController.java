package com.iacg.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iacg.document.Student;
import com.iacg.dto.ResponseDto;
import com.iacg.dto.ResponseGenericDto;
import com.iacg.enums.StatusHttp;
import com.iacg.services.StudentService;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase de Comtroller que contiene los metodos, para el funcionamiento
 * de la API estudiante
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class StudentController {

	/**
	 * Servicio StudentService
	 */
	@Autowired
	private StudentService service;
	
	@PostMapping
	public ResponseEntity<?> saveStudent(@RequestBody Student student){
		log.info("Metodo: POST, Operacion: saveStudent, datos: {}", student);
		ResponseGenericDto<Student> response;
		HttpStatus httpStatus;
		//Llmar a servicio 
		Student studentInserted = this.service.insert(student);
		
		if(Objects.isNull(studentInserted)) {
			httpStatus = HttpStatus.CONFLICT;
			response = new ResponseGenericDto<Student>(new ResponseDto(StatusHttp.ERROR, httpStatus, "Error al crear estudiante"));
		}else {
			httpStatus = HttpStatus.CREATED;
			response = new ResponseGenericDto<Student>(studentInserted, new ResponseDto(StatusHttp.SUCCESS, httpStatus, "Exito al crear estudiante"));
		}
		return ResponseEntity.status(httpStatus).body(response);
	}
	
	@GetMapping()
	public ResponseEntity<?> findStudents(@RequestParam(required = false, name = "email") String email){
		log.info("Metodo: GET, Operacion: findStudents, correo: {}", email);
		ResponseGenericDto<Student> response;
		HttpStatus httpStatus;
		
		if(Objects.isNull(email)) {
			List<Student> students = this.service.findAllStudents();
			httpStatus = HttpStatus.OK;
			response = new ResponseGenericDto<Student>(students, new ResponseDto(StatusHttp.SUCCESS, httpStatus, "Se ha encontrado a los estudiante"));
		}else {
			//Llmar a servicio 
			Student studentFound = this.service.findByEmail(email);
			if(Objects.isNull(studentFound)) {
				httpStatus = HttpStatus.CONFLICT;
				response = new ResponseGenericDto<Student>(new ResponseDto(StatusHttp.WARN, httpStatus, "No se encontro al estudiante"));
			}else {
				httpStatus = HttpStatus.OK;
				response = new ResponseGenericDto<Student>(studentFound, new ResponseDto(StatusHttp.SUCCESS, httpStatus, "Se ha encontrado al estudiante"));
			}
		}
		
		

		return ResponseEntity.status(httpStatus).body(response);
	}
	
	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody Student student){
		log.info("Metodo: UPDATE, Operacion: updateStudent, datos: {}", student);
		ResponseGenericDto<Student> response;
		HttpStatus httpStatus;
		
		//Llamar al servicio
		Student studentUpdated = this.service.update(student);
		if(Objects.isNull(studentUpdated)) {
			httpStatus = HttpStatus.CONFLICT;
			response = new ResponseGenericDto<Student>(new ResponseDto(StatusHttp.ERROR, httpStatus, "No se actualizo al estudiante"));
		}else {
			httpStatus = HttpStatus.CREATED;
			response = new ResponseGenericDto<Student>(studentUpdated, new ResponseDto(StatusHttp.SUCCESS, httpStatus, "Se ha actualiado al estudiante"));
		}
		
		return ResponseEntity.status(httpStatus).body(response);
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<?> deleteStudent(@PathVariable(required = true, name = "email") String email){
		log.info("Metodo: DELETE, Operacion: deleteStudent, correo: {}", email);
		ResponseGenericDto<Student> response;
		HttpStatus httpStatus;	
		
		//Llamar a servicio
		boolean deleted = this.service.delete(email);
		
		if(!deleted) {
			httpStatus = HttpStatus.NOT_FOUND;
			response = new ResponseGenericDto<Student>(new ResponseDto(StatusHttp.ERROR, httpStatus, "No se elimino al estudiante"));
		}else {
			httpStatus = HttpStatus.OK;
			response = new ResponseGenericDto<Student>(new ResponseDto(StatusHttp.SUCCESS, httpStatus, "Se ha eliminado al estudiante"));
		}
		
		return ResponseEntity.status(httpStatus).body(response);
	}
	
}//Fin de clase
