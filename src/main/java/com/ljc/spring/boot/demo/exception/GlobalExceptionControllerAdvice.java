package com.ljc.spring.boot.demo.exception;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionControllerAdvice {

    public static final String DEFAULT_ERROR_VIEW = "error";

//    @ExceptionHandler(Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e){
//            ModelAndView mav = new ModelAndView();
//            mav.addObject("exception",e);
//            mav.addObject("url",req.getRequestURL());
//            mav.setViewName(DEFAULT_ERROR_VIEW);
//            return mav;
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> defaultErrorHandler(HttpServletRequest req, Exception e){
        Map<String,String> map = new HashMap<String, String>();
        map.put("code","9999");
        map.put("msg","系统未知错误");
        return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
    }


}
