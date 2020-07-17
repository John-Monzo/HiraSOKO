package k1Sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

import sf.Sound;
import sf.SoundFactory;

public class Player extends Actor {
//local values to navigate to move sound
  public final static String DIR = "src/res/";
  public final static String MOVE_SOUND = DIR + "moving.wav";
  
    
    public Player(int x, int y) {
    	super(x, y);
    	
//    	Image URL is now stored in an object for easy access
        URL loc = this.getClass().getResource("/res/sokoban.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }
	/*
	 * movement class to set x and y 
	 * and the new updated x and y
	 * slightly modified to have sounds 
	 * play after each call.
	 */
    public void move(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
	    Sound sound = SoundFactory.getInstance(MOVE_SOUND);
		SoundFactory.play(sound);
        
    }
}