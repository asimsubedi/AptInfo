package com.nivtek.aptinfo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author AsimSubedi
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	// handling ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException resourceNotFound,
			WebRequest webrequest) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), resourceNotFound.getMessage(),
				webrequest.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}

	// handling Global Exception
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest webrequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
				webrequest.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
