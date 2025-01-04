
public class Main {
    public static void main(String[] args) throws Exception {
        ChessBoard chessBoard = new ChessBoard(); // new clen Chess Board
        GameLogic gl = new GameLogic();
        chessBoard.printBoard();

        while (true) {
            gl.turn(chessBoard);
        }

    }




}
