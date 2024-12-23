import java.util.ArrayList;

public class King extends Piece {

    public King() {
        isWhite = true;
    }
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

        return getMovesInDirections(x, y, board, directions);
    }

    @Override
    protected void addMove(ArrayList<Move> moves, int x, int y, int dx, int dy, Piece[][] board) {
        int nx = x + dx;
        int ny = y + dy;

        if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
            Move move;
            if (board[nx][ny] != null) {
                if (board[nx][ny].isWhite != isWhite) {
                    moves.add(new Move(nx, ny));
                }
            } else {
                moves.add(new Move(nx, ny));
            }
        }

    }
    @Override
    public King copy() {
        boolean isWhite = this.isWhite;
        return new King(!isWhite);
    }
}
