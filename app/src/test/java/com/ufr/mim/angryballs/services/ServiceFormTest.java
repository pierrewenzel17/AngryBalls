package com.ufr.mim.angryballs.services;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.models.Form;
import com.ufr.mim.angryballs.models.enums.ColorForm;
import com.ufr.mim.angryballs.views.draw.DrawFx;
import com.ufr.mim.angryballs.views.draw.DrawVisitor;
import javafx.scene.Group;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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