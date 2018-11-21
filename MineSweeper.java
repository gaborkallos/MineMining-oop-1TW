import java.util.*;
import java.lang.Math;

public class MineSweeper {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int[] parameters = getInputs();
        GameConfig game = new GameConfig(parameters[0], parameters[1]);
        int[][] gameTable = game.getMineTable();
        PrintTable.printTable(gameTable);

        Input in = new Input();
        in.coordinate();
        in.mineOrFlag();
        scan.close();
    }
    private static int[] getInputs(){
        int size;
        do {
            size = getPlayerInput("tablesize (1-50)");
        } while (size>50 || size<1);
        int numberOfMine;
        do {
            numberOfMine = getPlayerInput("number of mines (more than 0)");
        } while (numberOfMine<=0);
        if (numberOfMine >= Math.pow(size, 2)){
            numberOfMine = (int)Math.pow(size, 2)-1;
        }
        if (size == 1){
            numberOfMine = 1;
        }
        int[] inputs = {size, numberOfMine};
        
        return inputs;
    }


    private static int getPlayerInput(String nameOfInput) {
        System.out.println("Please enter " + nameOfInput + "!");
        int size = scan.nextInt();
        return size;
    }
}
