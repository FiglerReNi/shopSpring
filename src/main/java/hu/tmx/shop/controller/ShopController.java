package hu.tmx.shop.controller;

import hu.tmx.shop.model.Product;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ShopController {

    public void displayPrice(List<Product> products) {
        products.forEach(System.out::println);
    }


}
