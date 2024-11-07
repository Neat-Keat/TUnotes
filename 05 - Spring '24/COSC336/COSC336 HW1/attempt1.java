/*
10, 9, 2, 5, 3, 101, 7, 18

186, 359, 274, 927, 890, 520, 571, 310, 916, 798, 732, 23, 196, 579,
426,188, 524, 991, 91, 150, 117, 565, 993, 615, 48, 811, 594, 303, 191,
505, 724, 818, 536, 416, 179, 485 , 334 , 74, 998, 100, 197, 768, 421,
114, 739, 636, 356, 908 , 477, 656

318 , 536 , 390 , 598 , 602 , 408 , 254 , 868 , 379 , 565 , 206 , 619 , 936 , 195 ,
123 , 314 , 729 , 608 , 148 , 540, 256 , 768 , 404 , 190 , 559 , 1000 , 482 , 141 , 26,
230 , 550 , 881 , 759 , 122 , 878, 350, 756, 82, 562, 897, 508, 853, 317 ,
380 , 807 , 23 , 506 , 98 , 757 , 247
 */

import java.util.Arrays;

public class attempt1 {
    public static void main(String[] args){

        int[] numbers = new int[]{10, 9, 2, 5, 3, 101, 7, 18}; //input numbers
        //System.out.println(numbers[1]);
        //System.out.println(numbers.length);

        int sequenceLength = 0;                                 //running length of sequence (ie D[j].length)
        int[] sequence = new int[numbers.length];                //running sequence
        int nextSequenceIndex = 0;

        for (int i=numbers.length; i > 0; i--) {                  //check bounds here (possibly start sequence length at 1 to avoid off by 1?)
            if (numbers[i] < numbers [i+1]){
                sequenceLength++;                                 //+1 to max length, save value to sequence and increment index
                sequence[nextSequenceIndex] = numbers[i];
                nextSequenceIndex++;
            }
        }
        
        System.out.println(sequenceLength);
        System.out.println(Arrays.toString(sequence));
    }
}
