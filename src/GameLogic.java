import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

public class GameLogic {
    Boolean isWhiteTurn = true;

    public void turn(ChessBoard chessBoard) throws IOException {
        System.out.print("Ruch "+(isWhiteTurn ? "białych" : "czarnych")+". ");
        makeMove(chessBoard);
        checkMate();
        isWhiteTurn = !isWhiteTurn;
    }

    private void makeMove(ChessBoard chessBoard) throws IOException {
        while (true) {
            System.out.println("Wprowadź współrzędne x i y: ");
            Move pos = new Move(checkBrake());
            if (chessBoard.board[pos.getX()][pos.getY()] == null) {
                System.out.print("Błąd: puste pole. ");
            }
            else if (chessBoard.board[pos.getX()][pos.getY()].isWhite != isWhiteTurn) {
                System.out.println("Zły kolor figury. Ruch "+(isWhiteTurn ? "białych" : "czarnych")+". ");
            }
            else {
                ArrayList<Move> legalMoves = getLegalMoves(pos.getX(), pos.getY(), chessBoard);
                if (!legalMoves.isEmpty()) {
                    System.out.print("Możliwe ruchy: ");
                    for (Move moves : legalMoves) {
                        System.out.print(moves+ " ");
                        visualMoves(moves.getX(), moves.getY(), chessBoard);
                    }
                    System.out.println();
                    chessBoard.printBoard();
                    for (Move moves : legalMoves) {
                        removeVisualMoves(moves.getX(), moves.getY(), chessBoard);   // też do zmiany, upchnąć kod w funkcji zamiast 2 for each
                    }
                    while (true) {
                        System.out.println("Wprowadź nx i ny figury: ");
                        Move new_pos = new Move(checkBrake());



                        if (legalMoves.contains(new Move(new_pos.getX(), new_pos.getY()))) { // do zmiany na contains.(new_pos)
                            setPiece(pos.getX(), pos.getY(), new_pos.getX(), new_pos.getY(), chessBoard);
                            chessBoard.printBoard();
                            break;
                        } else System.out.print("Nie znaleziono ruchu. ");
                    }
                    break;
                } else {System.out.println("Brak ruchów dla tej figury. ");}
            }
        }
    }



    private void checkMate() {      // and basic check

    }

    public ArrayList<Move> getLegalMoves(int x, int y, ChessBoard chessBoard) {
//        if (piece == null) Collections.emptyList();
        ArrayList<Move> legalMoves = null;
        Piece piece = chessBoard.board[x][y];

        try {
            legalMoves = piece.getPotentialMoves(x, y, chessBoard.board);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException in ChessBoard.getLegalMoves()");
        }

        return legalMoves;
    }

    public static void setPiece(int x, int y, int nx, int ny, ChessBoard chessBoard) {
        chessBoard.board[nx][ny] = chessBoard.board[x][y];
        chessBoard.board[x][y] = null;
    }

    private String checkBrake() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.equals("break")) System.exit(0);
        return s;
    }

    private static void visualMoves(int x, int y, ChessBoard chessBoard) {
        chessBoard.board[x][y] = new MoveOption();
    }

    private static void removeVisualMoves(int x, int y, ChessBoard chessBoard) {
        chessBoard.board[x][y] = null;
    }
}


