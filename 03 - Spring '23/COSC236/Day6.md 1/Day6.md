Interactive Programs with _Scanner_
 
- Interactive program: reads input from the console
    
    - While the program runs, it asks the user to type input
    - The input typed by the user is stored in variables in the code
 
- Can be tricky; users are unpredictable and misbehave
- Interactive programs have more interesting behavior
  - The Scanner class is found in the java.util package
- Constructing a Scanner object to read console input:
    
    - Scanner name = new Scanner(System.in);
    - Example
        
        - Scanner console = new Scanner(System.in);

Import java.util.*; //so you can use Scanner
   

Scanner methods
 
|   |   |
|---|---|
|Method|Description|
|nextInt()|Reads an int from the user and returns it|
|nextDouble()|Reads a double from the user|
|next()|Reads a 1-word String from the user|
|nextLine()|Reads a 1-line String from the user|
 
- Each method waits until the user presses enter.
- The value typed by the user is returned
 
-------------------------------------------------------------------------------------------------------------------------------
 
import java.util.*; // so that I can use Scanner   public class UserInputExample {  
public static void main(String[] args) {  
Scanner console = new Scanner(System.in);  
System.out.print("How old are you? ");  
int age = console.nextInt();   int years = 65 - age;  
System.out.println(years + " years to retirement!");  
}  
}   Console (user input underlined):   How old are you?  
29  
36 years until retirement!  
-------------------------------------------------------------------------------------------------------------------------------
 
import java.util.*; // so that I can use Scanner   public class ScannerMultiply {  
public static void main(String[] args) {  
Scanner console = new Scanner(System.in);   System.out.print("Please type two numbers: ");  
int num1 = console.nextInt();  
int num2 = console.nextInt();   int product = num1 * num2;  
System.out.println("The product is " + product);  
}  
}   Output (user input underlined):   Please type two numbers: 8 6  
The product is 48   The Scanner can read multiple values from one line.  
-------------------------------------------------------------------------------------------------------------------------------  
Input tokens  
* token: a unit of user input, as read by the Scanner

- Tokens are separated by _whitespace_ (spaces, tabs, new lines).
- How many tokens appear on the following line of input?

23 John Smith 42.0 "Hello world" $2.50 " 19"
 - When a token is not the type you ask for, it crashes
   

System.out.print("What is your age? ");  
int age = console.nextInt();  
Output:  
What is your age? Timmy  
java.util.InputMismatchException  
at java.util.Scanner.next(Unknown Source)  
at java.util.Scanner.nextInt(Unknown Source)  
…  
-------------------------------------------------------------------------------------------------------------------------------  
Scanner's next method reads a word of input as a String.   Scanner console = new Scanner(System.in);  
System.out.print("What is your name? ");  
String name = console.next();  
name = name.toUpperCase();  
System.out.println(name + " has " + name.length() +  
" letters and starts with " + name.substring(0, 1));   Output:  
What is your name? Chamillionaire  
CHAMILLIONAIRE has 14 letters and starts with C   The nextLine method reads a line of input as a String.   System.out.print("What is your address? ");  
String address = console.nextLine();  
-------------------------------------------------------------------------------------------------------------------------------
 
