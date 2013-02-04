import java.lang.Math;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import javax.swing.ImageIcon; //Imports

public class Sprite 
{
	private boolean control = false; 
    private int x, y;
    private int width, height;
    private Image image; //The main image of the sprite
    private boolean visible;
    
    double slope = 0;          //These are 
	boolean slopeDone = false; //all related
	boolean xOVERy = false;	   //to the slope	
	double distanceX;		   //and moving
    double distanceY;		   //to a location
		
//////////////////////////////////////////////////////////////////////////////////////////

    public Sprite(String path, int startX, int startY) 
    {
    	
        ImageIcon temp = new ImageIcon(path); //Load the image
        image = temp.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);

    	visible = true;    	    	
        x = startX; //Starting pos
        y = startY;
    }

        
    public int getX() 
    { 
        return x;
    }

    public int getY() 
    { 
        return y;
    }    
    
    public Image getImage() 
    {
        return image;
    }

     
    public void setVisible(Boolean visible) 
    {
        this.visible = visible;
    }

    public boolean isVisible() 
    {
        return visible;
    }

    public void bounce()
    {
    	if (control)
		{
			control = false; //Move the sprite up
			y += 5;
		} else
		{
			control = true; //Move the sprite down
			y -= 5;
		}	
    }
  
    public void blink()
    {   	  
		if (visible)
    	{
	    	setVisible(true);
	    	visible = false;
	    } else 
	    {
		    setVisible(false);
		    visible = true;
	    }
    }

	public void moveOnX(double xIncr)
	{	
		x += xIncr;
	}   
	
	public void moveOnY(double yIncr)
	{
		y += yIncr;
	}
	 
    public Rectangle getBounds() //Bounds of the Sprite image
    {
        return new Rectangle(x, y, width, height);
    }    
}