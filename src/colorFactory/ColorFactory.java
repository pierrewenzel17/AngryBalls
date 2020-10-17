package colorFactory;

import models.enums.ColorForm;
import java.util.Map;

/**
 * Cette Factory permet de transformer une couleur du Back-end en couleur Front-end
 * @param <T> : Le type de la couleur en fonction de ça librairie de front-end (awt, swing, JavaFx)
 */
public abstract class ColorFactory<T> {
    /**
     * Table de hachage qui fait le lien entre le couleur Back-end (clef) et la couleur font-end
     * qui correspond (valeur)
     */
    protected Map<ColorForm,T> _colorMap;
    /**
     * Cette fonction transforme la couleur back-end en front-end
     * @param colorForm : Couleur voulu en frond-end
     * @return la couleur en front-end
     */
    public abstract T MapColor(ColorForm colorForm);
}
