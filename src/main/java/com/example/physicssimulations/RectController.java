package com.example.physicssimulations;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class RectController {
    private AnchorPane box;
    private Rectangle rect;
    private double velocityX;
    private double velocityY;

    RectController(AnchorPane box, Rectangle rect, double velocityX, double velocityY) {
        this.box = box;
        this.rect = rect;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        box.getChildren().add(rect);
    }

    protected void moveRect() {
        rect.setLayoutX(rect.getLayoutX() + velocityX);
        rect.setLayoutY(rect.getLayoutY() + velocityY);
    }

    protected void bounceBack() {
        if (rect.getLayoutX() <= 0 || rect.getLayoutX() + rect.getWidth() >= box.getWidth()) {
            velocityX = -velocityX;
        }
        if (rect.getLayoutY() <= 0 || rect.getLayoutY() + rect.getHeight() >= box.getHeight()) {
            velocityY = -velocityY;
        }
    }
}
