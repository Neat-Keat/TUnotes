import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
import java.util.Scanner;

public class Assignment5 {

    public static final int SIZE = 10000;

    public static void main(String[] args) {
        int length;
        int maxSum = 0;
        int[] a = new int[SIZE];
        length = read_values(a);

        int[] sums = new int[length];

        for (int i = 0; i < length; i++) {
            sums[i] = a[i];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j] && sums[i] <= sums[j] + a[i]) {
                    sums[i] = sums[j] + a[i];
                }
            }
        }

        for (int i = 0; i < length; i++) {
            maxSum = Math.max(maxSum, sums[i]);
        }

        System.out.println("Greatest sum of increasing non-contiguous integers: " + maxSum);
    }

     public static int read_values(int a[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input file name: ");
        String fileName = scan.next();
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            int index = 0;
            
            fileScanner.nextInt();  //throw away 1st token, since SIZE = 10000

            while (fileScanner.hasNextInt()) {
                a[index++] = fileScanner.nextInt();
            }
            fileScanner.close();
            return index;
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
        return 0;
     }
}