import java.util.ArrayList;

public class ChessBoard {
    Piece[][] board = new Piece[8][8];


    // sets clean, new ChessBoard
    public ChessBoard() {

        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Rook());
        pieces.add(new Knight());
        pieces.add(new Bishop());
        pieces.add(new Queen());
        pieces.add(new King());
        pieces.add(new Bishop());
        pieces.add(new Knight());
        pieces.add(new Rook());

        for (Piece piece : pieces) {
            board[pieces.indexOf(piece)][0] = piece;
            board[pieces.indexOf(piece)][7] = piece.copy();

            board[pieces.indexOf(piece)][1] = new Pawn(true);
            board[pieces.indexOf(piece)][6] = new Pawn(false);
        }
    }

    public void printBoard() {
        for (int i = 7; i >= 0; i--) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < 8; j++) {
                if (board[j][i] != null) {
                    System.out.print(board[j][i].emoji() + " ");
                } else {
                    System.out.print("▯ ");
                }
            }
            System.out.println();
        }
        System.out.print("  \u200A");
        for (int i=0; i < 8; i++) {
            System.out.print((new Move().intToChessStringCord(i))+"\u2002"+"\u2002");
        }
        System.out.println();
    }

}
