import java.util.*;

class PrintTable {
    static void printTable(int[][] actualTable) {
        for (int[] line : actualTable) {
            for (int field: line) {
                if (field == 9) {
                    System.out.print(" ☀");
                } else if (field == 0) {
                    System.out.print(" _");
                } else if (field == 100) {
                    System.out.print("  ");
                } else {
                    System.out.print(" " + field);
                }
             
            }
        System.out.println("");  
        }
    }
}