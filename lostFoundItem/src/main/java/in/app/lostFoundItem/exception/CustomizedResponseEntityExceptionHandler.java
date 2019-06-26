package in.app.lostFoundItem.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionBody exp=	new ExceptionBody(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exp,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(ItemNotFoundException.class)
	public final ResponseEntity<Object> handleItemNotFoundException(ItemNotFoundException ex, WebRequest request) throws Exception {
		ExceptionBody exp=	new ExceptionBody(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exp,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<Object> handleEmployeemNotFoundException(EmployeeNotFoundException ex, WebRequest request) throws Exception {
		ExceptionBody exp=	new ExceptionBody(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exp,HttpStatus.NOT_FOUND);
		
	}

}
