import java.util.ArrayList;

public class MoveOption extends Piece {


    public MoveOption() {}

    @Override
    public ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board) {
        return null;
    }

    @Override
    public Piece copy() {
        return null;
    }

    @Override
    public String emoji() {
        return "●";
    }
}
