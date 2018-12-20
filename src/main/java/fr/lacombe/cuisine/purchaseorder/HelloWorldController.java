package fr.lacombe.cuisine.purchaseorder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/status")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/order")
    public String order() {
        return "1 tomate\n2 patates";
    }
}
