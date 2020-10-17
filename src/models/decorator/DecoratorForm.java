package models.decorator;
import mesmaths.geometrie.base.Vecteur;
import models.enums.ColorForm;
import models.Form;


public abstract class DecoratorForm extends Form {

    protected Form _decoratedFrom;

    public DecoratorForm(Form decoratedFrom) {
        this._decoratedFrom = decoratedFrom;
    }

    @Override
    public double getRadius() {
        return this._decoratedFrom.getRadius();
    }

    @Override
    public ColorForm getColor() {
        return this._decoratedFrom.getColor();
    }

    @Override
    public Vecteur getPosition() {
        return this._decoratedFrom.getPosition();
    }

    @Override
    public Vecteur getSpeed() {
        return this._decoratedFrom.getSpeed();
    }

    @Override
    public Vecteur getAcceleration() {
        return this._decoratedFrom.getAcceleration();
    }

    @Override
    public double mass() {
        return this._decoratedFrom.mass();
    }
}
