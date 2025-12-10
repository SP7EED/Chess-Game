import java.util.ArrayList;

public abstract class Piece {
    boolean isWhite;

    // CONSTRUCTORS
    public Piece() {
        isWhite = true;
    }
    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }




    // FUNCTIONS FOR GENERATING MOVES
    protected ArrayList<Move> getMovesInDirections(int x, int y, Piece[][] board, int[][] directions) {
        ArrayList<Move> moves = new ArrayList<>();

        for (int[] direction : directions) {
            addMove(moves, x, y, direction[0], direction[1], board);
        }

        return moves;
    }
    
    protected void addMove(ArrayList<Move> moves, int x, int y, int dx, int dy, Piece[][] board) {
        int nx = x + dx;
        int ny = y + dy;

        while(nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
            if (board[nx][ny] != null) {
                if (board[nx][ny].isWhite != isWhite) {
                    moves.add(new Move(nx, ny));
                }
                break;
            }
            moves.add(new Move(nx, ny));
            nx += dx;
            ny += dy;
        }
    }




    // TODO
    public ArrayList<Move> validateMovesForCheckmate(int x, int y, Piece[][] board, ArrayList<Move> allMoves) {
        for (Move move : allMoves) {
            Piece[][] boardCopy = new Piece[8][8];
//            wziąć ruchy każdego przeciwnego koloru i powrównać czy są takie same co król
//                    - współrzędne figur
//                    - współrzędne króla
//                    - zrobić porównywarke
            // to-do

            /*
             * Program musi sprawdzać czy król nie jest szachowany, czy nie ma ruchu na pozycje w której będzie szachowany.
             * Musi też sprawdzać czy ruchy innych figur nie prowadzą do szacha, tak aby nie można było swoim ruchem zaszachować własnego króla. -> program musi liczyć to z wyprzedzeniem.
             * */
        }
        return allMoves;
    }
    // I hope there will be mechanic for checking checkmates before outputting valid moves SOMEDAY





    // ABSTRACT FUNCTIONS
    public abstract Piece copyPieceWithDifferentColor();
    public abstract String emoji();

    public abstract ArrayList<Move> getPotentialMoves(int x, int y, Piece[][] board);

}

