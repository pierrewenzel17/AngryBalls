package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.models.StateClic;
import com.ufr.mim.angryballs.utils.BallsUtil;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

import java.util.Collection;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.ArrayUtils.toPrimitive;

public final class Pilot extends BallOption {

    private StateClic stateClic;
    private Vecteur clickPosition;

    public Pilot(final Ball ball) {
        super(ball);
        stateClic = null;
        clickPosition = new Vecteur(0,0);
    }

    public Vecteur getClickPosition() {
        return clickPosition;
    }

    public void setClickPosition(Vecteur clickPosition) {
        this.clickPosition = clickPosition;
    }

    public StateClic getState() {
        return stateClic;
    }

    public void setState(StateClic stateClic) {
        this.stateClic = stateClic;
    }

    @Override
    public void manageAcceleration(Collection<Ball> balls) {
        super.manageAcceleration(balls);
        this.getAcceleration().ajoute(accelerate(balls));
    }

    /**
     * Fonction qui calcul une accélération dû au mouvement de la sourie
     * <p>C'est-à-dire que {@code this} subit l'attraction gravitationnelle due à la sourie</p>
     * <p>Le calcul est effectué dans {@link MecaniquePoint}</p>
     * @param balls la liste de toute les billes en mouvement. La liste peut contenir {@code this}
     * @return le {@link Vecteur} d'accélération résultant
     */
    private Vecteur accelerate(Collection<Ball> balls) {
        var ballCopy = BallsUtil.otherBalls(this, balls);
        var masses = ballCopy.stream().map(Ball::getMass).collect(toList());
        var positions = ballCopy.stream().map(Ball::getPosition).collect(toList());
        System.out.println(this.clickPosition);
        return MecaniquePoint.champGravitéGlobal(this.clickPosition, toPrimitive(masses.toArray(Double[]::new)), positions.toArray(Vecteur[]::new));
    }

    /*StateClic state = new StateClic.Play();
    state.run(this);*/
}
