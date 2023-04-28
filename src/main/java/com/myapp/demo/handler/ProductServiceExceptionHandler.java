package com.myapp.demo.handler;

import com.myapp.demo.dto.ErrorDTO;
import com.myapp.demo.exception.ProductNotFoundException;
import com.myapp.demo.exception.ProductServiceBusinessException;
import com.myapp.demo.response.APIResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ProductServiceExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public  APIResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        APIResponse<?> objectAPIResponse = new APIResponse<>();
        List<ErrorDTO> errorDTOList=new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error-> {
            ErrorDTO errorDTO=new ErrorDTO(error.getField(),error.getDefaultMessage());
            errorDTOList.add(errorDTO);
        });
        objectAPIResponse.setStatus("FAILED");
        objectAPIResponse.setErrors(errorDTOList);
    return objectAPIResponse;
    }

    @ExceptionHandler(ProductServiceBusinessException.class)
    public APIResponse<?> handleServiceException(ProductServiceBusinessException productServiceBusinessException){
        APIResponse<?> serviceResponse= new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("",productServiceBusinessException.getMessage())));
        return serviceResponse;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public APIResponse<?> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        APIResponse<?> serviceResponse=new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("",productNotFoundException.getMessage())));
        return serviceResponse;
    }
}
