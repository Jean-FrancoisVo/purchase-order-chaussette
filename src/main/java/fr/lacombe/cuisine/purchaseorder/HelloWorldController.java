package fr.lacombe.cuisine.purchaseorder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/status")
    public String hello() {
        return "Hello";
    }
}
