package ee.taltech.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@RestController
public class IndexController {

    @GetMapping
    public String index(){
        return "Hello from Spring Boot";
    }
}
