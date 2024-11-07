Day 11 was exam 1!

high score was 98
avg was 74

solutions in lecture notes and textbook

----------

Multiplexing and Demultiplexing

# Multiplexing Concepts
- typically, w communicating stations will not utilize the full capacity of a data link
- for efficiency, it should be possible to share that capacity
- such sharing is called multiplexing

- *multiplexing* refers to the *combination* of information streams from multiple sources for transmission over a *shared medium*
- *demultiplexing* refers to the *separation* of a combination back into separate information streams
![[Pasted image 20241003094522.png]]

- Multiple signals with data can be carried on the same medium without interference
	- allows multiple simultaneous data streams
	- dialup modems can carry full-duplex data on one voice channel
- Ex: multiple TV stations in air medium
- Each separate signal is called channel
![[Pasted image 20241003094633.png]]

# Types of Multiplexing
- Major approaches
	- frequency division multiplexing (FDM)
	- Orthogonal FDM (OFDM): 4G/5G, Wi-fi
	- Wavelength Division Multiplexing (WDM)
	- Time Division Multiplexing (TDM)
	- Code Division Multiplexing (CDM)
- TDM supports legacy systems and telephony infrastructure
- FDM is still widely used
- WDM is a form of FDM used for optical fiber
- CDM/CDMA is a mathematical approach used in *cell phone* mechanisms

# Frequency Division Multiplexing
- the most familiar method to anyone who ever used radio or TV set - widely used, long-lived
- Can be used with analog signals
	- each carrier is assigned a separate channel
- *Modulation* equipment is needed
	- move each signal to the required frequqncy band
- *Multiplexing* equipment is needed
	- combine the modulated signals
- *Modulated signal* requires a certain bandwidth called channel
![[Pasted image 20241003094959.png]]

- Each communicating pair gets a private transmission path
- some limitations in FDM
	- interference may occur if channels are too close
	- demultiplexer must devide the signal into separate carriers
	- FCC in USA regulates adequate spacing
	- Carrier frequencies must have a *guard band*
- Figures 11.4 and 11.5 show an example
	- *200* KHz allocated to each of *6* channels with a guard band of *20* KHz

![[Pasted image 20241003095138.png]]
![[Pasted image 20241003095143.png]]

# Range of Frequencies Per Channel
- FDM susceptible to noise and distortion
- Most FDM systems assign each sender and receiver pair a range of frequencnies
- FDM can choose how the frequencies are used
- Two primary ways:
	- increase the data rate
	- Increase *immnity* to interference
- To increase the overall data rate
	- a sender divides the frequency range of the channel into *K* carriers
	- sends *1/K* of the data over each carrier

