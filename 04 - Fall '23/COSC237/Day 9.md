Subclasses start today  
Program 2 uses objects  
Program 3 will use subclasses
 
-------------------------------------------------------------------------------------------------------------------------------
 
INHERITANCE AND POLYMORPHISM
 
Think of using objects as variables like plugging in a component to a motherboard
 
INHERITANCE  
Inheritance occurs when a subclass of a given class is declared  
The *extends* keyword is used to define a subclass  
We look at the definition of a ColorLine class as a subclass of the Line class.
 ![Line Class public class Line private XYCoord coordl; private XYCoord coord2; private final double epsilon = Init some epsilon that difference of lengths must be within to be public Line(XYCoord coordl, this.coordl= coordl; this.coord2 = coord2; // (getter and setters to be placed here) public boolean equals(Line Tine) { // retums true if equal length within the specified epsilon We will soon see a more retum Math. abs(length() - rLine. length()) robust definition for equals methods public double length() { retum Math.sqrt(Math.pow(coord2.getX() - coord1.getX(), 2) + Math.pow (coord2.getY() - coord1.getY(), 2) ) ](Exported%20image%2020240525213003-0.png)   ![Use of the Line Class public static void main(String[] args) Line linel, line2; linel = new Line(new XYCoord(O, O), new XYCoord(10, O)); line2 = new Line(new XYCoord(O, 10), new XYCoord(10, 10)); of linel: " + linel.length()); of line2: " + line2.length()); if(line1.equals(line2)) and line2 are equal in length"); else and line2 are NOT equal in length"); OUTPUT Length of linel: 10 Length of line2: 10 linel and line2 are equal in length ](Exported%20image%2020240525213003-1.png)   
ColorLine a Subclass of the Line Class  
-------------------------------------------------------------------------------------------------------------------------------  
//declared as a subclass of the line class  
public class ColorLine extends Line  
{  
private String color;
 
//coord1 & coord2 inherited as part of class definition  
public colorLine(XYCoord coord1, XYCoord coord2, String color) {  
//call to superclass constructor to init its private instance variables  
super(coord1, coord2); //MUST be first line? if its not here java will call default constructor automatically
 
//constructor colorLine inits its private instance variables  
this.color = color;  
}
 
//provided getter and setter for the line color  
public void setColor(String color) {  
this.color = color;  
}
 
public String getColor() {  
return color;  
}
 
//calls to equals method of superclass from within equals method of this subclass  
public boolean equals(ColorLine rLine) {  
return super.equals(rLine) && rLine.color.equals(color));  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
use super to refer to immediate parent class
 
we can type cast subclasses to parent classes  
(line) redLine  
we CANNOT type cast parent classes to subclasses  
(colorLine) line1  
-------------------------------------------------------------------------------------------------------------------------------
 
public static void main(String[] args)  
{  
ColorLine line1, ine2;
 
line1 = new ColorLine(new XYCoord(0,0) new XYCoord(10,0), "red");  
line2 = new ColorLine(new XYCoord(0,10), new XYCoord(10,10), "black");
 
System.out.println("Length of line1: " + line1.length());  
System.out.println("Length of line2: " + line2.length());
 
if(line1.equals(line2))  
System.out.println("line1 and line2 are equal in length and color");  
else  
System.out.println("line1 and line2 are NOT equal in length and color");  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
Determining the Type of an object during Program Execution
 
the instanceof Operator  
one way to check the type of a given object at execution time is with the instanceof operator  
if (line instanceof ColorLine)  
System.out.println("Color of line is " + line.getColor());
   
![public class ColorLine private XYCoord coordl; private XYCoord coord2; Private members inherited from Line class, and therefore not directly accessible from the methods private final double epsilon = private int colorCode; public ColorLine(XYCoord coordl, XYCoord coord2) { } public int getCoIor() { } public boolean equals(Line rLine) { } public double length() { } Members in blue are inherited from the Line class. Members in black are newly-defined in the class. Members in red override methods inherited from the Line class. ](Exported%20image%2020240525213003-2.png)     

An overriding method is a method of a subclass with the same function signature as a method inherited from its superclass, thus redefining it in the subclass
 
the equals method of the ColorLine class is an example of an overriding method
 
OVERRIDING =/ OVERLOADING
 
a symbol can be overloaded if it has different behaviors depending on the types and amounts of arguments passed to it
 
a method can override parent methods by being declared in a subclass with the same name, type, and args
 
generally, OOP langs allow for inheritance from more than one parent, but java only allows for single inheritance
 
multiple inheritance is a means of inheriting code from more than one super class. This results in a (sub)class which is multi-typed.
 
There are other means of creating a multi-typed class without the use of multiple inheritance. This is done in Java by the use of Java interfaces (we will discruss Java interfaces later).