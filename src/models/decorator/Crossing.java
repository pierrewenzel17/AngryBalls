package models.decorator;

import models.Form;

public final class Crossing extends DecoratorForm {
    public Crossing(Form decoratedFrom) {
        super(decoratedFrom);
    }
}
