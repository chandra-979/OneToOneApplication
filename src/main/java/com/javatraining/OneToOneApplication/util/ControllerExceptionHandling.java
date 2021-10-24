package com.javatraining.OneToOneApplication.util;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandling {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handlingConstraintsViolationException(ConstraintViolationException exception) {
		ErrorMessage error = new ErrorMessage();
		error.setTimeStamp(LocalDateTime.now());
		String errorMsg = "";
		errorMsg = exception.getConstraintViolations().stream().map(err->err.getMessage()).collect(Collectors.joining(" : "));
		error.setErrorMessage(errorMsg);
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handlingMethodArgumentException(MethodArgumentNotValidException exception) {
		ErrorMessage error = new ErrorMessage();
		error.setTimeStamp(LocalDateTime.now());
		List<FieldError> errors = exception.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(fieldError -> new FieldError(fieldError.getField(), fieldError.getDefaultMessage(), null))
	            .collect(Collectors.toList());
		String errorMsg = "";
		errorMsg = errors.stream().map(err->err.getField()).collect(Collectors.joining(" : "));
		error.setErrorMessage(errorMsg);
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleNormalException(Exception exception) {
		ErrorMessage error = new ErrorMessage();
		error.setTimeStamp(LocalDateTime.now());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
