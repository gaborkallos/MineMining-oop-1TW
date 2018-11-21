import java.util.*;

// 100 is the not revealed field

class ValidateStep {
    private int[][] userTable; 
    private Queue<Coordinates> outer;

    public ValidateStep(int tableSize) {
        this.outer = new LinkedList<Coordinates>();

        this.userTable = new int[tableSize][tableSize];
        for (int i = 0; i < tablesize; i++) {
            for (int j = 0; j < tablesize; j++) {
                this.userTable[i][j] = 100;
            }
        }
    }
    
    static boolean validateStep(int[][] finalTable, Coordinates c, String select) {
        return (isStep(select) && isNotMine(finalTable, c)); 
    }
    
    static boolean isStep(String select) {
        return (select == "s" || select == "S" );
    }

    static boolean isNotMine(int[][] finalTable, Coordinates c) {
        return (finalTable[c.row][c.col] != 9);
    }
       

    private int[][] updateUserTable(int[][] finalTable, Coordinates c, String select) {
        if (this.userTable[c.row][c.col] != 100) {
            if (finalTable[c.row][c.col] != 0) {
                this.userTable[c.row][c.col] = finalTable[c.row][c.col];
            } else {
                this.addCoordsToQueue(c.row, c.col);
                while (!outer.isEmpty()) {
                    Coordinates checkCoords = outer.poll();
                    this.checkAroundCell(checkCoords, finalTable);
                }     
            }
        }
        return this.userTable;
    }

    private void checkAroundCell(Coordinates checkCoords, int[][] finalTable) {
        for (int newRow = checkCoords.row-1; newRow <= checkCoords.row+1; newRow++) {
            for (int newCol = checkCoords.col-1; newCol <= checkCoords.col+1; newCol++) {
                if (this.userTable[newRow][newColl] !=100) {
                    if (finalTable[newRow][newCol] > 0) {
                        this.userTable[newRow][newCol] = finalTable[newRow][newCol];
                    } 
                    if (newRow == checkCoords.row || newCol == checkCoords.col) {
                        this.userTable[newRow][newCol] = finalTable[newRow][newCol];
                        // check if the coords are already part of outer Queue if not only then add
                        this.addCoordsToQueue(newRow, newCol);
                    }
                }
            }
        }
    }

    private void addCoordsToQueue(int row, int col) {
        Coordinates newCoordinates = new Coordinates();
        newCoordinates.row = row;
        newCoordinate.col = col;
        this.outer.add(newCoordinates);
    }

    private boolean isCoordsNotPartYet(int row, int col) {
        for (int i = 0; i < this.outer.length; i++) {
            if (row == this.outer.get(i).get(0) && col == this.outer.get(i).get(1)) {
                return false;
            }
        }
        return true;
    }
}