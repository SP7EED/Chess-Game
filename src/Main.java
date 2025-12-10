
public class Main {
    public static ChessBoard chessBoard;

    public static void main(String[] args) throws Exception {

        // PREPARING GAME
        chessBoard = new ChessBoard(); // new clen Chess Board
        GameLogic gl = new GameLogic();
        chessBoard.printBoard();



        while (true) {
            gl.turn(chessBoard);
        }

    }




}
