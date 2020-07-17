package k1Sokoban;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.net.URL;
import java.util.ArrayList;

//import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import sf.Sound;
import sf.SoundFactory;

@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class Board extends JPanel { 
//	These numbers are used for spacing and map placements
    private final int OFFSET = 60;
    private final int SPACE = 40;
    
//  These ints will come into play later when used in collision booleans
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;
    
//  booleans that are set to false at the start, they indicate when a block is in the corresponding areas
	boolean a_in = false;
	boolean i_in = false;
	boolean o_in = false;
	boolean u_in = false;
	boolean e_in = false;

//	List of Each of the various objects in the game
    private ArrayList walls = new ArrayList();
    private ArrayList baggs = new ArrayList();
    private ArrayList areas = new ArrayList();
   
//  A variety of the baggs and areas used to keep track of when a character enters a destination block
    private a_block a_area;
    private i_block i_area;
    private o_block o_area;
    private u_block u_area;
    private e_block e_area;
    private a_char a_obj;
    private i_char i_obj;
    private o_char o_obj;
    private u_char u_obj;
    private e_char e_obj;
    
//  Player object
    private Player soko;
    
//  Size of the screen
    private int w = 700;
    private int h = 500;
    
	/*
	 * Various other initial variables that need to be made in the start. Completed
	 * checks if all the bags have been placed in an area 
	 * Moves counts each time the player object moves one unit. 
	 * Stopwatch is a timer and adds seconds to the clock. 
	 * - Count and delay are used to measure increments of time.
	 * alternate_sound_conditions determines if the alternate sound will play when
	 * the level is completed
	 */
    
    private boolean completed = false;

    
    public int Moves = 0;
    public Timer stopwatch;
    public int count = 0;
    public int delay = 1000;
	public int alternate_sound_conditions = 0;
	private int lose_conditions = 0;
    
//	URLS for the SFX
    public final static String DIR = "src/res/";
    public final static String BAG_MOVE_SOUND = DIR + "walking.wav";
    public final static String DESTINATION_SOUND = DIR + "final.wav";
    public final static String ALTERNATE_SOUND = DIR + "ALTERNATE_ENDING.wav";
    public final static String A_SOUND = DIR + "A_SFX.wav";
    public final static String I_SOUND = DIR + "I_SFX.wav";
    public final static String O_SOUND = DIR + "O_SFX.wav";
    public final static String U_SOUND = DIR + "U_SFX.wav";
    public final static String E_SOUND = DIR + "E_SFX.wav";
    public final static String BEGINING_SOUND = DIR + "opening.wav";
   

//    Levels are made via string and chars.
    private String level1 =
            "    ##################\n"
          + "    ##    #         ##\n"
          + "   ###　　      #       ##\n"
          + "  #               o ##\n"
          + " ##   a i #   #     ##\n"
          + "#      ## ###   ######\n"
          + "#    # ## ####   21#\n"
          + "#  e  u  #       53#\n"
          + "#       #   @#### 4#\n"
          + "#          #########\n"
          + "############\n";
    
    private String level2 =
            "#  ##################\n"
          + "#             #    1#\n"
          + "#   ##         #    #\n"
          + "#4####    a     #  ##\n"
          + "##     o  i  e      #\n"
          + "#  # # ####   ####  #\n"
          + "#         u         #\n"
          + "#3#          @      #\n"
          + "######5########     #\n"
          + "##2                 #\n"
          + "#####################\n";
    
    private String level3 =
            "    ######\n"
          + "    ##   #\n"
          + "    ##e  #\n"
          + "  ####   ##\n"
          + "  ## o  u #\n"
          + "#### # ## #   ######\n"
          + "##   # ## #####  54#\n"
          + "##         a 　    23#\n"
          + "######i### #@##   1#\n"
          + "    ##     #########\n"
          + "    ########\n";
    
//    Holds a string of the name of the level for when it loads.
	private String levelholder;

//	Indicates the start of the timer so that the clock can start
	public void startTimer(int countPassed) {

		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
			}
		};
		stopwatch = new Timer(delay, action);
		stopwatch.setInitialDelay(0);
		stopwatch.start();
		count = countPassed;
		Sound sound = SoundFactory.getInstance(BEGINING_SOUND);
		SoundFactory.play(sound);
	}
