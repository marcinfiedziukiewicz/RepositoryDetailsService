package my.task.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionController {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    Map<String, Object> errorHandlerForHttpClientErrorException(HttpServletRequest request, HttpClientErrorException e) {
        log.error("HttpClientErrorException: " + e.getMessage(), e);
        return buildErrorResponse(request, e);
    }

    private Map<String, Object> buildErrorResponse(HttpServletRequest request, Exception e) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", e.getMessage());
        errorResponse.put("path", request.getServletPath());
        return errorResponse;
    }
}
