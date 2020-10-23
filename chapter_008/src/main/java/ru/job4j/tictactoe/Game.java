package ru.job4j.tictactoe;
/**
 * Food.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Game {
    /**
     * Field - stores link of Board .
     */
    Board board;
    /**
     * Field - activates user's player .
     */
    Player player = new UserPlayer();
    /**
     * Field - activates computer's player .
     */
    Player playerAi = new AIPlayer();
    /**
     * Field - stores quality winners of user.
     */
    int qtyWin;
    /**
     * Constructor for activation fields.
     */
    public Game(Board bord ) {
        this.board = bord;
    }
    /**
     * Overloaded  Constructor for activation fields in additional quality winners of user.
     */
    public Game(Board bord,  int qtyWin ) {
        this.board = bord;
        this.qtyWin = qtyWin;
    }
    /**
     * The method puts mark on Bord.
     * return logical conclusion.
     */

    public boolean play() {
        boolean check = false;
        board.printTable();
        do {
            if (board.checkWin(player.getMark())) {
                qtyWin ++;
                System.out.println("YOU WIN!");
                 System.out.println("at a run " + qtyWin);
                 board.clean();
                 if (qtyWin == 5) {
                     check = true;
                       break;
                  }
            }
            player.turn(board);
            if (board.isTableFull()) {
                System.out.println("Sorry, DRAW!");
                board.clean();
            }
            playerAi.turn(board);
            board.printTable();
            if (board.checkWin(playerAi.getMark())) {
                System.out.println("AI WIN!");
               break;
            }
            if (board.isTableFull()) {
                System.out.println("Sorry, DRAW!");
                board.clean();
            }
        }  while (true);
        System.out.println("GAME OVER.");
        return check;

    }
    public static void main(String[] args) {
        Board board = new ModifyBoard(3);
        Game game = new Game(board);
        game.play();
    }
}
