import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Chess {
    private Cell[][] board;
    private Player[] players;
    private Player currentPlayer;
    private ArrayList<Piece> Kings;

    public void play() {
        System.out.println("--- Welcome to Ludo Chess' Game ---");
        while (true) {
            createPlayers();
            initialiseBoard();
            while (!isCheckMate()) {
                printBoard();
                String move;
                do {
                    move = reworkInput(askMove());
                }
                while (!isValidOrder(move));
                updateBoard(move);
                switchPlayer();
            }
        }
    }

    public Cell[][] getBoard() {
        return this.board;
    }

    private void initialiseBoard () {
        this.board = new Cell[8][8];
        for (int x=0; x<this.board.length; x++) {
            for (int y=0; y<this.board[0].length; y++) {
                this.board[x][y] = new Cell(x, y);
            }
        }

        // Mise en place des pieces
        this.board[4][0].setPiece(new King(this.board[4][0].getPosition(), 0));
        this.board[4][7].setPiece(new King(this.board[4][7].getPosition(), 1));
        this.board[3][0].setPiece(new Queen(this.board[3][0].getPosition(), 0));
        this.board[3][7].setPiece(new Queen(this.board[3][7].getPosition(), 1));
        this.board[2][0].setPiece(new Bishop(this.board[2][0].getPosition(), 0));
        this.board[2][7].setPiece(new Bishop(this.board[2][7].getPosition(), 1));
        this.board[5][0].setPiece(new Bishop(this.board[5][0].getPosition(), 0));
        this.board[5][7].setPiece(new Bishop(this.board[5][7].getPosition(), 1));
        this.board[1][0].setPiece(new Knight(this.board[1][0].getPosition(), 0));
        this.board[1][7].setPiece(new Knight(this.board[1][7].getPosition(), 1));
        this.board[6][0].setPiece(new Knight(this.board[6][0].getPosition(), 0));
        this.board[6][7].setPiece(new Knight(this.board[6][7].getPosition(), 1));
        this.board[0][0].setPiece(new Rook(this.board[0][0].getPosition(), 0));
        this.board[0][7].setPiece(new Rook(this.board[0][7].getPosition(), 1));
        this.board[7][0].setPiece(new Rook(this.board[7][0].getPosition(), 0));
        this.board[7][7].setPiece(new Rook(this.board[7][7].getPosition(), 1));
        for (int x=0; x<8; x++) {
            this.board[x][1].setPiece(new Pawn(this.board[x][1].getPosition(), 0));
            this.board[x][6].setPiece(new Pawn(this.board[x][6].getPosition(), 1));
        }

        // On déclare les cellules correspondantes occupées
        int[] busyLinesAtInitialization = new int[] {0, 1, 6, 7};
        for (int i=0; i<8; i++) {
            for (int j=0; j<busyLinesAtInitialization.length; j++) {
                this.board[i][busyLinesAtInitialization[j]].setEmpty(false);
            }
        }

        this.Kings = new ArrayList<>();
        this.Kings.add(this.board[4][0].getPiece());
        this.Kings.add(this.board[4][7].getPiece());
    }

    private void createPlayers() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> colors = new ArrayList(Arrays.asList(0, 1));

        this.players = new Player[2];
        for (int i=0; i<this.players.length; i++) {
            System.out.println("New player, what's your name ?");
            String name = scanner.nextLine();

            Random rand = new Random();
            int color = rand.nextInt(colors.size());
            this.players[i] = new Player(name, colors.get(color));

            if (colors.get(color) == 0) {
                this.currentPlayer = this.players[i];
                System.out.println("Player " + name + " is " + Player.colors.get(colors.get(color)) + " and starts.");
            } else if (colors.get(color) == 1) {
                System.out.println("Player " + name + " is " + Player.colors.get(colors.get(color)) + ".");
            } else {
                System.out.println("Error in color attribution.");
            }
            colors.remove(color);
        }
    }

    private boolean isCheckMate() {
        Piece checkPiece = isCheck();
        if (checkPiece != null) {
            int checkColor = 1 - checkPiece.getColor(); // color of attacking piece
            for (Piece king: this.Kings) {
                if (king.getColor() == checkColor) {
                    if (king.anyMovePossible(this.board) == false) {
                        if (!checkPiece.isEdible(this.board)) {
                            System.out.println("Checkmate");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidOrder(String move) {
        if (move.length() != 7) {
            System.out.println("Moves must look like 'b3 b5' or 'Pb3 Pb5'.");
            return false;
        }
        if (move.charAt(3) != ' ') {
            System.out.println("Moves must look like 'b3 b5' or 'Pb3 Pb5'.");
            return false;
        }
        int row = Position.rowToInt(Character.toUpperCase(move.charAt(1)));
        int column = Character.getNumericValue(move.charAt(2)) - 1;
        if (!Piece.inBoard(row, column)) {
            System.out.println("Order out of board.");
            return false;
        }
        Cell cell = this.board[row][column];
        if (cell.getPiece() == null) {
            System.out.println("You have chosen an empty cell.");
            return false;
        }
        if (cell.getPiece() != null && cell.getPiece().getColor() != this.currentPlayer.getColor()) {
            System.out.println("This piece is not yours.");
            return false;
        }
        int newRow = Position.rowToInt(Character.toUpperCase(move.charAt(5)));
        int newColumn = Character.getNumericValue(move.charAt(6)) - 1;
        if (!Piece.inBoard(newRow, newColumn)) {
            System.out.println("Order out of board.");
            return false;
        }

        Position newPosition = new Position(newRow, newColumn);
        if (cell.getPiece() != null && !cell.getPiece().isValidMove(newPosition, this.board)) {
            System.out.println("The move is not valid.");
            return false;
        }
        return true;
    }

    private void switchPlayer() {
        this.currentPlayer = (this.players[0] == this.currentPlayer ? this.players[1] : this.players[0]);
    }

    private void printBoard() {
        System.out.println("           * Black *       ");
        System.out.println("     A  B  C  D  E  F  G  H ");
        System.out.println("   --------------------------");
        for (int i=this.board[0].length - 1; i>=0; i--) {
            String row = (i + 1) + " | ";
            for (int j=0; j<this.board.length; j++) {
                row += this.board[j][i].toString() + " ";
            }
            System.out.println(row + "| " + (i + 1));
        }
        System.out.println("   --------------------------");
        System.out.println("     A  B  C  D  E  F  G  H ");
        System.out.println("          * White *         ");
    }

    private String askMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.currentPlayer.toString()  + "(" + Player.colors.get(this.currentPlayer.getColor()) + ")" + " what's your move ?");
        String move = scanner.nextLine();
        return move;
    }

    private Piece isCheck() {
        // Check if King is in the imaginable moves of opponent Pieces
        for (Piece king: this.Kings) {
            for (Cell[] cellList: board) {
                for (Cell cell: cellList) {
                    if(!cell.isCellEmpty() && cell.getPiece().getColor() != king.getColor()
                            && cell.getPiece().isValidMove(king.getPosition(), this.board)) {
                        System.out.println("King(" + king.getColor() + ") is check ! (By " + cell.toString() + ")");
                        return cell.getPiece();
                    }
                }
            }
        }
        return null;
    }

    private void updateBoard(String move) {
        int row = Position.rowToInt(Character.toUpperCase((move.charAt(1))));
        int column = Character.getNumericValue(move.charAt(2)) - 1;
        Cell cell = this.board[row][column];
        int newRow = Position.rowToInt(Character.toUpperCase(move.charAt(5)));
        int newColumn = Character.getNumericValue(move.charAt(6)) - 1;
        Cell newCell = this.board[newRow][newColumn];

        cell.getPiece().setPosition(newCell.getPosition()); // On actualise la position de la piece avant de la déplacer
        newCell.setPiece(cell.getPiece()); // On récupère ensuite cette piece sur la nouvelle cellule
        newCell.setEmpty(false); // On indique que la cell n'est plus vide
        cell.setPiece(null); // On vide la cellule d'origine
        cell.setEmpty(true); // On indique que l'ancienne cellule est laissée vide

        isCheck();
    }

    private String reworkInput (String move) {
        if (move.length() == 3) {
            return new StringBuilder().append(move.charAt(0)).append(move.charAt(1)).append(' ').append(move.charAt(2)).append(move.charAt(3)).toString();
        }
        if (move.length() == 4) {
            return new StringBuilder().append('X').append(move.charAt(0)).append(move.charAt(1)).append(' ').append('X').append(move.charAt(2)).append(move.charAt(3)).toString();
        } else if (move.length() == 5) {
            return new StringBuilder().append('X').append(move.charAt(0)).append(move.charAt(1)).append(' ').append('X').append(move.charAt(3)).append(move.charAt(4)).toString();
        } else {
            return move;
        }
    }
}
