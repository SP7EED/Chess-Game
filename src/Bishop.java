import java.util.ArrayList;

public class Bishop extends Piece {
    int value = 3;

    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        return getMovesInDirections(x, y, board, directions);
    }
}
