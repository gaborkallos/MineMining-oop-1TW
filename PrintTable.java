import java.util.*;

class PrintTable {
    static void printTable(Cell[][] actualTable) {
        // linebreak after table config
        System.out.println("");

        // print out the header of the game (column numbers)
        System.out.print("      ");
        for (int c = 0; c < actualTable.length; c++) {
            if (c < 10) {
                    System.out.print("0");
            }
            System.out.print(c + " ");
        }
        System.out.println("");
        
        // print out the separator below the column number
        System.out.print("      ");
        for (int c = 0; c < actualTable.length; c++) {
            System.out.print("___");
        }
        System.out.println("");

        // print each row
        for (int i = 0; i < actualTable.length; i++) {
            // print each row number
            if (i < 10) {
                System.out.print("0");
            }
            System.out.print(i + " ");

            // print separator next to row number
            System.out.print(" | ");

            // print the actual numbers
            for (int j = 0; j < actualTable.length; j++) {
                if (actualTable[i][j].isRevealed()) {
                    if (actualTable[i][j].getValue() == 9) {
                        System.out.print(" " + "\033[41m" + "☀ " + "\033[0m");
                    } else if (actualTable[i][j].getValue() == 0) {
                        System.out.print("\033[90m" + " . " + "\033[37m");
                    } else {
                        System.out.print("\033[33m"+ " " + actualTable[i][j].getValue() + " "+ "\033[37m");
                    }
                } else {
                    System.out.print("\033[42m" + " # " + "\033[0m");
                }
            }
            System.out.print(" | \n");
        }
        // print out the separator below the column number
        System.out.print("      ");
        for (int c = 0; c < actualTable.length; c++) {
            System.out.print("___");
        }
        System.out.println("");        
    }
}