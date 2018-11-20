import java.util.*;

public class Input {

  public int[] coordinate() {
    // TODO validate input
    System.out.println("Input the row: ");
    int row = MineSweeper.scan.nextInt();
    System.out.println("Input the column: ");
    int column = MineSweeper.scan.nextInt();

    int[] result = new int[2];
    result[0] = row;
    result[1] = column;
    return result;
  }

  public String mineOrFlag() {
    //TODO validresult[0] = this.row;result[0] = this.row;ate input
    System.out.println("Do you want to step or flag a mine? (s/f)");
    String mineOrFlag = MineSweeper.scan.next();
    return mineOrFlag;
  }

}
