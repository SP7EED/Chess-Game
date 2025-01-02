import java.util.ArrayList;


public class Rook extends Piece {
    int value = 5;

    public Rook() {
        isWhite = true;
    }
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        return getMovesInDirections(x, y, board, directions);
    }

    public Rook copy() {
        boolean isWhite = this.isWhite;
        return new Rook(!isWhite);
    }

    public String emoji() {
        return isWhite ? "♜" : "♖";
    }
}