//	Generates a random number
	public static int rand(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("Invalid range");
		}

		double rand = Math.random();
		return (int) (rand * ((max - min) + 1)) + min;
	}
//	Uses the number generated to determine the level
	public String randnum() {
		int min = 1, max = 3;

		double i = (rand(min, max));

		if (i == 1) {
			levelholder = level1;
		}

		else if (i == 2) {
			levelholder = level2;
		}

		else if (i == 3) {
			levelholder = level3;
		}

		return levelholder;
	}

	/*
	 * Constructor to initialize the layout of the map loaded and start the timer as
	 * well as enabling KeyListener to pickup player input
	 */
	
	public Board() {

		addKeyListener(new TAdapter());
		setFocusable(true);
		initWorld();
		startTimer(0);
	}
	/*
	 * getBoardWidth determines the width in a public in from variable w
	 * getBoardHeight determines the height in a public in from variable h
	 */
	public int getBoardWidth() {
		return this.w;
	}

	public int getBoardHeight() {
		return this.h;
	}

	/*
	 * Method that selects a random world and initializes all the assets using
	 * the text maps from the string levels
	 */
	public final void initWorld() {
		String randomselect = randnum();
		int x = OFFSET;
		int y = OFFSET;

		Wall wall;

		if (randomselect == level1) {

			for (int i = 0; i < level1.length(); i++) {
				char item = level1.charAt(i);

				if (item == '\n') {
					y += SPACE;
					if (this.w < x) {
						this.w = x;
					}
					x = OFFSET;
				} else if (item == '#') {
					wall = new Wall(x, y);
					walls.add(wall);
					x += SPACE;
				} else if (item == 'a') {
					a_obj = new a_char(x, y);
					baggs.add(a_obj);
					x += SPACE;
				} else if (item == 'i') {
					i_obj = new i_char(x, y);
					baggs.add(i_obj);
					x += SPACE;
				} else if (item == 'e') {
					e_obj = new e_char(x, y);
					baggs.add(e_obj);
					x += SPACE;
				} else if (item == 'o') {
					o_obj = new o_char(x, y);
					baggs.add(o_obj);
					x += SPACE;
				} else if (item == 'u') {
					u_obj = new u_char(x, y);
					baggs.add(u_obj);
					x += SPACE;
				} else if (item == '1') {
					a_area = new a_block(x, y);
					areas.add(a_area);
					x += SPACE;
				} else if (item == '2') {
					e_area = new e_block(x, y);
					areas.add(e_area);
					x += SPACE;
				} else if (item == '3') {
					i_area = new i_block(x, y);
					areas.add(i_area);
					x += SPACE;
				} else if (item == '4') {
					o_area = new o_block(x, y);
					areas.add(o_area);
					x += SPACE;
				} else if (item == '5') {
					u_area = new u_block(x, y);
					areas.add(u_area);
					x += SPACE;
				} else if (item == '@') {
					soko = new Player(x, y);
					x += SPACE;
				} else if (item == ' ') {
					x += SPACE;
				}

			}
		} else if (randomselect == level2) {

			for (int i = 0; i < level2.length(); i++) {
				char item = level2.charAt(i);

				if (item == '\n') {
					y += SPACE;
					if (this.w < x) {
						this.w = x;
					}
					x = OFFSET;
				} else if (item == '#') {
					wall = new Wall(x, y);
					walls.add(wall);
					x += SPACE;
				} else if (item == 'a') {
					a_obj = new a_char(x, y);
					baggs.add(a_obj);
					x += SPACE;
				} else if (item == 'i') {
					i_obj = new i_char(x, y);
					baggs.add(i_obj);
					x += SPACE;
				} else if (item == 'e') {
					e_obj = new e_char(x, y);
					baggs.add(e_obj);
					x += SPACE;
				} else if (item == 'o') {
					o_obj = new o_char(x, y);
					baggs.add(o_obj);
					x += SPACE;
				} else if (item == 'u') {
					u_obj = new u_char(x, y);
					baggs.add(u_obj);
					x += SPACE;
				} else if (item == '1') {
					a_area = new a_block(x, y);
					areas.add(a_area);
					x += SPACE;
				} else if (item == '2') {
					e_area = new e_block(x, y);
					areas.add(e_area);
					x += SPACE;
				} else if (item == '3') {
					i_area = new i_block(x, y);
					areas.add(i_area);
					x += SPACE;
				} else if (item == '4') {
					o_area = new o_block(x, y);
					areas.add(o_area);
					x += SPACE;
				} else if (item == '5') {
					u_area = new u_block(x, y);
					areas.add(u_area);
					x += SPACE;
				} else if (item == '@') {
					soko = new Player(x, y);
					x += SPACE;
				} else if (item == ' ') {
					x += SPACE;
				}
			}
		} else if (randomselect == level3) {

			for (int i = 0; i < level3.length(); i++) {
				char item = level3.charAt(i);

				if (item == '\n') {
					y += SPACE;
					if (this.w < x) {
						this.w = x;
					}

					x = OFFSET;
				} else if (item == '#') {
					wall = new Wall(x, y);
					walls.add(wall);
					x += SPACE;
				} else if (item == 'a') {
					a_obj = new a_char(x, y);
					baggs.add(a_obj);
					x += SPACE;
				} else if (item == 'i') {
					i_obj = new i_char(x, y);
					baggs.add(i_obj);
					x += SPACE;
				} else if (item == 'e') {
					e_obj = new e_char(x, y);
					baggs.add(e_obj);
					x += SPACE;
				} else if (item == 'o') {
					o_obj = new o_char(x, y);
					baggs.add(o_obj);
					x += SPACE;
				} else if (item == 'u') {
					u_obj = new u_char(x, y);
					baggs.add(u_obj);
					x += SPACE;
				} else if (item == '1') {
					a_area = new a_block(x, y);
					areas.add(a_area);
					x += SPACE;
				} else if (item == '2') {
					e_area = new e_block(x, y);
					areas.add(e_area);
					x += SPACE;
				} else if (item == '3') {
					i_area = new i_block(x, y);
					areas.add(i_area);
					x += SPACE;
				} else if (item == '4') {
					o_area = new o_block(x, y);
					areas.add(o_area);
					x += SPACE;
				} else if (item == '5') {
					u_area = new u_block(x, y);
					areas.add(u_area);
					x += SPACE;
				} else if (item == '@') {
					soko = new Player(x, y);
					x += SPACE;
				} else if (item == ' ') {
					x += SPACE;
				}

			}
		}

	}


