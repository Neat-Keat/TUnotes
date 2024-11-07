Shannon's Theorem example numbers:
$$ C = 3000 * log_2(1 + 1000)* $$


-----------

Transmission Errors
- external electromagnetic signals can cause incorrect delivery of data
	- data can be received incorrectly
	- data can be lost
	- unwanted data can be generated
- any of these problems are called transmission errors
	- 3 main sources of transmission errors:
		- interference
		- distortion
		- attenuation

approaches to reduce errors
- Shannon's theorem:
	- increase the signal-to-noise ratio
		- by increasing the signal or
		- by lowering noise
- Shielded wiring
- noise/interference cannot be eliminated completely
	- transmission errors can be *detected*
	- some errors can be *corrected* automatically
- error detection adds *overhead*
- *error handling* is a tradeoff, system designers
	- must decide whether a given error is likely to occur
	- analyze the consequences

![[Pasted image 20240924093503.png]]

Error detection -
	send additional info so incorrect data can be detected and rejected (Automatic Repeat reQuest (ARQ) mechanism)
	determine changed bits exactly and to compute correct values
Error correction -
	send additional information so incorrect data can be corrected and accepted (Forward Error Correction (FEC) mechanism)
	Sender and receiver exchange messages to insure that all data arrives correctly

Parity Checking
- *parity* refers to the number of bits set to 1 in the data item
	- *even parity* - an even number of bits are 1
	- *odd parity* - an odd number of bits are 1
- A *parity bit* is an extra bit transmitted with a data item, chose to give the resulting bits even or odd parity

000  0
001  1
010  1
011  0
100  1
101  0
110  0
111  1

![[Pasted image 20240924094012.png]]

The mathematics of Block Error Codes and (n, k) notation
- Mathematically
	- we define the set of all possible messages to be a set of *datawords -> k*
	- and define the set of all possible encoded versions to be a set of *codewords -> n*
- *(n, k)* encoding scheme
	- where *n = k + r, r is additional bit*
- Error detection utilizes *2* valid codewords
	- the valid subset is known as a *codebook*

![[Pasted image 20240924094410.png]]

Hamming Distance
- given 2 strings of *n* bits each, the Hamming distance is defined as the number of differences
- Exclusive OR can compute Hamming Distance
ex:
	The XOR of the 2 strings is
		110 + 011 = 101 => 2
		d(000, 001) = 1
		d(000, 101) = 2
		d(101, 100) = 1
		d(001, 010) = 2
	counts the number of different bits basically

minimum hamming distance:
	from 1 code word to another valid code word, its the minimum # of bit changes

- When erros transform a valid codeword into another valid codeword
	- use of Hamming distance
- Consider fig 8.6 that lists the *four (4)* possible datawords and Hamming distance
- minimum Hamming distance, d_min
	- determines the number of bit errors that can cause such transformation

![[Pasted image 20240924094832.png]]

The tradeoff between error detection and overhead
- a large value of d_min is desirable
	- fewer than d_min bits are changed -> error(s) occurred
- the max # of bit errors, e, can be computed as:
$$ e = d_min - 1 $$
- a code with a higher value of d_min sends more *redundant* information than an error code with a lower value of d_min
- code rate can be computed as:
$$ R = k/n $$
Minimum Hamming Distance
- the minimum Hamming distance for a code, D(min), determines its error detecting and error correcting capability.
- for any code word, X, to be interpreted as a different valid code word, Y, at least D_min single-bit errors must occur in X
- Thus, to detect k (or fewer) single-bit errors, the code must have a Hamming distance of D_min = k + 1

![[Pasted image 20240924095157.png]]
![[Pasted image 20240924095209.png]]
the 2 disagreements correspond to the row and column position of the error
	correct the error
RAC can correct any single data error
When 2 or 3 bits are changed
	RAC encoding detects an odd number of errors only

Alternative Error Detection Schemes:
- many alternative schemes that:
	- detect multi-bit errors
	- correct errors through redundant info
- checksum and CRC are 2 widely used techniques

![[Pasted image 20240924095734.png]]
![[Pasted image 20240924095806.png]]

Checksums
sum of data in messages treated as an array of integers
-  can be 8-, 16- or 32-bit integers
- typically use 1's-complement arithmetic
- ex - 16-bit checksum with 1's complement arithmetic
- the size and ease of computation => requires addition only
![[Pasted image 20240924095933.png]]

![[Pasted image 20240924095956.png]]

Cyclic Redundancy Checks
* detect more errors without increasing additional info in each packet
* consider data in message as coefficients of a polynomial
* divide that coefficient set by a known polynomial e.g. 1011
* Ex: 1010 = x^3 + x (known polynomial) -> y
	* preprocessing: data bits: m
		1. add k 0's to the data -> m + k -> n
		2. divide n with y
		3. find remainder ->
		4. subtract remainder from n -> z
	- transmit remainder as CRC
	- no error if z is divisible by y at the receiver
	- easy to implement in hardware


