/**
https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        char[] map = s.toCharArray();
        int valley = 0;
        int currentLevel = 0;
        boolean isInValley = false;

        for (int i = 0 ; i < n ; i++) {
            if (map[i] == 'D') {
                currentLevel--;
            } else {
                currentLevel++;
            }
            if (currentLevel < 0 && !isInValley) {
                valley++;
                isInValley = true;
            } else if (currentLevel >= 0 && isInValley) {
                isInValley = false;;
            }
        }
        return valley;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}