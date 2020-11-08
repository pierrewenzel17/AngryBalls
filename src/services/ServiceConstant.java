package services;

import views.draw.GraphicConfigChooser;

public final class ServiceConstant {
    /**
     * a changer si on veux un autre front
     */
    public static final GraphicConfigChooser GRAPHIC_CONFIG_CHOOSER = GraphicConfigChooser.JAVAFX;

    private ServiceConstant() throws IllegalAccessException {
        throw new IllegalAccessException("not instantiable");
    }
}
