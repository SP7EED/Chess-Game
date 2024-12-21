import java.util.ArrayList;
import java.util.HashMap;

public class Knight extends Piece {
    int value = 3;

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<HashMap> getPotentialMoves(int x, int y, Piece[][] board) {
        ArrayList<HashMap> moves = new ArrayList<>();

        addMove(moves, x, y, -2 , 1, board);
        addMove(moves, x, y, 2 , 1, board);
        addMove(moves, x, y, -2 , -1, board);
        addMove(moves, x, y, 2 , -1, board);

        addMove(moves, x, y, 1 , 2, board);
        addMove(moves, x, y, -1 , 2, board);
        addMove(moves, x, y, 1 , -2, board);
        addMove(moves, x, y, -1 , -2, board);

        return moves;
    }

    private void addMove(ArrayList<HashMap> moves, int x, int y, int dx, int dy, Piece[][] board) {
        int nx = x + dx;
        int ny = y + dy;

        if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
            HashMap<Integer, Integer> move = new HashMap<>();
            if (board[nx][ny] != null) {
                if (board[nx][ny].isWhite != isWhite) {
                    move.put(nx, ny);
                    moves.add(move);
                }
            } else {
                move.put(nx, ny);
                moves.add(move);
            }
        }

    }
}
