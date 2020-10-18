package factoryColor;
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
    T color(final String value);
}
