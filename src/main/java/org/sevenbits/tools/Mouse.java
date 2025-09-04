package org.sevenbits.tools;

import java.awt.Robot;
import java.awt.AWTException;

public class Mouse{
    public Robot robot;
    public Screen screen;
    public Coordinates mouse;

    public Mouse() {
        mouse = new Coordinates(200,200);
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            System.err.println(e);
        }
    }

    public void setWindow(int x1, int y1, int x2, int y2){
        screen = new Screen(x1,y1,x2,y2);
    }

    public void run(){
        robot.mouseMove(mouse.getX(), mouse.getX());
    }
}

class Screen{

    Coordinates leftDown,leftUp,rightUp,rightDown;

    public Screen(int x1,int y1, int x2, int y2){
        this.leftUp = new Coordinates(x1, y1);
        this.rightDown = new Coordinates(x2,y2);
        this.leftDown = new Coordinates(leftUp.getX(),rightDown.getY());
        this.rightUp = new Coordinates(rightDown.getX(),leftUp.getY());
    }


    public Coordinates getLeftDown() {
        return leftDown;
    }

    public Coordinates getLeftUp() {
        return leftUp;
    }

    public Coordinates getRightUp() {
        return rightUp;
    }

    public Coordinates getRightDown() {
        return rightDown;
    }
}

class Coordinates{
    private int x,y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
