import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private String name;
    private int color;

    public static ArrayList<String> colors = new ArrayList(Arrays.asList("White", "Black"));

    public Player(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String toString() {
        return this.name;
    }

    public int getColor() {
        return this.color;
    }
}
