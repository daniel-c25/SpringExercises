package interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {

    @GetMapping("/time")
    public LocalDateTime time() {
        return LocalDateTime.now();
    }

    @GetMapping("/legacy")
    public String legacy() {
        return "This is just old code";
    }

}