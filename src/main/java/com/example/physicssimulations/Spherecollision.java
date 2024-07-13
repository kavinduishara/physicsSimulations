package com.example.physicssimulations;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Spherecollision implements Initializable {
    @FXML
    protected Circle sphere1;
    @FXML
    protected Circle sphere2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final double[] velx1 = {1};
        final double[] vely1 = {1};
        final double[] velx2 = {-1};
        final double[] vely2 = {1};
        double mass1 = 1;
        double mass2 = 1;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000 / 60.0), e -> { // Adjusting to 60 FPS

            double x1 = sphere1.getLayoutX();
            double y1 = sphere1.getLayoutY();
            double x2 = sphere2.getLayoutX();
            double y2 = sphere2.getLayoutY();



            if (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) <= sphere1.getRadius() + sphere2.getRadius()) {
                double collisionAngle=Math.atan2((y2-y1),(x2-x1));
                double inline1=vely1[0]*Math.sin(collisionAngle)+velx1[0]*Math.cos(collisionAngle);
                double inline2=vely2[0]*Math.sin(collisionAngle)+velx2[0]*Math.cos(collisionAngle);
                double tanline1=vely1[0]*Math.cos(collisionAngle)-velx1[0]*Math.sin(collisionAngle);
                double tanline2=vely2[0]*Math.cos(collisionAngle)-velx2[0]*Math.sin(collisionAngle);
                // Collision response calculations
                double newx1vel = ((mass1 - mass2) * inline1) / (mass1 + mass2) + ((2 * mass2 * inline2) / (mass1 + mass2));
                double newx2vel = ((mass2 - mass1) * inline2) / (mass1 + mass2) + ((2 * mass1 * inline1) / (mass1 + mass2));

                velx1[0] = newx1vel*Math.cos(collisionAngle)-tanline1*Math.sin(collisionAngle);
                vely1[0] = newx1vel*Math.sin(collisionAngle)+tanline1*Math.cos(collisionAngle);
                velx2[0] = newx2vel*Math.cos(collisionAngle)-tanline2*Math.sin(collisionAngle);
                vely2[0] = newx2vel*Math.sin(collisionAngle)+tanline2*Math.cos(collisionAngle);

            }
            sphere1.setLayoutX(x1 + velx1[0]);
            sphere1.setLayoutY(y1 + vely1[0]);
            sphere2.setLayoutX(x2 + velx2[0]);
            sphere2.setLayoutY(y2 + vely2[0]);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
