package com.ufr.mim.angryballs.models;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

import java.util.Collection;

/**
 * Interface représentent une bille et qui sert de pont pour décoré une bille
 * @see <a href="https://fr.wikipedia.org/wiki/Décorateur_(patron_de_conception)">Decorator Design Pattern</a>
 */
public interface Ball {
    double getRadius();
    double getDensity();
    Color getColor();
    Vecteur getPosition();
    Vecteur getSpeed();
    Vecteur getAcceleration();
    double getMass();

    default double getX() {
        return getPosition().x;
    }

    default double getY() {
        return getPosition().y;
    }

    /**
     * Fonction de déplacement d'une bille en fonction du temps
     * @param deltaT : variable de temps en millisecondes
     */
    void move(double deltaT);
    /**
     * Fonction qui gère les collisions avec les bores de fenêtre. <b>Fonction décoré</b>.
     * <p>Dans {@link SimpleBall} cette fonction crée un rebond sur les bords.</p>
     * <p>Elle est redéfinit dans les classes d'options suivante : </p>
     * <ul>
     *     <li>{@link com.ufr.mim.angryballs.models.balloptions.Blocked}</li>
     *     <li>{@link com.ufr.mim.angryballs.models.balloptions.WallPass}</li>
     * </ul>
     * <p>Toute les opérations sur les paramètres peu importe les options sont réalisés dans {@link Collisions}</p>
     * @param xAxis Représente l'axe des abscisses
     * @param yAxis Représente l'axe des ordonnées
     * @param width Représente la largeur de la fenêtre
     * @param height Représente la hauteur de la fenêtre
     */
    void manageCollision(double xAxis, double yAxis, double width, double height);
    /**
     * Fonction qui ajoute une accélération à une bille. <b>Fonction décoré</b>.
     * <p>Dans {@link SimpleBall} l'accélération de base est {@link Vecteur Vecteur.VECTEURNUL} donc null.</p>
     * <p>Elle est redéfinit dans les classes d'options suivante : </p>
     * <ul>
     *     <li>{@link com.ufr.mim.angryballs.models.balloptions.Gravity}</li>
     *     <li>{@link com.ufr.mim.angryballs.models.balloptions.Newton}</li>
     *     <li>{@link com.ufr.mim.angryballs.models.balloptions.AirFriction}</li>
     * </ul>
     * @param balls : <p>représente toute les billes en mouvement, ce paramètre n'est que utilisé
     *              dans l'accélération de Newton.
     */
    void manageAcceleration(final Collection<Ball> balls);
    /**
     * Fonction qui vérifie si {@code this} est en collision avec une bille.
     * @param ball Une bille décoré ou non.
     * @return {@code true} si la {@link Ball balle} est
     * en collisions avec la {@link Ball balle donnée en paramètre}.
     * @see Collisions
     */
    default boolean isInCollision(final Ball ball) {
        return Collisions.CollisionBilleBille(getPosition(), getRadius(), getSpeed(),  getMass(),
                ball.getPosition(), ball.getRadius(), ball.getSpeed(), ball.getMass());
    }
}
