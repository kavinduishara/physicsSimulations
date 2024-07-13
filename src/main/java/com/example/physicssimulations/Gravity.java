package com.example.physicssimulations;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Gravity {
    private AnchorPane box;
    private Circle circle;
    private double velocityX;
    private double velocityY;
    private double r;
    private double x;
    private double y;

    Gravity (AnchorPane box,double r,double x,double y, double velocityX, double velocityY) {
        Circle circle=new Circle(x,y,r);
        this.circle=circle;
        circle.setFill(Color.rgb((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
        this.box = box;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        box.getChildren().add(circle);
        this.x=x;
        this.y=y;
    }
    protected void moveCircle() {
        circle.setLayoutX(circle.getLayoutX() + velocityX);
        circle.setLayoutY(circle.getLayoutY() + velocityY);
    }
}
