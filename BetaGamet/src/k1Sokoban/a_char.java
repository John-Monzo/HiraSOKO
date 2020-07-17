package k1Sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class a_char extends Baggage {
//	sets the baggage x and y to a_char x and y
    public a_char(int x, int y) {
        super(x, y);
//    	Image url now has a value and is stored in an object
        URL loc = this.getClass().getResource("/res/a-char.png");
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
