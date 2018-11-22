import java.util.*;

class PrintTable {
    static void printTable(Cell[][] actualTable) {
        for (Cell[] line : actualTable) {
            for (Cell field: line) {
                if (field.getValue() == 9) {
                    System.out.print(" ☀");
                } else if (field.getValue() == 0) {
                    System.out.print(" _");
                } else if (field.getValue() == 100) {
                    System.out.print("  ");
                } else {
                    System.out.print(" " + field.getValue());
                }
             
            }
        System.out.println("");  
        }
    }
}