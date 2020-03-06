import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'dynamicArray' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY queries
   */

  public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
    int lastAnswer = 0;
    List<Integer> lastAnswers = new ArrayList<>();
    List<Integer> eachSequence;
    List<List<Integer>> sequenceList = new ArrayList<>();

    for(int i = 0 ; i < n ; i++) {
      sequenceList.add(i,new ArrayList<>());
    }

    for(List<Integer> eachQuery : queries) {
      int queryType = eachQuery.get(0);
      int xValue = eachQuery.get(1);
      int yValue = eachQuery.get(2);

      eachSequence = new ArrayList<>();

      int index = (xValue ^ lastAnswer) % n;
      int sequenceSize = sequenceList.size();

      if (queryType == 1) {
        if (index < sequenceSize && !sequenceList.get(index).isEmpty()) {
          eachSequence = sequenceList.get(index);
        }
        eachSequence.add(yValue);
        sequenceList.set(index, eachSequence);
      } else if (queryType == 2) {
        if (sequenceList.get(index).isEmpty()) {
          continue;
        }
        eachSequence = sequenceList.get(index);
        int valueToFindIndex = yValue % eachSequence.size();
        if (valueToFindIndex <= eachSequence.size()) {
          lastAnswer = eachSequence.get(valueToFindIndex);
          lastAnswers.add(lastAnswer);
        }
      }
    }

    return lastAnswers;
  }

}

public class DynamicArray {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int q = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, q).forEach(i -> {
      try {
        queries.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    List<Integer> result = Result.dynamicArray(n, queries);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}