package fr.lacombe.cuisine.purchaseorder.infra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderController {
    @GetMapping("/status")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/order")
    public String order() {
        return "1 tomate\n2 patates";
    }
}
