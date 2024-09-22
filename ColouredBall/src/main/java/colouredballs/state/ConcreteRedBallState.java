package colouredballs.state;

import colouredballs.model.Ball;
import javafx.scene.paint.Paint;

public class ConcreteRedBallState implements State{
    private Ball ball;

    public ConcreteRedBallState(Ball ball) {
        this.ball = ball;
    }

    public Ball getBalL() {
        return ball;
    }

    public void setBalL(Ball ball) {
        this.ball = ball;
    }

    public void coliding() {
        Paint redColor = Paint.valueOf("blue");
        ball.setColour(redColor);
        ball.setState(new ConcreteBlueBallState(ball));
    }

}
