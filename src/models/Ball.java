package models;

import models.enums.ColorForm;
import views.draw.DrawVisitor;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

import java.lang.String;
import java.util.Objects;

/**
 * Class qui représente une bille
 */
public class Ball extends Form {

    private final double radius; // /!\ le final dois être enlever en cas de setter
    private final ColorForm color;
    private final Vecteur position;
    private final Vecteur speed;
    private final Vecteur acceleration;

    public static final double DENSITY = 1;

    public Ball(double radius, ColorForm color, final Vecteur position, final Vecteur speed,
                final Vecteur acceleration) {
        this.radius = radius;
        this.color = color;
        this.position = position;
        this.speed = speed;
        this.acceleration = acceleration;
    }

    public Ball(double radius, ColorForm color) {
        this(radius, color, new Vecteur(), new Vecteur(), new Vecteur());
    }

    @Override
    public double getRadius() {
        return this.radius;
    }

    @Override
    public ColorForm getColor() {
        return this.color;
    }

    @Override
    public Vecteur getPosition() {
        return this.position;
    }

    @Override
    public Vecteur getSpeed() {
        return this.speed;
    }

    @Override
    public Vecteur getAcceleration() {
        return this.acceleration;
    }

    @Override
    public double mass() {
        return DENSITY * Geop.volumeSphère(radius);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.radius, radius) == 0 &&
                ball.color == color &&
                position.equals(ball.position) &&
                speed.equals(ball.speed) &&
                acceleration.equals(ball.acceleration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, color, position, speed, acceleration);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "radius=" + radius +
                ", colorForm=" + color +
                ", position=" + position +
                ", speed=" + speed +
                ", acceleration=" + acceleration +
                '}';
    }

    @Override
    public <GRAPHIC> void draw(final DrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g) {
        drawVisitor.draw(this, g);
    }
}
