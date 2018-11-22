import java.util.ArrayList;

public class Table {
    private final Cell[][] cells;

    public Table(int rows, int columns, int[][] finalTable) {
        cells = new Cell[rows][columns];
        int[][] generated = finalTable;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new Cell(row, column, generated[row][column]);
            }
        }
    }

    public Table(int size, int[][] finalTable) {
        this(size, size, finalTable);
    }


    Cell[][] getUserTable() {
        return cells;
    }


    public void reveal(int row, int column) {
        if(cells[row][column].isRevealed())
            return;
        // reset();
        final Cell clicked = cells[row][column];
        clicked.reveal();
        if (clicked.isMine()) {
            gameOver(clicked);
            return;
        }
        if (clicked.getValue() == 0) {
            revealAround(clicked);
        }
    }

    public void flag(int row, int column) {
        if(cells[row][column].isRevealed())
            return;
        reset();
    }

    public void revealAround(Cell cell) {
        final Cell[] neighbours = neighboursFor(cell);
        for (Cell neighbour : neighbours) {
            if(!neighbour.isRevealed() &&
               !neighbour.isMine() &&
               !neighbour.isProcessed()) {
                    neighbour.reveal();
                    if (neighbour.getValue() == 0) {
                        revealAround(neighbour);
                    }
                }
            }
        }

    private Cell[] neighboursFor(Cell cell) {
        int row = cell.getRow();
        int col = cell.getColumn();
        ArrayList<Cell> neighbours = new ArrayList<Cell>();
        for (int k = -1; k <=1; k++) {
            for (int l = -1; l <=1; l++) {
                if (row+k >= 0 && row+k < cells.length && col+l >= 0 && col+l < cells.length) {
                    if (k != 0 && l != 0) {
                        System.out.println("around");
                        System.out.print(cells[row+k][col+l].getRow());
                        System.out.print(" - ");
                        System.out.print(cells[row+k][col+l].getColumn());
                        neighbours.add(cells[row+k][col+l]);
                    }
                }
            }
        }

        Cell[] newArray = new Cell[neighbours.size()];
        for (int i = 0; i < neighbours.size(); i++) {
            newArray[i] = neighbours.get(i);
        }
        return newArray;
    
    }

    private boolean gameOver(Cell cell) {
        System.out.println("GameOver!");
        return false;
    }

    private void reset() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.reset();
            }
        }
    }
}