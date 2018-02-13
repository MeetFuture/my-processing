package com.tangqiang;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * 对象
 *
 * @author Tom
 * @version 1.0 2018-02-01 0001 Tom create
 * @date 2018-02-01 0001
 * @copyright Copyright © 2018 Grgbanking All rights reserved.
 */
public class ProcessingTestMover extends PApplet {
    private int count = 40;
    private float fps = 60;
    private BallMover[] movers = new BallMover[count];

    public static void main(String[] args) {
        main(ProcessingTestMover.class);
    }

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        frameRate(fps);
        stroke(0xFF3A6EAB);
        fill(0xFF3A6EAB);

        for (int i = 0; i < count; i++) {
            movers[i] = new BallMover(this);
        }
    }

    @Override
    public void draw() {
        background(0xC7EDCC);

        for (BallMover mover : movers) {
            mover.update();
            mover.display();
            smooth();
        }
    }


    private class BallMover {
        float spleed = 8;
        float accel = 0.2f;

        private PApplet applet;
        private PVector location;
        private PVector velocity;
        private PVector acceleration;


        public BallMover(PApplet applet) {
            this.applet = applet;

            location = new PVector(applet.width / 2, applet.height / 2);
            velocity = PVector.random2D();
            velocity.normalize();
            velocity.mult(spleed);
        }

        public void update() {
            PVector mouse = new PVector(applet.mouseX, applet.mouseY);
            PVector dir = PVector.sub(mouse, location);
            dir.normalize();
            acceleration = dir.mult(accel);

            velocity.add(acceleration);
            velocity.limit(spleed);

            location.add(velocity);
            checkEdges();
        }

        public void display() {
            applet.ellipse(location.x, location.y, 4, 4);
        }

        private void checkEdges() {
            if (location.x > applet.width) {
                location.x = applet.width;
                velocity.x = velocity.x * -1;
            } else if (location.x < 0) {
                location.x = 0;
                velocity.x = velocity.x * -1;
            }
            if (location.y > applet.height) {
                location.y = applet.height;
                velocity.y = velocity.y * -1;
            } else if (location.y < 0) {
                location.y = 0;
                velocity.y = velocity.y * -1;
            }
        }
    }
}
