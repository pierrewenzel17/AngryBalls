package models.decorator;

import models.Form;

public final class Gravity extends DecoratorForm {
    public Gravity(Form decoratedFrom) {
        super(decoratedFrom);
    }
}
