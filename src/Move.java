import java.util.Objects;

public class Move {
    int x;
    int y;
    String chessX = intToChessStringCord(x);
    int chessY = y+1;

    // CONSTRUCTORS
    public Move() {}
    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Move(String s) {
        String[] stringsTab = s.replaceAll(" ", "").split("");
        try {
            this.x = stringsTab[0].matches("\\d") ? Integer.parseInt(stringsTab[0]) : chessStringCordToInt(stringsTab[0]);
            this.y = Integer.parseInt(stringsTab[1])-1;
        } catch (NumberFormatException e) {System.out.println("NumberFormatException in Move constructor");}
    } // constructor able to decode chess cords into x and y



    // TODO - what is that for?
    @Override // idk for what is this, but sure its important
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return x == move.x && y == move.y;
    }



    // FORMATTING CORDS HASHES, DECODING CORDS
    @Override
    public String toString() {
        return "(" + intToChessStringCord(x) + ", " + (y+1) + ")";
    } // CORD TO STRING
    public String intToChessStringCord(int a) {
        return switch (a) {
            case 0: yield "\uD835\uDDD4";
            case 1: yield "B";
            case 2: yield "C";
            case 3: yield "D";
            case 4: yield "E";
            case 5: yield "F";
            case 6: yield "G";
            case 7: yield "H";

            default:
                throw new IllegalStateException("Unexpected value: " + a);
        };
    }
    public int chessStringCordToInt(String a) {
        return switch (a.toUpperCase()) {
            case "A": yield 0;
            case "B": yield 1;
            case "C": yield 2;
            case "D": yield 3;
            case "E": yield 4;
            case "F": yield 5;
            case "G": yield 6;
            case "H": yield 7;
            default:
                System.out.println("Błędna współrzędna. ");
                yield 0;
        };
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    // GET/SET X and Y
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
