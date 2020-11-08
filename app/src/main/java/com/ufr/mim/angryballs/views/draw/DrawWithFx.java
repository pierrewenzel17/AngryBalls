package com.ufr.mim.angryballs.views.draw;

import com.ufr.mim.angryballs.models.Ball;

import javafx.scene.Group;

public final class DrawWithFx implements IDrawVisitor<Group> {


    public static DrawWithFx getInstance() {
        return DrawWithFxHolder.INSTANCE.drawVisitor;
    }

    private DrawWithFx() {}

    @Override
    public void draw(final Ball ball, Group group) {
        //TODO Sebastien
        System.out.println(ball.toString());
    }

    private enum DrawWithFxHolder {

        INSTANCE(new DrawWithFx());

        protected final DrawWithFx drawVisitor;

        DrawWithFxHolder(final DrawWithFx drawVisitor) {
            this.drawVisitor = drawVisitor;
        }
    }
}
