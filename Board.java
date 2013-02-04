import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer; //Imports

public class Board extends JPanel implements ActionListener 
{
	private Sprite mainCharacter;
	private Sprite evilCharacter;
	boolean visible = true;
	
	private Timer timer; //Timing events
 	private Image imageMain;
	private Image imageEvil;
 	
//////////////////////////////////////////////////////////////////////////////////////////
	    
    public Board() //Sets up the board (constructor)
    { 
    	mainCharacter = new Sprite("aaaDeNiro.png", 0, 100); //deNiro!
    	evilCharacter = new Sprite("aaaDeNiroEvil.png", 700, 100); //Evil deNiro!
    	
        setBackground(Color.BLACK); //Put in backdrops later
        setDoubleBuffered(true); //Buffers
             	
     	timer = new Timer(5, this); //Higher ~ Slower
     	timer.start(); //Start the timer
     	
    }

    public void paint(Graphics g) //Paint the image
    {
    	super.paint(g);        
        Graphics2D g2d = (Graphics2D)g;
        
        imageMain = mainCharacter.getImage();   
        imageEvil = evilCharacter.getImage();     
        
        if (mainCharacter.isVisible())
        {
	        g2d.drawImage(imageMain, (mainCharacter.getX()), (mainCharacter.getY()), this);
	    } //Draw the mainCharacter if he's visible
	    
	    if (evilCharacter.isVisible())
	    {
		    g2d.drawImage(imageEvil, (evilCharacter.getX()), (evilCharacter.getY()), this); 
	    } //Draw the evilCharacter if he's 
        					
        Toolkit.getDefaultToolkit().sync(); //Some important shit
        g.dispose(); //Idk, just don't fuck with it
    }
        
    public void collisionCheck()
    {
    	Rectangle mainRec = mainCharacter.getBounds();
    	Rectangle evilRec = evilCharacter.getBounds();
        if (mainRec.intersects(evilRec))
        {
        	mainCharacter.setVisible(false);
        }
     }
        
    public void actionPerformed(ActionEvent e)
    {
     	//mainCharacter.blink(); 
     	//evilCharacter.bounce();
    	mainCharacter.moveOnX(1); 	 
    	evilCharacter.moveOnX(-3);
    	collisionCheck(); 	    	
    	repaint(); //Repaint the image every turn  	  	
    } 
       	       	  
}