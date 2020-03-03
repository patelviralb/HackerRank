import java.io.*;
import java.util.*;

public class SparseArrays {

  // Complete the matchingStrings function below.
  static int[] matchingStrings(String[] strings, String[] queries) {
    int stringArraySize = strings.length;
    int queriesArraySize = queries.length;
    int[] answerArray = new int[queriesArraySize];

    Map<String, Integer> stringsMap = new HashMap<>();
    for (String string : strings) {
      if (stringsMap.containsKey(string)) {
        stringsMap.replace(string, stringsMap.get(string) + 1);
      } else {
        stringsMap.put(string, 1);
      }
    }
    //System.out.println("DEBUG: Map data: " + stringsMap.toString());
    int j = 0;
    for (String query : queries) {
      answerArray[j] = stringsMap.getOrDefault(query, 0);
      j++;
    }
    //System.out.println("DEBUG: answerArray: " + answerArray.length);
    return answerArray;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int stringsCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String[] strings = new String[stringsCount];

    for (int i = 0; i < stringsCount; i++) {
      String stringsItem = scanner.nextLine();
      strings[i] = stringsItem;
    }

    int queriesCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String[] queries = new String[queriesCount];

    for (int i = 0; i < queriesCount; i++) {
      String queriesItem = scanner.nextLine();
      queries[i] = queriesItem;
    }

    int[] res = matchingStrings(strings, queries);

    for (int i = 0; i < res.length; i++) {
      bufferedWriter.write(String.valueOf(res[i]));

      if (i != res.length - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}