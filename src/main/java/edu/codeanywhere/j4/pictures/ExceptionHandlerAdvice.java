package edu.codeanywhere.j4.pictures;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
public class ExceptionHandlerAdvice
{
    /**
     * This method intercepts the exception and replaces it with the VO.
     * 
     * @param exception <code>Exception</code>
     * @return ResponseEntity
     */
    @ExceptionHandler
    static @ResponseBody ResponseEntity handle(final Exception exception)
    {
        final HttpStatus responseStatus = resolveAnnotatedResponseStatus(exception);
        return new ResponseEntity<>(exception.getMessage(), responseStatus);
    }

    /**
     * This method find the ResponseValue of the exception if it was annotated. It returns Internal Server Error if no
     * ReponseValue was annotated on the Exception.
     * 
     * @param exception <code>Exception</code>
     * @return HttpStatus
     */
    static HttpStatus resolveAnnotatedResponseStatus(final Exception exception)
    {
        final ResponseStatus annotation = org.springframework.core.annotation.AnnotatedElementUtils
            .findMergedAnnotation(exception.getClass(), ResponseStatus.class);
        if (annotation != null)
        {
            return annotation.value();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

