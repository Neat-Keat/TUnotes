Loops  
Repetition control structure

|   |   |
|---|---|
|Body|Statement to be repeated|
|Control statement (test)|Decides whether another repetition needs to be made|
|Leading decision loop|Control statement before body|
|Trailing decision loop|Control statement after body|
|Logical loop|While do .. While|
|Counted loop|for|
       
While Loops
 
Leading Decision Loop  
Prime the loop // start  
While (condition) // Test  
{  
Body of loop - //action  
Group of one or more statements  
Note: indent the statements  
//restart  
}
 
STAR method for while loops
 
|   |   |
|---|---|
|Start|Initial condition|
|Test|While…|
|Action|Steps needed to solve the problem|
|Restart|Often the same as start|
 
Test step first
 
Ex: Input Control
 
Cin >> number;  
While (number < 0)  
{  
Cout << "Enter positive values only! ";  
Cin >> number;  
}
   

TYPES OF WHILE LOOPS

|   |   |   |
|---|---|---|
|Sentinel Controlled|Keep processing data until a special value is entered to indicate that processing should stop|Read blood pressures until a special value (like -1) selected by you is read|
|Count Controlled|Keep processing data for a specified number of times|Read 100 blood pressures|
|End-of-file Controlled|Keep processing data as long as there is more data in the file|Read all the blood pressures from a file no matter how many there are|
|Flag Controlled|Keep processing data while a flag condition is true|Read blood pressures until a dangerously high BP (200 or more) is read|
 
A Sentinel-controlled Loop

- Read numbers until -1, 999
- Not always easy to determine sentinel value
- Requires a "priming read"
- "priming read" means you read one set of data before the while
 
STAR for sentinel loops  
Start Get 1st value  
Test while (value != sentinel)  
Action  
Restart Get next value
   

Accumulator -storage area for keeping cumulative or running totals

- Initialize: total = 0;
- Update:
    
    - Total = total + number
    - TotalWagesPaid = totalWagesPaid + netPay

Counter - storage area in which we count

- Initialize: count = 0;
- Increment:
    
    - Count = count + 1 or count++

Example: to mfind the average of a group of numbers, need a running total and how many numbers
 
Accumulator Ex:  
Initialize: total = o;  
Update: total = total + num;
 
Counter Example:  
Initialize: count = 0;  
Increment: count++
   

COUNT CONTROLLED LOOP  
Do something a set # of times  
Needs a counter  
Initialize  
Increment  
Iteration counter: incremented during each iteration of the loop  
Event counter: incremented each time a particular event occurs
 
STAR method: Counted Loop
 
Start: initialize counter  
Test: while (counter < limit)  
Actions  
Restart: increment counter

![When the expression is tested and found to be false, the loop is exited and control passes to the statement which follows the loop body. while LOOP FALSE Expression TRUE body statement ](Exported%20image%2020240525202935-0.png) ![Example //START cout you want to play?(y/n)"; cin ans; while ((ans Il (ans //body //ACTION cout <<"Do you want to play (y/n)?";//RESTART cin ans; cout <<"Thanks for playing! " endl; ](Exported%20image%2020240525202935-1.png) ![// Senti Loop for #include < i ostream> using namespace std; int main ( ) int num; num = cout < < "Enter cin num; while (num -1) if (num cout el se cout "Enter cin num; / Of loop return e; and negati ve numbers (EXAMPLE) to stop) " e ndl; "positive " a number ( end I; —I to stop) " endl; ](Exported%20image%2020240525202935-2.png) ![Adding a Running Total to a Sentinel- Controlled While Loop total = 0; cin >> item; while (item != Sentinel) total = total + item; cin >> item; ](Exported%20image%2020240525202935-3.png) ![// Sentinel controlled loop (Alternative Example) total = 0; cout << "Enter the price of the item (-1 to stop ) ";//START cin >> itemPrice; while (itemPrice > 0) // while not sentinel total = total + itemPrice; cout item price(-l to stop ) ' cin >> itemPrice; TEST // ACTION ; // RESTART cout << The total price of all items is << total << endl; ](Exported%20image%2020240525202935-4.png) ![Count Controlled loop Example: // Count (for Odd us Ine namespace std; Int main() int num; int count; num count e; // I Even) while (count le) test if (num % 2 c out else // end Of While I OOP a) / / action end I; ; // 3. action " Odd " endl end I; // 3 . action ](Exported%20image%2020240525202935-5.png) ![Known Count Example //Print Hello 10 times int count ; o; count = while (count < 10) cout << ' 'Hello 'L count = count + 1; //start //test //action //restart ](Exported%20image%2020240525202935-6.png) ![variable count Example //Print Hello int count ; cout << "How many times should we print Hello?" cin >> count; while (count > 0) cout "Hello " count = count -1 • ](Exported%20image%2020240525202935-7.png)

(This is technically decrementing)

WHILE is a keyword, you cannot declare a variable named WHILE

Use loops for input controls instead of if-else statements  
Loops run continuously, if-else runs once

STAR
 
R is usually just S repeated

Count controlled loop:
 
For (count = 1; count <=10; count++)  
Cout << "Hello" << endl;

Int main()  
{  
Int counter;
 
For counter = 0; counter < 3; counter++)  
{  
Cout << counter << endl;  
}
 
Cout << "last line"  
}