CRC review in class:

1         0        1        1
x^3   x^2   x^1   x^0 
1         0         1       1

do a mod2 division, add the remainder to the codeword, and see if it matches

ex
we want to transmit:

10111011

with polynomial 1011 (of power x^3)

10111011 divided by 1011:

1011 | 10111011 000 (adding 3 zero's to the end)

![[Pasted image 20240924101217.png]]
the do 1001 | 10111011 110 as the receiver
	if it returns a remainder of 0, then no error!

CRC Key properties:
- arbitrary length message
- excellence error detection
- fast hardware implementation

most commonly used CRC Polynomials
CRC-8: 100000111 (9 bits)
CRC-10: 11000110011
CRC-12: 1100000001111
CRC-16: 11000000000000101
CRC-CCITT: 10001000000100001
CRC-32: 100000100110000010001110110110111
CRC-64

![[Pasted image 20240924101622.png]]
![[Pasted image 20240924101630.png]]

Error Detection and Frames
- error detection typically done for each frame
- error in frame typically causes receiver to discard frame
- ex - CRC sent after end of frams computed on data in frame

![[Pasted image 20240924101750.png]]

be able to do a CRC problem by hand!
\
# Transmission Modes
-----------

![[Pasted image 20240924101931.png]]

Serial:
10111100 ->

Parallel
1 ->
0 ->
1 ->
1 ->
1 ->
1 ->
0 ->
0 ->

parallel is much faster right?
	well the transmission delay for each wire can vary slightly, messing up the order in which bits arrive
today, the most popular form we use is USB!

![[Pasted image 20240924102211.png]]
![[Pasted image 20240924102217.png]]
![[Pasted image 20240924102224.png]]
![[Pasted image 20240924102304.png]]
![[Pasted image 20240924102330.png]]
![[Pasted image 20240924102430.png]]

Universal Serial Bus 
- an industry standard developed in the mid-1990s
- designed to standardize the connection of computer peripherals to personal computers
- effectively replaced a variety of earlier interfaces such as serial and parallel ports, as well as power chargers for portable devices
- the most recent USB specification is USB4 Version 2.0, which offers a significant bandwidth upgrade of up to 80 Gbps

![[Pasted image 20240924103115.png]]

Timing of Serial Transmission
3 categories:
- *Asynchronous* transmission can occur at any time
- *Synchronous* transmission occurs continuously with *no gap* between the transmission of two data items
	- *Isochronous* transmission occurs at regular intervals with a *fixed gap*

Encoding details
- several standard organizations specify the details:
	- IEEE
	- ITU
	- EIA
- To be interoperable network hardware should conform to the standards

The RS-232C Standard
- Ex use
	- connection to keyboard/mouse
	- Serial port on PC
- Specified by EIA
- voltage is +15 or -15
- Cable limited to <50 feet
-  Uses asynchronous communication
![[Pasted image 20240924103542.png]]

Asynchronous Communication
- sender and receiver must agree on:
	- number of bits per character
	- duration of each bit
- receiver
	- does not know when a character will arrive
	- may wait forever
- to ensure meaningful exchange send
	- start bit before character
	- one or more stop bits after character

Synchronous Transmission
- a synchronous mechanism transmits
	- back-to-back transmission
- the sender and receiver must remain synchronized
- RS-232 requires an extra start bit and stop bit
	- requires 10 bit times
- On a synchronous system
	- each character is sent without start or stop bits
![[Pasted image 20240924103812.png]]

Duration of a bit in RS-232C
- determined by baud rate
	- typical baud rate is 9.6Kbaud, 14.4Kbaud, 28.8Kbaud
	- duration of bit is 1/baud_rate
- Sender and receiver must agree on the details
- receiver examines signal
- disagreement results in framing error

Bytes, Blocks, and Frames
- when sender sends bits continually with synchronous mechanism
	- *use of framing:*
		- frame is used in a synchronous mechanism to handle a block of bytes
	- for proper synchronization
		- a frame starts with a special sequence of bits
	- when no data to send
		- an idle sequence (or idle byte)

![[Pasted image 20240924104255.png]]

Isochronous Transmission
	- provides *steady bit flow* for multimedia applications
- Reasoning for steady bit flow
	- to prevent *jitter*
- at a fixed rate, R
	- network interface handles transmission at exactly R bits per second
![[Pasted image 20240924104431.png]]![[Pasted image 20240924104445.png]]
![[Pasted image 20240924104452.png]]
![[Pasted image 20240924104458.png]]
![[Pasted image 20240924104505.png]]
![[Pasted image 20240924104511.png]]
![[Pasted image 20240924104516.png]]

---------
midterm next week, study guide given out next class
whatever we cover TH, will be on the exam