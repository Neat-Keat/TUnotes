![Data Types Integer Float (or real) Character String Boolean Data set All whole numbers All real numbers All letters, symbols, numbers, and special symbols Combination of more than one character TRUE, FALSE Examples 3580, -90, 6 37.92, -8.3, 100.0 single quotes "21093", "Mrs Smith" Double quotes done, valid ](Exported%20image%2020240525202933-0.png) ![• • Variables and Constants constant alphabetic or numeric value that never changes during processing can be any data type can also be used for something that may change at a later date — need only be changed in one place Aids readability — const float PI = 3.14; - const float MD TAX RATE = .06; Note, use caps for constants variable - value does change during process cosc175/data 3 ](Exported%20image%2020240525202933-1.png) ![Example: C++ Data types Data type Stores fundamental data types user-defined data type short int fl oat double bool char stri ng an integer Range: -32,768 to 32,767 an integer Range: -2,147 to 2,147 a real number with 7 digits of precision Range: -3.4 x 1038 to 3.4 x 1038 a real number with 15 digits of precision Range: -1.7 X 10308 to 1.7 X 10308 a Boolean value se) one character zero or more characters cosc175/data Memory required 2 bytes 4 bytes 4 bytes 8 bytes 1 byte I byte I byte per character 8 ](Exported%20image%2020240525202933-2.png)

We'll use INT and FLOAT in this class

![Numerical Data • Is used for all types of numbers • Used in calculations • Use numerical data for values such as salary, hours • Do not use for zip-code or social security number Numerical Data Types examples: . int float or double ](Exported%20image%2020240525202933-3.png)

INT's have a bit reserved for declaring the sign of the #
 
If #s are too big, then you get INT overflow, where the value wraps around and overwrites important other data, like the sign bit  
EX: int num1;

FLOAT's include decimal precision
 
EX: float itemPrice;

![characters Are all letters, numbers, and special characters Declare character inputChar BCD_- convert each digit into binary form (uses 4 bits) ASCII - American Standard Code for Information Interchange 7 bits used for pc's http://www.asciitable.com/ EBCDIC - Extended Binary Coded Decimal Interchange Code 8 bits IBM mainframes ](Exported%20image%2020240525202933-4.png)

[http://www.asciitable.com/](http://www.asciitable.com/)

![string • Are set of characters • + - concatenation - joins strings together — "44" • use string for zip code - allows you to hold leading o's Examples: Declare: string zipCode; zipCode = "21093"; ](Exported%20image%2020240525202933-5.png)

CONCATENATION: adding strings together

Pay attention to declaring with ", not '

Declaring Data Types:
 
Variables must be declared before use  
DECLARATION - defines data type and allocates memory  
Variable names correspond to memory address

![Numbering system Decimal Octal Hexadecimal Binary 0-1 BASE 10 8 16 2 Digits ](Exported%20image%2020240525202933-6.png) ![Exported image](Exported%20image%2020240525202933-7.png) ![Binary to Decimal Multiply the I's in a binary number by their position values, then sum the products. Exa. 02 O X 2A0 O X 2A2 1 X 2A4 = 16 2610 ](Exported%20image%2020240525202933-8.png) ![Converting From Decimal to Binary use the division/remainder technique Divide the number repeatedly by 2 and record the remainder of each division. 100112 - 1910 2. 21 19 21 9 21 4 21 2 21 1 Reverse:. 1 ](Exported%20image%2020240525202933-9.png) ![Binary to Octal •Start with the rightmost digit • group by 3 digits •Look up the octal equivalent 100 0011102 4 1 68 ](Exported%20image%2020240525202933-10.png) ![Octal to Binary •Start with the rightmost digit • Look up the binary equivalent (3 digits) 5 38 101 0112 ](Exported%20image%2020240525202933-11.png) ![Binary to Hex •Start with the rightmost digit • group by 4 digits •Look up the hex equivalent 110001012 c 516 ](Exported%20image%2020240525202933-12.png) ![Hexadecimal to Binary Perform the grouping procedure in reverse. B 316 1011 00112 ](Exported%20image%2020240525202933-13.png)