import java.util.ArrayList;

// TODO - how to remove this unnecessary class
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
    public Piece copyPieceWithDifferentColor() {
        return null;
    }

    @Override
    public String emoji() {
        return s_emoji;
    }

    // I don't know yet what is this class for but will tag it when I figure out
}
