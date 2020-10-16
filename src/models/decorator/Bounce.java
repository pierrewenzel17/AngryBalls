package models.decorator;

import models.Form;

public final class Bounce extends DecoratorForm {
    public Bounce(Form decoratedFrom) {
        super(decoratedFrom);
    }
}
