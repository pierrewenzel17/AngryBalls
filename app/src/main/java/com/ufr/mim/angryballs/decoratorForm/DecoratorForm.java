package com.ufr.mim.angryballs.decoratorForm;

import com.ufr.mim.angryballs.models.Form;
import com.ufr.mim.angryballs.models.enums.ColorForm;
import com.ufr.mim.angryballs.views.draw.DrawVisitor;
import mesmaths.geometrie.base.Vecteur;

public abstract class DecoratorForm extends Form {

    protected Form decoratedForm;

    protected DecoratorForm(Form decoratedForm) {
        this.decoratedForm = decoratedForm;
    }

    @Override
    public double getRadius() {
        return this.decoratedForm.getRadius();
    }

    @Override
    public ColorForm getColor() {
        return this.decoratedForm.getColor();
    }

    @Override
    public Vecteur getPosition() {
        return this.decoratedForm.getPosition();
    }

    @Override
    public Vecteur getSpeed() {
        return this.decoratedForm.getSpeed();
    }

    @Override
    public Vecteur getAcceleration() {
        return this.decoratedForm.getAcceleration();
    }

    @Override
    public double mass() {
        return this.decoratedForm.mass();
    }

    @Override
    public <GRAPHIC> void draw(DrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g) {
        this.decoratedForm.draw(drawVisitor, g);
    }
}
