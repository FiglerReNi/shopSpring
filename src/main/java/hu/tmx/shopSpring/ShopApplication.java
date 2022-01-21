package hu.tmx.shopSpring;

import hu.tmx.shopSpring.shopmanager.ShopManager;
import hu.tmx.shopSpring.model.impl.Flower;
import hu.tmx.shopSpring.model.impl.Shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {


    ShopManager shopManager;

    @Autowired
    public void setShopManager(ShopManager shopManager) {
        this.shopManager = shopManager;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void run(String... args) {
        shopManager.displayPrice(List.of(
                new Shoes("Adidas", 44),
                new Shoes("Reebok", 40.5),
                new Shoes("Nike", 38),
                new Flower("Liliom", 8),
                new Flower("Jácint", 1)
        ));
    }
}
