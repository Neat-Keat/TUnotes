Start of Polymorphism
 
-------------------------------------------------------------------------------------------------------------------------------
 
The menu object can provide an iterator thru menu options with its methods
 
Current_index to be used by bottom 3 iterator methods  
for the iterator method, check if menu_items[I] == null OR out of bounds error
 
menu = everything they CAN order  
orders = everything they HAVE ordered
 
add more error handling to prevent ALL errors, not just whats listed in instructions
 
disyplay menu, items with a number  
users enter a number corresponding to a menu item to add it to their order
 
-------------------------------------------------------------------------------------------------------------------------------
 
INHERITANCE AND POLYMORPHISM
 
Single vs multiple inheritance  
in general in OOP, a class may inherit from more than one parent class, referred to as multiple inheritance. Java, however, only allows for single inheritance.  
java still lets you have multityped objects, however
   

imagine
 
Student class  
public float getGPA()
 
Worker Class  
public float getHrPay()
 
Student Worker class  
public float getGPA()  
public float getHrPay()
 
can be passed to methods as either a student OR a worker!!
 
Subclasses vs subtypes  
the notion of a sybtype is an important one in OOP  
if an object is a subtype of another object, then the subtype object should be able to be substituted for the supertype with no consequences
 
POLYMORPHISM  
something that takes many forms. A classic example is the concept of a shape.
 
circles, squares, triangles, etc. are all a type of shape. Thus, when these classes are declared subclasses (e.g., subtypes) of the shape class, then polymorphism can be used.
 ![Oeae a16ue!11 Oeae auenbs Oeae adeqs Oeae apu!0 ](Exported%20image%2020240525213005-0.png)  

abstract classes can be declared for classes without complete methods, strictly to derive from for subclasses.  
subclasses inherit incomplete methods, which you can implement to make it concrete
 
**WITHOUT POLYMORPHISM**
 ![// get area switch (which) { case 1: area = circleVar. area(); break; case 2: area = squareVar.area(); break; case 3: area = triangleVar.area(); break; // user selects size change in GUI size: ") size_value = input. nextlnt(); switch (which) { This is very tedious. Also, if a new shape is added to the program (Rectangle), then ALL the switch statements in the program must be case 1: circleVar.setSize(size_value); break; altered. case 2: squareVar.setSize(size_value); brea case 3: triangleVar.setSize(size_value); brea // user selects new location in GUI size: ") size_value = input. nextlnt(); switch (which) { case 1: circleVar. brea case 2: squareVar.setLocation(new_loc); bre k; case 3: triangleVar.setLocation(new loc); b ak; ](Exported%20image%2020240525213005-1.png)  
![With the Use of Polymorphism With the use of polymorphism, there is only ONE variable declared of the parent class type, Shape. Shape shapeVar; When the user enters what shape they want, the following switch statement is executed, switch (which) { case 1: shapeVar = new Circle(); break; case 2: shapeVar = new Square(); break; case 3: shapeVar = new Triangle; break; ](Exported%20image%2020240525213005-2.png)  

public abstract class Shape {
 
String color;
 
public Shape(String color) {  
this.color = color;  
}
 
public abstract double area();  
}
   

public class Circle extends Shape {
 
double radius;
 
public Circle(int size, String color) {  
super(color);  
this.radius = radius();  
}
 
public double area() {  
return Math.PI * radius * radius;  
}  
}