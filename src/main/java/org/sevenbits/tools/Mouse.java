package org.sevenbits.tools;

import java.awt.*;

public class Mouse{
    public Robot robot;
    public Screen screen;
    public Coordinates mouse;

    public Mouse() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        screen = new Screen(dimension.width,dimension.height);
        mouse = new Coordinates(200,200);
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            System.err.println(e);
        }
    }

    public void run(){
        robot.mouseMove(mouse.getX(), mouse.getX());
    }
}

class Screen{

    Coordinates leftDown,leftUp,rightUp,rightDown;

    public Screen(int x, int y){
        this.leftUp = new Coordinates(0, 0);
        this.rightDown = new Coordinates(x,y);
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
    public Coordinates getRightDown() {return rightDown;}
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