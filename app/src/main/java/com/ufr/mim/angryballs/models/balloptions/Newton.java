package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.utils.BallsUtil;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

import java.util.Collection;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.ArrayUtils.toPrimitive;

/**
 * Classe qui muni une bille d'une attraction par les autres billes
 * (attraction universelle due à la force de Newton)
 */
public final class Newton extends BallOption {

    public Newton(final Ball ball) {
        super(ball);
    }

    @Override
    public void manageAcceleration(final Collection<Ball> balls) {
        super.manageAcceleration(balls);
        getAcceleration().ajoute(accelerate(balls));
    }

    /**
     * Fonction qui calcul une accélération de Newton grace au champ de gravité global
     * <p>C'est-à-dire que {@code this} subit l'attraction gravitationnelle due aux
     * billes contenues dans {@link Collection balls}</p>
     * <p>Le calcul est effectué dans {@link MecaniquePoint}</p>
     * @param balls la liste de toute les billes en mouvement. La liste peut contenir {@code this}
     * @return le {@link Vecteur} d'accélération résultant
     */
    private Vecteur accelerate(Collection<Ball> balls) {
        var ballCopy = BallsUtil.otherBalls(this, balls);
        var masses = ballCopy.stream().map(Ball::getMass).collect(toList());
        var positions = ballCopy.stream().map(Ball::getPosition).collect(toList());
        return MecaniquePoint.champGravitéGlobal(this.getPosition(), toPrimitive(masses.toArray(Double[]::new)), positions.toArray(Vecteur[]::new));
    }

    @Override
    public String toString() {
        return "Newton{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
