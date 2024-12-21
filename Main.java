import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();

        // Dodaj figury na planszy
        chessBoard.board[3][4] = new Rook(true);  // Wieża biała
        chessBoard.board[3][0] = new Bishop(true);


        // Pobierz legalne ruchy wieży
        ArrayList<HashMap> legalMoves = chessBoard.getLegalMoves(chessBoard.board[3][4], 3, 4);

        // Wypisz legalne ruchy
        for (HashMap<Integer, Integer> HahshMapa : legalMoves) {
            for (HashMap.Entry<Integer, Integer> entry : HahshMapa.entrySet()) {
                System.out.println("Ruch: "+entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
