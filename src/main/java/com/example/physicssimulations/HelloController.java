package com.example.physicssimulations;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    protected Rectangle rect1;
    @FXML
    protected Rectangle rect2;
    @FXML
    protected Label impact;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        double[] rect1vel = {-1};  // Initial velocity of rect1
        double[] rect2vel = {0};  // Initial velocity of rect2
        int rect2mass = 1;        // Mass of rect1
        int rect1mass = 10000000;        // Mass of rect2
        int[] impacts = {0};
        final boolean[] gone = {false};

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {

            rect1.setLayoutX(rect1.getLayoutX() + rect1vel[0]);
            rect2.setLayoutX(rect2.getLayoutX() + rect2vel[0]);

            if (rect1.getLayoutX()<=rect2.getLayoutX()+rect1.getWidth()) {
                double newRect2Vel = (2 * rect1mass * rect1vel[0]) / (rect1mass + rect2mass) + ((rect2mass - rect1mass) * rect2vel[0] / (rect1mass + rect2mass));
                double newRect1Vel = ((rect1mass - rect2mass) * rect1vel[0]) / (rect1mass + rect2mass) + ((2 * rect2mass * rect2vel[0]) / (rect1mass + rect2mass));

                rect2vel[0] = newRect2Vel;
                rect1vel[0] = newRect1Vel;
                impacts[0]++;
                impact.setText(Arrays.toString(impacts));

            }
            if (rect2.getLayoutX()<=0){
                rect2vel[0]=-rect2vel[0];
                impacts[0]++;
            }
            if(rect1vel[0]>=Math.abs(rect2vel[0]) && !gone[0]){
                System.out.println("gone");
                System.out.println(rect1vel[0]);
                System.out.println(rect2vel[0]);
                gone[0] =true;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }
}
