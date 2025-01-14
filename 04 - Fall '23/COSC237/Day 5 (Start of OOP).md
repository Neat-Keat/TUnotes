Classes  
You're creating a new type when you create a new class
 
Class as a data type  
A data type is a set of values and set of operators that operate on those values  
Ex. Int:  
Set of int values  
Set of operators, +, -, etc.  
Defining an XYCoord Class  
-------------------------------------------------------------------------------------------------------------------------------  
public class XYCoord  
{  
//instance variables  
private int x;  
private int y;
 
//constructor  
public XYCoord(int x_value, int y_value)  
{  
x = x_value;  
y = y_value;  
}
 
//print method  
public void print()  
{  
System.out.println("(" + x + "," + y + ")");  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------  
Creating objects of Type XYCoord  
-------------------------------------------------------------------------------------------------------------------------------  
XYCoord coord1;  
coord1 = new XYCoord(0,0);
 
Analogous To: int n;  
n = 10;
 
XYCoord cord2;  
coord2 = new XYCoord(20,60);
 
There are times when the declaration and construction can be performed as 1 instruction:
 
XYCoord coord1 = new XYCoord(0,0);
 
Analogous To: int n = 10;  
-------------------------------------------------------------------------------------------------------------------------------
 
classes normally begin with an uppercase letter by convention  
constructors initialize instance variables in each object
 
**constructors are defined by having no return type AND the same name as the class**
 
What is an object really?  
Smalltalk = 1 OOP lang  
Called this bc they thought kids could deal with it easily  
Included subclasses and polymorphism  
Coincided with the development of the GUI  
Objects can do things to their own data, as they have methods!  
Function calls are like messaging the object to do something
 
members of the same class can access all other members of the same class
 
creating and using objects in main  
-------------------------------------------------------------------------------------------------------------------------------  
public static void main(String[] args)  
{  
//declaring variables (of type XYCoord)  
XYCoord coord1, coord2; //each has initial value of null
 
//constructing objects (of type XYCoord)  
coord1 = new XYCoord(0,0); //creates and assigns location of object
 
coord2 = newXYCoord(0,10); // in variables coord1 and coord2
 
//using XYCoord objects  
coord1.print();  
coord2.print();  
}  
-------------------------------------------------------------------------------------------------------------------------------  
objects should never print directly to the screen, there should be a user interface that handles that instead.
 
defining alternate constructors
 
public class XYCoord  
{  
//no arg (default) constructor  
public XYCoord()  
{  
x = 0;  
y = 0;  
}
 
//alternate constructor  
public XYCoord(int x_value, int y_value)  
{  
x = x_value;  
y = y_value;  
}  
}
 
XYCoord coord1;  
coord1 = new XYCoord();  
Constructs a new XYCoord object with value (0, 0) by use of the  
no-arg (default) constructor   XYCoord coord1;  
coord1 = new XYCoord(0, 0);  
Constructs a new XYCoord object with value (0, 0) by use of the  
alternate constructor   XYCoord coord2;  
coord2 = new XYCoord(20, 60);  
Constructs a new XYCoord object with value (20, 60) by use of the  
alternate constructor
 
each constructor has to either have different parameters or be of different types
 
Adding Getters and Setters
 
public class XYCoord  
{  
//instance variables  
private int x;  
private int y;  
.  
.  
public int getX()  
{ return x; }
 
public void setX(int value)  
{ x = value; }
 
public int getY()  
{ return y; }
 
public void setY(int value)  
{ y = value; }  
.  
.  
}
 
"you always want getters, but you don’t always want setters"
 
XYCoord cord1;  
coord1 = newXYCoord(10,20)
 
coord1.print() --> (10,20)  
.  
.  
coord1.getX() --> 10  
coord1.getY() --> 20  
.  
.  
coord1.setX(5);  
.  
coord1.print() --> (5,20)  
--------------------------------------
 
getters = accessors  
setters = mutators  
objects mutable with setter methods
 
adding a general method
 
----------------------------------------------------------------------------------------  
public class XYCoord  
{  
//instance variables  
private int x;  
private int y;  
.  
.  
.  
public double distance(XYCoord rCoord)  
{
 
double xTerm = 0;  
double yTerm = 0;  
double distance = 0;
 
xTerm = Math.pow(rCoord.getX() - x, 2);  
yTerm = Math.pow(rCoord.getY() - y, 2;  
distance = Math.sqrt(xTerm + yTerm);
 
return distance;  
}  
}  
----------------------------------------------------------------------------------------  
XYCoord coord1;  
coord1 = new XYCoord(10, 20);   XYCoord coord2;  
coord2 = new XYCoord(50, 70);   distance = coord1.distance(coord2);
 
System.out.println(“The distance between coordinates” +  
“(” + coord1.getX() + “, “ + coord1.getY() + “)” +  
“(” + coord2.getX() + “, “ + coord2.getY() + “)” +  
“is “ + distance);  
OUTPUT:  
The distance between coordinates (10, 20) and (50, 70) is 44.72  
The above println is tedious to write. Can do a better way.   Defining a toString Method  
public class XYCoord  
{  
//instance variables  
//constructors
 
public String toString()  
{  
return "(" + x + ","+ y + ")";  
}  
}
 
now you can say:  
System.out.println("The distance between coordinates" + coord1.toString() + "and" + coord2.toString() + "is" + distance);
 
PROTIP  
java can implicitly determine to use methods called toString during concatenation checks, so you can actually say:
 
System.out.println("The distance between coordinates" + coord1 + "and" + coord2 + "is" + distance);
 
SO NAME YOUR METHOD toString PLEASE!!!