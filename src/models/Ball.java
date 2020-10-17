package models;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import models.enums.ColorForm;

import java.util.Objects;

/**
 * Class qui représente une bille
 */
public class Ball extends Form {

    private final double _radius; // /!\ le final dois être enlever en cas de setter
    private final ColorForm _colorForm;
    private final Vecteur _position;
    private final Vecteur _speed;
    private final Vecteur _acceleration;

    public static final double DENSITY = 1;

    public Ball(double _radius, ColorForm _colorForm, Vecteur _position, Vecteur _speed, Vecteur _acceleration) {
        this._radius = _radius;
        this._colorForm = _colorForm;
        this._position = _position;
        this._speed = _speed;
        this._acceleration = _acceleration;
    }

    public Ball(double _radius, ColorForm _colorForm) {
        this(_radius, _colorForm, new Vecteur(), new Vecteur(), new Vecteur());
    }

    @Override
    public double getRadius() {
        return this._radius;
    }

    @Override
    public ColorForm getColor() {
        return this._colorForm;
    }

    @Override
    public Vecteur getPosition() {
        return this._position;
    }

    @Override
    public Vecteur getSpeed() {
        return this._speed;
    }

    @Override
    public Vecteur getAcceleration() {
        return this._acceleration;
    }

    @Override
    public double mass() {
        return DENSITY * Geop.volumeSphère(_radius);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball._radius, _radius) == 0 &&
                _colorForm.equals(ball._colorForm) &&
                _position.equals(ball._position) &&
                _speed.equals(ball._speed) &&
                _acceleration.equals(ball._acceleration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_radius, _colorForm, _position, _speed, _acceleration);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "_radius=" + _radius +
                ", _color=" + _colorForm +
                ", _position=" + _position +
                ", _speed=" + _speed +
                ", _acceleration=" + _acceleration +
                '}';
    }
}
