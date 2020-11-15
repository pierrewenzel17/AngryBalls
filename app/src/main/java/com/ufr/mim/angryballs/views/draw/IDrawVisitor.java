package com.ufr.mim.angryballs.views.draw;

import com.ufr.mim.angryballs.models.Ball;

/**
 * Visiteur qui s'occupe du dessin
 * @param <G> class graphique que l'ont utilise pour attacher un dessin
 * comme {@link java.awt.Graphics} en Awt, {@link javafx.scene.Group} en JavaFx, etc.
 * @see <a href="https://fr.wikipedia.org/wiki/Visiteur_(patron_de_conception)">Visitor Design Pattern</a>
 */
@FunctionalInterface
public interface IDrawVisitor<G> {
    /**
     * Fonction de dessin
     * @param ball : la bille que l'ont veut dessiner
     * @param graphic : le graphique à modifier sur lequel on ajoute le dessin
     */
    void draw(final Ball ball, G graphic);
}