- A sender can perform FDM within an allocated channel
- to increase immunity to interference
	- *spread spectrum*
	- (links to en.wikipedia.org/wiki/Hedy_Lamarr , a 1940's movie star that invented it)
- basic idea:
	- divide the channel into *K* carriers
	- transmit the same data over multiple channels
	- a receiver choose one with fewest errors
- works well in noisy environment

# Hierarchical FDM
- FDM hardware can shift frequencies
- A set of incoming signals with the range between *0* and *4* KHz
	- leave the first stage as is
	- the second onto the range *4* KHz to *8* KHz
	- the third onto the range *8* KHz to *12* KHz, and so on
- Hierarchy in FDM multiplexors is that each maps its inputs to a larger, continuous band of frequqncies
- figure 11.6 illustrates the concept of hierarchical FDM
![[Pasted image 20241003095644.png]]

# Orthogonal Frequency-Division Multiplexing
- a type of digital transmission
- how it works:
	- incoming bitstream is divided into multiple streams
	- multiple bits transmitted in parallel with overlapping spectra using multiple orthogonal subcarriers
	- subcarriers are orthogonally arranged to avoid interferences
	- fast fourier transformation algorithm is used for demodulation
- application areas:
	- Digital television/audio broadcasting
	- DSL internet access
	- Wireless networks
	- 4G/5G
![[Pasted image 20241003095834.png]]

# Wavelength Division Multiplexing
- a variation of FDM for fiber optic channels
- wavelength of light is used for multiplexing
- uses prism or diffraction grating to separate channels
- potentially many channels (hundreds) can be multiplexed together over long-haul routes

Ex: DWDM: assign each source a specific wavelength (channel) and transmit all the lambdas on the same fiber optic (some successful configurations)
	320 channels with 2.5 Gbps (800 Gbps)
	160 channels with 10 Gbps (1.6 Tbps)
	128 channels with 40 Gbps (5.12 Tbps)
	96 channels with 400 Gbps (38 Tbps)

![[Pasted image 20241003100144.png]]

# Time Division Multiplexing (TDM)
- TDM does not rely on special properties of electromagnetic energy
	- multiplexing in time simple means transmitting an item from one source, then transmitting an item from another source, and so on
![[Pasted image 20241003100245.png]]

# Synchronous Time Division Multiplexing
- can be used with digital signals or analog signals carrying digital data
- When the achievable data rate of the medium exceeds the data rate of digital signals to be transmitted
- Data from various sources are carried in repetitive frames and each frame consists of a set of time slots. Time slots are pre-assigned
- the slot length equals to the transmitter buffer length, typically a bit or a character.
- Items are sent in a round-robin fashion

# Framing in TDM (Telephone System)
- Multiplex digital streams from multiple phone calls
	- the specific form of TDM used to multiplex digital telephone calls
- The phone system TDM
	- to insure that a demultiplexor stays synchronized with the multiplexor
- Why synchronization?
	- each slot doesn't have any indication of the output
- A demultiplexor cannot tell where a slot begins
	- a slight difference in the *clocks* can cause misinterpretation

- to prevent *misinterpretation*, an extra framing channel is used as input
- a single bit is inserted as a *framing* bit
- a demultiplexor extracts data from the framing channel and checks for alternating *0* and *1* bits
- If an error causes a demultiplexor to lose a bit
	- upon detecting an error -> allow the transmission to be restarted
- Figure 11.10 illustrates the use of framing bits

![[Pasted image 20241003100859.png]]

# Hierarchical TDM
- TDM hierarchy uses *N* times the bit rate
	- in FDM, each successive stage uses *N* times the frequencies
- Additional framing bits are added to the data
	- the bit rate of each successive layer of hierarchy is slightly greater than the aggregate voice traffic
- Compare the example TDM hierarchy
	- in figure 11.11 with the FDM example in figure 11.6
![[Pasted image 20241003101029.png]]

# How to calculate T1 speed
- T1 connections have 24 voice channels (24 DS0)
- PCM takes 8000 samples per second
	- each sample is represented by 8 bits (1 byte)
- 1 sample from 24 voice circuits would be 24 * 8 bits -> 192 bits
	- all the samples will be placed into a frame
	- there will be 1 framing bit added in order to prevent misinterpretation
- T1 transmits 8000 samples per second
	- 8000 * 193 bits -> 1.544 Mbps

# Unfilled Slots with Synchronous TDM
- Synchronous TDM works with *uniform* rate
- many sources generate data in bursts, with idle time between bursts
- in figure 11.12
	- sources on the left produce data items at random
	- the synchronous multiplexor leaves a slot unfilled
- in practice, a slot cannot be *empty*
	- empty slot is assigned a value (such as zero)
	- an extra bit is used to indicate invalid value
![[Pasted image 20241003101412.png]]

# Statistical Time Division Multiplexing
- in Synchronous TDM, many of the time slots in a frame are usually wasted.
- Assumption for this method is that the data rate of the output is less than the sum of the data rates of the inputs
- User data are buffered and transmitted as rapidly as possible using available time slots
- address information is required to assure proper delivery.
![[Pasted image 20241003101549.png]]

- Statistical multiplexing incure extra *overhead*
- Consider demultiplexing:
	- in a synchronous TDM system a demultiplexor knows that every *N* slot corresponds to a given receiver
	- in a statistical multiplexing system, the data in a given slot can correspond to any receiver
- each slot must contain the *identification* of the receiver to which the data is being sent
- Later chapters discuss identification mechanisms
	- that are used with statistical multiplexing in packet switching networks and the internet.

# Inverse Multiplexing
- consider two points with multiple transmission media
	- no single medium's bit rate is sufficient
- To solve the problem, multiplexing is used in *reverse*
	- spread a high-speed digital input over multiple lower-speed circuits for transmission and combine the results at the receiving end
![[Pasted image 20241003101857.png]]

- an *inverse* multiplexor requires special hardware
	- the sender and receiver agree on how data arriving from the input will be distributed over the lower-speed connections
	- different delay may cause out of order arrival
	- the system must insure that the order is preserved
- despite its complexity, inverse multiplexing is widely used in the Internet

# Code Division Multiplexing (CDM)
- several channels simultaneously share the same
- Used in some cellular telephone system and some satellite communication
- Cellular telephone version is called Code Division Multi-Access (CDMA)
	- When CDM is used to allow multiple users to share a single communications channel
	- another important application of CDMA is the GPS

# CDM (or spread spectrum)
- Each sender is assigned a unique binary code ($C_i$) 
	- that is known as a *chip sequence*
	- chip sequences are selected to be orthogonal vectors (dot product of any two sequences are zero, e.g., $U*V = 0$)
	- CDM doesn't rely on physical properties but on values from orthogonal vector spaces

- At any point in time, each sender has a value to transmit, *$V_i$*
	- the senders each multiple *$C_i x V_i$* and transmit the results
- Simultaneous transmission
	- the values are added together
	- over the same frequency band
- To extract value *V_i*, a receiver multiplies the sum by *$C_i$*
	- Ex: $C_1 V_1, C_2 V_2$ -> $C_1 V_1 + C_2 V_2$ (transmission) -> $(C_1 V_1 + C_2 V_2) * C_1$(extraction of $V_1$)

# CDM
![[Pasted image 20241003102628.png]]
![[Pasted image 20241003102642.png]]
![[Pasted image 20241003102647.png]]
