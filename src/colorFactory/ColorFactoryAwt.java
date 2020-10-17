package colorFactory;

import java.awt.Color;

/**
 * Cette class dois être instancié si on utilise awt
 * Elle transforme les couleurs de ColorForm en Color awt
 */
public final class ColorFactoryAwt extends ColorFactory<Color> {
    /**
     * Constructeur pour AWT
     */
    public ColorFactoryAwt() {
        super(Color::getColor);
    }
}
