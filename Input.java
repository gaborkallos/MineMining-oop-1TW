import java.util.*;

public class Input {
    int[] userMove = new int[3];

  public int[] movement() {
    // TODO validate input
    System.out.println("Input the row: ");
    userMove[0] = MineSweeper.scan.nextInt();
    System.out.println("Input the column: ");
    userMove[1] = MineSweeper.scan.nextInt();
    System.out.println("If you want to flag, enter 'f', otherwise press anything else");
    String mineOrFlag = MineSweeper.scan.next();
    if (mineOrFlag.contains("f")) {userMove[2] = 1;}
    return userMove;
  }

}
