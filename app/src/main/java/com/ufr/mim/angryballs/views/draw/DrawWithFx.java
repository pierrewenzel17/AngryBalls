package com.ufr.mim.angryballs.views.draw;

import com.ufr.mim.angryballs.models.Ball;

import javafx.scene.Group;

/**
 * Class de dessin en javafx
 */
public final class DrawWithFx implements IDrawVisitor<Group> {
    /**
     * Singleton
     * @return l'instance du holder
     */
    public static DrawWithFx getInstance() {
        return DrawWithFxHolder.INSTANCE.drawVisitor;
    }

    private DrawWithFx() {}

    @Override
    public void draw(final Ball ball, Group group) {
        //TODO Seb
    }
    /**
     * Singleton holder
     */
    private enum DrawWithFxHolder {

        INSTANCE(new DrawWithFx());

        protected final DrawWithFx drawVisitor;

        DrawWithFxHolder(final DrawWithFx drawVisitor) {
            this.drawVisitor = drawVisitor;
        }
    }
}
