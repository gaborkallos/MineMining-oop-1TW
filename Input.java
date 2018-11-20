import java.util.*;

public class Input {

  public int[] coordinate() {
    Scanner sc = new Scanner(System.in);
    //TODO validate inpu
    System.out.println("Input the row: ");
    int row = sc.nextInt();
    System.out.println("Input the column: ");
    int column = sc.nextInt();

    int[] result = new int[2];
    result[0] = row;
    result[1] = column;
    return result;
  }

  public String mineOrFlag() {
    Scanner sc = new Scanner(System.in);
    //TODO validresult[0] = this.row;result[0] = this.row;ate input
    System.out.println("Do you want to step or flag a mine? (s/f)");
    String mineOrFlag = sc.next();
    return mineOrFlag;
  }

}
