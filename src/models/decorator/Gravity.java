package models.decorator;

import models.Form;

public final class Gravity extends DecoratorForm {

    public Gravity(Form decoratedFrom) {
        super(decoratedFrom);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {

    }
}
