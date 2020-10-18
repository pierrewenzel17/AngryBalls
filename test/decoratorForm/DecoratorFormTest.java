package decoratorForm;

import models.Ball;
import models.Form;
import models.enums.ColorForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class DecoratorFormTest {

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
    }
}