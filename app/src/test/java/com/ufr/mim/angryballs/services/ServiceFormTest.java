package com.ufr.mim.angryballs.services;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.models.IBall;
import com.ufr.mim.angryballs.models.Color;
import com.ufr.mim.angryballs.views.draw.DrawWithFx;
import com.ufr.mim.angryballs.views.draw.IDrawVisitor;
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
        List<IBall> forms = new ArrayList<>();
        ServiceBall serviceForm = new ServiceBall();

        forms.add(new Ball(2, Color.BEIGE));
        Group group = new Group();

        //serviceForm.drawForm(g, group, forms);
        //serviceForm.drawForm(DrawVisitor.getInstance(), group, new Ball(3, ColorForm.BLUE));
    }
}