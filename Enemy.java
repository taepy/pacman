import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.math.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private double speed = 5.0;
    private boolean flag = true;

    public void act() 
    {
        // Add your action code here.
        if(flag) {
            int xpos = getX();
            int ypos = getY();
            int xsign, ysign;
            if(Math.random() > 0.5) xsign = 1;
            else xsign = -1;
            if(Math.random() > 0.5) ysign = 1;
            else ysign = -1;
            
            xpos += speed * 10 * Math.random() * xsign;
            ypos += speed * 10 * Math.random() * ysign;
            setLocation(xpos, ypos);
            if(getOneObjectAtOffset(0,0,pacman.class) != null) {
                flag = false;
            }
        }
    }
}
