package k1Sokoban;

public class excess {
//	package k1Sokoban;
//
//	import java.awt.Color;
//	import java.awt.Graphics;
//	import java.awt.event.ActionEvent;
//	import java.awt.event.ActionListener;
//	import java.awt.event.KeyAdapter;
//	import java.awt.event.KeyEvent;
//	import java.util.ArrayList;
//
//
//	import javax.swing.JPanel;
//	import javax.swing.Timer;
//
//	import sf.Sound;
//	import sf.SoundFactory;
/*//package k1Sokoban;


public class SwingTimer{

//    int count = 0;
//    int delay = 1000;

*/
//startTimer(60); this is how to instantiate the timer method for 60 secs

	
//	@SuppressWarnings({"serial","rawtypes", "unchecked"})
//	public class Board extends JPanel { 
//
//	    private final int OFFSET = 60;
//	    private final int SPACE = 40;
//	    private final int LEFT_COLLISION = 1;
//	    private final int RIGHT_COLLISION = 2;
//	    private final int TOP_COLLISION = 3;
//	    private final int BOTTOM_COLLISION = 4;
//
//	    private ArrayList walls = new ArrayList();
//	    private ArrayList baggs = new ArrayList();
//	    private ArrayList areas = new ArrayList();
//	    private Player soko;
//	    private int w = 700;
//	    private int h = 500;
//	    private boolean completed = false;
//	    private boolean compls = false;
//	    public int Moves=0;
//	    public Timer stopwatch;
//	    public int count = 0;
//	    public int delay = 1000;
//
//	    
//	    public final static String DIR = "src/res/";
//	    public final static String BAG_MOVE_SOUND = DIR + "walking.wav";
//	    public final static String DESTINATION_SOUND = DIR + "final.wav";
//	    public final static String BEGINING_SOUND = DIR + "opening.wav";
//	    
//	//    
//	    private String level1 =
//	            "    ##################\n"
//	          + "    ##    #         ##\n"
//	          + "   ###　　      #       ##\n"
//	          + "  #               o ##\n"
//	          + " ##   a i #   #     ##\n"
//	          + "#      ## ###   ######\n"
//	          + "#    # ## ####   ..#\n"
//	          + "#  e  u  #       ..#\n"
//	          + "#       #   @####..#\n"
//	          + "#          #########\n"
//	          + "############\n";
//	    
//	    private String level2 =
//	            "#  #################\n"
//	          + "#             #    .#\n"
//	          + "#   ##         #    #\n"
//	          + "#.####    a     #  ##\n"
//	          + "##     o  i  e      #\n"
//	          + "#  # # ####   ####  #\n"
//	          + "#         u         #\n"
//	          + "#.#          @      #\n"
//	          + "######.########     #\n"
//	          + "##.                 #\n"
//	          + "#####################\n";
//	    
//	    private String level3 =
//	            "    ######\n"
//	          + "    ##   #\n"
//	          + "    ##e  #\n"
//	          + "  ####   ##\n"
//	          + "  ## o  u #\n"
//	          + "#### # ## #   ######\n"
//	          + "##   # ## #####  ..#\n"
//	          + "##         a 　    ..#\n"
//	          + "######i### #@##  ..#\n"
//	          + "    ##     #########\n"
//	          + "    ########\n";
//	    
//		private String levelholder;
//		
//	    public void startTimer(int countPassed){
//
//	        ActionListener action = new ActionListener(){
//	            public void actionPerformed(ActionEvent e){
//	            	count++;
//	            }
//	        };
//	        stopwatch = new Timer(delay, action);
//	        stopwatch.setInitialDelay(0);
//	        stopwatch.start();
//	        count = countPassed;
//		    Sound sound = SoundFactory.getInstance(BEGINING_SOUND);
//			SoundFactory.play(sound);
//	    }
//
//		
//		public static int rand(int min, int max)
//		{
//			if (min > max) {
//				throw new IllegalArgumentException("Invalid range");
//			}
//
//			double rand = Math.random();
//			return (int)(rand * ((max - min) + 1)) + min;
//		}
//		
//	    public String randnum() {
//	    	int min=1, max=3;
//	    	
//	    	double i=(rand(min, max));
//	    			
//	    	if(i==1) {
//	        	levelholder=level1;
//	        }
//	    	
//	    	else if (i==2) {
//	    		levelholder=level2;
//	    	}
//	    	
//	    	else if (i==3) {
//	    		levelholder=level3;
//	    	}
//	    	
//	        return levelholder;
//	    }
//	    
//	    public Board() {
//
//	        addKeyListener(new TAdapter());
//	        setFocusable(true);
//	        initWorld();
//	        startTimer(0);
//	    }
//
//	      
//	    public int getBoardWidth() {
//	        return this.w;
//	    }
//
//	    public int getBoardHeight() {
//	        return this.h;
//	    }
//	    
//
//	    public final void initWorld() {
//	        String randomselect = randnum();
//	        int x = OFFSET;
//	        int y = OFFSET;
//	        
//	        Wall wall;
//	        Baggage b;
//	        a_char ca;
//	        i_char ci;
//	        o_char co;
//	        u_char cu;
//	        e_char ce;
//	        Area a;
//
//	        if(randomselect==level1) {
//	        	
//	       
//	        for (int i = 0; i < level1.length(); i++) {
//	            char item = level1.charAt(i);
//	        	
//	            if (item == '\n') {
//	                y += SPACE;
//	                if (this.w < x) {
//	                    this.w = x;
//	                }
//
//	                x = OFFSET;
//	            } else if (item == '#') {
//	                wall = new Wall(x, y);
//	                walls.add(wall);
//	                x += SPACE;
//	            } else if (item == 'a') {
//	                ca = new a_char(x, y);
//	                baggs.add(ca);
//	                x += SPACE;
//	            } else if (item == 'i') {
//	                ci = new i_char(x, y);
//	                baggs.add(ci);
//	                x += SPACE;
//	            } else if (item == 'e') {
//	                ce = new e_char(x, y);
//	                baggs.add(ce);
//	                x += SPACE;
//	            } else if (item == 'o') {
//	                co = new o_char(x, y);
//	                baggs.add(co);
//	                x += SPACE;
//	            } else if (item == 'u') {
//	                cu = new u_char(x, y);
//	                baggs.add(cu);
//	                x += SPACE;
//	            }else if (item == '.') {
//	                a = new Area(x, y);
//	                areas.add(a);
//	                x += SPACE;
//	            } else if (item == '@') {
//	                soko = new Player(x, y);
//	                x += SPACE;
//	            } else if (item == ' ') {
//	                x += SPACE;
//	            }
//
//	        }
//	    }
//	        else if(randomselect==level2) {
//	        	
//	            
//	            for (int i = 0; i < level2.length(); i++) {
//	                char item = level2.charAt(i);
//	            	
//	                if (item == '\n') {
//	                    y += SPACE;
//	                    if (this.w < x) {
//	                        this.w = x;
//	                    }
//
//	                    x = OFFSET;
//	                } else if (item == '#') {
//	                    wall = new Wall(x, y);
//	                    walls.add(wall);
//	                    x += SPACE;
//	                } else if (item == 'a') {
//	                    ca = new a_char(x, y);
//	                    baggs.add(ca);
//	                    x += SPACE;
//	                } else if (item == 'i') {
//	                    ci = new i_char(x, y);
//	                    baggs.add(ci);
//	                    x += SPACE;
//	                } else if (item == 'e') {
//	                    ce = new e_char(x, y);
//	                    baggs.add(ce);
//	                    x += SPACE;
//	                } else if (item == 'o') {
//	                    co = new o_char(x, y);
//	                    baggs.add(co);
//	                    x += SPACE;
//	                } else if (item == 'u') {
//	                    cu = new u_char(x, y);
//	                    baggs.add(cu);
//	                    x += SPACE;
//	                } else if (item == '.') {
//	                    a = new Area(x, y);
//	                    areas.add(a);
//	                    x += SPACE;
//	                } else if (item == '@') {
//	                    soko = new Player(x, y);
//	                    x += SPACE;
//	                } else if (item == ' ') {
//	                    x += SPACE;
//	                }
//	               }
//	            }
//	        else if(randomselect==level3) {
//	        	
//	            
//	            for (int i = 0; i < level3.length(); i++) {
//	                char item = level3.charAt(i);
//	            	
//	                if (item == '\n') {
//	                    y += SPACE;
//	                    if (this.w < x) {
//	                        this.w = x;
//	                    }
//
//	                    x = OFFSET;
//	                } else if (item == '#') {
//	                    wall = new Wall(x, y);
//	                    walls.add(wall);
//	                    x += SPACE;
//	                } else if (item == 'a') {
//	                    ca = new a_char(x, y);
//	                    baggs.add(ca);
//	                    x += SPACE;
//	                } else if (item == 'i') {
//	                    ci = new i_char(x, y);
//	                    baggs.add(ci);
//	                    x += SPACE;
//	                } else if (item == 'e') {
//	                    ce = new e_char(x, y);
//	                    baggs.add(ce);
//	                    x += SPACE;
//	                } else if (item == 'o') {
//	                    co = new o_char(x, y);
//	                    baggs.add(co);
//	                    x += SPACE;
//	                } else if (item == 'u') {
//	                    cu = new u_char(x, y);
//	                    baggs.add(cu);
//	                    x += SPACE;
//	                } else if (item == '.') {
//	                    a = new Area(x, y);
//	                    areas.add(a);
//	                    x += SPACE;
//	                } else if (item == '@') {
//	                    soko = new Player(x, y);
//	                    x += SPACE;
//	                } else if (item == ' ') {
//	                    x += SPACE;
//	                }
//	               }
//	            }
//	    }
//
//	    public void buildWorld(Graphics g) {
//
//	        g.setColor(new Color(250, 240, 170));
//	        g.fillRect(0, 0, this.getWidth(), this.getHeight());
//
//	        
//
//	        ArrayList world = new ArrayList();
//	        world.addAll(walls);
//	        world.addAll(areas);
//	        world.addAll(baggs);
//	        world.add(soko);
//
//			
//
//	        for (int i = 0; i < world.size(); i++) {
//	        	
//	            Actor item = (Actor) world.get(i);
//	            
//	            if ((item instanceof Player)
//	                    || (item instanceof a_char)
//	                    || (item instanceof i_char)
//	                    || (item instanceof e_char)
//	                    || (item instanceof u_char)
//	                    || (item instanceof o_char)) {
//	                g.drawImage(item.getImage(), item.x() + 2, item.y() + 2, this);
//	            } 
//	            else {
//	                g.drawImage(item.getImage(), item.x(), item.y(), this);
//	            }
//
//	            if (completed) {
//	                g.setColor(new Color(0, 0, 0));
//	                g.drawString("Completed", 25, 20);
//	                g.drawString("High Scores              "+"AAA              "+Moves, 630, 80);
//	                g.drawString("Press 'Q' to quit", 200, 30);
//	                g.drawString("Press 'R' to reset and randomize level" , 200, 50);
//	            }
//	            
//	            if (!completed) {
//	                g.setColor(new Color(0, 0, 0));
//	                g.drawString("Moves: "+ Moves, 40, 40);
//	                g.drawString("Timer: "+ count , 40, 60);
//	                g.drawString("Press 'Q' to quit", 200, 30);
//	                g.drawString("Press 'R' to reset and randomize level" , 200, 50);
//	            }
//	           
//
//	        }
//	    }
//
//
//		@Override
//	    public void paint(Graphics g) {
//	        super.paint(g);
//	        buildWorld(g);
//	    }
//
//	    class TAdapter extends KeyAdapter {
//	        
//	        @Override
//	        public void keyPressed(KeyEvent e) {
//
////	            if (completed) {
////	                return;
////	            }
//	            
//	            int key = e.getKeyCode();
//
//
//	            if (key == KeyEvent.VK_LEFT && !completed) {
//	                if (checkWallCollision(soko,
//	                        LEFT_COLLISION)) {
//	                    return;
//	                }
//
//	                if (checkBagCollision(LEFT_COLLISION)) {
////	                		|| checkBagCollision_a(LEFT_COLLISION)||
////	                		checkBagCollision_i(LEFT_COLLISION)||
////	                		checkBagCollision_o(LEFT_COLLISION)||
////	                		checkBagCollision_u(LEFT_COLLISION)||
////	                		checkBagCollision_e(LEFT_COLLISION)) {
//	                    return;
//	                }
//
//	                soko.move(-SPACE, 0);
//	                Moves=Moves+1;
////	        	    Sound sound = SoundFactory.getInstance(MOVE_SOUND);
////	        		SoundFactory.play(sound);
//
//	            } else if (key == KeyEvent.VK_RIGHT && !completed) {
//
//	                if (checkWallCollision(soko,
//	                        RIGHT_COLLISION)) {
//	                    return;
//	                }
//
//	                if (checkBagCollision(RIGHT_COLLISION)) {
////	                		||checkBagCollision_a(RIGHT_COLLISION)||
////	                		checkBagCollision_i(RIGHT_COLLISION)||
////	                		checkBagCollision_o(RIGHT_COLLISION)||
////	                		checkBagCollision_u(RIGHT_COLLISION)||
////	                		checkBagCollision_e(RIGHT_COLLISION)) {
//	                    return;
//	                }
//
//	                soko.move(SPACE, 0);
//	                Moves=Moves+1;
////	        	    Sound sound = SoundFactory.getInstance(MOVE_SOUND);
////	        		SoundFactory.play(sound);
//
//	            } else if (key == KeyEvent.VK_UP && !completed) {
//
//	                if (checkWallCollision(soko,
//	                        TOP_COLLISION)) {
//	                    return;
//	                }
//
//	                if ( checkBagCollision(TOP_COLLISION)) {
//	                    return;
//	                }
//
//	                soko.move(0, -SPACE);
//	                Moves=Moves+1;
////	        	    Sound sound = SoundFactory.getInstance(MOVE_SOUND);
////	        		SoundFactory.play(sound);
//
//	            } else if (key == KeyEvent.VK_DOWN && !completed) {
//
//	                if (checkWallCollision(soko,
//	                        BOTTOM_COLLISION)) {
//	                    return;
//	                }
//
//	                if (checkBagCollision(BOTTOM_COLLISION)) {
////	                		||checkBagCollision_a(BOTTOM_COLLISION)||
////	                		checkBagCollision_i(BOTTOM_COLLISION)||
////	                		checkBagCollision_o(BOTTOM_COLLISION)||
////	                		checkBagCollision_u(BOTTOM_COLLISION)||
////	                		checkBagCollision_e(BOTTOM_COLLISION)) {
//	                    return;
//	                }
//
//	                soko.move(0, SPACE);
//	                Moves=Moves+1;
////	        	    Sound sound = SoundFactory.getInstance(MOVE_SOUND);
////	        		SoundFactory.play(sound);
//
//	            } else if (key == KeyEvent.VK_R) {
//	                restartLevel();
//	            }
//	            else if (key == KeyEvent.VK_Q) {
//	            	System.exit(0);
//	            }
//
//	            repaint();
//	        }
//	    }
//
//	    private boolean checkWallCollision(Actor actor, int type) {
//
//
//	        if (type == LEFT_COLLISION) {
//
//	            for (int i = 0; i < walls.size(); i++) {
//	                Wall wall = (Wall) walls.get(i);
//	                if (actor.isLeftCollision(wall)) {
//	                    return true;
//	                }
//	            }
//	            return false;
//
//	        } else if (type == RIGHT_COLLISION) {
//
//	            for (int i = 0; i < walls.size(); i++) {
//	                Wall wall = (Wall) walls.get(i);
//	                if (actor.isRightCollision(wall)) {
//	                    return true;
//	                }
//	            }
//	            return false;
//
//	        } else if (type == TOP_COLLISION) {
//
//	            for (int i = 0; i < walls.size(); i++) {
//	                Wall wall = (Wall) walls.get(i);
//	                if (actor.isTopCollision(wall)) {
//	                    return true;
//	                }
//	            }
//	            return false;
//
//	        } else if (type == BOTTOM_COLLISION) {
//
//	            for (int i = 0; i < walls.size(); i++) {
//	                Wall wall = (Wall) walls.get(i);
//	                if (actor.isBottomCollision(wall)) {
//	                    return true;
//	                }
//	            }
//	            return false;
//	        }
//	        return false;
//	    }
//	    private boolean checkBagCollision(int type) {
//	    	if (type == LEFT_COLLISION) {
//
//	            for (int i = 0; i < baggs.size(); i++) {
//
//	                Baggage bag = (Baggage) baggs.get(i);
//	                if (soko.isLeftCollision(bag)) {
//
//	                    for (int j=0; j < baggs.size(); j++) {
//	                        Baggage item = (Baggage) baggs.get(j);
//	                        if (!bag.equals(item)) {
//	                            if (bag.isLeftCollision(item)) {
//	                                return true;
//	                            }
//	                        }
//	                        if (checkWallCollision(bag,
//	                                LEFT_COLLISION)) {
//	                            return true;
//	                        }
//	                    }
//	                    bag.move(-SPACE, 0);
//	                    isCompleted();
//	                }
//	            }
//	            return false;
//
//	        } else if (type == RIGHT_COLLISION) {
//
//	            for (int i = 0; i < baggs.size(); i++) {
//
//	                Baggage bag = (Baggage) baggs.get(i);
//	                if (soko.isRightCollision(bag)) {
//	                    for (int j=0; j < baggs.size(); j++) {
//
//	                        Baggage item = (Baggage) baggs.get(j);
//	                        if (!bag.equals(item)) {
//	                            if (bag.isRightCollision(item)) {
//	                                return true;
//	                            }
//	                        }
//	                        if (checkWallCollision(bag,
//	                                RIGHT_COLLISION)) {
//	                            return true;
//	                        }
//	                    }
//	                    bag.move(SPACE, 0);
//	                    isCompleted();                   
//	                }
//	            }
//	            return false;
//
//	        } else if (type == TOP_COLLISION) {
//
//	            for (int i = 0; i < baggs.size(); i++) {
//
//	                Baggage bag = (Baggage) baggs.get(i);
//	                if (soko.isTopCollision(bag)) {
//	                    for (int j = 0; j < baggs.size(); j++) {
//
//	                        Baggage item = (Baggage) baggs.get(j);
//	                        if (!bag.equals(item)) {
//	                            if (bag.isTopCollision(item)) {
//	                                return true;
//	                            }
//	                        }
//	                        if (checkWallCollision(bag,
//	                                TOP_COLLISION)) {
//	                            return true;
//	                        }
//	                    }
//	                    bag.move(0, -SPACE);
//	                    isCompleted();
//	                }
//	            }
//
//	            return false;
//
//	        } else if (type == BOTTOM_COLLISION) {
//	        
//	            for (int i = 0; i < baggs.size(); i++) {
//
//	                Baggage bag = (Baggage) baggs.get(i);
//	                if (soko.isBottomCollision(bag)) {
//	                    for (int j = 0; j < baggs.size(); j++) {
//
//	                        Baggage item = (Baggage) baggs.get(j);
//	                        if (!bag.equals(item)) {
//	                            if (bag.isBottomCollision(item)) {
//	                                return true;
//	                            }
//	                        }
//	                        if (checkWallCollision(bag,
//	                                BOTTOM_COLLISION)) {
//	                            return true;
//	                        }
//	                    }
//	                    bag.move(0, SPACE);
//	                    isCompleted();
//	                }
//	            }
//	        }
//
//	        return false;
//	    }
//
//	    public void isCompleted() {
//	        int num = baggs.size();
//	        int compl = 0;
//
//	        for (int i = 0; i < num; i++) {
//	            Baggage bag = (Baggage) baggs.get(i);
//	            for (int j = 0; j < num; j++) {
//	            	
//	                Area area = (Area) areas.get(j);
////	              compls=true;
//	                if (bag.x() == area.x()
//	                        && bag.y() == area.y()) {
//	               	 	compl += 1;
//	               	 	}
//	                }
////	       	 	if (compls==true)
////	       	 		compls=false;
////	       	 	else if (compls==false) {
////	       	 		compls=true;
////	       	 	}
//	        }
//	        
//	        if (compl == num) {
//	            completed = true;
//	            repaint();
//	    	    Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//	    		SoundFactory.play(sound);
//	        }
//	    }
//	    public void restartLevel() {
//
//	        areas.clear();
//	        baggs.clear();
//	        walls.clear();
//	        Moves=0;
//	        count= 0;
//	        initWorld();
//	        if (completed) {
//	            completed = false;
//	        }
//	    }
//	        
//	 }
	//private boolean checkBagCollision_a(int type) {
		//
//		        if (type == LEFT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                Baggage a_bag = (Baggage) baggs.get(i);
//		               
//		                if (soko.isLeftCollision(a_bag)) {
		//
//		                    for (int j=0; j < baggs.size(); j++) {
//		                        Baggage item = (Baggage) baggs.get(j);
//		                        if (!a_bag.equals(item)) {
//		                            if (a_bag.isLeftCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(a_bag,
//		                                LEFT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    a_bag.move(-SPACE, 0);
//		                   
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    isCompleted();
//		                }
//		            }
//		            return false;
		//
//		        } else if (type == RIGHT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                a_char a_bag = (a_char) baggs.get(i);
//		                if (soko.isRightCollision(a_bag)) {
//		                    for (int j=0; j < baggs.size(); j++) {
		//
//		                        a_char item = (a_char) baggs.get(j);
//		                        if (!a_bag.equals(item)) {
//		                            if (a_bag.isRightCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(a_bag,
//		                                RIGHT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    a_bag.move(SPACE, 0);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            }
//		            return false;
		//
//		        } else if (type == TOP_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                a_char a_bag = (a_char) baggs.get(i);
//		                if (soko.isTopCollision(a_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        a_char item = (a_char) baggs.get(j);
//		                        if (!a_bag.equals(item)) {
//		                            if (a_bag.isTopCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(a_bag,
//		                                TOP_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    a_bag.move(0, -SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    
		// 
//		                }
//		            }
		//
//		            return false;
		//
//		        } else if (type == BOTTOM_COLLISION) {
//		        
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                a_char a_bag = (a_char) baggs.get(i);
//		                if (soko.isBottomCollision(a_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        a_char item = (a_char) baggs.get(j);
//		                        if (!a_bag.equals(item)) {
//		                            if (a_bag.isBottomCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(a_bag,
//		                                BOTTOM_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    a_bag.move(0, SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            }
//		        }
		//
//		        return false;
//		        
//		    }
//		    private boolean checkBagCollision_i(int type) {
//		        if (type == LEFT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
//		            	
//		                i_char i_bag = (i_char) baggs.get(i);
		//
//		                if (soko.isLeftCollision(i_bag)) {
		//
//		                    for (int j=0; j < baggs.size(); j++) {
//		                        i_char item = (i_char) baggs.get(j);
//		                        if (!i_bag.equals(item)) {
//		                            if (i_bag.isLeftCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(i_bag,
//		                                LEFT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    i_bag.move(-SPACE, 0);
//		                   
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    isCompleted();
//		                }
//		            }
//		            return false;
		//
//		        } else if (type == RIGHT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                i_char i_bag = (i_char) baggs.get(i);
//		                if (soko.isRightCollision(i_bag)) {
//		                    for (int j=0; j < baggs.size(); j++) {
		//
//		                        Baggage item = (Baggage) baggs.get(j);
//		                        if (!i_bag.equals(item)) {
//		                            if (i_bag.isRightCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(i_bag,
//		                                RIGHT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    i_bag.move(SPACE, 0);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            }
//		            return false;
		//
//		        } else if (type == TOP_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                i_char i_bag = (i_char) baggs.get(i);
//		                if (soko.isTopCollision(i_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        i_char item = (i_char) baggs.get(j);
//		                        if (!i_bag.equals(item)) {
//		                            if (i_bag.isTopCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(i_bag,
//		                                TOP_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    i_bag.move(0, -SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    
		// 
//		                }
//		            }
		//
//		            return false;
		//
//		        } else if (type == BOTTOM_COLLISION) {
//		        
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                i_char i_bag = (i_char) baggs.get(i);
//		                if (soko.isBottomCollision(i_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        i_char item = (i_char) baggs.get(j);
//		                        if (!i_bag.equals(item)) {
//		                            if (i_bag.isBottomCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(i_bag,
//		                                BOTTOM_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    i_bag.move(0, SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            }
//		        }
		//
//		        return false;
//		        
//		    }
//		    private boolean checkBagCollision_u(int type) {
		//
//		        if (type == LEFT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                u_char u_bag = (u_char) baggs.get(i);
		//
//		                if (soko.isLeftCollision(u_bag)) {
		//
//		                    for (int j=0; j < baggs.size(); j++) {
//		                        u_char item = (u_char) baggs.get(j);
//		                        if (!u_bag.equals(item)) {
//		                            if (u_bag.isLeftCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(u_bag,
//		                                LEFT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    u_bag.move(-SPACE, 0);
//		                   
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    isCompleted();
//		                }
//		            }
//		            return false;
		//
//		        } else if (type == RIGHT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                u_char u_bag = (u_char) baggs.get(i);
//		                if (soko.isRightCollision(u_bag)) {
//		                    for (int j=0; j < baggs.size(); j++) {
		//
//		                        u_char item = (u_char) baggs.get(j);
//		                        if (!u_bag.equals(item)) {
//		                            if (u_bag.isRightCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(u_bag,
//		                                RIGHT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    u_bag.move(SPACE, 0);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            }
//		            return false;
		//
//		        } else if (type == TOP_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                u_char u_bag = (u_char) baggs.get(i);
//		                if (soko.isTopCollision(u_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        u_char item = (u_char) baggs.get(j);
//		                        if (!u_bag.equals(item)) {
//		                            if (u_bag.isTopCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(u_bag,
//		                                TOP_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    u_bag.move(0, -SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    
		// 
//		                }
//		            }
		//
//		            return false;
		//
//		        } else if (type == BOTTOM_COLLISION) {
//		        
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                u_char u_bag = (u_char) baggs.get(i);
//		                if (soko.isBottomCollision(u_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        u_char item = (u_char) baggs.get(j);
//		                        if (!u_bag.equals(item)) {
//		                            if (u_bag.isBottomCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(u_bag,
//		                                BOTTOM_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    u_bag.move(0, SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            }
//		        }
		//
//		        return false;
//		        
//		    }
//		    private boolean checkBagCollision_o(int type) {
		//
		//
//		        if (type == LEFT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                o_char o_bag = (o_char) baggs.get(i);
		//
//		                if (soko.isLeftCollision(o_bag)) {
		//
//		                    for (int j=0; j < baggs.size(); j++) {
//		                        o_char item = (o_char) baggs.get(j);
//		                        if (!o_bag.equals(item)) {
//		                            if (o_bag.isLeftCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(o_bag,
//		                                LEFT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    o_bag.move(-SPACE, 0);
//		                   
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    isCompleted();
//		                }
//		            }
//		            return false;
		//
//		        } else if (type == RIGHT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                o_char o_bag = (o_char) baggs.get(i);
//		                if (soko.isRightCollision(o_bag)) {
//		                    for (int j=0; j < baggs.size(); j++) {
		//
//		                        o_char item = (o_char) baggs.get(j);
//		                        if (!o_bag.equals(item)) {
//		                            if (o_bag.isRightCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(o_bag,
//		                                RIGHT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    o_bag.move(SPACE, 0);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            }
//		            return false;
		//
//		        } else if (type == TOP_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                o_char o_bag = (o_char) baggs.get(i);
//		                if (soko.isTopCollision(o_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        o_char item = (o_char) baggs.get(j);
//		                        if (!o_bag.equals(item)) {
//		                            if (o_bag.isTopCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(o_bag,
//		                                TOP_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    o_bag.move(0, -SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    
		// 
//		                }
//		            }
		//
//		            return false;
		//
//		        } else if (type == BOTTOM_COLLISION) {
//		        
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                o_char o_bag = (o_char) baggs.get(i);
//		                if (soko.isBottomCollision(o_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        o_char item = (o_char) baggs.get(j);
//		                        if (!o_bag.equals(item)) {
//		                            if (o_bag.isBottomCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(o_bag,
//		                                BOTTOM_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    o_bag.move(0, SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            }
//		        }
		//
//		        return false;
//		        
//		    }     
//		    private boolean checkBagCollision_e(int type) {

//		        if (type == LEFT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                e_char e_bag = (e_char) baggs.get(i);
		//
//		                if (soko.isLeftCollision(e_bag)) {
		//
//		                    for (int j=0; j < baggs.size(); j++) {
//		                        e_char item = (e_char) baggs.get(j);
//		                        if (!e_bag.equals(item)) {
//		                            if (e_bag.isLeftCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(e_bag,
//		                                LEFT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    e_bag.move(-SPACE, 0);
//		                   
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    isCompleted();
//		                }
//		            }
//		            return false;
		//
//		        } else if (type == RIGHT_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                e_char e_bag = (e_char) baggs.get(i);
//		                if (soko.isRightCollision(e_bag)) {
//		                    for (int j=0; j < baggs.size(); j++) {
		//
//		                        e_char item = (e_char) baggs.get(j);
//		                        if (!e_bag.equals(item)) 
//		                            if (e_bag.isRightCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(e_bag,
//		                                RIGHT_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    e_bag.move(SPACE, 0);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            
//		            return false;
		//
//		    } else if (type == TOP_COLLISION) {
		//
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                e_char e_bag = (e_char) baggs.get(i);
//		                if (soko.isTopCollision(e_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        e_char item = (e_char) baggs.get(j);
//		                        if (!e_bag.equals(item)) {
//		                            if (e_bag.isTopCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(e_bag,
//		                                TOP_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    e_bag.move(0, -SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                    
		// 
//		                }
//		            }
		//
//		            return false;
		//
//		        } else if (type == BOTTOM_COLLISION) {
//		        
//		            for (int i = 0; i < baggs.size(); i++) {
		//
//		                e_char e_bag = (e_char) baggs.get(i);
//		                if (soko.isBottomCollision(e_bag)) {
//		                    for (int j = 0; j < baggs.size(); j++) {
		//
//		                        e_char item = (e_char) baggs.get(j);
//		                        if (!e_bag.equals(item)) {
//		                            if (e_bag.isBottomCollision(item)) {
//		                                return true;
//		                            }
//		                        }
//		                        if (checkWallCollision(e_bag,
//		                                BOTTOM_COLLISION)) {
//		                            return true;
//		                        }
//		                    }
//		                    e_bag.move(0, SPACE);
//		                    isCompleted();
//		                    Sound sound = SoundFactory.getInstance(BAG_MOVE_SOUND);
//		        	    	SoundFactory.play(sound);
//		        	    	compls=false;
//		                }
//		            }
//		        }
		//
//		        return false;
//		        
//		    }     
	 // a_block as = (a_block) areas.contains(as);
//    i_block is = new i_block(getX(),getY());
//    o_block os = new o_block(getX(),getY());
//    u_block us = new u_block(getX(),getY());
//    e_block es = new e_block(getX(),getY());
//    a_char ac = new a_char(getX(),getY());
//    i_char ic = new i_char(getX(),getY());
//    e_char ec = new e_char(getX(),getY());
//    o_char oc = new o_char(getX(),getY());
//    u_char uc = new u_char(getX(),getY());
//
//	if(is.x()==ic.x()&&is.y()==ic.y()) {
//	    Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//		SoundFactory.play(sound);
//	}
//	else if (is.x()==ic.x()&&is.y()==ic.y()) {
//	    Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//		SoundFactory.play(sound);
//	}
//	else if (es.x()==ec.x()&&es.y()==ec.y()) {
//	    Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//		SoundFactory.play(sound);
//	}
//	else if (os.x()==oc.x()&&os.y()==oc.y()) {
//	    Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//		SoundFactory.play(sound);
//	}
//	else if (us.x()==uc.x()&&us.y()==uc.y()) {
//	    Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//		SoundFactory.play(sound);
//	}
//	else
//		return;
//}
//    if (inZone(A_CHAR)) {
//        return;
//    }
//    if (inZone(I_CHAR)) {
//        return;
//    }
//    if (inZone(O_CHAR)) {
//        return;
//    }
//    if (inZone(U_CHAR)) {
//        return;
//    }
//    if (inZone(E_CHAR)) {
//        return;
//    }
//	private boolean inZone(int type) {
//    	if(type==A_CHAR) {
//    	for (int i = 0; i < baggs.size(); i++) {
//            a_char ca = (a_char) baggs.get(i);
//            a_block ba = (a_block) areas.get(i);
//            if (ca.x()==ba.x()||ca.y()==ba.y()) {
//                Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//         		SoundFactory.play(sound);
//         		return true;
//            }
//    }
//    	}
//    	if(type==I_CHAR) {
//    	for (int i = 0; i < baggs.size(); i++) {
//            i_char ci = (i_char) baggs.get(i);
//            i_block bi = (i_block) areas.get(i);
//            if (ci.x()==bi.x()||ci.y()==bi.y()) {
//                Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//         		SoundFactory.play(sound); 
//            	return true;
//            }
//    }
//    	}
//    	if(type==E_CHAR) {
//    	for (int i = 0; i < baggs.size(); i++) {
//            e_char ce = (e_char) baggs.get(i);
//            e_block be = (e_block) areas.get(i);
//            if (ce.x()==be.x()||ce.y()==be.y()) {
//                Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//         		SoundFactory.play(sound); 
//            	return true;
//            }
//    }
//    	}
//    	if(type==O_CHAR) {
//    	for (int i = 0; i < baggs.size(); i++) {
//            o_char co = (o_char) baggs.get(i);
//            o_block bo = (o_block) areas.get(i);
//            if (co.x()==bo.x()||co.y()==bo.y()) {
//                Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//         		SoundFactory.play(sound);
//            	return true;
//            }
//    }
//    	}
//    	if(type==U_CHAR) {
//    	for (int i = 0; i < baggs.size(); i++) {
//            u_char cu = (u_char) baggs.get(i);
//            u_block bu = (u_block) areas.get(i);
//            if (cu.x()==bu.x()||cu.y()==bu.y()) {
//                Sound sound = SoundFactory.getInstance(DESTINATION_SOUND);
//         		SoundFactory.play(sound); 
//            	return true;
//            }
//    }
//    	}
//    	return false;
//    }
//	package k1Sokoban;
//
//	import java.awt.BorderLayout;
//	import java.awt.Dimension;
//	import java.awt.Toolkit;
//	import java.awt.event.MouseAdapter;
//	import java.awt.event.MouseEvent;
//
//	import javax.swing.ImageIcon;
//	import javax.swing.JFrame;
//	import javax.swing.JLabel;
//
//	@SuppressWarnings("serial")
//	public final class Sokoban extends JFrame {
//
//	    private final int OFFSET = 30;
//	    private boolean splash = true;
//
//	    public Sokoban() {
//	        	InitUI();
//	        	
//	    }
//		private void SplashScreen() {
	//
//	    }
//		public void InitUI() {
//			Board board = new Board();
//			int i=0;
//			for(i=0;i<1;)
//				addMouseListener(new MouseAdapter() {
//						public void mousePressed(MouseEvent e)
//	            {
//				splash=false;
//	            }});
//				
//				JLabel l = new JLabel(new ImageIcon("src/res/Title.png"));
//				getContentPane().add(l, BorderLayout.CENTER);
//				pack();
//		        setSize(board.getBoardWidth() + OFFSET,
//		                board.getBoardHeight() + 2*OFFSET);
//			if (splash==false) {
//				i++;
//		        setLocationRelativeTo(null);
//	        	add(board);
//
//	        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        	setSize(board.getBoardWidth() + OFFSET,
//	        	board.getBoardHeight() + 2*OFFSET);
//	        	setLocationRelativeTo(null);
//	        	setTitle("Sokoban");
//	        	}
//		}
//	           
//
//
//	    public static void main(String[] args) {
//	        Sokoban sokoban = new Sokoban();
//	        sokoban.setVisible(true);
//	    }
//	}
}
