package hu.tmx.shopSpring.model;

import hu.tmx.shopSpring.model.impl.Flower;
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
    public void GetPrice(){
        assertEquals(1394, flower.getPrice());
    }

    @Test
    public void FirstMaintainNeedIsTrueIfFlowerOlderThan3Years(){
        assertTrue(flower.needMaintenance());
    }

    @Test
    public void FirstMaintainNeedIsTrueIfFlower3Years(){
        flower.setAgeInWeeks(156);
        assertTrue(flower.needMaintenance());
    }

    @Test
    public void SecondMaintainNeedIsTrueIfPreviousMaintenanceOlderThan3Years(){
        flower.setLastMaintenanceDate(LocalDate.now().minusWeeks(200));
        assertTrue(flower.needMaintenance());
    }

    @Test
    public void FirstMaintainNeedIsFalseIfFlowerYoungerThan3Years(){
        flower.setAgeInWeeks(10);
        assertFalse(flower.needMaintenance());
    }

    @Test
    public void SecondMaintainNeedIsFalseIfPreviousMaintenanceYoungerThan3Years(){
        flower.setLastMaintenanceDate(LocalDate.now().minusWeeks(52));
        assertFalse(flower.needMaintenance());
    }

    @Test
    public void MaintainTypeIsCorrectIfFlowerNeedsMaintenance(){
        assertEquals("Öntözés", flower.maintain());
        assertEquals(LocalDate.now(), flower.getLastMaintenanceDate());
    }

    @Test
    public void MaintainTypeIsNullIfFlowerNoNeedMaintenance(){
        flower.setAgeInWeeks(10);
        assertNull(flower.maintain());
        assertNull(flower.getLastMaintenanceDate());
    }

    @Test
    public void ToStringCorrect(){
        System.out.println(flower);
        assertEquals("49 hónapos és 1 hetes Liliom - 1394.0", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown(){
        flower = null;
        System.setOut(standardOut);
    }

}
