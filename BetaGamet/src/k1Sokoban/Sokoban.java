package k1Sokoban;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public final class Sokoban extends JFrame {

    private final int OFFSET = 30;

    //constructor that initiates the InitUI
    public Sokoban() {
        InitUI();
    }
//InitUI displays all that is happening in the board class
    public void InitUI() {
        Board board = new Board();
        add(board);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2*OFFSET);
        setLocationRelativeTo(null);
        setTitle("Sokoban");
    }

//enables the JFrame to be visible
    public static void main(String[] args) {
        Sokoban sokoban = new Sokoban();
        sokoban.setVisible(true);
    }
}
