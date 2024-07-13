package com.example.physicssimulations;

public class Main {
    public static void main(String[] args) {
        double[] rect1vel = {-1};  // Initial velocity of rect1
        double[] rect2vel = {0};  // Initial velocity of rect2
        double rect2mass = 1;        // Mass of rect2
        double rect1mass = 1;       // Mass of rect1
        int[] impacts = {0};

        while (rect1vel[0] - rect2vel[0]<0) {
            double tempRect1Vel = rect1vel[0];
            double tempRect2Vel = rect2vel[0];

            double newRect2Vel = (2 * rect1mass * tempRect1Vel) / (rect1mass + rect2mass) + ((rect2mass - rect1mass) * tempRect2Vel / (rect1mass + rect2mass));
            double newRect1Vel = ((rect1mass - rect2mass) * tempRect1Vel) / (rect1mass + rect2mass) + ((2 * rect2mass * tempRect2Vel) / (rect1mass + rect2mass));
            if(newRect2Vel<0){
                impacts[0]++;
            }

            rect2vel[0] = Math.abs(newRect2Vel);
            rect1vel[0] = newRect1Vel;
            impacts[0]++;
        }

        System.out.println(impacts[0]);
        System.out.println((int) (Math.random()*255));
    }
}
