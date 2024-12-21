import java.util.ArrayList;
import java.util.HashMap;

public abstract class Piece {
    boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract ArrayList<HashMap> getPotentialMoves(int x, int y, Piece[][] board);
}

