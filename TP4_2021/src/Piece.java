import java.util.ArrayList;
import java.util.HashMap;

public abstract class Piece {
    private Position position;
    private int color;
    protected HashMap<String, int[]> directions;

    protected void initDirections() {} // Override et non abstract car pas pertinent pour toutes les subclasses

    public Piece(Position position, int color) {
        this.position = position;
        this.color = color;
        initDirections();
    }

    public final Position getPosition() {
        return this.position;
    }

    public final void setPosition(Position position) {
        this.position = position;
    }

    public final int getColor() {
        return this.color;
    }

    public abstract String toString();

    public static final boolean inBoard(int row, int column) {
        if (row >= 0 && row < 8 && column >= 0 && column < 8) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidMove(Position position, Cell[][] board) {
        ArrayList<Cell> imaginableMoves = buildImaginableMoves(board);
        ArrayList<Cell> validMoves = imaginableToValidMoves(imaginableMoves);

        if (validMoves.contains(board[position.getRow()][position.getColumn()])) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean anyMovePossible(Cell[][] board) {
        if (buildImaginableMoves(board).size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean isEdible(Cell[][] board) {
        for (Cell[] cellList : board) {
            for (Cell cell : cellList) {
                if(cell.getPiece().getColor() != this.getColor()) {
                    ArrayList<Cell> imaginableMoves = cell.getPiece().buildImaginableMoves(board);
                    if (imaginableMoves.contains(this)) {
                        System.out.println(cell.toString() + " can eat the attacking Piece " + this.toString());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected abstract ArrayList<Cell> buildImaginableMoves (Cell[][] board);

    protected ArrayList<Cell> buildImaginableMovesQueenBishopKnight(Cell[][] board) {
        ArrayList<Cell> imaginableCells = new ArrayList();

        for (int[] dir : this.directions.values()) {
            int k = 1;
            while (inBoard(this.getPosition().getRow() + k * dir[0], this.getPosition().getColumn() + k * dir[1])) {
                Cell tryCell = board[this.getPosition().getRow() + k * dir[0]][this.getPosition().getColumn() + k * dir[1]];
                imaginableCells.add(tryCell);
                if (!tryCell.isCellEmpty()) {
                    break;
                }
                k++;
            }
        }

        return imaginableCells;
    }

    protected final ArrayList<Cell> imaginableToValidMoves(ArrayList<Cell> imaginableMoves) {
        ArrayList<Cell> validMoves = new ArrayList<>();
        for (int i=0; i<imaginableMoves.size(); i++) {
            Cell tryCell = imaginableMoves.get(i);
            if (tryCell.isCellEmpty()) {
                validMoves.add(imaginableMoves.get(i));
            } else {
                if (tryCell.getPiece().getColor() != this.getColor()) {
                    validMoves.add(imaginableMoves.get(i));
                }
            }
        }
        return validMoves;
    }
}

class King extends Piece {
    public King(Position position, int color) {
        super(position, color);
    }

    public String toString() {
        return "K";
    }

    @Override
    protected ArrayList<Cell> buildImaginableMoves(Cell[][] board) {
        ArrayList<Cell> imaginableCells = new ArrayList();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (Math.abs(this.getPosition().getRow()) - i <= 1 && Math.abs(this.getPosition().getColumn() - j) <= 1) {
                    imaginableCells.add(board[i][j]);
                }
            }
        }
        return imaginableCells;
    }
}

class Queen extends Piece {
    public Queen(Position position, int color) {
        super(position, color);
    }

    public String toString() {
        return "Q";
    }

    @Override
    protected void initDirections() {
        this.directions = new HashMap();
        this.directions.put("topright", new int[]{1, 1});
        this.directions.put("bottomright", new int[]{-1, 1});
        this.directions.put("topleft", new int[]{1, -1});
        this.directions.put("bottomleft", new int[]{-1, -1});
        this.directions.put("top", new int[]{1, 0});
        this.directions.put("right", new int[]{0, 1});
        this.directions.put("bottom", new int[]{-1, 0});
        this.directions.put("left", new int[]{0, -1});
    }

    @Override
    protected ArrayList<Cell> buildImaginableMoves(Cell[][] board) {
        return  buildImaginableMovesQueenBishopKnight(board);
    }
}

class Bishop extends Piece {
    public Bishop(Position position, int color) {
        super(position, color);
    }

    public String toString() {
        return "B";
    }

    @Override
    protected void initDirections() {
        this.directions = new HashMap();
        this.directions.put("topright", new int[]{1, 1});
        this.directions.put("bottomright", new int[]{-1, 1});
        this.directions.put("topleft", new int[]{1, -1});
        this.directions.put("bottomleft", new int[]{-1, -1});
    }

    @Override
    protected ArrayList<Cell> buildImaginableMoves(Cell[][] board) {
        return  buildImaginableMovesQueenBishopKnight(board);
    }
}

class Knight extends Piece {
    public Knight(Position position, int color) {
        super(position, color);
    }

    public String toString() {
        return "N";
    }

    protected ArrayList<Cell> buildImaginableMoves(Cell[][] board) {
        ArrayList<Cell> imaginableCells = new ArrayList();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                int rowDiff = Math.abs(this.getPosition().getRow() - i);
                int columnDiff = Math.abs(this.getPosition().getColumn() - j);
                if ((rowDiff == 1 && columnDiff == 2) || (rowDiff == 2 && columnDiff == 1)){
                    imaginableCells.add(board[i][j]);
                }
            }
        }

        return imaginableCells;
    }
}

class Rook extends Piece {
    public Rook(Position position, int color) {
        super(position, color);
    }

    public String toString() {
        return "R";
    }

    @Override
    protected void initDirections() {
        this.directions = new HashMap();
        this.directions.put("top", new int[]{1, 0});
        this.directions.put("right", new int[]{0, 1});
        this.directions.put("bottom", new int[]{-1, 0});
        this.directions.put("left", new int[]{0, -1});
    }

    @Override
    protected ArrayList<Cell> buildImaginableMoves(Cell[][] board) {
        return  buildImaginableMovesQueenBishopKnight(board);
    }
}

class Pawn extends Piece {
    public Pawn(Position position, int color) {
        super(position, color);
    }

    public String toString() {
        return "P";
    }

    protected ArrayList<Cell> buildImaginableMoves(Cell[][] board) {
        ArrayList<Cell> imaginableCells = new ArrayList();
        for (int i=0; i<board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                if (this.getColor() == 0) {
                    if ((i == this.getPosition().getRow() && j == this.getPosition().getColumn() + 1)
                            || (i == this.getPosition().getRow() && j == this.getPosition().getColumn() + 2 && j == 3)) {
                        if (board[i][j].isCellEmpty()) {
                            imaginableCells.add(board[i][j]);
                        }
                    }
                    if (!board[i][j].isCellEmpty() && Math.abs(i - this.getPosition().getRow()) == 1 && (j == this.getPosition().getColumn() + 1)) {
                        if (board[i][j].getPiece().getColor() != this.getColor()) {
                            imaginableCells.add(board[i][j]);
                        }
                    }
                } else {
                    if ((i == this.getPosition().getRow() && j == this.getPosition().getColumn() - 1)
                            || (i == this.getPosition().getRow() && j == this.getPosition().getColumn() - 2 && j == 4)) {
                        if (board[i][j].isCellEmpty()) {
                            imaginableCells.add(board[i][j]);
                        }
                    }
                    if (!board[i][j].isCellEmpty() && Math.abs(i - this.getPosition().getRow()) == 1 && j == this.getPosition().getColumn() - 1) {
                        if (board[i][j].getPiece().getColor() != this.getColor()) {
                            imaginableCells.add(board[i][j]);
                        }
                    }
                }
            }
        }

        return imaginableCells;
    }
}
