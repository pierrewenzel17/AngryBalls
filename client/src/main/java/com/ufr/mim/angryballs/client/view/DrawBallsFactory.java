package com.ufr.mim.angryballs.client.view;

import com.ufr.mim.angryballs.client.model.SimpleBallDTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Factory qui s'occupe du dessin
 * @param <G> est une figure qui représente une bille.
 * @see <a href="https://fr.wikipedia.org/wiki/Fabrique_abstraite">Abstract Factory Design Pattern</a>
 * @see DrawBallsWithFx
 */
public abstract class DrawBallsFactory<G> {

    protected final Map<Integer, G> ballsMap = new HashMap<>();

    /**
     * Constructeur
     * @param balls la liste des billes à mapper
     * @param transformer méthode renvoie la forme de dessin
     */
    protected DrawBallsFactory(Collection<SimpleBallDTO> balls, Function<SimpleBallDTO, G> transformer) {
        balls.forEach(ball -> ballsMap.put(ball.hashCode(), transformer.apply(ball)));
    }
    /**
     * Fonction qui retourne la forme de dessin
     * @param ball la bille dont on veut le dessin
     * @return la forme de dessin
     */
    public G getShape(SimpleBallDTO ball) { return ballsMap.get(ball.hashCode()); }
}
