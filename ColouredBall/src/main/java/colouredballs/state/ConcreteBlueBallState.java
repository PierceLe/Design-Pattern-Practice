package colouredballs.state;

import colouredballs.model.Ball;
import javafx.scene.paint.Paint;

public class ConcreteBlueBallState implements State {
    private Ball ball;

    public ConcreteBlueBallState(Ball ball) {
        this.ball = ball;
    }

    public Ball getBalL() {
        return ball;
    }

    public void setBalL(Ball ball) {
        this.ball = ball;
    }

    public void coliding() {
        Paint redColor = Paint.valueOf("black");
        ball.setColour(redColor);
        ball.setState(new ConcreteBlackBallState(ball));
    }
}
