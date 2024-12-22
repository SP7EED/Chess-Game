import java.util.ArrayList;

public class ChessBoard {
    Piece[][] board = new Piece[8][8];

    public ArrayList<Move> getLegalMoves(Piece piece, int x, int y) {
//        if (piece == null) Collections.emptyList();
        ArrayList<Move> legalMoves = null;
        try {
            legalMoves = piece.getPotentialMoves(x, y, board);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException in CHessBoard.getLegalMoves()");
        }

        return legalMoves;
    }
}
