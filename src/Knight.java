import java.util.ArrayList;

public class Knight extends Piece {
    int value = 3;

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = {{-2, 1}, {2, 1}, {-2, -1}, {2, -1},   {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};

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
}
