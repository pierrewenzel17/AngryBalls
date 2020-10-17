package colorFactory;

import javafx.scene.paint.Color;
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
        ColorFactory<Color> colorFactory = new ColorFactoryFx();
        assertEquals(Color.valueOf("#D58F1C"), colorFactory.MapColor(ColorForm.BEIGE));
    }
}