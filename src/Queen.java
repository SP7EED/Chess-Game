import java.util.ArrayList;

public class Queen extends Piece {
    int value = 9;

    // CONSTRUCTORS
    public Queen() {
        isWhite = true;
    }
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    // TEMPORARY FUNCTIONS FOR GENERATING
    @Override
    public Queen copyPieceWithDifferentColor() {
        boolean isWhite = this.isWhite;
        return new Queen(!isWhite);
    }
    public String emoji() {
        return isWhite ? "♛" : "♕";
    }




    // ACTUAL FUNCTIONS
    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        return getMovesInDirections(x, y, board, directions);
    }
}
