package com.ufr.mim.angryballs.utils;

import com.ufr.mim.angryballs.models.Ball;

import java.util.Collection;
import java.util.List;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;
/**
 * Utilitaire statique de bille
 * Dans cette classe sont écrite les fonctions et méthodes d'opération sur les billes
 */
public final class BallsUtil {
    /**
     * Constructeur qui empêche une mauvaise utilisation de la classe (instantiation)
     */
    private BallsUtil() { throw new IllegalAccessError("not instantiable"); }
    /**
     * Fonction qui enlève une bille d'une collection
     * @param ball : la bille à enlever
     * @param balls : la liste de billes
     * @return un copie de la {@link Collection balls} sans {@link Ball ball}
     */
    public static Collection<Ball> otherBalls(final Ball ball, final Collection<Ball> balls) {
        return List.copyOf(balls).stream().filter(not(ball::equals)).collect(toList());
    }
    /**
     * Fonction qui vérifie une collection
     * @param ball : la bille courante sur laquelle on travail,
     *             cette bille peut-être dans {@link Collection balls}
     * @param balls : la liste de toutes les billes
     * @return {@code true} si {@link Ball ball} est en collision
     * avec une bille de {@link Collection balls} sinon retourne {@code false}
     */
    public static boolean isInCollisionWithABall(final Ball ball, final Collection<Ball> balls) {
        return otherBalls(ball, balls).stream().anyMatch(ball::isInCollision);
    }
}