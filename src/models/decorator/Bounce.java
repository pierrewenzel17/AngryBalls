package models.decorator;

import models.Form;

public final class Bounce extends DecoratorForm {

    public Bounce(Form decoratedFrom) {
        super(decoratedFrom);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {

    }
}
