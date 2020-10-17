package colorFactory;

import java.awt.Color;

/**
 * Cette class doit être instancié si on utilise awt
 * Elle transforme les couleurs de ColorForm en Color awt
 * @author Pierre Wenzel
 */
public final class ColorFactoryAwt extends ColorFactory<Color> {
    /**
     * Constructeur pour AWT
     * @author Pierre Wenzel
     */
    public ColorFactoryAwt() {
        super(Color::getColor);
    }
}
