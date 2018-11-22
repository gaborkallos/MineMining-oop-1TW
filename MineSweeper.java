import java.util.*;
import java.lang.Math;

public class MineSweeper {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int[] parameters = getInputs();
        GameConfig game = new GameConfig(parameters[0], parameters[1]);
        int[][] gameTable = game.getMineTable();
        UserShow ushow = new UserShow(parameters[0], gameTable);
        char[][] showTable = ushow.getPrintTable();
        printTable(gameTable);
        System.out.println();
        printCharTable(showTable);
        Input in = new Input();
        int[] firstMove = in.movement();
        ushow.setMove(firstMove);
        showTable = ushow.calculateShowTable();
        if (checkLose(firstMove, gameTable)) {
            System.out.println("Sorry you lose");
        }
        System.out.println();
        printCharTable(showTable);
        System.out.println(Arrays.toString(firstMove));

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

    public static void printTable(int[][] gameTable){
        for (int[] line : gameTable){
            System.out.println(Arrays.toString(line));
        }
    }

    public static boolean checkLose(int[] move, int[][] table){
        if (table[move[0]][move[1]] == 9) {
            return true;
        } else {
            return false;
        }

    }

    public static void printCharTable(char[][] gameTable){
        for (char[] line : gameTable){
            System.out.println(Arrays.toString(line));
        }

    }
}
