package colouredballs.model;

import colouredballs.state.ConcreteBlackBallState;
import colouredballs.state.ConcreteBlueBallState;
import colouredballs.state.ConcreteRedBallState;
import colouredballs.state.State;
import colouredballs.strategy.MovingStrategy;
import javafx.scene.paint.Paint;

import java.util.Random;

public class Ball {
    private double xPos;
    private double yPos;
    private double radius;
    private double xVel;
    private double yVel;
    private Paint colour;
    private ConcreteBlackBallState blackState;
    private ConcreteBlueBallState blueState;
    private ConcreteRedBallState redState;
    private State stateNow;
    private MovingStrategy strategy;

    Ball(double startX, double startY, double startRadius, Paint colour, MovingStrategy movingStrategy) {
        redState = new ConcreteRedBallState(this);
        blackState = new ConcreteBlackBallState(this);
        blueState = new ConcreteBlueBallState(this);
        stateNow = redState;
        this.xPos = startX;
        this.yPos = startY;
        this.radius = startRadius;
        this.colour = colour;
        xVel = new Random().nextInt(5);
        yVel = new Random().nextInt(5);
        this.strategy = movingStrategy;
    }

    void tick() {
        xPos += xVel;
        yPos += yVel;
    }

    public void setxVel(double xVel) {
        this.xVel = xVel;
    }

    public void setyVel(double yVel) {
        this.yVel = yVel;
    }

    public double getRadius() {
        return radius;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public Paint getColour() {
        return colour;
    }

    public double getxVel() {
        return xVel;
    }

    public double getyVel() {
        return yVel;
    }

    void setxPos(double xPos) {
        this.xPos = xPos;
    }

    void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public void setState(State state) {
        this.stateNow = state;
    }


    public void setColour(Paint colour) {
        this.colour = colour;
    }

    public void updateStrategy(MovingStrategy strategy) {
        this.strategy = strategy;
    }

    public void colisionAction() {
        stateNow.coliding();
    }


    void think(Ball ball, BallPit ballPit, Double durationFrame) {
        this.strategy.movingAction(ball, ballPit, durationFrame);
        // Here is where the strategy should have some effect.
        // You can add parameters to the think method so the ball knows something about its
        // world to make decisions with, or you can inject things upon construction for it to query
    }
}
