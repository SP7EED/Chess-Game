import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameLogic {
    Boolean isWhiteTurn = true;
    ArrayList<Piece> whiteFigures = new ArrayList<Piece>();
    ArrayList<Piece> blackFigures = new ArrayList<Piece>();

    // CONSTRUCTOR
    // #1. Spawns black and white pieces on board
    public GameLogic() {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                this.whiteFigures.add(Main.chessBoard.board[j][i]);
                System.out.println(Main.chessBoard.board[j][i]);
            }
        }

        for (int i = 7; i > 5; i--) {
            for (int j = 0; j < 8; j++) {
                this.blackFigures.add(Main.chessBoard.board[j][i]);     // narazie dla sprawdzenia
                System.out.println(Main.chessBoard.board[j][i]);
            }
        }
    }


    // #2. Handles whose turn is, and if current player is checkamted
    public void turn(ChessBoard chessBoard) throws IOException {
        System.out.print("Ruch "+(isWhiteTurn ? "białych" : "czarnych")+". ");

        if (checkMate(isWhiteTurn)) {
            // TODO
            // have to take it into account while getting legal moves
        } else {
            makeMove(chessBoard);
        }

        isWhiteTurn = !isWhiteTurn;
    }




    // USED FUNCTIONS
    private void makeMove(ChessBoard chessBoard) throws IOException {
        while (true) {
            System.out.println("Wprowadź współrzędne x i y: ");
            Move pos = new Move(isGameStopped());

            if (chessBoard.board[pos.getX()][pos.getY()] == null) {
                System.out.print("Błąd: puste pole. ");
            }
            else if (chessBoard.board[pos.getX()][pos.getY()].isWhite != isWhiteTurn) {
                System.out.println("Zły kolor figury. Ruch "+(isWhiteTurn ? "białych" : "czarnych")+". ");
            }
            else {
                ArrayList<Move> legalMoves = getLegalMoves(pos.getX(), pos.getY(), chessBoard);
                if (!legalMoves.isEmpty()) {
                        printOptions(legalMoves, chessBoard);

                    while (true) {
                        System.out.println("Wprowadź nx i ny figury: ");
                        Move new_pos = new Move(isGameStopped());

                        if (legalMoves.contains(new Move(new_pos.getX(), new_pos.getY()))) { // to change on contains.(new_pos)
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

    public ArrayList<Move> getLegalMoves(int x, int y, ChessBoard chessBoard) {
//        if (piece == null) Collections.emptyList();
        ArrayList<Move> legalMoves = new ArrayList<>();
        ArrayList<Move> forbiddenMoves = new ArrayList<>();
        Piece piece = chessBoard.board[x][y];

        try {
            legalMoves = piece.getPotentialMoves(x, y, chessBoard.board);
            forbiddenMoves = piece.validateMovesForCheckmate(x, y, chessBoard.board, legalMoves); // EMPTY FUNCTION
        } catch (NullPointerException e) {
            System.out.println("NullPointerException in ChessBoard.getLegalMoves()");
        }
        // allMoves - forbidden moves, przy okazi różnica do visual
        return legalMoves;
    } // return possible legal moves

    public static void setPiece(int x, int y, int nx, int ny, ChessBoard chessBoard) {
        chessBoard.board[nx][ny] = chessBoard.board[x][y];
        chessBoard.board[x][y] = null;
    } // changes piece position


    // TODO
    // Think how to precalculate potential checkmates
    private boolean checkMate(boolean isWhiteTurn) {      // and basic check
        return false;
    }



    // BOARD EFFECTS
    private static void visualMoves(int x, int y, ChessBoard chessBoard) {
        if (chessBoard.board[x][y] == null) chessBoard.board[x][y] = new MoveOption("▮");
        else chessBoard.board[x][y] = new MoveOption("✖");
    }  // VISUALIZES POSSIBLE MOVES ON MAP
    private static void removeVisualMoves(int x, int y, ChessBoard chessBoard) {
        chessBoard.board[x][y] = null;
    } // HIDES POSSIBLE MOVES AFTER MOVE
    private void printOptions(ArrayList<Move> legalMoves, ChessBoard chessBoard) {
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
    } // SHOWS POSSIBLE MOVES CORDS

    // BREAK
    private String isGameStopped() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.equals("break")) System.exit(0);
        return s;
    } // wpisanie 'break' oznacza zatrzymanie programu
}


