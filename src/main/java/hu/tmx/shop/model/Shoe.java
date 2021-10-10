package hu.tmx.shop.model;

import hu.tmx.shop.service.Refundable;
import org.springframework.beans.factory.annotation.Autowired;

public class Shoe extends Product{

    private double size;

    @Autowired
    private Refundable refundable;

    public Shoe(String name, double size) {
        super(name);
        this.size = size;
    }

    @Override
    public double receivePrice() {

    }
}
