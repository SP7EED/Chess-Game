import java.util.ArrayList;

public class Queen extends Piece {
    int value = 9;
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        return getMovesInDirections(x, y, board, directions);
    }
}
