Partitioning arrays on exam  
-------------------------------------------------------------------------------------------------------------------------
   

import java.util.*;
 
public class FileProc {
 
public static void main(String[] args) throws FileNotFoundException {  
Scanner inputFile = new Scanner(new File("test.txt"));  
processFile(inputFile);  
}
 
public static void processFile(Scanner input) {  
int numCount = 0;  
int numTotal = 0;
 
while(input.hasNext()) {  
if(input.hasNextInt()) {  
numTotal += input.nextInt();  
numCount++;  
} else {  
input.next();  
}  
}  
System.out.println(numCount + " numbers were found");  
System.out.println("The average of the numbers is: " + (double) (numTotal/numCount));  
}  
}