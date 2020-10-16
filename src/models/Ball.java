package models;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import models.enums.Color;

import java.util.Objects;

/**
 * Class qui représente une bille
 */
public class Ball extends Form {

    private final double _radius; // /!\ le final dois être enlever en cas de setter
    private final Color _color;
    private final Vecteur _position;
    private final Vecteur _speed;
    private final Vecteur _acceleration;

    public static final double DENSITY = 1;

    public Ball(double _radius, Color _color, Vecteur _position, Vecteur _speed, Vecteur _acceleration) {
        this._radius = _radius;
        this._color = _color;
        this._position = _position;
        this._speed = _speed;
        this._acceleration = _acceleration;
    }

    public Ball(double _radius, Color _color) {
        this(_radius, _color, new Vecteur(), new Vecteur(), new Vecteur());
    }

    @Override
    public double getRadius() {
        return this._radius;
    }

    @Override
    public Color getColor() {
        return this._color;
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
                _color.equals(ball._color) &&
                _position.equals(ball._position) &&
                _speed.equals(ball._speed) &&
                _acceleration.equals(ball._acceleration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_radius, _color, _position, _speed, _acceleration);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "_radius=" + _radius +
                ", _color=" + _color +
                ", _position=" + _position +
                ", _speed=" + _speed +
                ", _acceleration=" + _acceleration +
                '}';
    }
}
