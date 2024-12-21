import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ChessBoard {
    Piece[][] board = new Piece[8][8];

    public ArrayList<HashMap> getLegalMoves(Piece piece, int x, int y) {
        if (piece == null) Collections.emptyList();
        ArrayList<HashMap> legalMoves = piece.getPotentialMoves(x, y, board);

        return legalMoves;
    }
}
