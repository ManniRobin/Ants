import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * The world where ants live.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class AntWorld extends World
{
    public static final int WORLDSIZE = 640;

    /**
     * Create a new world. It will be initialised with a few ant hills
     * and food sources
     */
    public AntWorld()
    {
        super(WORLDSIZE, WORLDSIZE, 1);
        setPaintOrder(Ant.class, AntHill.class);
        scenario1();
    }
    public void scenario1()
    {
        removeObjects(getObjects(null));
        addObject(new AntHill(), 320, 320);
        addObject(new Food(), 250, 50);
        addObject(new Food(), 400, 150);
        addObject(new Food(), 180, 380);
        addObject(new Food(), 200, 250);
        addObject(new Food(), 520, 320);
        addObject(new Food(), 550, 550);
    }
}
