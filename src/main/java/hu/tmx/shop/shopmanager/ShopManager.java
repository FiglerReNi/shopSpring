package hu.tmx.shop.shopmanager;

import hu.tmx.shop.model.Product;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ShopManager {

    public void displayPrice(List<Product> products) {
        products.forEach(System.out::println);
    }

}
