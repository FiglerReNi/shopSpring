package hu.tmx.shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Product {

    private final String name;

    public abstract double receivePrice();




}
