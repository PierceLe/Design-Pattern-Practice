package colouredballs.state;
import colouredballs.model.Ball;
import javafx.scene.paint.Paint;

public class ConcreteBlackBallState implements State {
    private Ball ball;

    public ConcreteBlackBallState(Ball ball) {
        this.ball = ball;
    }

    public Ball getBalL() {
        return ball;
    }

    public void setBalL(Ball ball) {
        this.ball = ball;
    }

    public void coliding() {
        Paint redColor = Paint.valueOf("red");
        ball.setColour(redColor);
        ball.setState(new ConcreteRedBallState(ball));
    }
}
