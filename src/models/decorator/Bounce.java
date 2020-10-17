package models.decorator;

import mesmaths.cinematique.Collisions;
import models.Form;

/**
 * Cette class permet de rajouté un comportement de rebond a une form.
 */
public final class Bounce extends DecoratorForm {

    public Bounce(Form decoratedFrom) {
        super(decoratedFrom);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRadius(),
                this.getSpeed(), xAxis, yAxis, width, height);

    }

    @Override
    public String toString() {
        return "Bounce{" + this._decoratedFrom + "}";
    }
}
