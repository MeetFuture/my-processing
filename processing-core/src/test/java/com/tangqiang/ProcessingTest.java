package com.tangqiang;

import processing.core.PApplet;

/**
 * ProcessingTest
 */
public class ProcessingTest extends PApplet {
    int count = 0;

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        stroke(0);
        fill(0);
        textSize(20);
        textAlign(CENTER);
    }

    @Override
    public void draw() {
        background(0xC7EDCC);
        text("This is a Test", width / 2, height / 2 - 100 + count++);
    }
}
