package com.tangqiang;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * 向量
 *
 * @author Tom
 * @version 1.0 2018-02-01 0001 Tom create
 * @date 2018-02-01 0001
 * @copyright Copyright © 2018 Grgbanking All rights reserved.
 */
public class ProcessingTestVector extends PApplet {

    public static void main(String[] args) {
        main(ProcessingTestVector.class);
    }

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void draw() {
        testNormalize();
    }


    private void testSub(){
        background(255);
        PVector mouse = new PVector(mouseX, mouseY);
        PVector center = new PVector(width / 2, height / 2);

        // PVector subtraction!
        mouse.sub(center);
        translate(width / 2, height / 2);
        line(0, 0, mouse.x, mouse.y);
    }


    private void testMult(){
        background(255);
        PVector mouse = new PVector(mouseX,mouseY);
        PVector center = new PVector(width/2,height/2);
        mouse.sub(center);
        mouse.mult(0.5f);
        translate(width/2,height/2);
        line(0,0,mouse.x,mouse.y);
    }

    private void testMag(){
        background(255);
        PVector mouse = new PVector(mouseX,mouseY);
        PVector center = new PVector(width/2,height/2);
        mouse.sub(center);
        float m = mouse.mag();
        fill(0);
        rect(0,0,m,10);
        translate(width/2,height/2);
        line(0,0,mouse.x,mouse.y);
    }


    private void testNormalize(){
        background(255);
        PVector mouse = new PVector(mouseX,mouseY);
        PVector center = new PVector(width/2,height/2);
        mouse.sub(center);
        mouse.normalize();
        mouse.mult(50);
        translate(width/2,height/2);
        line(0,0,mouse.x,mouse.y);
    }
}
