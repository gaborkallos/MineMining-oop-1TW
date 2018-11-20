import java.util.*;

public class MineSweeper {
    public static void main(String[] args) {
        Scanner readSize = new Scanner(System.in);
        int size = getPlayerInput(readSize, "tablesize");
        int numberOfMine = getPlayerInput(readSize, "number of mines");
        GameConfig game = new GameConfig(size, numberOfMine);
        int[][] gameTable = game.getMineTable();
        printTable(gameTable);

        Input in = new Input();
        in.coordinate();
        in.mineOrFlag();

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
