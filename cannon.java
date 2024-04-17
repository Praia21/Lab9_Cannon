import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cannon extends Actor
{
    private final static double CANNON_BALL_VELOCITY = 1500.0;
    public void act()
    { 
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if  (mouse != null)
        {
            Vector2D cannonToMouse = new Vector2D(mouse.getX() - getX(), mouse.getY() - getY());
            
            alignWithVector(cannonToMouse);
            
            if (Greenfoot.mouseClicked(null))
            {
                cannonToMouse.normalize();
                cannonToMouse = Vector2D.multiply(cannonToMouse, CANNON_BALL_VELOCITY);
                
                CannonBall ball = new CannonBall();
                ball.setVelocity(cannonToMouse);
                getWorld().addObject(ball, getX(), getY());
                Greenfoot.playSound("cannonSound.wav");
            }
        }
    }
    /**
     * Act - do whatever the cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void alignWithVector(Vector2D v)
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        { Vector2D cannonToMouse = new Vector2D(mouse.getX() - getX(),
                                                mouse.getY() - getY());
          double adjecent = cannonToMouse.getX();
          double opposite = cannonToMouse.getY();
          
          double angleRadians = Math.atan2(opposite, adjecent);
          double angleDegrees = Math.toDegrees(angleRadians);
          
          
          setRotation((int) angleDegrees);  
        }
    }
}
