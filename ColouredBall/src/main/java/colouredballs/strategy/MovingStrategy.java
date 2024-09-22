package colouredballs.strategy;

import colouredballs.model.Ball;
import colouredballs.model.BallPit;

public interface MovingStrategy {
    public void movingAction(Ball ball, BallPit ballPit, Double frameDuration);
}
