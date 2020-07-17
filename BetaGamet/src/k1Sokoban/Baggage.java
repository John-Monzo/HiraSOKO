package k1Sokoban;

//Baggage class that extends an Actor
public class Baggage extends Actor {
//	sets the x and y to Baggage x and y
    public Baggage(int x, int y) {
        super(x, y);
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