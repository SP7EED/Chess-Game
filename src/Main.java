import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws Exception {
        ChessBoard chessBoard = setChessBoard(); // new clen Chess Board

            System.out.println("Format wpisywania współrzędnych to dokładnie 'x, y'.  // podpisać pola i zmienić na ABC");
            chessBoard.printBoard();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true)  {
                System.out.println("Wprowadź x i y figury z dostępnych powyżej: ");
                Move pos = new Move(br.readLine());

                System.out.println("Możliwe ruchy: ");

                ArrayList<Move> legalMoves = chessBoard.getLegalMoves(pos.getX(), pos.getY());
                if (!legalMoves.isEmpty() && legalMoves != null) {
                    for (Move moves : legalMoves) {
                        System.out.print(moves+ " ");
                    }
                    System.out.println();
                    System.out.println("Wprowadź nx i ny figury: ");
                    Move new_pos = new Move(br.readLine());

                    if (legalMoves.contains(new Move(new_pos.getX(), new_pos.getY()))) {
                        chessBoard.setPiece(pos.getX(), pos.getY(), new_pos.getX(), new_pos.getY());
                        chessBoard.printBoard();
                    } else System.out.println("Nie znaleziono ruchu");
                } else {System.out.println("Brak ruchów");}
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
