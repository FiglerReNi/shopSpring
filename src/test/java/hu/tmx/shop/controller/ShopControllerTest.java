package hu.tmx.shop.controller;

import hu.tmx.shop.model.Flower;
import hu.tmx.shop.model.Shoe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ShopControllerTest {

    Flower flower;
    Shoe shoe;

    @BeforeEach
    public void setUp(){
        flower = new Flower("Liliom", 197);
        shoe = new Shoe(44, "Adidas");
    }



    @AfterEach
    public void tearDown(){

    }
}