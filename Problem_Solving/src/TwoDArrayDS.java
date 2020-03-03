import java.io.*;
import java.util.*;

public class TwoDArrayDS {

  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr) {
    int arrLengthToLoop = arr.length - 2;
    int arrEachRowLength = arr[0].length - 2;
    int largestSum = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0 ; i < arrLengthToLoop ; i++) {
      for (int j = 0 ; j < arrEachRowLength ; j++) {
        sum = arr[i][j] + arr[i][j+1] + arr[i][j+2];
        //System.out.println(arr[i][j] + "\t" + arr[i][j+1] + "\t" + arr[i][j+2]);
        sum += arr[i+1][j+1];
        //System.out.println("\t\t" + arr[i+1][j+1]);
        sum += arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
        //System.out.println(arr[i+2][j] + "\t" + arr[i+2][j+1] + "\t" + arr[i+2][j+2]);
        //System.out.println(sum);

        if (sum > largestSum) {
          largestSum = sum;
        }
      }
      System.out.println();
    }
    return largestSum;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int[][] arr = new int[6][6];

    for (int i = 0; i < 6; i++) {
      String[] arrRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 6; j++) {
        int arrItem = Integer.parseInt(arrRowItems[j]);
        arr[i][j] = arrItem;
      }
    }

    int result = hourglassSum(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}