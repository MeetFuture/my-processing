package com.tangqiang;

import processing.core.PApplet;
import processing.core.PVector;

/**
 *  小弹球
 *
 * @author Tom
 * @version 1.0 2018-02-01 0001 Tom create
 * @date 2018-02-01 0001
 * @copyright Copyright © 2018 Grgbanking All rights reserved.
 */
public class ProcessingTest3 extends PApplet {
    private PVector location;
    private PVector velocity;

    public static void main(String[] args) {
        main(ProcessingTest3.class);
    }

    @Override
    public void settings() {
        size(800, 600);
        location = new PVector(100, 100);
        velocity = new PVector(0.5f, 0.5f);
    }

    @Override
    public void draw() {
        background(255);
        location.add(velocity);

        if ((location.x > width) || (location.x < 0)) {
            velocity.x *= -1;
        }

        if ((location.y > height) || (location.y < 0)) {
            velocity.y *= -1;
        }


        stroke(0);
        fill(175);
        ellipse(location.x, location.y, 16, 16);
    }

}
