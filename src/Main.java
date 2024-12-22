import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();

        chessBoard.board[3][4] = new Rook(true);
        chessBoard.board[3][0] = new Bishop(true);

        ArrayList<Move> legalMoves = chessBoard.getLegalMoves(chessBoard.board[3][4], 3, 4);

        System.out.println("Test: Możliwe ruchy wieży");
        for (Move moves : legalMoves) {
            System.out.println("Ruch: "+moves);
        }

    }
}
