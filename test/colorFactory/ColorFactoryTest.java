package colorFactory;

import models.enums.ColorForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorFactoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mapColor() {
        var colorFactoryFx = new ColorFactoryFx();
        var colorFactoryAwt = new ColorFactoryAwt();
        assertEquals(javafx.scene.paint.Color.valueOf("#D58F1C"), colorFactoryFx.MapColor(ColorForm.BEIGE));
        assertEquals(java.awt.Color.getColor("#D58F1C"), colorFactoryAwt.MapColor(ColorForm.BEIGE));
    }
}