package com.ufr.mim.angryballs.views.draw;

public enum GraphicConfigChooser {

    JAVAFX("JAVAFX", new DrawFx());

    protected final String name;
    public final DrawVisitor<?> drawVisitor;

    GraphicConfigChooser(final String name, DrawVisitor<?> drawVisitor) {
        this.name = name;
        this.drawVisitor = drawVisitor;
    }
}
