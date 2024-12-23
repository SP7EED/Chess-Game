import java.util.ArrayList;

public class Pawn extends Piece {
    int value = 1;

    public Pawn() {
        isWhite = true;
    }
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        int[][] directions = {{0, -1}, {1, -1}, {-1, -1}, {0, -2}};

        return getMovesInDirections(x, y, board, directions);
    }

    @Override
    protected void addMove(ArrayList<Move> moves, int x, int y, int dx, int dy, Piece[][] board) {
        int nx = x + dx;
        int ny;
        ny = isWhite ? y + dy : y - dy;


        if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
           Move move;
            if (nx == x) {
                if (board[nx][ny] == null) {
                    if (!(dy == -2 && x != 1 && x != 7)) {
                        moves.add(new Move(nx, ny));
                    }
                }
            } else {
                if (board[nx][ny] != null && board[nx][ny].isWhite != this.isWhite) {
                    moves.add(new Move(nx, ny));
                }
            }
        }

    }

    @Override
    public Pawn copy() {
        boolean isWhite = this.isWhite;
        return new Pawn(!isWhite);
    }
}
