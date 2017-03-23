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
    
    public Ant(AntHill home)
    {
        setHomeHill(home);
    }
    
    public Ant()
    {
    }
    
    public void act()
    {
        getHomeLocationX();
        getHomeLocationY();
        if (checkForFood() && foundFood == true)
        {
            getHome();
            if (atHome())
            {
                searchForFood();
            }
        }
        else
        {
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
        if (i == 0)
        {
            i = 1;
            xCoordinate = getX() + 0;
        }
        return 320;
    }
    
    private int getHomeLocationY()
    {
        if (i == 0)
        {
            i = 1;
            yCoordinate = getY() + 0;
        }
        return 320;
    }
    
    public void getHome()
    {
        deltaX = getX() - getHomeLocationY();
        deltaY = getY() - getHomeLocationX();
        foundFood = true;
        
        if (deltaX != 0 || deltaY != 0)
        {
            Angle = Math.atan2(-deltaY, -deltaX) * (180 / Math.PI);
            int angle = (int)Angle;
            setRotation(90);
        }
        move(3);
    }
    
    public boolean atHome()
    {
        if (getX() == 320 && getY() == 320)
        {
            setImage("ant.gif");
            return true;
        }
        else
        {
            return false;
        }
    }
}