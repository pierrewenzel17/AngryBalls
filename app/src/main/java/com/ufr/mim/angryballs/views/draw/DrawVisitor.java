package com.ufr.mim.angryballs.views.draw;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.services.ServiceConstant;

public abstract class DrawVisitor<GRAPHIC> {

    public static DrawVisitor<?> getInstance() {
        return DrawVisitorHolder.INSTANCE.drawVisitor;
    }

    protected DrawVisitor() {}
    /* void draw(final Form ? , GRAPHIC graphic); */
    public abstract void draw(final Ball ball, GRAPHIC graphic);

    /**
     * Singleton
     */
    private enum DrawVisitorHolder {

        INSTANCE(ServiceConstant.GRAPHIC_CONFIG_CHOOSER.drawVisitor);

        protected final DrawVisitor<?> drawVisitor;

        DrawVisitorHolder(final DrawVisitor<?> drawVisitor) {
            this.drawVisitor = drawVisitor;
        }
    }
}
