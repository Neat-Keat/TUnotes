Redo practicum 20, it’s a new one?  
Practicum 21 out too  
-------------------------------------------------------------------------------------------------------------------------------
 
Classes are a way to group things together

- Called encapsulation
 
Class as a Data Type  
Defining an XYCoord Class
 
Public class XYCoord  
{  
//instance variables  
Private int x;  
Private int y;
 
//contructor  
Public XYCoord(int x_value, int y_value)  
{  
X = x_value;  
Y = y_value;  
}
 
//print method  
Public void print()  
{  
System.out.println("(" + x + "," + y + ")");  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
Creating obkects of type XYCoord
 
XYCoord coord1;  
coord1 = new XYCoord(0,0);
 
analogous to: int n;  
n = 10;
 
XYCoord coord2;  
coord2 = new XYCoord(20,60);
 
there are times when the declaration and construction can be performend as one instruction,
 
XYCoord coord1 = new XYCoord(0,0);
 
Analogous to: int n = 10;
 
-------------------------------------------------------------------------------------------------------------------------------
 
anything that’s not the no-arg (default) constructor is called an alternate constructor
 
classes let you add more complex general methods (see the distance function
 
.toString is actually an inherited method, when you define and implement your own your overwriting the default method!
 
**its generally not good to have a class print out its own value. Instead, it should return a string representation of its value that the client displays.**
 
XYCoord Class (with everything above)
 
public class XYCoord {
 
//instance variables  
private int x;  
private int y;
 
//constructors  
public XYCoord(int x, int y) { this.x = x, this.y = y; }
 
//getters and setters  
public int getX() { return x; }  
public void setX(int value) { x = value; }  
public int getY() { return y; }  
public void setY(int value) { y = value; }
 
//toString method  
public String toString()
   

//operators  
public double distance(XYCoord rCoord) {  
double xTerm;  
double yTerm;  
double distance;
 
xTerm = math.pow(rCoord.getX() - x, 2);  
yTerm = math.pow(rCoord.getY() - y, 2);  
distance = Math.sqrt(xTerm + yTerm);
 
return distance;  
}  
}
 
The "this" method points to an object's self, it has more fundamental uses than just serving as an alternate name lol
 
Objects are References in Java  
this has important implications!
 
How do I compare 2 objects for equality?  
by default, reference values are being compared (shallow), and not object's values (deep)
 
redefine it yourself with the equals() method!
 
Therefore, assigning 1 object variable to another does not do what the assignment of primitive types does,  
k = 10  
n = 10  
k and n have distinct values
 
Assigning one (clock) object to another,  
variables myClock and yourClock refer to the same object instance
 
The equals method in Java

class Clock:  
Data Members (instance Variables):

- private int hr; // store hours
- etc
 
methods:

- public boolean equals(Clock otherClock)
 
-------------------------------------------------------------------------------------------------------------------------------  
public boolean equals(Clock otherClock)  
{  
if (hr == otherClock.hr && min == otherClock.min && sec == otherClock.sec)  
return true;  
else  
return false;  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
the following will always determine if the reference for each of the two objects are equal (ie, do they both refer to the same object instance?)  
clock1 == clock2
 
the following will perform a deep comparison IF an equals method is defined in the class for properly doing so, otherwise it performs a shallow comparison:  
clock1.equals.(clock2)  
same as  
clock2.equals(clock1)
 
this works because when methods are part of a class that uses objects of the same class, it can directly see their private variables lulw
 
Copy constructors in Java  
as with the equals method which performs deep comparison of objects, the copy constructor method is meant to perform a deep copy of an object.
 
//copy constructor  
public Clock(Clock otherClock)  
{  
hr = otherClock.hr;  
min = otherClock.min;  
sec = otherClock.sec;  
}
 
Java takes this to be a constructor bc it has the same name as the class, and has no return type declared. it is a copy constructor since the value that the new object is initialized to is copied from the existing Clock object based to it
 
The following creates a new Clock object named clock2 with the same values currently in CLock object clock1.
 
clock2 = new Clock(clock1);