package factoryColor;

import javafx.scene.paint.Color;
/**
 * Cette class doit être instancié si on utilise JavaFx
 * Elle transforme les couleurs de ColorForm en Color JavaFx
 * @author Pierre Wenzel
 */
public final class ColorFactoryFx extends ColorFactory<Color> {
    /**
     * Contructeur pour javaFx
     * @author Pierre Wenzel
     */
    public ColorFactoryFx() {
        super(Color::valueOf);
    }
}
