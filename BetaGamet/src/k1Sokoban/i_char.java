package k1Sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class i_char extends Baggage {
	/*
	 * this enables us to set the x and y 
	 * to the same as the Area
	 */
    public i_char(int x, int y) {
        super(x, y);
        
//    	Image URL is now stored in an object for easy access
        URL loc = this.getClass().getResource("/res/i-char.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }
	/*
	 * movement class to set x and y 
	 * and the new updated x and y
	 */
    public void move(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
        }

}