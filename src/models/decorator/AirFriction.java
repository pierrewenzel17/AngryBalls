package models.decorator;

import models.Form;

public final class AirFriction extends DecoratorForm {

    public AirFriction(Form decoratedFrom) {
        super(decoratedFrom);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {

    }
}
