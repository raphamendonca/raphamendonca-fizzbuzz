package com.github.raphamendonca.raphamendoncafizzbuzz.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class})
 	public ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex) {

		return new ResponseEntity<>(new ResponseError.ResponseErrorBuilder()
		        .withStatus(HttpStatus.BAD_REQUEST)
		        .withCode(HttpStatus.BAD_REQUEST.value())
		        .withMessage("Invalid parameter type, must be an Integer value. Or a list of integer separated with comma")
		        .build(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { Exception.class,RuntimeException.class })
	public ResponseEntity<Object> defaultExceptionHandler(Exception ex) {

		ResponseError response;
		if (ex instanceof Exception) {
			response = new ResponseError.ResponseErrorBuilder()
			        .withStatus(HttpStatus.BAD_REQUEST)
			        .withCode(HttpStatus.BAD_REQUEST.value())
			        .withMessage(ex.getLocalizedMessage()).build();
		}else {
			response = new ResponseError.ResponseErrorBuilder()
			        .withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
			        .withCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
			        .withMessage(ex.getLocalizedMessage()).build();			
		}
		
		return new ResponseEntity<>(response,response.getStatus());
	}

	
}
