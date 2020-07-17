package k1Sokoban;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

// area class that extends an area
public class a_block extends Area {
//	sets the x and y to area x and y
    public a_block(int x, int y) {
    	super(x, y);
//    	Image url and obj now has a value
        URL loc = this.getClass().getResource("/res/a-area.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        
    }
}
