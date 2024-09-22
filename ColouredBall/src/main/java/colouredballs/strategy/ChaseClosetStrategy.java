package colouredballs.strategy;

import colouredballs.model.Ball;
import colouredballs.model.BallPit;

public class ChaseClosetStrategy implements MovingStrategy {

    @Override
    public void movingAction(Ball ball, BallPit ballPit, Double frameDuration) {
        Ball furthestBall = ballPit.getClosestBall(ball);
        double accelX = ((furthestBall.getxPos() - ball.getxPos()) / ballPit.euclideanDistance(ball,furthestBall)) * frameDuration;
        double accelY = ((furthestBall.getyPos() - ball.getyPos()) / ballPit.euclideanDistance(ball,furthestBall)) * frameDuration;
        ball.setxVel(ball.getxVel() + accelX);
        ball.setyVel(ball.getyVel() + accelY);
    }
}
