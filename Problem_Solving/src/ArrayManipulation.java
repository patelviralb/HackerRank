import java.io.*;
import java.util.*;

public class ArrayManipulation {

  // Complete the arrayManipulation function below.
  static long arrayManipulation(int n, int[][] queries) {
    long maxValue = 0;
    List<Long> arrayValue = new ArrayList<>();
    long temp = 0;

    for (int i = 0; i <= n; i++) {
      arrayValue.add((long) 0);
    }

    for (int[] query : queries) {
      arrayValue.set((query[0]), (arrayValue.get(query[0]) + (long) query[2]));
      if ((query[1] + 1) <= n) {
        arrayValue.set((query[1] + 1), (arrayValue.get(query[1] + 1) - (long) query[2]));
      }
    }

    for (int i = 0; i <= n; i++) {
      temp += arrayValue.get(i);
      if (temp > maxValue) {
        maxValue = temp;
      }
    }

    return maxValue;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[][] queries = new int[m][3];

    for (int i = 0; i < m; i++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 3; j++) {
        int queriesItem = Integer.parseInt(queriesRowItems[j]);
        queries[i][j] = queriesItem;
      }
    }

    long result = arrayManipulation(n, queries);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}