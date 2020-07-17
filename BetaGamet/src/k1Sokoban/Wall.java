package k1Sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Wall extends Actor {

    private Image image;
	/*
	 * this enables us to set the x and y 
	 * to the same as the Actor
	 */
    public Wall(int x, int y) {
    	super(x,y);

 //    	Image URL is now stored in an object for easy access
        URL loc = this.getClass().getResource("/res/wall.png");
        ImageIcon iia = new ImageIcon(loc);
        image = iia.getImage();
        this.setImage(image);

    }
}