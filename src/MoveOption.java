import java.util.ArrayList;

public class MoveOption extends Piece {
    String s_emoji;

    public MoveOption(String s_emoji) {
        this.s_emoji = s_emoji;
    }

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
        return s_emoji;
    }
}
