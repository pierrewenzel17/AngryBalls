package com.ufr.mim.angryballs.views.draw;

import com.ufr.mim.angryballs.models.Ball;

import javafx.scene.Group;

public final class DrawFx extends DrawVisitor<Group> {

    public DrawFx() {
    }

    @Override
    public void draw(final Ball ball, Group group) {
        //TODO Sebastien
        System.out.println(ball.toString());
    }
}
