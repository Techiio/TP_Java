import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cell {
    private Position position;
    private boolean isEmpty;
    private Piece piece;

    public Cell(int x, int y) {
        this.position = new Position(x, y);
        this.isEmpty = true;
        this.piece = null;
    }

    public boolean isCellEmpty() {
        return this.isEmpty;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Position getPosition() {
        return position;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean getEmpty() {
        return this.isEmpty;
    }

    public void setEmpty(boolean empty) {
        this.isEmpty = empty;
    }

    public String toString() {
        if (this.isEmpty) {
            return "--";
        } else {
            return "" + this.getPiece().getColor() + this.piece.toString();
        }
    }
}
