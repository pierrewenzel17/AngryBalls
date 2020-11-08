package views.draw;

import javafx.scene.Group;
import models.Ball;

public final class DrawFx extends DrawVisitor<Group> {

    public DrawFx() {
    }

    @Override
    public void draw(final Ball ball, Group group) {
        //TODO Sebastien
        System.out.println(ball.toString());
    }
}
