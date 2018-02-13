package com.tangqiang;

import processing.core.PApplet;

/**
 * 向量
 *
 * @author Tom
 * @version 1.0 2018-02-01 0001 Tom create
 * @date 2018-02-01 0001
 * @copyright Copyright © 2018 Grgbanking All rights reserved.
 */
public class ProcessingTestBuringTree extends PApplet {
    int toDraw = 0;
    int tree = 0;
    int burningTree = 1;
    int emptySite = 2;
    int x_limit = 800;
    int y_limit = 600;
    int brown = color(80, 50, 10);
    int red = color(255, 0, 0);
    int green = color(0, 255, 0);
    float pGrowth = 0.01f;
    float pBurn = 0.00006f;
    int[][][] pix = new int[2][x_limit][y_limit];

    public static void main(String[] args) {
        main(ProcessingTestBuringTree.class);
    }

    boolean prob(float p) {
        if (random(0, 1) < p) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void settings() {
        size(x_limit, y_limit);
    }

    @Override
    public void setup() {
        frameRate(60);

        /* Initialize to all empty sites */
        for (int x = 0; x < x_limit; x++) {
            for (int y = 0; y < y_limit; y++) {
                pix[toDraw][x][y] = emptySite;
            }
        }

    }

    @Override
    public void draw() {
        update();

        for (int x = 0; x < x_limit; x++) {
            for (int y = 0; y < y_limit; y++) {
                if (pix[toDraw][x][y] == tree) {
                    stroke(green);
                } else if (pix[toDraw][x][y] == burningTree) {
                    stroke(red);
                } else {
                    stroke(brown);
                }
                point(x, y);
            }
        }
        toDraw = (toDraw == 0) ? 1 : 0;
    }


    void update() {
        int x, y, dx, dy, cell, chg, burningTreeCount;
        int toCompute = (toDraw == 0) ? 1 : 0;

        for (x = 1; x < x_limit - 1; x++) {
            for (y = 1; y < y_limit - 1; y++) {

                cell = pix[toDraw][x][y];

                // Survey area for burning trees
                burningTreeCount = 0;
                for (dx = -1; dx < 2; dx++) {
                    for (dy = -1; dy < 2; dy++) {
                        if ((dx == 0) && (dy == 0)) {
                            continue;
                        } else if (pix[toDraw][x + dx][y + dy] == burningTree) {
                            burningTreeCount++;
                        }
                    }
                }

                // Determine next state
                if (cell == burningTree) {
                    chg = emptySite;
                } else if ((cell == emptySite) && (prob(pGrowth))) {
                    chg = tree;
                } else if ((cell == tree) && (prob(pBurn))) {
                    chg = burningTree;
                } else if ((cell == tree) && (burningTreeCount > 0)) {
                    chg = burningTree;
                } else {
                    chg = cell;
                }
                pix[toCompute][x][y] = chg;
            }
        }
    }
}