// This program prints your "gangsta" name.  
import java.util.*;   public class GangstaName {  
public static void main(String[] args) {  
Scanner console = new Scanner(System.in);  
System.out.print("Type your name, playa: ");  
String name = console.nextLine();   // split name into first/last name and initials  
String first = name.substring(0, name.indexOf(" "));  
String last = name.substring(name.indexOf(" ") + 1);  
last = last.toUpperCase();  
String fInitial = first.substring(0, 1);   System.out.println("Your gangsta name is \"" + fInitial +  
". Diddy " + last + " " + first + "-izzle\"");  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
**BUILDING JAVA PROGRAMS SUPPLEMENT 3G**  
**GRAPHICS**
 
We will draw graphics in Java using 3 kinds of objects

- DrawingPanel: A window on the screen
    
    - Not part of Java; provided by the authors. See class website
- Graphics: A "pen" to draw shapes and lines on a window
- Color: Colors in which to draw shapes.
 
"Canvas" objects that represents windows/drawing surfaces
 
- To create a window:

DrawingPanel name = new DrawingPanel(width, height);

- The window has nothing on it.
    
    - We draw shapes/lines on it with another object of type Graphics
 
"Pen" or "paint brush" objects to draw lines and shapes

- Access it by calling getGraphics on your DrawingPanel

Graphics g = panel.getGraphics();
 - Draw shapes by calling methods on the Graphics object.
 
g.fillRect(10, 30, 60, 35);  
g.fillOval(80, 40, 50, 70);  
----------------------------------------------------------------------------------------------------------------------------
 
- Java class libraries: Classes included with Java's JDK
    
    - Organized into groups named packages
    - To use a package, put an import declaration in your program:
- Graphics belong to a package named java.awt
- To use Graphics, you must place the above line at the very top of your program, before the public class header
 
// put this at the very top of your program  
Import packageName.(;
 
Import java.awt.*;
 ![• Each (x, y) position is a pixe/ ("picture element"). • Position (0, 0) is at the window's top-left corner. — x increases rightward and the y increases downward. • The rectangle from (0, 0) to (200, 100) looks like this: (200, 100) ](Exported%20image%2020240525204020-0.png)  
![Graphics methods Method name g. drawLine(x1, yl, x2, y2); g. drawoval(x, y, width, height) ; g. drawRect(x, y, width, height) ; g. drawstring(text, x, y) ; g. fillOval(x, y, width, height) ; g. fillRect(x, y, width, height) ; g. setCo lor( Color) ; Description line between points (xl, yl), (x2, ya outline largest oval that fits in a box of size width* heightwith top-left at (x, outline of rectangle of size width* heightwith top-left at (x, y) text with bottom-left at (x, y) fill largest oval that fits in a box of size width* heightwith top-left at (x, y) fill rectangle of size width* height with top-left at (x, y) set Graphics to paint any following sha es in the iven color ](Exported%20image%2020240525204020-1.png) ![Color • Specified as predefined color class constants: color . CONSTANT NAME where CONSTANT NAME is one of•. BLACK, GREEN, PINK, RED, BLUE, CYAN, DARK GRAY, GRAY, LIGHT GRAY, MAGENTA, ORANGE, WHITE, YELLOW • Or create one using Red-green-Blue (RGB) values of 0- 255 color name = new color ( red, green, blue) — Example: ](Exported%20image%2020240525204020-2.png) ![• Pass a color to Graphics object's setcolor method — Subsequent shapes will be drawn in the new color. g. setcolor ( color . BLACK) ; 30, 50); O, 10, 30); g. setcolor(color . RED) ; 40, 40, 70); • Pass a color to Drawingpanel's setBackgrouncÄl — The overall window background color will chang color brown = new color-(192, 128, 64); panel. setBackground( brown) ; ](Exported%20image%2020240525204020-3.png)  

To give a colored shape a border, fill it, then draw it in a different color

![import java.awt.*; // so I can use Graphics public class OutlineExample { public static void main(String[] args) { DrawingPanel panel = new Graphics g = panel. getGraphics() ; // inner red fill g. setCo lor (Color . RED) ; g. fiURect(20, 10, 100, // black out line g. setCo lor (Color . BLACK) ; g.drawRect(20, 10, 100, 50) ; Eile 50) ; ](Exported%20image%2020240525204020-4.png) ![Superimposing shapes • When 2 2 shapes occupy the same pixels, the last drawn "wins." import java.awt. * ; public class Car { public static void main(String[] args) { DrawingPanel panel = new panel . setBackground(Color . LIGHT _ GRAY) ; Graphics g = panel. getGraphics(); g. setCo lor(Co lor . BLACK) ; 30, 50); g. setCo lor(Co lor . RED) ; 70, 20, 70, 20, g. setCo lor(Co lor . CYAN); 40, 30, 100); Drawing Panel ](Exported%20image%2020240525204020-5.png) ![Drawing with loops • The x, y, w,h expressions can use the loop counter variable: panel. setBackground(Color . YELLOW) ; g. setCo lor(Co lor. RED); for (int i = 1; i 10; i++) { + 20 * i, 5 + 20 * i, w 50, h 50); • Nested loops can be used with graphics: g. setCo lor(Co lor . BLUE); for (int x = 1; x 4; x++) { for (int y = 1; y 9; Y++) { g. drawstring( "Java", x * 40, y * 25); ](Exported%20image%2020240525204020-6.png) ![Zero-based loops • Beginning at 0 and using < can make coordinates easier. DrawingPanel panel — new 143); Graphics g = pane l. getGraphics( ) ; // horizontal line of 5 20x20 rectangles starting // at (11, 18); x increases by 20 each time for (int i = O; i < 5; i++) { g.drawRect(11 + 23 * i, 18, 20, 20); • Exercise: Write a variation of the above program that draws the output at right. — The bottom-left rectangle is at (11, 98). for (int i = 3; i < 5; i++) { g.drawRect(11 + 23 * i, 98 - 20 * i, 23, 23); ](Exported%20image%2020240525204020-7.png)   
Write a program that draws the following figure:  
drawing panel is size 200x150  
book is at (20, 35), size 100x100  
cyan background  
white "BJP" text at position (70, 55)   stairs are in color (red=191, green=118, blue=73)  
each stair is 9px tall  
1st stair is 10px wide  
2nd stair is 20px wide ...  
stairs are 10px apart (1 blank pixel between)

![DrawingPaneI file Lien del. ](Exported%20image%2020240525204020-8.png)

-------------------------------------------------------------------------------------------------------------------------------// Draws a Building Java Programs textbook with DrawingPanel.  
import java.awt.*;   public class Book {  
public static void main(String[] args) {  
DrawingPanel panel = new DrawingPanel(200, 150);  
panel.setBackground(Color.WHITE);  
Graphics g = panel.getGraphics();   g.setColor(Color.CYAN); // cyan background  
g.fillRect(20, 35, 100, 100);   g.setColor(Color.WHITE); // white "bjp" text  
g.drawString("BJP", 70, 55);   g.setColor(new Color(191, 118, 73));  
for (int i = 0; i < 10; i++) { // orange "bricks"  
g.fillRect(20, 35 + 10 * i, 10 + 10 * i, 9);  
}  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------

![Polygon Objects that represent arbitrary shapes • Add points to a polygon using its addP0int(x, y) method. • Example: Drawingpanel p = new Graphics g = p. getGraphics( ) ; g. setcolor( color . GREEN); polygon poly = new polygon(); poly . addP0int (10, 90); poly . addP0int (50, 10); poly . addP0int (90, 90); g. filtpolygon(poly); ](Exported%20image%2020240525204020-9.png)

panel.clear();  
Erases any shapes that are drawn on the drawing panel.   panel.setWidth(width);  
panel.setHeight(height);  
panel.setSize(width, height);  
Changes the drawing panel's size to the given value(s).   panel.save(filename);  
Saves the image on the panel to the given file (String).   panel.sleep(ms);  
Pauses the drawing for the given number of milliseconds.
 
DrawingPanel's sleep method pauses your program for a given number of milliseconds.   You can use sleep to create simple animations.  
DrawingPanel panel = new DrawingPanel(250, 200);  
Graphics g = panel.getGraphics();   g.setColor(Color.BLUE);  
for (int i = 1; i <= 10; i++) {  
g.fillOval(15 * i, 15 * i, 30, 30);  
panel.sleep(500);  
}   Try adding sleep commands to loops in past exercises in this chapter and watch the panel draw itself piece by piece.