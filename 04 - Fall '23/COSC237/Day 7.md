This week we finish up the basics of classes  
Next week we talk about inheritance
 
-------------------------------------------------------------------------------------------------------------------------------
 
Theres function scope AND class scope for variables
 
Objects are references in Jave  
Reference variables point to memory addresses, not actual values in the object
 
//copy constructor  
public Clock(Clock otherClock)  
{  
hr = otherClock.hr  
min = otherClock.min;  
sec = otherClock.sec;  
}
 
Java takes this to be a constructor bc it has the same name as the class, and has no return type declared. it is a copy constructor since the value that the new object is initialized to is copied from the existing Clock object based to it.
 
the following creates a new Clock object named clock2 with the same values currently in Clock object clock1
 
clock2 = new Clock(clock1)
 
Special Reference this
 
Special reference this refers ("points") to the object instance that a called method is part of.  
one use of this is to escape the scope of a method.
 
public class XYCoord  
{  
//instance variables  
private int x;  
private int y;  
.  
.  
public void setX(int x)  
{ this.x = x; }
 
public void setY(int y)  
{ this.y = y; }  
}
 
this.x and this.y refer to instance values  
x and y refer to parameter values
 ![Using Objects in a Program public class Example public static void main(String[] args) Scanner console = new Scanner(System.in); XYCoord coordl; XYCoord coord2; System.out.print("Enter first coordinate value as x <space> Y• x = console.nextlnt(); y = console.nextlnt(); coordl = new XYCoord(x, y); System.out.print("Enter second coordinate value. ), x = console.nextlnt(); y = console.nextlnt(); coord2 = new XYCoord(x, y); System.out.printIn("Distance between two coordinates is" coord1.distance(coord2)); ](Exported%20image%2020240525213001-0.png)  

**COMPOSITION IN JAVA**  
(I.e., objects containing objects)
 
using XYCoord Class as a member of another Class
 
public class Line  
{  
private XYCoord coord1;  
private XYCoord coord2;
 
public Line(XYCoord coord1, XYCoord coord2)  
{  
this.coord1 = coord1;  
this.coord2 = coord2;  
}
 
public boolean equals(Line rLine)  
// returns true if equal in length  
{  
return length() == rLine.length();  
}
 
public double length()  
{  
return coord1.distance(coord2);  
}  
}
 
-------------------------------------------------------------------------------------------------------------------------------
 
public class square  
{  
private Line() lines;
 
public square(XYCoord upper_left, int length)  
//location of upper left corner of square given, along with its size  
{  
int x = upper_left.getX();  
int y = upper_left.getY();
 
XYCoord upper_right = new XYCoord(x + length, y);  
XYCoord lower_right = newXYCoord(x + length), y – length);  
XYCoord lower_left = new XYCoord(x, y – length);
 
lines = new Line[4];  
lines[0] = new Line(upper_left, upper_right);  
lines[1] = new Line(upper_right, lower_right);  
lines[2] = new Line(lower_right, lower_left);  
lines[3] = new Line(lower_left, upper_left);  
}
 
public int size() {  
return lines[0].length()  
}
 
public int area() {  
return (int) Math.pow(lines[0].length(), 2);  
}
 
public boolean equals(Square rSquare) {  
return size() == rSquare.size();  
}
   

-------------------------------------------------------------------------------------------------------------------------------  
EXAMPLE UML CLASS DIAGRAM

![Clock —hr: int —min : int —sec: int +C10ck( int, int, int) +setTime( int, int, int) : + getHours( ) : int +getMinutes( ) : int + get Seconds ( ) : int +printTime( ) : void + incrementHours( ) : int + incrementMinutes( ) : int + ( ) : int +equals (Clock): boolean +makeCopy ( Clock ) : void +getCopy( ) : Clock void ](Exported%20image%2020240525213001-1.png)     

Class Scope
 
With functions (methods), there is the notion of local scope. This means that any variables declared within the function are not accessible by any other functions in a program.
 
There is also the notion of class scope. This means that any method of a class may access all the other members of the class (both instance variables and other methods), whether public or private.   Only members of a class declared public can be access by methods of other classes.