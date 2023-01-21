package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
  
	@ExceptionHandler(OrderBillException.class)
	public ResponseEntity<MyErrorDetails> myOrderBillExceptionHandler(OrderBillException obe, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), obe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
/*------------------------------------------Global SweetItemException-------------------------------------------------*/

	
	
	
	@ExceptionHandler(SweetOrderException.class)
	public ResponseEntity<MyErrorDetails> mySweetOrderExceptionHandler(SweetOrderException soe, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), soe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(CustomerException e, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(ProductException pe, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), pe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),
				me.getBindingResult().getFieldError().getDefaultMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception e, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(IllegalArgumentException e, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> myEhandler(LoginException e, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> categoryExceptionHandler(CategoryException e, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> cartExceptionHandler(CartException e, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
