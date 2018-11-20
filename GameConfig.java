import java.util.*;
import com.sun.org.apache.xpath.internal.SourceTree;

class GameConfig {
    private final int M = 9;
    private int tableSize;
    private int numberOfMines;
    private int[][] mineTable;
    
    //constructor
    public GameConfig(int tableSize, int numberOfMines) {
        this.tableSize = tableSize;
        this.numberOfMines = numberOfMines;
        this.mineTable = new int[this.tableSize][this.tableSize];
        generateMines();
        generateNumbers();
    }

    public int[][] getMineTable() {
        return this.mineTable;
    }

    public void generateMines() {
        int counter = 0;
        Random r = new Random();
        while (counter<this.numberOfMines){
            int xCordinate = r.nextInt(this.tableSize);
            int yCordinate = r.nextInt(this.tableSize);
            if (this.mineTable[xCordinate][yCordinate] == 0){
                this.mineTable[xCordinate][yCordinate] = M;
                counter++;
            }
        }
    }
    public void generateNumbers(){
        for (int i=0; i< this.tableSize; i++){
            for( int j=0; j< this.tableSize; j++ ){
                if (this.mineTable[i][j] == M){
                    for (int k = -1; k<=1; k++){
                        for (int l = -1; l<=1; l++){
                            if (i+k>=0 && i+k<this.tableSize){
                                if (j+l>=0 && j+l<this.tableSize){
                                    if (this.mineTable[i+k][j+l]!=M){
                                        this.mineTable[i+k][j+l]++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

