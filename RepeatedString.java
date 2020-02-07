/**
https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        char[] charArray = s.toCharArray();
        long stringLength = s.length();
        long countOfA = 0;
        for (int i = 0 ; i < stringLength ; i++) {
            if (charArray[i] == 'a') {
                countOfA++;
            }
        }
        //System.out.println(countOfA);
        long tempLength = n % stringLength;
        long tempCount = 0;
        //System.out.println("tempLength:\t" + tempLength + "\ttempCount:\t" + tempCount + "\t(n / stringLength):\t" + (n / stringLength));
        if (tempLength != 0) {
            for (int i = 0 ; i < tempLength ; i++) {
                if (charArray[i] == 'a') {
                    tempCount++;
                }
            }
        }
        countOfA = (countOfA * (n / stringLength)) + tempCount;
        //System.out.println(countOfA);
        return countOfA;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}