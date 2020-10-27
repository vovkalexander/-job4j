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
    private Board board;
    /**
     * Field - activates user's player .
     */
    private Player player;
    /**
     * Field - activates computer's player .
     */
    private Player playerAi;
    /**
     * Field - stores quality winners of user.
     */
    private int qtyWin;
    /**
     * Constructor for activation fields.
     */

    public Game(Board bord, Player player1, Player player2) {
        this.board = bord;
        this.player = player1;
        this.playerAi = player2;
    }
    /**
     * Overloaded  Constructor for activation fields in additional quality winners of user.
     */

    public Game(Board board, Player player, Player playerAi, int qtyWin) {
        this.board = board;
        this.player = player;
        this.playerAi = playerAi;
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
                qtyWin++;
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
        Player player = new UserPlayer();
        Player playerAi = new AIPlayer();
        Game game = new Game(board, player, playerAi);
        game.play();
    }
}
