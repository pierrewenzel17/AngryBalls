package models.decorator;

import models.Form;

public final class UniformRectilinear extends DecoratorForm {

    public UniformRectilinear(Form decoratedFrom) {
        super(decoratedFrom);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {

    }

    @Override
    public String toString() {
        return "UniformRectilinear{" + this._decoratedFrom + "}";
    }
}
