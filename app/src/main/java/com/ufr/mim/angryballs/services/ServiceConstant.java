package com.ufr.mim.angryballs.services;

import com.ufr.mim.angryballs.views.draw.GraphicConfigChooser;

public final class ServiceConstant {
    /**
     * a changer si on veux un autre front
     */
    public static final GraphicConfigChooser GRAPHIC_CONFIG_CHOOSER = GraphicConfigChooser.JAVAFX;

    private ServiceConstant() throws IllegalAccessException {
        throw new IllegalAccessException("not instantiable");
    }
}
