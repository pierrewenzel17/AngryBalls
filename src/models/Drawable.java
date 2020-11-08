package models;

import views.draw.DrawVisitor;

interface Drawable {
    <GRAPHIC> void draw(final DrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g);
}
