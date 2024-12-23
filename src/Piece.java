import java.util.ArrayList;

public abstract class Piece {
    boolean isWhite;

    public Piece() {
        isWhite = true;
    };
    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board);

    protected ArrayList<Move> getMovesInDirections(int x, int y, Piece[][] board, int[][] directions) {
        ArrayList<Move> moves = new ArrayList<>();

        for (int[] direction : directions) {
            addMove(moves, x, y, direction[0], direction[1], board);
        }

//        for (Move move : moves) {
//            move.x += 1;         // szachownica 1-8
//            move.y += 1;
//        }

        return moves;
    }

    protected void addMove(ArrayList<Move> moves, int x, int y, int dx, int dy, Piece[][] board) {
        int nx = x + dx;
        int ny = y + dy;

        while(nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
            Move move;
            if (board[nx][ny] != null) {
                if (board[nx][ny].isWhite != isWhite) {
                    moves.add(new Move(nx, ny));
                }
                break;
            }
            moves.add(new Move(nx, ny));
            nx += dx;
            ny += dy;
        }
    }

    public abstract Piece copy();

}

