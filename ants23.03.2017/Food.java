import greenfoot.*;
import java.util.Random;
/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    public int Crumbs = 100;
    private int ImageSize = 30;
    private Color limegreen = new Color(50, 205, 50);
    private Color darkgreen = new Color(0, 100, 0);
    private int i;
    private int test = 0;
    
    public Food()
    {
        updateImage();
    }
    
    public void act()
    {
        
    }
    
    public void takeSomeCrumbs()
    {
        Crumbs = Crumbs - 1;
        if (Crumbs <= 0)
        {
            getWorld().removeObject(this);
        }
        else
        {
            updateImage();
        }
    }
    
    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage(ImageSize, ImageSize);
        i = 0;
        while (i<Crumbs)
        {
            int x = randomCoord();
            int y = randomCoord();
            image.setColorAt(x, y, limegreen);
            image.setColorAt(x + 1, y, darkgreen);
            image.setColorAt(x, y + 1, darkgreen);
            image.setColorAt(x + 1, y + 1, darkgreen);
            i = i + 1;
        }
        setImage(image);
    }
    
    private int randomCoord()
    {
        int coordinate = ImageSize / 2 + (int) (new Random().nextGaussian() * (ImageSize / 4));
        if (coordinate < 0)
        {
            return 0;
        }
        if(coordinate > ImageSize - 2)
        {
            return ImageSize - 2;
        }
        else
        {
            return coordinate;
        }
    }
}