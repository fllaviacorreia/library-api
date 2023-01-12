package com.projects.library.api.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Field> fields = new ArrayList<>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String field = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			fields.add(new Field(field, message));
		}
		
		Error error = new Error();
		error.setStatus(status.value());
		error.setDateTime(LocalDateTime.now());
		error.setTitle("Some error(s) occured in request...");
		error.setListFields(fields);
		
		return handleExceptionInternal(ex, error, headers, status, request);
	}
}

