package hu.tmx.shop.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ShoeTest {

    Shoe shoe;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        shoe = new Shoe(44, "Adidas");
        shoe.setSellDate(LocalDate.of(2021,10, 1));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void receiveLargePrice(){
        assertEquals(15000, shoe.receivePrice());
    }

    @Test
    public void receiveSmallPrice(){
        shoe.setSize(40);
        assertEquals(14000, shoe.receivePrice());
    }

    @Test
    public void firstDayRefundablePrice(){
        shoe.setSellDate(LocalDate.now());
        assertEquals(15000, shoe.receiveRefundablePrice());
    }

    @Test
    public void SecondDayRefundablePrice(){
        shoe.setSellDate(LocalDate.of(2021,10,10));
        assertEquals(7500, shoe.receiveRefundablePrice());
    }

    @Test
    public void NoRefundablePrice(){
        shoe.setSellDate(LocalDate.of(2021,1,1));
        assertEquals(0, shoe.receiveRefundablePrice());
    }

    @Test
    public void toStringIsCorrect(){
        System.out.println(shoe);
        assertEquals("44.0 méretű Adidas Cipő - 15000", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown(){
        shoe = null;
        System.setOut(standardOut);
    }

}