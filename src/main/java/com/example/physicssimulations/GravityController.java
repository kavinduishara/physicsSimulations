package com.example.physicssimulations;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GravityController implements Initializable {
    @FXML
    protected Label v1;
    @FXML
    protected Label v2;
    @FXML
    protected Label r;
    @FXML
    protected AnchorPane box;
    @FXML
    protected Circle circle1;
    @FXML
    protected Circle circle2;
    private double velocityX1;
    private double velocityX2;
    private double velocityY1=0;
    private double velocityY2=Math.sqrt((double) 1000 /200);
    private double mass1=1;
    private double mass2=0.0000000000001;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        box.setBackground(Background.fill(Color.rgb(240,240,240)));
        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(10), e->{
            double x=circle1.getLayoutX();
            double y=circle1.getLayoutY();
            double x1=circle2.getLayoutX();
            double y1=circle2.getLayoutY();
            if((Math.abs(x-x1)< circle1.getRadius()&&Math.abs(y-y1)<circle1.getRadius())){
                circle1.setLayoutX(x + velocityX1);
                circle1.setLayoutY(y + velocityY1);
                circle2.setLayoutX(x1 + velocityX2);
                circle2.setLayoutY(y1 + velocityY2);
                return;
            }
            double rSquared=Math.pow(x-x1,2)+Math.pow(y-y1,2);
            double f=1000*mass1*mass2/rSquared;

            double ax=f*Math.cos(Math.atan(Math.abs((y-y1)/(x-x1))));
            if(x>x1){
                ax=ax*-1;
            }
            velocityX1=velocityX1+ax/mass1;
            velocityX2=velocityX2-ax/mass2;
            double ay=f*Math.sin(Math.atan(Math.abs((y-y1)/(x-x1))));
            if(y>y1){
                ay=ay*-1;
            }

            velocityY1=velocityY1+ay/mass1;
            velocityY2=velocityY2-ay/mass2;


            circle1.setLayoutX(x + velocityX1);
            circle1.setLayoutY(y + velocityY1);
            circle2.setLayoutX(x1 + velocityX2);
            circle2.setLayoutY(y1 + velocityY2);

            v1.setText(String.valueOf(Math.sqrt(Math.abs(velocityX1*velocityX1+velocityY1*velocityY1))));
            v2.setText(String.valueOf(Math.sqrt(Math.abs(velocityX2*velocityX2+velocityY2*velocityY2))));
            r.setText(String.valueOf(Math.sqrt(Math.abs(rSquared))));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
