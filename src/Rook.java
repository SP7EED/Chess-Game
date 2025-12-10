import java.util.ArrayList;


public class Rook extends Piece {
    int value = 5; // value

    // CONSTRUCTORS
    public Rook() {
        isWhite = true;
    } // empty construct defines white color
    public Rook(boolean isWhite) {
        super(isWhite);
    } // not empty construct


    // TEMPORARY FUNCTIONS FOR GENERATING
    @Override
    public Rook copyPieceWithDifferentColor() {
        boolean isWhite = this.isWhite;
        return new Rook(!isWhite);
    } // used to create opposite piece with different color
    public String emoji() {
        return isWhite ? "♜" : "♖";
    } // to visualize color of piece




    // ACTUAL FUNCTIONS
    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        return getMovesInDirections(x, y, board, directions);
    }
}
