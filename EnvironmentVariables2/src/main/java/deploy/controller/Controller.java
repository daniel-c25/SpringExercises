package deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Environment env;

    @GetMapping("/{name}")
    public String devName(@PathVariable String name) {
        return name + " " + env.getProperty("authCode") + " " + env.getProperty("devName");
    }
}