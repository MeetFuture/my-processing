package com.tangqiang;

import processing.core.PApplet;

/**
 * 测试 Processing 1
 *
 * @author Tom
 * @version 1.0 2018-02-01 0001 Tom create
 * @date 2018-02-01 0001
 * @copyright Copyright © 2018 Grgbanking All rights reserved.
 */
public class ProcessingTest1 extends PApplet {

    public static void main(String[] args) {
        main(ProcessingTest1.class);
    }


    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void draw() {
        background(mouseX, mouseY, 100);

        fill(255);
        ellipse(mouseX, mouseY, 80, 80);
    }

}
