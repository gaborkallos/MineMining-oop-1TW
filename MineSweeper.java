import java.util.*;
import java.lang.Math;

public class MineSweeper {
    public static void main(String[] args) {
        int[] parameters = getInputs();
        GameConfig game = new GameConfig(parameters[0], parameters[1]);
        int[][] gameTable = game.getMineTable();
        printTable(gameTable);

    }
    private static int[] getInputs(){
        Scanner readSize = new Scanner(System.in);
        int size;
        do {
            size = getPlayerInput(readSize, "tablesize (1-50)");
        } while (size>50 || size<1);
        int numberOfMine;
        do {
            numberOfMine = getPlayerInput(readSize, "number of mines (more than 0)");
        } while (numberOfMine<=0);
        if (numberOfMine >= Math.pow(size, 2)){
            numberOfMine = (int)Math.pow(size, 2)-1;
        }
        if (size == 1){
            numberOfMine = 1;
        }
        readSize.close();
        int[] inputs = {size, numberOfMine};
        return inputs;
    }


    private static int getPlayerInput(Scanner readSize, String nameOfInput) {
        System.out.println("Please enter " + nameOfInput + "!");
        int size = readSize.nextInt();
        return size;
    }

    public static void printTable(int[][] gameTable){
        for (int[] line : gameTable){
            System.out.println(Arrays.toString(line));
        }

    }
}
