Chapter 3 – Boolean Algebra and Digital Logic
 
3.5 Digital components
 
- The main thing to remember is that combinations of gates implement Boolean functions
- We simplify our Boolean expressions so that we can create simpler circuits
![• The circuit below implements the Boolean function F(x,y,z) = x + w. ](Exported%20image%2020240525213135-0.png)   - Standard digital components are combined into single integrated circuit packages
- Boolean logic can be used to implement the desired functions ![• The Boolean circuit: x (x'y)' = x + y' x'y • Can be rendered using only NANO gates as: x' ](Exported%20image%2020240525213135-1.png)  
-   
    
- ![• So we can wire the prepackaged circuit to implement our function: x x'y ](Exported%20image%2020240525213135-2.png) - Boolean logic is used to solve practical problems
- Expressed in terms of Boolean logic practical problems can be expressed by truth tables
- Truth tables can be readily rendered into Boolean logic circuits           
3.6 Combinational Circuits
 
- F(x,y,z) = X+Y'Z
    
    - This is an example of a combinational logic circuit
    - Combinational logic circuits produce a specified output (almost) at the instant when input values are applied
        
        - This is not always the case, as seen later 
Half adder is a combinational circuit!

![I nputs Ou tpu t s S um Car r y x o O 1 Y o 1 ](Exported%20image%2020240525213135-3.png) ![c arry ](Exported%20image%2020240525213135-4.png)   
Full adder!

![x o o I npu t s C a rry Y In o o Ou tpu t s S um Ou t ](Exported%20image%2020240525213135-5.png)  
![Carry ](Exported%20image%2020240525213135-6.png)  

2 half adders = 1 full adder  
2+ full adders = ripple-carry adder
 ![Xls Carry Out FA Carry In ](Exported%20image%2020240525213135-7.png)  

- Combinational circuit
- Among other things, they are useful in selecting a memory location according to a binary value placed on the address lines of a memory bus
- Address decoders with n inputs can select any of 2^n locations ![n Inputs Decoder 2 n Outputs ](Exported%20image%2020240525213135-8.png)  
![• This is what a 2-to-4 decoder looks like on the inside. If x = O and y = I, which output line is enabled? ](Exported%20image%2020240525213135-9.png)
 
- Does the opposite of a decoder
- Selects 1 output from several inputs
- The particular input chosen for the output is determined by the value of the multiplexer's control lines
- To be able to select among n inputs, log(n) control lines are needed
![1 1 1 Mul tip 1 exer (MVX) Sl SO Control lines ](Exported%20image%2020240525213135-10.png) ![Exported image](Exported%20image%2020240525213135-11.png)  
 
- Combinational logic circuits are perfect for situations when we require the immediate application of a Boolean function to a set of inputs
- There are other times, however, when we need a circuit to change its value with consideration to its current state as well as it inputs
    
    - These circuits have to "remember" their current state
- Sequential logic circuits provide this functionality for us - As the name implies, sequential logic circuits require a means by which events can be sequenced
- State changes are controlled by clocks
    
    - A "clock" is a special circuit that sends electrical pulses through a circuit
- Clocks produce electrical waveforms such as the one shown below
![Exported image](Exported%20image%2020240525213135-12.png)- State changes occur in sequential circuits only when the clock ticks
- Circuits can change state on the rising edge, falling edge, or when the clock pulse reaches its highest voltage
![Falling Rising Edge High ](Exported%20image%2020240525213135-13.png)- Circuits that change state on the rising edge, or falling edge of the clock pulse are called edge-triggered
- Level-triggered circuits change state when the clock voltage reaches its highest or lowest level

- To retain their state values, sequential circuits rely on _feedback_.
- Feedback in digital circuits occurs when an output is looped back to the input.
- A simple example of this concept is shown below.
    
    - If Q is 0 it will always be 0. If it is 1, it will always be 1. Why?
    ![Exported image](Exported%20image%2020240525213135-14.png)
 - You can see how feedback works by examining the most basic sequential logic components, the SR flip-flip.
    
    - The SR stands for set/reset
- The internals of an SR FF are shown below, along with its block diagram
- The behavior of an SR flip flop is described by a characteristic table
- Q(t) means the value of the output at time t. Q(t+1) is the value of Q after the next clock pulse
![Exported image](Exported%20image%2020240525213135-15.png)  
- The SR FF actually has 3 inputs: S, R, and its current output, Q.
- Thus, we can construct a truth table for this circuit, as shown at the right.
- Notice the 2 undefined values. When both S and R are 1, the SR FF is unstable
- If we can be sure that the inputs to an SR FF will never both be 1, we will never have an unstable circuit. This may not always be the case
- The SR FF can be modified to provide a stable state when both inputs are 1
- This modified FF is called a JK FF, shown below.
![Exported image](Exported%20image%2020240525213135-16.png)  
- below, we see how an SR FF can be modified to create a JK FF
- The characteristic table indicates that the FF is stable for all inputs ![Exported image](Exported%20image%2020240525213135-17.png)  
- Another modification of the SR FF is the D FF, shown below with its characteristic table
- You will notice that the output of the FF remains the same during subsequent clock pulses. The output changes only when the value of D changes. ![Exported image](Exported%20image%2020240525213135-18.png)  
- The D FF is the fundamental circuit of computer memory
    
    - D FFs are usually illustrated using the block diagram shown below.
- The characteristic table for the D FF is shown below.
![Exported image](Exported%20image%2020240525213135-19.png)  
- The behavior of sequential circuits can be expressed using characteristic tables or finite state machines (FSMs)
    
    - FSMs consist of a set of nodes that hold the states of the machine and a set of arcs that connect the states.
- Moore and Mealy machines are 2 types of FSMs that are equivalent
    
    - They differ only in how they express the outputs of the machine
- Moore machines place outputs on each node, while Mealy machines present their outputs on the transitions. ![Exported image](Exported%20image%2020240525213135-20.png)   - Although the behavior of Moore and Mealy machines is identical, their implementations differ.
- This is our Moore machine:
![Exported image](Exported%20image%2020240525213135-21.png)  
- This is our Mealy machine:
![Exported image](Exported%20image%2020240525213135-22.png)  
- It is difficult to express the complexities of actual implementations using only Moore and Mealy machines.
    
    1. They do not address the intricacies of timing very well
    2. It is often the case that an interaction of numerous signals is required to advance a machine from one state to the next.
- For these reasons, Christopher Clare invented the algorithmic state machine (ASM).
          
Decoders
    
Multiplexer
 
The Shifter!  
Moves the bits of a nibble 1 position to the left or right

![03 01 0 一 0 。 ](Exported%20image%2020240525213135-23.png)  

3.7 Sequential Circuits
    ![Exported image](Exported%20image%2020240525213135-24.png)   ![Exported image](Exported%20image%2020240525213135-25.png)                    

- Sequential circuits are used anytime that we have a "stateful" application.
    
    - A stateful application is one where the next state of the machine depends on the current state of the machine and the input.
- A stateful application requires both combinational and sequential logic.
- The following slides provide several examples of circuits that fall into this category.
- Can you think of others? ![Exported image](Exported%20image%2020240525213135-26.png)  
![Exported image](Exported%20image%2020240525213135-27.png)  
![Exported image](Exported%20image%2020240525213135-28.png)   - We have seen digital circuits from 2 points of view: digital analysis and digital synthesis
    
    - Digital analysis explores the relationship between a circuits inputs and its outputs
    - Digital synthesis creates logic diagrams using the values specified in a truth table.
- Digital systems designers must also be mindful of the physical behaviors of circuits to include minute propagation delays that occur between the time when a circuit's inputs are energized and when the output is accurate and stable. - Digital designers rely on specialized software, such as VHDL and Verilog, to create efficient circuits.
    
    - Thus, software is an enabler for the construction of better hardware.
- Of course, software is in reality a collection of algorithms that could just as well be implemented in hardware
    
    - Recall the principle of equivalence of hardware and software. - When we need to implement a simple, specialized algorithm and its execution speed must be as fast as possible, a hardware solution is often preferred
- This is the idea behind _embedded systems_, which are small special-purpose computers that we find in many everyday things.
- Embedded systems require special programming that demands an understanding of the operation of digital circuits, the basics of which you have learned in this chapter.
            

CONCLUSION

- Computers are implementations of Boolean logic
- Boolean functions are completely described by truth tables
- Logic gates are small circuits that implement Boolean operators
- The basic gates are AND, OR, and NOT
    
    - The XOR gate is very useful in parity checkers and adders
- The "universal gates" are NOR and NAND
- Computer circuits consist of combinational logic circuits and sequential logic circuits
- Combinational circuits produce outputs (almost) immediately when their inputs change
- Sequential circuits require clocks to control their changes of state
- The basic sequential circuit unit is the FF: the behaviors of the SR, JK, and D FFs are the most important to know
- The behavior of sequential circuits can be expressed using characteristic tables or through various finite state machines
- Moore and Mealy machines are 2 finite state machines that model high-level circuit behavior.