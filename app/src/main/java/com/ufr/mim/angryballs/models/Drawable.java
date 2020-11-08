package com.ufr.mim.angryballs.models;

import com.ufr.mim.angryballs.views.draw.DrawVisitor;

@FunctionalInterface
interface Drawable {
    <GRAPHIC> void draw(final DrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g);
}
