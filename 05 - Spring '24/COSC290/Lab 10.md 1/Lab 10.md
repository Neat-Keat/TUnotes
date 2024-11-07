Next week *should* be the last lab  
Assignment 10 added lulw
 
32 bit registers  
16 bit registers  
8 bit registers
 
All 32 bits is EAX  
Lower 16 bits is AX  
Lower 8 bits is AL  
Upper 8 Bits is AH
 ![aaae coel 0010 0011 0101 0101 0100 0101 EAX- 0110 alll 0110 0111 0110 0111 —FFFFFFFF ES I =0040BOl A AL EBX- —FFFFFFFE ED I OAA EFL=00000202 ](Exported%20image%2020240525213137-0.png)  

TYPE operator returns the size in **bytes** of 1 element of a data declaration

![. data varl BYTE ? var2 WORD ? var3 pwpgp ? var4 Qwpgp ? . code TYPE TYPE TYPE TYPE varl var2 var3 var4 1 2 4 8 ](Exported%20image%2020240525213137-1.png)   
OFFSET operator gets # of address location
 ![(Example) Let's assume that the data segment begins at 00404000h: . data BYTE ? WORD ? dva12 ? . code OFFSET OFFSET OFFSET OFFSET dva12 = 00404000 = 00404001 = 00404003 = 00404007 ](Exported%20image%2020240525213137-2.png)   
LENGTHOF operator counts # of elements in an array (note that strings are treated as an array of characters)
 
DUP() operator creates a copy of something //short for duplicate?  
5 DUP(?) -> creates an array with 5 empty elements  
5 DUP(a) -> creates an array with 5 elements that all store a
 
Note the nested dup call in line 4  
5 DUP (3 DUP (?)) -> 5 DUP(_,_,_) -> empty array of size 15
 ![. data bytel BYTE 10, 20, 30 arrayi 30 array2 5 DUP(3 DUP(?)) array3 m.'ORD digitstr BYTE "12345678", O . code mov ecx, LENGTHOF arrayi LENGTHOF 3 32 15 4 9 32 ](Exported%20image%2020240525213137-3.png)  

SIZEOF returns LENGTHOF * TYPE -> essentially, the number of bytes!

![. data bytel BYTE 10, 20, 30 arrayi 30 array2 5 DUP(3 DUP(?)) array3 m.'ORD 3 4 digitstr BYTE "12345678", o . code mov ecx,SIZEOF arrayl SIZEOF 3 30 16 9 ](Exported%20image%2020240525213137-4.png)   
Addressing Mode (Direct)

- Direct-Offset Operands: A constant offset is added to a data label to produce an effective address (EA). The address is dereferenced to get the value inside its memory location
 
Note that to access ARRAY_A  
ARRAY_A[0] //does not work!  
ARRAY_A //does work!  
//no explanation why
 ![. data ARRAY A . code BYTE 10h, 20h, 30h, 40h MOV MOV MOV mov ARRAY ARRAY al, [ARRAY ARRAY al = 20h al = 20h alternative notation al = 30h ](Exported%20image%2020240525213137-5.png)  

Indexed Addressing Mode

- AN indexed operand adds a constant to a register to generate an effective address. There are 2 notational forms
    
    - [label + reg]
    - Label[reg]
 ![. data arrayW . code mov mov mov add add etc. 1000h, 2000h, 3000h esi, O ax, [arrayW + esi] ax, arrayW[esi] esi, 2 ax, [arrayW + esi] AX = 1000h alternate format AX = 3000h ](Exported%20image%2020240525213137-6.png)   
Addressing Mode (Indirect)

- An indirect operand holds the address of a variable, usually an array or string. It can be dereferenced
 ![. data vall BYTE 10h, 20h, 30h . code • AL = 20h AL = 30h mov mov Inc mov Inc mov esi,OFFSET vall [esi] es1 [esi] es1 [esi] dereference ESI (AL = 10h) ](Exported%20image%2020240525213137-7.png)  

When you copy a smaller value into a larger destination, the MOVZX instruction fills the upper half of the destination with 0s

- The destination MUST be a register
 ![0 00000000 ax, b 1 Source zero-extension ](Exported%20image%2020240525213137-8.png)   
The MOVSX instruction fills the upper half of the destination with a copy of the source operand's sign bit

- The destination MUST be a register
 ![ax,bl sign extension ](Exported%20image%2020240525213137-9.png)  

The LOOP instruction creates a counting loop

- Syntax: LOOP target
- Logic: ECX is used for a "loop counter"

ECX <- ECX – 1  
If ECX != 0, jump to target
 ![. code Oh 5h LI : add loop LI = 15h (5+4+3+2+1) ](Exported%20image%2020240525213137-10.png)

Note that because ECX = 5, it decrements by 1 on each loop, stopping on 0
 
--------------------------------------------------------------------------------------------------------  
￼Start of the assignment lol
 
#1) attach ss of code and output