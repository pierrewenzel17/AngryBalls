package decoratorForm;

import models.Form;

public final class Crossing extends DecoratorForm {

    public Crossing(Form decoratedFrom) {
        super(decoratedFrom);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {

    }
}
