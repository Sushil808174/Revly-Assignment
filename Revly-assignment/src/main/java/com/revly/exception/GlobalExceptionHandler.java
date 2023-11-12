package com.revly.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userExceptionHandler(UserException ex ,WebRequest req){
		ErrorDetails err= new ErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ex.getLocalizedMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DoubtException.class)
	public ResponseEntity<ErrorDetails> doubtExceptionHandler(DoubtException ex ,WebRequest req){
		ErrorDetails err= new ErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ex.getLocalizedMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> gereralExceptionHandler(Exception ex ,WebRequest req){
		ErrorDetails err= new ErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ex.getLocalizedMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> walletExceptionHandler(NoHandlerFoundException ex ,WebRequest req){
		ErrorDetails err= new ErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ex.getLocalizedMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
}
