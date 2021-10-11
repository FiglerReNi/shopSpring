package hu.tmx.shop.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {

    Flower flower;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        flower = new Flower("Liliom", 197);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void receiveLargePrice(){
        assertEquals(1394, flower.receivePrice());
    }

    @Test
    public void firstMaintainNeedIsTrue(){
        assertTrue(flower.isMaintained());
    }

    @Test
    public void secondMaintainNeedIsTrue(){
        flower.setMaintainDate(LocalDate.of(2018, 1, 1));
        assertTrue(flower.isMaintained());
    }

    @Test
    public void firstMaintainNeedIsFalse(){
        flower.setAge(3);
        assertFalse(flower.isMaintained());
    }

    @Test
    public void secondMaintainNeedIsFalse(){
        flower.setMaintainDate(LocalDate.of(2020, 1, 1));
        assertFalse(flower.isMaintained());
    }

    @Test
    public void needMaintain(){
        assertEquals("Öntözés", flower.maintain());
        assertEquals(LocalDate.of(2021,10,11), flower.getMaintainDate());
    }

    @Test
    public void noNeedMaintain(){
        flower.setAge(3);
        assertNull(flower.maintain());
        assertNull(flower.getMaintainDate());
    }

    @Test
    public void toStringIsCorrect(){
        System.out.println(flower);
        assertEquals("49 hónapos és 1 hetes Liliom - 1394", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown(){
        flower = null;
        System.setOut(standardOut);
    }

}