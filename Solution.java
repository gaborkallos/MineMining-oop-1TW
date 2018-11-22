import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHourGlass = -999999;
        // d coordinates is [y;x] where y defines the row, x the col
        for (int y = 1; y <=4; y++) {
            for (int x = 1; x <= 4; x++) {
                // calculate each the sum of values of each hourglass
                int hourglass = 0 - arr[y][x-1] - arr[y][x+1];
                for (int rows = y-1; rows <= y+1; rows++) {
                    for (int cols = x-1; cols <= x+1; cols++) {
                        hourglass += arr[rows][cols];
                        }
                    }
                System.out.println(hourglass);
                // if the sum of values of the actuall hourglass is greater than the max, add it
                if (hourglass > maxHourGlass) {
                maxHourGlass = hourglass;
                }
            }    
        }
    return maxHourGlass;
    }


    public static void main(String[] args) throws IOException {

        int[][] multi = new int[][]{
            {1,1,1,0,0,0},
            {0,1,0,0,0,0},
            {1,1,1,0,0,0},
            {0,0,2,4,4,0},
            {0,0,0,2,0,0},
            {0,0,1,2,4,0},
        };

        int[][] multi2 = new int[][]{
            {-1, -1, 0, -9, -2, -2},
            {-2, -1, -6, -8, -2, -5},
            {-1, -1, -1, -2, -3, -4},
            {-1, -9, -2, -4, -4, -5},
            {-7, -3, -3, -2, -9, -9},
            {-1, -3, -1, -2, -4, -5}
        };

    System.out.println(hourglassSum(multi2));  // result wil be 19
    }
}
