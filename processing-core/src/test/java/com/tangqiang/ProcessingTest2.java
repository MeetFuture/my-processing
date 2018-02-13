package com.tangqiang;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * 测试 Processing 2
 *
 * @author Tom
 * @version 1.0 2018-02-01 0001 Tom create
 * @date 2018-02-01 0001
 * @copyright Copyright © 2018 Grgbanking All rights reserved.
 */
public class ProcessingTest2 extends PApplet {

    public static void main(String[] args) {
        main(ProcessingTest2.class);
    }


    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void draw() {

        background(0xFFEE31);
        pushMatrix();
        translate(200, 200 - 60);

        PVector mouse = new PVector(mouseX, mouseY);
        mouse.sub(200, 200 - 60, 0);
        mouse.limit(7);
        fill(0);
        noStroke();
        rectMode(CENTER);
        rect(-1 * 40 + mouse.x, -15 + mouse.y, 15, 25, 8);

        if (mousePressed) {
            rect(40 + mouse.x, -15 + mouse.y, 28, 10, 5);
        } else {
            rect(40 + mouse.x, -15 + mouse.y, 15, 25, 8);
        }

        //mouth
        noFill();
        strokeWeight(12);
        stroke(0);
        arc(0, 0, 150, 120, PI / 4, PI - PI / 4);
        popMatrix();


        //text
        textSize(25);
        textAlign(CENTER);
        text("Enjoy your hacking with\nProcessing!", width / 2, height / 2 + 100);
    }

}
