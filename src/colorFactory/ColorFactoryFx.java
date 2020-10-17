package colorFactory;

import javafx.scene.paint.Color;
/**
 * Cette class dois être instancié si on utilise JavaFx
 * Elle transforme les couleurs de ColorForm en Color JavaFx
 */
public final class ColorFactoryFx extends ColorFactory<Color> {
    /**
     * Contructeur pour javaFx
     */
    public ColorFactoryFx() {
        super(Color::valueOf);
    }
}
