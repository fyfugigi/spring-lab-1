package com.example.lab1.Controller;

import com.example.lab1.Service.Exception.NotFoundException;
import com.example.lab1.Service.Exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.net.URI.create;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Slf4j
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleProductNotFoundException(ProductNotFoundException ex) {
        log.info("Product not found exception raised");
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
        problemDetail.setType(create("product-not-found"));
        problemDetail.setTitle("Product Not Found");
        return ResponseEntity.status(NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ProblemDetail> handleProductNotFoundException(NotFoundException ex) {
        log.info("Not found exception raised");
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
        problemDetail.setType(create("not-found"));
        problemDetail.setTitle("Not Found");
        return ResponseEntity.status(NOT_FOUND).body(problemDetail);
    }
}
