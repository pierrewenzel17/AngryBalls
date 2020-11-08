package com.ufr.mim.angryballs.services;

import com.ufr.mim.angryballs.models.IBall;
import com.ufr.mim.angryballs.views.draw.IDrawVisitor;

import java.util.Arrays;
import java.util.List;

/**
 * Class qui gere toutes les opérations sur les formes
 */
public final class ServiceBall {
    /**
     * Constructeur
     */
    public ServiceBall() {}

    public void manageAcceleration(List<IBall> balls) {

    }

    public boolean manageCrashFormForm(List<IBall> balls) {
        return true;
    }

    public <GRAPHIC> void drawForm(IDrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g, List<IBall> balls) {
        try {
            for (IBall ball: balls) ball.draw(drawVisitor, g);
        } catch (NullPointerException nullPointerException) {
            throw new NullPointerException("The list of forms should be initialized");
        }
    }

    public <GRAPHIC> void drawForm(IDrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g, IBall... forms) {
        this.drawForm(drawVisitor, g, Arrays.asList(forms));
    }
}
