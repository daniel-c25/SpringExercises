package interceptor.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import interceptor.Month;

@RestController
public class Controller {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/")
    public String hello() {
        return "Hello User!";
    }

    @GetMapping("/month")
    public Month getMoth() {
        return (Month) request.getAttribute("month");
    }

}