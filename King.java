import java.util.ArrayList;
import java.util.HashMap;

public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<HashMap> getPotentialMoves(int x, int y, Piece[][] board) {
        ArrayList<HashMap> moves = new ArrayList<>();

        addMove(moves, x, y, 1, 0, board);
        addMove(moves, x, y, -1, 0, board);
        addMove(moves, x, y, 0, 1, board);
        addMove(moves, x, y, 0, -1, board);

        addMove(moves, x, y, 1, 1, board);
        addMove(moves, x, y, -1, -1, board);
        addMove(moves, x, y, 1, -1, board);
        addMove(moves, x, y, -1, 1, board);

        return moves;
    }
    private void addMove(ArrayList<HashMap> moves, int x, int y, int dx, int dy, Piece[][] board) {
        int nx = x + dx;
        int ny = y + dy;

        while(nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
            HashMap<Integer, Integer> move = new HashMap<>();
            if (board[nx][ny] != null) {
                if (board[nx][ny].isWhite != isWhite) {
                    move.put(nx, ny);
                    moves.add(move);
                    break;
                }
                break;
            }
            move.put(nx, ny);
            moves.add(move);
            nx += dx;
            ny += dy;
        }
    }
}
