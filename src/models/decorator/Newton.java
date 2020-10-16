package models.decorator;

import models.Form;

public final class Newton extends DecoratorForm {

    public Newton(Form decoratedFrom) {
        super(decoratedFrom);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {

    }
}
