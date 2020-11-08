package com.ufr.mim.angryballs.decoratorForm;

import com.ufr.mim.angryballs.models.Form;

public final class Newton extends DecoratorForm {

    public Newton(Form decoratedFrom) {
        super(decoratedFrom);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {

    }
}
