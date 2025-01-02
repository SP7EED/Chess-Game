import java.util.ArrayList;

public class ChessBoard {
    Piece[][] board = new Piece[8][8];

    public ArrayList<Move> getLegalMoves(int x, int y) {
//        if (piece == null) Collections.emptyList();
        ArrayList<Move> legalMoves = null;
        Piece piece = board[x][y];

        try {
            legalMoves = piece.getPotentialMoves(x, y, board);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException in ChessBoard.getLegalMoves()");
        }


        return legalMoves;
    }

    public void printBoard() {

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[j][i] != null) {
                    System.out.print(board[j][i].emoji() + " ");
                } else {
                    System.out.print("▯ ");
                }
            }
            System.out.println();
        }
    }

    public void setPiece(int x, int y, int nx, int ny) {
        board[nx][ny] = board[x][y];
        board[x][y] = null;
    }
}
