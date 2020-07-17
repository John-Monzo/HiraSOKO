package k1Sokoban;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

//e_block class that extends an area

public class o_block extends Area{
	/*
	 * this enables us to set the x and y 
	 * to the same as the Area
	 */
	public o_block(int x, int y) {
	    	super(x, y);
//Image URL is now stored in an object for easy access
	        URL loc = this.getClass().getResource("/res/o-area.png");
	        ImageIcon iia = new ImageIcon(loc);
	        Image image = iia.getImage();
	        this.setImage(image);
	        
	    }
}
