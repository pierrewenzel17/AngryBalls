package com.ufr.mim.angryballs.views.draw;

import com.ufr.mim.angryballs.models.Ball;

public interface IDrawVisitor<GRAPHIC> {
    void draw(final Ball ball, GRAPHIC graphic);
}
