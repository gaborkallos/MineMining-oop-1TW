import java.util.*;

public class UserShow {
    private char[][] showTable;
    private int tableSize;
    private int[] movement;            
    private int[][] gameTable;

    public UserShow(int tableSize, int[][] gameTable) {
        this.tableSize = tableSize;
        this.showTable = new char[this.tableSize][this.tableSize];
        this.gameTable = gameTable;
        fillWithDefault();
    }

    public char[][] calculateShowTable() {
        if (this.gameTable[movement[0]][movement[1]] == 9) {
            this.showTable[movement[0]][movement[1]] = '*';
        } else {
            this.showTable[movement[0]][movement[1]] = Character.forDigit(this.gameTable[movement[0]][movement[1]], 10);
        }
        return this.showTable;
    }
    public void setMove(int[] move) {
        this.movement = move;
    
    }

    public char[][] getPrintTable() {
        return this.showTable;
    }

    private void fillWithDefault() {
        for (int i=0; i<this.tableSize; i++) {
            for (int j=0; j<this.tableSize; j++) {
                this.showTable[i][j] = ' ';
            }
        }
    }

}