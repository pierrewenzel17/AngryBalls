package services;

import javafx.scene.Group;
import models.Ball;
import models.Form;
import models.enums.ColorForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import views.draw.DrawFx;
import views.draw.DrawVisitor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ServiceFormTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void drawForm() {
        List<Form> forms = new ArrayList<>();
        ServiceForm serviceForm = new ServiceForm();

        forms.add(new Ball(2, ColorForm.BEIGE));
        Group group = new Group();

        DrawFx g = (DrawFx) DrawVisitor.getInstance();
        serviceForm.drawForm(g, group, forms);
        //serviceForm.drawForm(DrawVisitor.getInstance(), group, new Ball(3, ColorForm.BLUE));
    }
}