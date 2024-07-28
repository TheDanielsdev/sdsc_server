package com.segundaniels.segundaniels;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

   @GetMapping("/say")
    public String toString() {
        return "Hello";
    }
}
