package hu.tmx.shop;

import hu.tmx.shop.shopmanager.ShopManager;
import hu.tmx.shop.model.impl.Flower;
import hu.tmx.shop.model.impl.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

    @Autowired
    ShopManager shopManager;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void run(String... args) {
        shopManager.displayPrice(List.of(
                new Shoe(44, "Adidas"),
                new Shoe(40.5, "Reebok"),
                new Shoe(38, "Nike"),
                new Flower("Liliom", 8),
                new Flower("Jácint", 1)
        ));
    }
}
