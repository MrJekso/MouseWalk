package org.sevenbits.tools;

import java.awt.*;

public class Mouse {
    private Robot robot;
    private Coordinates mouse;
    private boolean status;
    private int speed,sleep;
    private Dimension dimension;

    public Mouse() {
        speed = 2;
        sleep = 15;
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        mouse = new Coordinates(0, 0);
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            System.err.println(e);
        }
    }

    public void run() throws  InterruptedException{

        Point location = MouseInfo.getPointerInfo().getLocation();

        mouse.setCordinates((int)location.getX(),(int)location.getY());

        boolean checkY = true;
        boolean checkX = false;
        int y = mouse.getY();
        int x =mouse.getX();

        while(this.status){
            robot.mouseMove(mouse.getX(), mouse.getY());
            Thread.sleep(sleep);


            if(y > dimension.height){
                checkY = false;
            }
            if(y < 0){
                checkY = true;
            }

            if(checkY) {
                y+= speed;
                mouse.setY(mouse.getY() + speed);
            }else{
                y-= speed;
                mouse.setY(mouse.getY() - speed);
            }

            if(x > dimension.width){
                checkX = false;
            }
            if(x < 0){
                checkX = true;
            }
            if(checkX) {
                x+=speed;
                mouse.setX(mouse.getX() + speed);
            }else{
                x-=speed;
                mouse.setX(mouse.getX() - speed);
            }
        }
    }
    protected void setStatus(Boolean status) {
        this.status = status;
    }
}

class Coordinates{
    private int x,y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setCordinates(int x,int y) {this.x = x;this.y = y;}
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