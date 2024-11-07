Error Checking Method

- Data Transmission
    
    - Do you want to save your data?
        
        - Yes(1) / No(0)
        - S:1 R:0
        - S:1 R:1
- Types of Error-checking
    
    - Detection
        
        - Checking whether the received data bits has an error
            
            - Parity check
    - Correction
        
        - Checking which data bit is erroneous + correction!
            
            - Hamming code
 
Even parity bit generator with 3 inputs = input 1 XOR input 2 XOR input 3 = A'B'C + A'BC' + AB'C' + ABC != a XOR gate with 3 inputs
 
For even parity generation, we cannot use Built in XORS for inputs >2 bits  
USE 2-CHAIN XORS INSTEAD