//	uses the graphics class to build the world using a GUI
	public void buildWorld(Graphics g) {
       
		g.setColor(new Color(250, 240, 170));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		ArrayList world = new ArrayList();
		world.addAll(walls);
		world.addAll(areas);
		world.addAll(baggs);
		world.add(soko);

		for (int i = 0; i < world.size(); i++) {

			Actor item = (Actor) world.get(i);
			//Record rec= new Record(getName(), getScore());

//			Draws all the items by making an instance of all the classes used
			if ((item instanceof Player) || (item instanceof a_char) || (item instanceof i_char)
					|| (item instanceof e_char) || (item instanceof u_char) || (item instanceof o_char)) {
				g.drawImage(item.getImage(), item.x() + 2, item.y() + 2, this);
			} else {
				g.drawImage(item.getImage(), item.x(), item.y(), this);
			}
			/*
			 * Completed: GUI for when the level is completed. 
			 * !Completed: the main GUI while game is running
			 */
			if (completed) {
				g.setColor(new Color(0, 0, 0));
				g.drawString("Completed", 25, 20);
				g.drawString("High Scores              " + "AAA              " + 100, 630, 80);
				g.drawString("High Scores              " + getName()+"             " + 100, 630, 100);
				g.drawString("Press 'Q' to quit", 200, 30);
				g.drawString("Press 'R' to reset and randomize level", 200, 50);
			}if (!completed) {
				g.setColor(new Color(0, 0, 0));
				g.drawString("Moves: " + Moves, 40, 40);
				g.drawString("Timer: " + count, 40, 60);
				g.drawString("Press 'Q' to quit", 200, 30);
				g.drawString("Press 'R' to reset and randomize level", 200, 50);
			}else if(lose_conditions >= 2) {
				g.setColor(new Color(0, 0, 0));
				g.drawString("You Lose" + Moves, 40, 40);
				g.drawString("Press 'Q' to quit", 200, 30);
				g.drawString("Press 'R' to reset and randomize level", 200, 50);
			}
			
		}
	}

	/* Paint and repaint displays all the objects laid out in initWorld */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		buildWorld(g);
	}
	
