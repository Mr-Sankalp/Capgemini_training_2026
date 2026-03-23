package com.cg.exception;

import com.cg.dto.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice //kind of controller but is an advice class too(part of aop)-> acts as an observer
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(EmployeeNotFoundException exception, HttpServletRequest request){
        return new ErrorDTO(exception.getMessage(), LocalDate.now(),request.getRequestURI());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    //key- field name, value- error dto(since there can be exceptions in many fields, hence map them and then handle)
    public Map<String, ErrorDTO> handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request){
        //getAllErrors- returns List<ObjectError> that lists all the errors
        List<ObjectError> errors=exception.getBindingResult().getAllErrors();
        Map<String, ErrorDTO> errorsmap=new HashMap<>();
        for(ObjectError error:errors){
            String fieldName=((FieldError)error).getField(); //returns the name of the field
            errorsmap.put(fieldName,new ErrorDTO(error.getDefaultMessage(), LocalDate.now(),request.getRequestURI()));
        }
        return errorsmap;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleException(Exception exception, HttpServletRequest request){
        return new ErrorDTO(exception.getMessage(), LocalDate.now(),request.getRequestURI());
    }
}
