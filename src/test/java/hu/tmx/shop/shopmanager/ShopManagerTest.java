package hu.tmx.shop.shopmanager;

import hu.tmx.shop.model.impl.Flower;
import hu.tmx.shop.model.impl.Shoe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopManagerTest {

    @Autowired
    ShopManager shopManager;

    Flower flower;
    Shoe shoe;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        flower = new Flower("Liliom", 197);
        shoe = new Shoe(44, "Adidas");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void displayPriceIsCorrect(){
        shopManager.displayPrice(List.of(flower, shoe));
        assertEquals("49 hónapos és 1 hetes Liliom - 1394"
                + System.lineSeparator() + "44.0 méretű Adidas Cipő - 15000", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown(){
        flower = null;
        shoe = null;
        System.setOut(standardOut);
    }
}
