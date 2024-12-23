import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard = setChessBoard(); // new clen Chess Board

        ArrayList<Move> legalMoves = chessBoard.getLegalMoves(chessBoard.board[3][4], 3, 4);

        System.out.println("Test: Możliwe ruchy wieży");
        for (Move moves : legalMoves) {
            System.out.println("Ruch: " + moves);
        }

    }

    // sets clean, new ChessBoard
    public static ChessBoard setChessBoard() {
        ChessBoard chessBoard = new ChessBoard();

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
            chessBoard.board[pieces.indexOf(piece)][0] = piece;
            chessBoard.board[pieces.indexOf(piece)][7] = piece.copy();

            chessBoard.board[pieces.indexOf(piece)][1] = new Pawn(true);
            chessBoard.board[pieces.indexOf(piece)][6] = new Pawn(false);
        }
        return chessBoard;
    }
}
