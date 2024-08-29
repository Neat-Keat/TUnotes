Building Java Programs Chapter 8  
Classes
 
Problem

- Given a file of cities' (x,y) coordinates, which begins with the number of cities:
- Write a program to draw the cities on a DrawingPanel, then drop a "bomb" that turns all cities red that are within a given radius:
    
    - Blast site x? 100
    - Blast site y? 100
    - Blast radius? 75
    - Kaboom!

6  
50, 20  
90, 60  
10, 72  
74, 98  
5, 136  
150, 91
   
 
- A Point would store a city's x/y data
- We could compare distances between Points to see whether the bomb hit a given city
- Each Point would know how to draw itself
- The overall program would be shorter and cleaner
 
- Client program: A program that uses objects.
    
    - Ex: Bomb is a client of DrawingPanel and Graphics
      
    ![Bomb java (client program) public class Bomb { main(StringC] args) { new DrawingPanel(.. new DrawingPanel(.. Drawi ngpanel _ java (class) public class DrawingPanel { O CSE ](Exported%20image%2020240525204034-0.png)  
    
- Class: A program entity that represents either:
    
    - A Program/ module
    - A template for a new type of objects

- The DrawingPanel class is a template for creating DrawingPanel objects

- Object: an entity that combines state and behavior.
    
    - OOP: Programs that perform their behavior as interactions between objects ![Blueprint analogy iPod blueorint current song volume battery life power on/off change station'song change volume choose random song iPod #1 son* = Miles volume = 17 battery life = 2.5 hrs behavior: power on/off change volume choose random song song = "Letting You" volume = 9 battery life = 3.41 hrs behavior: power on/off change volume choose random song creates iPod #3 song = "Discipline" volume = 24 battery life = 1.8 hrs behavior: power on/otf change station/song choose random song ](Exported%20image%2020240525204034-1.png)   ![Point objects (desired) point PI = new point (5, -2); point P2 = new point(); • Data in each Point object: // origin, (O, 0) Field name Description the point's x-coordinate the point's y-coordinate • Methods in each Point object: Method name setLocation(x, y) translate(dx, dy) distance(p) draw(g) Description sets the point's x and y to the given values adjusts the point's x and y by the given amounts how far away the point is from point p displays the point on a drawing panel ](Exported%20image%2020240525204034-2.png)   
Point class as blueprint
   
![Point class as blueprint int x, Y behavior: setLocation(int x, int y translate(int dx, int dy distance(Point p) draw(Graphics g) x - -245, behavior: Y 18g7 behavior: setLocation(int x, translate(int dx, distance(Point p) draw(Graphics g) int y setLocation(int x, int y translate(int dx, int dy int dy distance( Point p) draw(Graphics g) x = 18, Y 42 behavior: setLocation(int x, int y trans late(int dx, int dy distance(Point p) draw(Graphics g) — The class (blueprint) will describe how to create objects. — Each object will contain its own data and methods. ](Exported%20image%2020240525204034-3.png)  

Point class, version 1
 
}
 
saved into Point.java
  ![Accessing fields • Other classes can access/modify an object's fields. Pl.x) — access: variable. field — modify: variable. field value ; • Example: Point pl = new Point(); Point p2 = new Point(); System . out . pr int " the P2.Y = 13; x-coord // access // modify ](Exported%20image%2020240525204034-4.png) ![A class and its client • Point . java is not, by itself, a runnable program. — A class can be used by client programs. PointMain . i ava (client program) public class PointMain { main(String args) { Point pl = new Point(); Pl.x = 7; pl.y = 2; Point p2 = new Point(); p2.x = 4; p2.Y = 3; Point java Of public class Point { int x; int y; ](Exported%20image%2020240525204034-5.png)

public class PointMain {  
public static void main(String[] args) {  
**// create two Point objects**  
Point p1 = new Point();  
**p1.y** = 2;  
Point p2 = new Point();  
**p2.x** = 4;
 
System.out.println(**p1.x** + ", " + **p1.y**); **// 0, 2**   **// move p2 and then print it**  
**p2.x** += 2;  
**p2.y**++;  
System.out.println(**p2.x** + ", " + **p2.y**); **// 6, 1**  
}  
}
   
![String[] words = new String[4] ; for (int i = O; i < words . length; coords[i] = "word" + i; index words value "word@" 1 "wordl " 2 "word2" // phase 1 // phase 2 3 "word3" ](Exported%20image%2020240525204034-6.png)  

-------------------------------------------------------------------------------------------------------------------------------
 ![import java.awt. import java.io. import java.util. * ; Bomb answer 1 // needed for GUI components // needed for File processing // needed for Scanner // Displays a set of cities and simulates dropping a pub lic class Bomb { "bomb" on them. public static void main(String[] args) throws FileNotFoundException { DrawingPanel panel = new DrawingPaneI(200, 200); Graphics g = panel . getGraphics(); // paper // pen Scanner input = new Scanner new File "cities. txt")); Point[] cities = readCities input, g , // drop the "bomb" Scanner console = new Scanner(System . in); Point bomb = new Point(); System .out.print( "Blast site x? bomb. x — console.nextlnt(); System .out.print( "Blast site y? bomb.y = console.nextlnt(); System .0ut .print( "Blast radius? int radius = console. nextlnt(); boom(bomb, radius, cities, g); ](Exported%20image%2020240525204034-7.png) ![Bomb answer 2 // Reads input file Of cities and returns them as arra Of Points. public static Point[l input, Graphi{s gl ( // f line #0 cities Point!] cities n for ( nt i = O; i < cities. Length; 144) { cities i new Point(); cities . x = input. nextlnt // read city x/y from file cities I input. next Int g. fill a L cig es[i] . y, 3, 3 . x, citiesli] .y);' return cities; // Simulates dro?ping a bomb at the on the iven cities. ius, Point[] cigies, Graphics g) { public static vo d boom(POint bomb, g.setCoIor Color .REO); . drawOvaI bomb.x radius, bomb. y - radius, 2 or lint i = < cities.len th; 144) { nt dx = cities i .x - bomg.x; int dy = cities i .y - bomb.y; double distance Math .sqrt(dx • dx + dy • • radius, 2 • radius); stem (distance c radiusl { 4 ciåes[l g.drawString(' . x, cities . y); . out. print "Kaboom! " ) ; ](Exported%20image%2020240525204034-8.png)

-------------------------------------------------------------------------------------------------------------------------------
 
Object Behavior: Methods
 ![Eliminating redundancy, VI • We can eliminate the redundancy with a static method: // Draws the given point on the DrawingPane1. public static void draw(Point p, Graphics g) { g. fillOval(p.x, p.y, 3, 3); g. + p.x + • main would call the method as follows: // draw each city draw(cities[i], g); p.x, ](Exported%20image%2020240525204034-9.png)  
![Problem with static method • We are missing a major benefit of objects: code reuse. — Every program that draws points would need a draw method. • The syntax doesn't match how we're used to using objects. draw(cities[i], g); // static (bad) • The point of classes is to combine state and behavior. — The draw behavior is closely related to a point's data. — The method belongs inside each point object. cities [i] . draw(g) ; // inside object (better) ](Exported%20image%2020240525204034-10.png)  

no more static!!!
 ![Instance method example public class Point { int x; int y; // Draws this point object with the given pen. public void draw(Graphics g) { — The draw method no longer has a point p parameter. — How will the method know which point to draw? • How will the method access that point's x/y data? ](Exported%20image%2020240525204034-11.png)  
![Point objects w/ method • Each point object has its own copy of the draw method, which operates on that object's state: point PI = Pl.x = 7; Pl.y = 2; point P2 = p2.x = 4; P2.y = 3; PI . draw(g); p2 . draw(g); new new point(); point(); P20— pi public void draw(Graphics g) { // this code can see PI's x and y public void draw(Graphics g) { // this code can see p2's x and y ](Exported%20image%2020240525204034-12.png) ![The implicit parameter • implicit parameter: The object on which an instance method is called. — During the call PI . draw(g) ; the object referred to by PI is the implicit parameter. — During the call p2 . draw(g) ; the object referred to by p2 is the implicit parameter. — The instance method can refer to that object's fields. • We say that it executes in the context of a particular object. • draw can refer to the x and y of the object it was called on. ](Exported%20image%2020240525204034-13.png) ![Point class, version 2 public class point { int x; int y; // Changes the location of this Point object . public void draw(Graphics g) { g.filtoval(x, y, 3, 3); — Each point object contains a draw method that draws that point at its current x/y position. ](Exported%20image%2020240525204034-14.png)   ![Mutator method questions • Write a method setLocation that changes a Point's location to the (x, y) values passed. • Write a method trans late that changes a Point's location by a given dx, dyamount. — Modify the point and client code to use these methods. ](Exported%20image%2020240525204034-15.png) ![Mutator method answers public void setLocation(int newx, int newY) { newx ; Y = newy; public void translate(int dx, x = x + dx; Y = Y + dy; int dy) { // alternative solution that utilizes setLocation public void translate(int dx, int dy) { setLocation(x + dx, y + dy); ](Exported%20image%2020240525204034-16.png) ![Accessor method questions • Write a method distance that computes the distance between a Point and another Point parameter. Use the formula: • Write a method distanceFromOrigin that returns the distance between a Point and the origin, (O, O). — Modify the client code to use these methods. ](Exported%20image%2020240525204034-17.png) ![Accessor method answers public double distance(P0int other) { int dx = x other. x; int dy = y - other. y; return Math.sqrt(dx * dx + dy * dy); public double { return Math.sqrt(x // alternative solution that uses distance public double distanceFromOriqin() { point origin = new point(); return distance(origin); ](Exported%20image%2020240525204034-18.png)  
- Every class has a toString, even if it isn't in your code.
- Default: class's name @ object's memory address (base 16) 
Point@9e8c34
 
toString syntax

- Method name, return, and parameters must match exactly.  
    
- Example:

**// Returns a String representing this Point.**  
public String toString() {  
return "(" + x + ", " + y + ")";  
}

Don’t use parallel arrays, its considered poor style, instead, store the coordinates as Point objects
 
Clients of objects
         

Abstraction: A distancing between ideas and details  
We can use objects without knowing how they work
 
Abstraction in an ipod  
You understand its external behavior (buttons, screen)  
You don’t understand its inner details, and you don’t need to
 
Our Task  
In the following slides, we will implement a Point class as a way of learning about defining classes.

- We will define a type of objects named Point
- Each Point object will contain x/y data called fields
- Each Point object will contain behavior called methods
- Client Programs will use the Point objects
         

public class Point {  
int x;  
int y;
   

* the above code creates a new type named Point.  
each point contains 2 pieces of data  
an int x  
an int y
 
so far they have no behavior
 
* field: a variable inside an object that is part of its state.  
each object has its own copy of each field
 
declaration syntax:  
type name;
 
ex  
public class Student {  
String name;  
double gpa;  
}
      

arrays of objects:  
* null: a value that does not refer to any object.  
the elements of an array of objects are initialized to null.  
String[] words = new String[5];  
DrawingPanel[] windows = new DrawingPanel[3];
 ![3 null windows index value index value null null 1 null 1 null 2 null 2 null 4 null ](Exported%20image%2020240525204034-19.png)

Things you can do w/ null
 
* store null in a variable or an array element  
String s = null;  
words[2] = null;
 
* print a null reference  
System.out.println(s); //null
 
* ask whether a variable or array element is null  
if (words[2] == null) {
 
* pass null as a parameter to a method if the return type is an object  
System.out.println(null); //null
 
* return null from a method ( often to indicate failure)  
return null;
 
Null pointer exception  
* dereference: to access data or methods of an object with the dot notation, such as s.length()  
it is illegal to dereference null ( causes an exception)  
null IS NOT an object, so it has no methods or data
 
String[] words = new String[5];  
System.out.println("word is: " + words[0]);  
words[0] = **words[0].toUpperCase()**; **// ERROR**   Output:  
word is: null  
Exception in thread "main" java.lang.NullPointerException  
at Example.main(Example.java:8)

![index value o null 1 null 2 null 3 null 4 null ](Exported%20image%2020240525204034-20.png)  

Looking before you leap  
* you can check for null before calling an object's methods
 ![String[] — new String[5] words — "hello"; words[2] = "goodbye" ; // words[l], for (int i = o; i < words. length; i++) { if (words[i] null) { words[i] = words[i] . touppercase(); words index value "HELLO" 1 null 2 "GOODBYE" [4] are null null null ](Exported%20image%2020240525204034-21.png)  

2-phase initialization  
1) initialize the array itself ( each element is initially null)  
2) initialize each element of the array to be a new object
       
Client code redundancy:  
Our client program wants to draw Point objects:  
**// draw each city**  
g.fillOval(cities[i].x, cities[i].y, 3, 3);  
g.drawString("(" + cities[i].x + ", " + cities[i].y + ")",  
cities[i].x, cities[i].y);
 
To draw them in other places, the code must be repeated  
we can remove this redundancy using a method.
    
Instance methods  
Exists inside each object of a class and gives behavior to each object
 ![public type name( parameters) { statements ; — same syntax as static methods, but without static keyword Example: public void shout() { system. out . print "HELLO THERE! ](Exported%20image%2020240525204034-22.png)     

Kinds of methods:  
Accessor: A method that lets clients examine object state  
examples: distance, distanceFromOrigin  
usually has a non-void return type  
Mutator: A method that modifies an object's state.  
examples: setLocation, translate  
get and set: Methods to examine and set individual field values
    
Printing objects  
* by default, Java doesn't know how to print objects  
Point p = new Point();  
p.x = 10;  
p.y = 7;  
System.out.println("p is " + p); **// p is Point@9e8c34**   **// better, but cumbersome; p is (10, 7)**  
System.out.println("p is (" + p.x + ", " + p.y + ")");   **// desired behavior**  
System.out.println("p is " + **p**); **// p is (10, 7)**
 
The toString method  
tells Java how to convert an object into a String
 
Point p1 = new Point(7, 2);  
System.out.println("p1: " + **p1**);
 
**// the above code is really calling the following:**  
System.out.println("p1: " + p1**.toString()**);  
    
public String toString() {  
**code that returns a String representing this object**;  
}