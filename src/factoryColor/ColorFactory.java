package factoryColor;

import models.enums.ColorForm;

import java.util.HashMap;
import java.util.Map;
/**
 * Cette Factory permet de transformer une couleur du Back-end en couleur Front-end
 * @param <T> : Le type de la couleur en fonction de ça librairie de front-end (awt, swing, JavaFx)
 * @author Pierre Wenzel
 */
public abstract class ColorFactory<T> {
    /**
     * Table de hachage qui fait le lien entre le couleur Back-end (clef) et la couleur font-end
     * qui correspond (valeur)
     */
    private final Map<ColorForm,T> _colorMap;
    /**
     * Constructeur la factory
     * @param colorListener : fonction de couleur ou le paramètre est un string
     * @author Pierre Wenzel
     */
    protected ColorFactory(final IColorListener<T> colorListener) {
        _colorMap = new HashMap<>();
        for(ColorForm c : ColorForm.values()) this._colorMap.put(c, colorListener.color(c.value));
    }
    /**
     * Cette fonction transforme la couleur back-end en front-end
     * @param colorForm : Couleur voulu en frond-end
     * @return la couleur en front-end
     * @author Pierre Wenzel
     */
    public T MapColor(final ColorForm colorForm) { return _colorMap.get(colorForm); }
}
