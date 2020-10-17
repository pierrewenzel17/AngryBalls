package models;

import colorFactory.ColorFactory;
import colorFactory.ColorFactoryFx;
import models.decorator.Bounce;
import models.decorator.UniformRectilinear;
import models.enums.ColorForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecoratorFormTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void init() {
        Form ballWithOption = new UniformRectilinear(new Bounce(new Ball(2, ColorForm.BLACK)));
        System.out.println(ballWithOption);
        ColorFactory colorFactory = new ColorFactoryFx();
    }
}