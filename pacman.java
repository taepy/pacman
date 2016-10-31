import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pacman extends Actor
{
    private int speed = 4;
    private boolean flag = true;
    private boolean auto = false;
    
    /**
     * Act - do whatever the pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        int xpos = getX();
        int ypos = getY();
        
        if(flag && !auto) {
            if(Greenfoot.isKeyDown("up")) {
                setRotation(270);
                ypos -= speed;
            }
            
            if(Greenfoot.isKeyDown("down")) {
                setRotation(90);
                ypos += speed;
            }
            
            if(Greenfoot.isKeyDown("left")) {
                setRotation(180);
                xpos -= speed;
            }
            
            if(Greenfoot.isKeyDown("right")) {
                setRotation(0);
                xpos += speed;
            }
            setLocation(xpos, ypos);
            
            if(Greenfoot.isKeyDown("A")) {
                auto = true;
            }
            
            if(getOneObjectAtOffset(0,0,Enemy.class) != null) {
                flag = false;
            }
        }
        if(flag && auto) {
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
