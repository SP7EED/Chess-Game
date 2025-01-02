import java.util.Objects;

public class Move {
    int x;
    int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Move(String s) {
        String[] stringsTab = s.split(",\\s*");
        try {
            this.x = Integer.parseInt(stringsTab[0]);
            this.y = Integer.parseInt(stringsTab[1]);
        } catch (NumberFormatException e) {System.out.println("NumberFormatException in Move constructor");}
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return x == move.x && y == move.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

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
