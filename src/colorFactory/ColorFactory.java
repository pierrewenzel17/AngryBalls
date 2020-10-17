package colorFactory;

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
    protected Map<ColorForm,T> _colorMap;
    /**
     * Fonction qui tranforme un string en couleur
     * Et définie dans les classes filles
     */
    final IColorListener<T> _colorListener;
    /**
     * Constructeur la factory
     * @param colorListener : fonction de couleur ou le paramètre est un string
     * @author Pierre Wenzel
     */
    protected ColorFactory(IColorListener<T> colorListener) {
        _colorListener = colorListener;
        _colorMap = new HashMap<>();
        for(ColorForm c : ColorForm.values()) this._colorMap.put(c, _colorListener.color(c.value));
    }
    /**
     * Cette fonction transforme la couleur back-end en front-end
     * @param colorForm : Couleur voulu en frond-end
     * @return la couleur en front-end
     * @author Pierre Wenzel
     */
    public T MapColor(ColorForm colorForm) { return _colorMap.get(colorForm); }
}
/**
 * Interface Listener (pointeur de fonction / callback / delegate)
 * Est seulement défini pour la Class ColorFactory et ces filles, ne pas utiliser autre part
 * @param <T> : Couleur en fonction de la classe fille
 * @author Pierre Wenzel
 */
interface IColorListener<T> {
    /**
     * Fonction qui sert de prête-nom la fonction voulu
     * @param value : la valeur string d'une couleur exemple #FFFFFF
     * @return la couleur
     * @author Pierre Wenzel
     */
    T color(String value);
}
