package hu.tmx.shop.util.impl;

import hu.tmx.shop.model.Product;
import hu.tmx.shop.util.ListInitializer;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ListInitializerImpl implements ListInitializer {

    @Override
    public void productInitializer(List<Product> products) {
        products.forEach();
    }
}
