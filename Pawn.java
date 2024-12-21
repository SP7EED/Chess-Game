import java.util.ArrayList;
import java.util.HashMap;

public class Pawn extends Piece {
    int value = 1;

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public ArrayList<HashMap> getPotentialMoves(int x, int y, Piece[][] board) {
        ArrayList<HashMap> moves = new ArrayList<>();

            addMove(moves, x , y, 0, -1, board);
            addMove(moves, x, y, 1, -1, board);
            addMove(moves, x, y, -1, -1, board);
            if ((isWhite && y == 7) || (!isWhite && y == 1)) {
                addMove(moves, x, y, 0, -2, board);
            }

        return moves;
    }
    private void addMove(ArrayList<HashMap> moves, int x, int y, int dx, int dy, Piece[][] board) {
        int nx = x + dx;
        int ny;
        ny = isWhite ? y + dy : y - dy;


        if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
            HashMap<Integer, Integer> move = new HashMap<>();
            if (nx == x) {
                if (board[nx][ny] == null) {
                    move.put(nx, ny);
                    moves.add(move);
                }
            } else {
                if (board[nx][ny] != null && board[nx][ny].isWhite != this.isWhite) {
                    move.put(nx, ny);
                    moves.add(move);
                }
            }
        }

    }
}
