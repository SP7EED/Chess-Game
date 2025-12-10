import java.util.ArrayList;

public class Bishop extends Piece {
    int value = 3;

    // CONSTRUCTORS
    public Bishop() {
        isWhite = true;
    }
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    // TEMPORARY FUNCTIONS FOR GENERATING
    @Override
    public Bishop copyPieceWithDifferentColor() {
        boolean isWhite = this.isWhite;
        return new Bishop(!isWhite);
    }
    public String emoji() {
        return isWhite ? "♝" : "♗";
    }




    // ACTUAL FUNCTIONS
    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        return getMovesInDirections(x, y, board, directions);
    }
}
