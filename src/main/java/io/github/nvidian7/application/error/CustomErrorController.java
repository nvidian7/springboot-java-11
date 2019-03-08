package io.github.nvidian7.application.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomErrorController
 */
@RestController
public class CustomErrorController extends AbstractErrorController {
    
    @Autowired private ErrorProperties errorProperties;
    
    public CustomErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }
  
    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> handleError(HttpServletRequest request) {
        return super.getErrorAttributes(request, errorProperties.isIncludeException());
    }
  
    @Override
    public String getErrorPath() {
        return "/error";
    }
}