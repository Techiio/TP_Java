import java.util.ArrayList;
import java.util.Arrays;

public class Position {
    private int row;
    private int column;

    private static ArrayList<Character> letters = new ArrayList(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'));

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public String toString() {
        return this.letters.get(this.row).toString() + (this.column + 1);
    }

    public static int rowToInt(Character character) {
        return Position.letters.indexOf(character);
    }
}
