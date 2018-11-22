import java.util.*;
import java.lang.Math;

public class MineSweeper {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int[] parameters = getInputs();
        GameConfig game = new GameConfig(parameters[0], parameters[1]);
        int[][] gameTable = game.getMineTable();

        // PrintTable.printTable(gameTable);

        Input in = new Input();     
        Table actualGame = new Table(parameters[0], gameTable);

        do {
            PrintTable.printTable(actualGame.getUserTable());
            String mOrF = in.mineOrFlag();
            int[] coord = in.coordinate();
            if (isStep(mOrF)) {
                System.out.println(mOrF);
                actualGame.reveal(coord[0], coord[1]);
            } else if (isFlag(mOrF)) {
                actualGame.flag(coord[0], coord[1]);
            }      
        } while (true);
    }


    private static boolean isStep(String select) {
        return (select.toLowerCase().contains("s"));
    }

    private static boolean isFlag(String select) {
        return (select == "f" || select == "F");
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
