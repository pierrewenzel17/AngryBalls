package models.decorator;

import models.Form;

public final class Pilot extends DecoratorForm {
    public Pilot(Form decoratedFrom) {
        super(decoratedFrom);
    }
}