//  TAdapder extending Key adapter allows for keys to be recognized when pressed
//	After any key is pressed the repaint methos is called 
	class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT && !completed) {
				if (checkWallCollision(soko, LEFT_COLLISION)) {
					return;
				}if (checkBagCollision(LEFT_COLLISION)) {
					return;
				}
				soko.move(-SPACE, 0);
				Moves = Moves + 1;

			} else if (key == KeyEvent.VK_RIGHT && !completed) {

				if (checkWallCollision(soko, RIGHT_COLLISION)) {
					return;
				}if (checkBagCollision(RIGHT_COLLISION)) {
					return;
				}
				soko.move(SPACE, 0);
				Moves = Moves + 1;

			} else if (key == KeyEvent.VK_UP && !completed) {

				if (checkWallCollision(soko, TOP_COLLISION)) {
					return;
				}if (checkBagCollision(TOP_COLLISION)) {
					return;
				}
				soko.move(0, -SPACE);
				Moves = Moves + 1;

			} else if (key == KeyEvent.VK_DOWN && !completed) {

				if (checkWallCollision(soko, BOTTOM_COLLISION)) {
					return;
				}if (checkBagCollision(BOTTOM_COLLISION)) {
					return;
				}
				soko.move(0, SPACE);
				Moves = Moves + 1;
				
			} else if (key == KeyEvent.VK_R) {
				restartLevel();
			} else if (key == KeyEvent.VK_Q) {
				System.exit(0);
			}
			repaint();
		}
	}

	/*
	 * Called in each KeyEvent, this boolean makes sure that the player and walls
	 * cannot affect one another. If the player collides with a wall, it will not
	 * move and nothing will happen.
	 */
	private boolean checkWallCollision(Actor actor, int type) {

		if (type == LEFT_COLLISION) {

			for (int i = 0; i < walls.size(); i++) {
				Wall wall = (Wall) walls.get(i);
				if (actor.isLeftCollision(wall)) {
					return true;
				}
			}
			return false;

		} else if (type == RIGHT_COLLISION) {

			for (int i = 0; i < walls.size(); i++) {
				Wall wall = (Wall) walls.get(i);
				if (actor.isRightCollision(wall)) {
					return true;
				}
			}
			return false;

		} else if (type == TOP_COLLISION) {

			for (int i = 0; i < walls.size(); i++) {
				Wall wall = (Wall) walls.get(i);
				if (actor.isTopCollision(wall)) {
					return true;
				}
			}
			return false;

		} else if (type == BOTTOM_COLLISION) {

			for (int i = 0; i < walls.size(); i++) {
				Wall wall = (Wall) walls.get(i);
				if (actor.isBottomCollision(wall)) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	/*
	 * Called in each KeyEvent just like checkWallCollision. This boolean 
	 * makes sure that the player object and the characters behave appropriately
	 * If the player collides with a character, it will 
	 * move in the direction it was pushed.
	 * 
	 * It also calls the is completed and 
	 * sound_isCompleted each round to indicate if the coordinates of the characters match the cooresponding areas.
	 */
	private boolean checkBagCollision(int type) {
		if (type == LEFT_COLLISION) {

			for (int i = 0; i < baggs.size(); i++) {

				Baggage bag = (Baggage) baggs.get(i);
				if (soko.isLeftCollision(bag)) {

					for (int j = 0; j < baggs.size(); j++) {
						Baggage item = (Baggage) baggs.get(j);
						if (!bag.equals(item)) {
							if (bag.isLeftCollision(item)) {
								return true;
							}
						}if (checkWallCollision(bag, LEFT_COLLISION)) {
							lose_conditions++;
							return true;
						}
					}
					bag.move(-SPACE, 0);
					isCompleted();
					sound_isCompleted();
				}
			}
			return false;

		} else if (type == RIGHT_COLLISION) {

			for (int i = 0; i < baggs.size(); i++) {

				Baggage bag = (Baggage) baggs.get(i);
				if (soko.isRightCollision(bag)) {
					for (int j = 0; j < baggs.size(); j++) {

						Baggage item = (Baggage) baggs.get(j);
						if (!bag.equals(item)) {
							if (bag.isRightCollision(item)) {
								return true;
							}
						}if (checkWallCollision(bag, RIGHT_COLLISION)) {
							lose_conditions++;
							return true;
						}
					}
					bag.move(SPACE, 0);
					isCompleted();
					sound_isCompleted();
				}
			}
			return false;

		} else if (type == TOP_COLLISION) {

			for (int i = 0; i < baggs.size(); i++) {

				Baggage bag = (Baggage) baggs.get(i);
				if (soko.isTopCollision(bag)) {
					for (int j = 0; j < baggs.size(); j++) {

						Baggage item = (Baggage) baggs.get(j);
						if (!bag.equals(item)) {
							if (bag.isTopCollision(item)) {
								return true;
							}
						}if (checkWallCollision(bag, TOP_COLLISION)) {
							lose_conditions++;
							return true;
						}
					}
					bag.move(0, -SPACE);
					isCompleted();
					sound_isCompleted();
				}
			}

			return false;

		} else if (type == BOTTOM_COLLISION) {

			for (int i = 0; i < baggs.size(); i++) {

				Baggage bag = (Baggage) baggs.get(i);
				if (soko.isBottomCollision(bag)) {
					for (int j = 0; j < baggs.size(); j++) {

						Baggage item = (Baggage) baggs.get(j);
						if (!bag.equals(item)) {
							if (bag.isBottomCollision(item)) {
								return true;
							}
						}if (checkWallCollision(bag, BOTTOM_COLLISION)) {
							lose_conditions++;
							return true;
						}
					}
					bag.move(0, SPACE);
					isCompleted();
					sound_isCompleted();
				}
				
			}
		}

		return false;
	}
// if the areas x and y are equal to the character obj x and y play the sound
	public void sound_isCompleted() {
		if (a_area.x() == a_obj.x() && a_area.y() == a_obj.y() && a_in == false) {
			Sound sound = SoundFactory.getInstance(A_SOUND);
			SoundFactory.play(sound);
			a_in = true;
			alternate_sound_conditions++;
		} else if (i_area.x() == i_obj.x() && i_area.y() == i_obj.y() && i_in == false) {
			Sound sound = SoundFactory.getInstance(I_SOUND);
			SoundFactory.play(sound);
			i_in = true;
			alternate_sound_conditions++;
		} else if (o_area.x() == o_obj.x() && o_area.y() == o_obj.y() && o_in == false) {
			Sound sound = SoundFactory.getInstance(O_SOUND);
			SoundFactory.play(sound);
			o_in = true;
			alternate_sound_conditions++;
		} else if (u_area.x() == u_obj.x() && u_area.y() == u_obj.y() && u_in == false) {
			Sound sound = SoundFactory.getInstance(U_SOUND);
			SoundFactory.play(sound);
			u_in = true;
			alternate_sound_conditions++;
		} else if (e_area.x() == e_obj.x() && e_area.y() == e_obj.y() && e_in == false) {
			Sound sound = SoundFactory.getInstance(E_SOUND);
			SoundFactory.play(sound);
			e_in = true;
			alternate_sound_conditions++;
		} else
			return;
	}

	/*
	 * if all the characters are docked regardless of whether they are in the right
	 * spots play one of the sounds
	 */
	public void isCompleted() {
		int num = baggs.size();
		int compl = 0;

		for (int i = 0; i < num; i++) {
			Baggage bag = (Baggage) baggs.get(i);
			for (int j = 0; j < num; j++) {

				Area area = (Area) areas.get(j);
				if (bag.x() == area.x() && bag.y() == area.y()) {
					compl += 1;
				}
			}
		}

		if (compl == num) {
			if (alternate_sound_conditions == 4) {
				Sound sound = SoundFactory.getInstance(ALTERNATE_SOUND);
				SoundFactory.play(sound);
			} else {
				Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
				SoundFactory.play(sound);
			}
			completed = true;
			repaint();
		}
		else if(lose_conditions==2) {
			repaint();
		}
	}

	/*
	 * Restarts the level and randomizes the new one as well as clearing all the
	 * objects and sets the " 'x'_in" booleans to their original false value.
	 */
	public void restartLevel() {
		
		areas.clear();
		baggs.clear();
		walls.clear();
		
		alternate_sound_conditions = 0;
		Moves = 0;
		count = 0;
		
		a_in = false;
		i_in = false;
		o_in = false;
		u_in = false;
		e_in = false;
		
		initWorld();
		if (completed) {
			completed = false;
		}
	}
}