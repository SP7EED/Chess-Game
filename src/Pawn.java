import java.util.ArrayList;

public class Pawn extends Piece {
    int value = 1;

    // CONSTRUCTORS
    public Pawn() {
        isWhite = true;
    }
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    // TEMPORARY FUNCTIONS FOR GENERATING
    @Override
    public Pawn copyPieceWithDifferentColor() {
        boolean isWhite = this.isWhite;
        return new Pawn(!isWhite);
    }
    public String emoji() {
        return isWhite ? "♟" : "♙";
    }



    // ACTUAL FUNCTIONS
    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = {{0, -1}, {1, -1}, {-1, -1}, {0, -2}};

        return getMovesInDirections(x, y, board, directions);
    }

    @Override
    protected void addMove(ArrayList<Move> moves, int x, int y, int dx, int dy, Piece[][] board) {
        int nx = x + dx;
        int ny;
        ny = isWhite ? y - dy : y + dy;


        if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
            if (nx == x) {
                if (board[nx][ny] == null) {
                    if (dy != -2) {
                        moves.add(new Move(nx, ny));
                    } else if ((isWhite && y == 1) || (!isWhite && y == 6)) {
                        moves.add(new Move(nx, ny));
                    }
                }
            } else {
                if (board[nx][ny] != null && board[nx][ny].isWhite != this.isWhite) {
                    moves.add(new Move(nx, ny));
                }
            }
        }

    } // more complicated functions to add moves to array

}
