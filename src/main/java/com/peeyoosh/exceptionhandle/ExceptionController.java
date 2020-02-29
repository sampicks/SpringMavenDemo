/**
 * 
 */
package com.peeyoosh.exceptionhandle;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This exception handler is generic class for all controllers. 
 * For specific controller we can create ExceptionHandler in controller itself.
 * Recommended for Global Exception Handling and Global Binders.
 * @author peeyooshkhare
 *
 */
@ControllerAdvice
public class ExceptionController {

	private Log logger = LogFactory.getLog(ExceptionController.class);
	
	@ExceptionHandler(value = Exception.class)
	public String handleError(HttpServletRequest req, Exception exception) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		return "error";
	}
}
