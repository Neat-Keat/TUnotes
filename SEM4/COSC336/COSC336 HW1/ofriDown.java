import java.util.Scanner;
public class ofriDown {

        public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = 0;
        int[] input = new int[100];
        System.out.print("Enter a sequence of integers to be analyzed, 999 to stop  ");
        int num = getInt(s);
        while (num != 999) {
            input[length] = num;
            num = getInt(s);
            length++;
        }
        int[] solution = new int[length];
        int[] sequence = new int[length];
        int min = solution[0];
        int endIndex = 0;
        for (int i = 0; i < length; i++) {
            solution[i] = 1;
            sequence[i] = i;
        }
        for (int j = length - 2; j >= 0; j--) {
            for (int k = j + 1; k < length; k++) {
                if (input[j] > input[k] && solution[j] < 1 + solution[k]) {
                    solution[j] = Math.max(solution[j], 1 + solution[k]);
                    sequence[j] = k;
                }
            }
        }
        for (int i = 1; i < length; i++) {
            if (solution[i] > min) {
                min = solution[i];
                endIndex = i;
            }
        }
        int current = endIndex;
        System.out.println("The length of the longest decreasing subsequence is: " + min);
        System.out.print("The longest decreasing subsequence is: [");
        for (current = endIndex; current != sequence[current]; current = sequence[current]) {
            System.out.print(input[current] + " ");
        }
        System.out.print(input[current]);
        System.out.print("]");
    }

    public static int getInt(Scanner s) {
        while (!s.hasNextInt()) {
            s.next();
            System.out.print("This is not an integer, try again");
        }
        return s.nextInt();
    }
}