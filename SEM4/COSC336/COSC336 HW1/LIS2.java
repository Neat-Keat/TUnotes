/*
10 9 2 5 3 101 7 18

186 359 274 927 890 520 571 310 916 798 732 23 196 579
426 188 524 991 91 150 117 565 993 615 48 811 594 303 191
505 724 818 536 416 179 485 334 74 998 100 197 768 421
114 739 636 356 908 477 656

318 536 390 598 602 408 254 868 379 565 206 619 936 195
123 314 729 608 148 540 256 768 404 190 559 1000 482 141 26
230 550 881 759 122 878 350 756 82 562 897 508 853 317
380 807 23 506 98 757 247
 */

import java.util.*;

import javax.sound.midi.Sequence;

public class LIS2 {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int length = 0;
        int [] input = new int[100];
        System.out.print("Enter a sequence of integers to be analyzed, -1 to stop  ");
        int num = s.nextInt();
        while(num != -1)
        {
            input[length] = num;
            num = s.nextInt();
            length++;
        }

        int[] LIS = new int[length];
        int[] sequence = new int[length];                //to save cached work; init all to 1 (analogous to D[0])                  
        for (int i = 0; i < length; i++){                //initialize all LIS[] indices to 1, modelling a min length of 1 for each number
            LIS[i] = 1;
            sequence[i] = i;
        }

        for (int i = length; i >= 0; i--){               //starting at the end of input[] and working backwards
            for (int j = i + 1; j < length; j++){        //compare current input to all previously checked inputs
                if(input[i] < input[j]){                       //check if current is eligible to extend LIS
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);     //take the max of (LIS of the checked value) vs (1 + LIS of previous checked candidate)
                    sequence[i] = input[j];
                }
            }
        }
        
        //returns max value found in LIS[]
        int max = LIS[0];

        for (int i = 1; i < LIS.length; i++) {
            if (LIS[i] > max) {
            max = LIS[i];
            }
        }

        System.out.println("LIS is: " + max);
        System.out.println("Sequence is: " + Arrays.toString(sequence));
    }
}