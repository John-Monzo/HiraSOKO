	package k1Sokoban;

import java.awt.Image;

public class Actor {

    private final int SPACE = 40;

    private int x;
    private int y;
    private Image image;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }

	/*
	 * image getter comes from the image value which is determined by each class.
	 */
    public Image getImage() {
        return this.image;
    }

    public void setImage(Image img) {
        image = img;
    }
//initializes the x value
    public int x() {
        return this.x;
    }
  //initializes the y value
    public int y() {
        return this.y;
    }
//sets the actors x to the x in the subclass
    public void setX(int x) {
        this.x = x;
    }
//sets ther actors y to the x in the subclass
    public void setY(int y) {
        this.y = y;
    }
//indicates collisions when an object collides with other actors.
    public boolean isLeftCollision(Actor actor) {
        if (((this.x() - SPACE) == actor.x()) &&
            (this.y() == actor.y())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRightCollision(Actor actor) {
        if (((this.x() + SPACE) == actor.x())
                && (this.y() == actor.y())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTopCollision(Actor actor) {
        if (((this.y() - SPACE) == actor.y()) &&
            (this.x() == actor.x())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBottomCollision(Actor actor) {
        if (((this.y() + SPACE) == actor.y())
                && (this.x() == actor.x())) {
            return true;
        } else {
            return false;
        }
    }
}
