import greenfoot.*;
/**
 * An ant that collects food.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Creature extends Actor
{
    private int ants = 0;
    private int SPEED;
    private int TURN;
    private int ChromaticSign = Greenfoot.getRandomNumber(2);
    private int Rotation = Greenfoot.getRandomNumber(30);
    
    private AntHill home;
    
    public void setHomeHill(AntHill homeHill)
    {
        home = homeHill;
    }
    
    public AntHill getHomeHill()
    {
        return home;
    }
    
    public int Speed()
    {
        return SPEED = Greenfoot.getRandomNumber(4) + 1;
    }
    
    public void searchForFood()
    {
        moveRandomSpeed();
        if (randomChance(50))
        {
            if (ChromaticSign == 0)
                turn(TurnAround());
                ChromaticSign = Greenfoot.getRandomNumber(2);
            if (ChromaticSign == 1)
                turn(-TurnAround());
                ChromaticSign = Greenfoot.getRandomNumber(2);
        }
    }
    
    public void moveRandomSpeed()
    {
        move(Speed());
    }
    
    public boolean randomChance(int chance)
    {
        if (Greenfoot.getRandomNumber(100) < chance)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private int TurnAround()
    {
        return TURN = Greenfoot.getRandomNumber(20) + 30;
    }
}