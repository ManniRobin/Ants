import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Ant here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ant extends Creature
{
    private int xCoordinate;
    private int yCoordinate;
    private int currentX;
    private int currentY;
    private int deltaX;
    private int deltaY;

    private double Angle;
    private int anlge;

    private int i;
    private boolean foundFood = false;
    
    public Ant()
    {
        getHomeLocationX();
        getHomeLocationY();
    }
    
    public void act()
    {
        if (foundFood == false)
        {
            searchForFood();
        }
        if (checkForFood() || foundFood == true)
        {
            getHome();
        }
        if (atHome())
        {
            foundFood = false;
            setImage("ant.gif");
            searchForFood();
        }
    }
    
    public boolean checkForFood()
    {
        Food getFood = (Food) getOneIntersectingObject(Food.class);
        if (getFood != null)
        {
            takeCrumbs(getFood);
            getHome();
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void takeCrumbs(Food getFood)
    {
        getFood.takeSomeCrumbs();
        setImage("ant-with-food.gif");
    }
    
    private int getHomeLocationX()
    {
        if (i == 1)
        {
            xCoordinate = getX() + 0;
            i = i + 1;
        }
        return 320;
    }
    
    private int getHomeLocationY()
    {
        if (i == 1)
        {
            yCoordinate = getY() + 0;
            i = i + 1;
        }
        return 320;
    }
    
    public void getHome()
    {
        deltaX = getX() - getHomeLocationX();
        deltaY = getY() - getHomeLocationY() ;
        foundFood = true;
        if (deltaX != 0 || deltaY != 0)
        {
            Angle = Math.atan2(-deltaY, -deltaX) * (180 / Math.PI);
            int angle = (int)Angle;
            setRotation(angle);
        }
        move(Speed());
    }
    
    public boolean atHome()
    {
        if (getX() == xCoordinate && getY() == yCoordinate)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}