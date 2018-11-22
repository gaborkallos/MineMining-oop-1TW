import java.util.*;

class PrintTable {
    static void printTable(Cell[][] actualTable) {
        for (Cell[] line : actualTable) {
            for (Cell field: line) {
                if (field.isRevealed()) {
                    if (field.getValue() == 9) {
                        System.out.print(" ☀");
                    } else if (field.getValue() == 0) {
                        System.out.print(" _");
                    } else {
                        System.out.print(" " + field.getValue());
                    }
                } else {
                    System.out.print(" ·");
                }
                
             
            }
        System.out.println("");  
        }
    }
}