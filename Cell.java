public class Cell {
    private final int row;
    private final int column;
    private final int value;

    private boolean revealed = false;
    private boolean processed = false;

    public Cell (int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public boolean isProcessed() {
        return processed;
    }

    public boolean isMine() {
        return value == 9;
    }

    public void reveal() {
        revealed = true;
        processed = true;
    }

    void reset() {
        processed = false;
    }
}