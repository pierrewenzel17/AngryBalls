package models.decorator;

import models.Form;

public final class Blocked extends DecoratorForm {
    public Blocked(Form decoratedFrom) {
        super(decoratedFrom);
    }
}
