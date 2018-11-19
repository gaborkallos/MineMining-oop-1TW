import java.util.*;

class GameConfig {
    private final int M = 9;
    private int tableSize;
    private int numberOfMines;

    private int[][] mineTable = {{1,2,2,1,0,0,0,1,M},
                                 {1,M,M,1,0,0,0,1,1},
                                 {1,2,2,1,0,0,0,0,0},
                                 {1,1,1,0,0,0,0,0,0},
                                 {1,M,1,1,2,2,2,1,1},
                                 {1,1,1,1,M,M,2,M,1},
                                 {1,1,1,1,2,2,1,1,1},
                                 {1,M,2,1,2,1,1,0,0},
                                 {1,1,2,M,1,M,1,0,0},
                                 {0,0,1,1,2,1,1,0,0}}; //M is the mine

    //constructor
    public GameConfig(int tableSize, int numberOfMines) {
        this.tableSize = tableSize;
        this.numberOfMines = numberOfMines;
    }

    public int[][] getMineTable() {
        return this.mineTable;
    }

    public int[][] generateTable() {
        int[][] result = new int[this.tableSize][this.tableSize];
        return result;
    }


}

