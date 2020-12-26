package com.ufr.mim.angryballs.models;

import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

import java.util.Collection;
import java.util.Objects;

/**
 * Class qui représente une bille simple
 */
public final class SimpleBall implements Ball {

    private final double radius;
    private final double density;
    private final Color color;
    private final Vecteur position;
    private final Vecteur speed;
    private final Vecteur acceleration;

    public SimpleBall(double radius, double density, Color color, Vecteur position, Vecteur speed, Vecteur acceleration) {
        this.radius = radius;
        this.density = density;
        this.color = color;
        this.position = position;
        this.speed = speed;
        this.acceleration = acceleration;
    }

    public SimpleBall(double radius, double density, Color color, Vecteur position, Vecteur speed) {
        this(radius,density,color,position,speed,new Vecteur());
    }

    public SimpleBall(double radius, double density, Color color) {
        this(radius, density, color, new Vecteur(), new Vecteur(), new Vecteur());
    }

    public SimpleBall(double radius, Color color) { this(radius, 1, color); }

    @Override
    public double getRadius() {
        return this.radius;
    }

    @Override
    public double getDensity() { return this.density; }

    @Override
    public Color getColor() {
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
    public double getMass() {
        return density * Geop.volumeSphère(radius);
    }

    @Override
    public void move(double deltaT) {
        Cinematique.mouvementUniformémentAccéléré( this.getPosition(), this.getSpeed(), this.getAcceleration(), deltaT);
    }

    @Override
    public void manageCollision(double xAxis, double yAxis, double width, double height) {
        Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRadius(),
                this.getSpeed(), xAxis, yAxis, width, height);
    }

    @Override
    public void manageAcceleration(final Collection<Ball> balls) { this.getAcceleration().set(Vecteur.VECTEURNUL); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleBall)) return false;
        SimpleBall ball = (SimpleBall) o;
        return Double.compare(ball.getRadius(), getRadius()) == 0 &&
                Double.compare(ball.getDensity(), getDensity()) == 0 &&
                getColor() == ball.getColor() &&
                getPosition().equals(ball.getPosition()) &&
                getSpeed().equals(ball.getSpeed()) &&
                getAcceleration().equals(ball.getAcceleration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius(), getDensity(), getColor(), getPosition(), getSpeed(), getAcceleration());
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
}
