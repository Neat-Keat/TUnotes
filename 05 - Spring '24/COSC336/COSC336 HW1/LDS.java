/*
10, 9, 2, 5, 3, 101, 7, 18

186, 359, 274, 927, 890, 520, 571, 310, 916, 798, 732, 23, 196, 579,
426, 188, 524, 991, 91, 150, 117, 565, 993, 615, 48, 811, 594, 303, 191,
505, 724, 818, 536, 416, 179, 485 , 334 , 74, 998, 100, 197, 768, 421,
114, 739, 636, 356, 908 , 477, 656

318 , 536 , 390 , 598 , 602 , 408 , 254 , 868 , 379 , 565 , 206 , 619 , 936 , 195 ,
123 , 314 , 729 , 608 , 148 , 540, 256 , 768 , 404 , 190 , 559 , 1000 , 482 , 141 , 26,
230 , 550 , 881 , 759 , 122 , 878, 350, 756, 82, 562, 897, 508, 853, 317 ,
380 , 807 , 23 , 506 , 98 , 757 , 247
 */

 public class LDS {
    public static void main(String[] args){
        int[] input = new int[]{318 , 536 , 390 , 598 , 602 , 408 , 254 , 868 , 379 , 565 , 206 , 619 , 936 , 195 ,
            123 , 314 , 729 , 608 , 148 , 540, 256 , 768 , 404 , 190 , 559 , 1000 , 482 , 141 , 26,
            230 , 550 , 881 , 759 , 122 , 878, 350, 756, 82, 562, 897, 508, 853, 317 ,
            380 , 807 , 23 , 506 , 98 , 757 , 247}; //input here

        int[] LIS = new int[input.length];                     //to save cached work; init all to 1 (analogous to D[0])
        for (int i = 0; i < input.length; i++){                //initialize all LIS[] indices to 1, modelling a min length of 1 for each number
            LIS[i] = 1;
        }

        for (int i = input.length; i >= 0; i--){               //starting at the end of input[] and working backwards
            for (int j = i + 1; j < input.length; j++){        //compare current input to all previously checked inputs
                if(input[i] > input[j]){                       //check if current is eligible to extend LIS (CHANGED TO CALC LDS)
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);     //take the max of (LIS of the checked value) vs (1 + LIS of previous checked candidate)
                }
            }
        }
        
        //copy pasted from https://stackoverflow.com/questions/16325168/how-to-find-the-maximum-value-in-an-array
        //returns max value found in LIS[]
        int max = LIS[0];

        for (int i = 1; i < LIS.length; i++) {
            if (LIS[i] > max) {
            max = LIS[i];
            }
        }

        System.out.println("LDS is: " + max);
    }
}