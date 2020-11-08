package com.ufr.mim.angryballs.decoratorForm;

import com.ufr.mim.angryballs.models.Form;

public final class AirFriction extends DecoratorForm {

    public AirFriction(Form decoratedFrom) {
        super(decoratedFrom);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {

    }
}
