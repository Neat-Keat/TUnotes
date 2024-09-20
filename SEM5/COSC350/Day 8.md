![[Pasted image 20240919093200.png]]

a terrestrial radio is a radio on the earth that uses it's curvature

![[Pasted image 20240919093318.png]]
"get familiarized with the sequence" #MEMORIZE 

to get to satellites, we use microwaves (35,000 km high)

![[Pasted image 20240919093534.png]]
![[Pasted image 20240919093623.png]]

Signal Propagation
- 2 broad categories as in wireless comm.
	- *Terrestrial*
	- *non-terrestrial*
- Frequency and amount of power used can affect:
	- the speed
	- the maximum distance
	- Characteristics (penetrate solid objects?)

Types of Satellites
- the laws of physics (ie Kepler's Law), applied to a *satellite*, that *orbits* the earth
- the orbital period depends on the distance from the earth
- three broad categories
	- LEO - Low Earth Orbit (~2,000 ft, SpaceX)
	- MEO -Medium Earth Orbit (for triangulation/GPS)
	- GEO - Geostationary Earth Orbit (35,000 Km, only need 3 to cover the entire earth)

![[Pasted image 20240919094211.png]]
airlines can go up to 40,000 ft high
	little rock -> baltimore SW flight where pilots found out how high it would go, followed by crash + death

GEO communication Satellites
- GEO
	- the *orbital period* is the same as the earth
- if positioned above the *equator*
	- a GEO satellite remains in one position
- A *stationary* satellite position
	- once aligned the equipment never needs to move
- "Router in the Sky"

![[Pasted image 20240919094806.png]]
![[Pasted image 20240919094816.png]]
note that the 2 in the numerator is for both travelling to and back

GEO coverage of the Earth
- how many GEO communication satellites are possible?
- there is a *limited* amount of "space" available in the geosynchronous orbit above the equator
	- frequency separation to avoid interference
	- the minimum separation depends on the power of the transmitters
- However, as technology is evolving it's possible to allocate more satellites in orbit

![[Pasted image 20240919095110.png]]

Low Earth Orbit (LEO) Satellites and Clusters
- up to *2000* Km typically at altitudes of 500-600 km or higher (above atmosphere)
- short delays (typically 1-4ms)

- disadvantages of LEO
	- the orbit does not match the rotation of the earth
- from an observer's POV on Earth
	- an LEO satellite appears to move across the sky
		- needs rotating antenna to *track* the satellite
	- Tracking is difficult because satellites move rapidly
	- the orbit between *90* minutes and several hours depending on altitude

![[Pasted image 20240919095403.png]]

Tradeoffs among media types
- the choice of medium is complex
- choice involves the evaluation of multiple factors, such as:
	- Cost
		- materials, installation, and maintenance
	- Data rate
		- number of bits/sec that can be sent
	- Delay
		- time required for signal propagation or processing
	- Affect on signal
		- attenuation and distortion
	- Environment
		- susceptibility to interference and electrical noise
	- Security
		- susceptibility to eavesdropping

Measuring Transmission Media
- the 2 measures of performance for medium:
	- propagation delay
		- the time required for a signal to traverse the medium
	- Channel capacity
		- the max data rate that the medium can support
- Nyquist Theorem
	- the relationship between the bandwidth of a transmission system and its capacity to transfer data
	- defines the max data rate without considering the effect of noise
	- K possible signal levels, analog bandwidth B, the max data rate in bits/sec, D,
$$ D = 2B(log_2(K))$$

The effect of noise on communication
- Nyquist's theorem cannot be achieved in practice due to electrical noise
- Claude Shannon extended Nyquist's work to specify the maximum data rate with noise
	- Shannon's theorem:
$$ C = B(log_2(1 + S/N))$$
where:
	C = the effective limit on the channel capacity in bits/sec
	B = the hardware bandwidth
	S/N is the signal-to-noise ratio, the ratio of the average signal power divided by the average noise power

Consider a transmission medium:
	- a bandwidth of 1 KHz (typical wi-fi is 20MHz, linear SNR is 1000)
	- an average signal power of 70 units
	- an average noise power of 10 units
- the channel capacity is
$$ C = 10^3 * log_2(1+7) = 10^3 * 3 = 3,000 bits/second $$
- The signal-to-noise ratio is often given in *decibels* (abbreviated dB), where a decibel is defined as a measure of the difference between two power levels
- illustrated in figure 7.14

![[Pasted image 20240919100355.png]]

The effect of noise on Communication
- the difference is expressed in decibels, defined as follows:
$$ dB = 10 log_10(P_2/P_1) $$
* using dB as a measure has 2 interesting advantages:
	* first, it can give us a quick idea about outcome of an operations:
		* a negtive dB value: attenuated
		* a positive dB value: amplified
	* Second, if a communication system has multiple parts arranged in a sequence
		* the dB measures of the parts *can be summed* to produce a measure of the overall system

EX:
- the voice telephone system:
	- S/N approximately 30 dB
	- an analog bandwidth of approx 3000 Hz
- to convert signal-to-noise ratio dB into a simple fraction
	- divide by 10 & use the result as a power of 10
	- (ie (30/10) = 3, and 10^3 = 1000, so the S/N ratio is 1000)
- Shannon's Theorem applied to the telephone network:
$$ C = 3000 * log_2(1+1000) $$
- or approx 30,000 bps
- S/N dominates data rate

The significance of Channel Capacity
- Nyquist's work
	- showed possibility of improving data rate with encoding technique
- Shannon's Theorem
	- showed fundamental limit on data rate in a real communication system -> the laws of physics

--------------
#  Midterm and Project info!

midterm 10/1 ( 2 weeks from today)
we'll get a study guide next week

whatever we cover before midterm will be on the midterm

right after the midterm, we'll discuss the term project
	winSocket or socket
	doing that with your group
	use wireshark to verify it works
	groups of odd numbers of people (ideally 3)
	groups assigned by professor
	the secret to writing socket programs: chatgpt lmfao
		need to know what you're doing
			what libraries and function calls you're using
			the comments are your assignment
			"ChatGPT is my TA"
	term project is writing about a new trend in data communication
		IEEE template provided
		abstract, intro, etc

--------------
# Reliability and Channel Coding 

basically a review of COSC290

Transmission Errors
- external electromagnetic signals can cause incorrect delivery of data
	- data can be received incorrectly
	- data can be lost
	- unwanted data can be generated
- any of these problems are called *transmission errors*
- three main sources of transmission errors:
	1. Interference
		- Electromagnetic radiation - electric motots
		- background cosmic radiation - natural environment
		- can disturb radio transmission and signals travelling across wires
	2. Distortion
		- all physical systems distort signals
		- as a pulse travels along an optical fiber, the pulse *disperses*
		- wires have properties of *capacitance* and *inductance*
		- large metal objects affect the set of passable frequencies - can block some frequencies of radio waves
	3. Attenuation
		- As a signal passes across a medium, the signal becomes weaker
			- signals become weaker over long distances

Approaches to reduce errors
* Shannon's theorem:
	* increase the *Signal-to-Noise ratio*
		* by increasing the signal or
		* by lowering noise
* *Shielded* wiring
* Noise/interference cannot be eliminated completely
	* transmission errors can be *detected*
	* some errors can be *corrected* automatically
* Error detection adds *overhead*
* *Error handling* is a tradeoff, system designers
	* must decide whether a given error is likely to occur
	* analyze the consequences

Effect of transmission errors on data
- Single bit error: often caused by very short-duration interference
- Burst Error: multiple bits in a block of bits are changed - often caused by long-duration interference
- Erasure (ambiguity): does not clearly correspond to either a logical 1 or a logical 0 - often caused by distortion or interference

for a burst error, the *burst size*, or *length*, is defined as the number of bits from the start of the corruption to the end of the corruption
![[Pasted image 20240919103448.png]]

Two strategies for handling Channel Errors
- Channel Coding
	- mathematical techniques designed to overcome errors during transmission and increase reliability
- Two broad categories:
	- Forward Error Correction (FEC) mechanisms
	- Automatic Repeat reQuest (ARQ) mechanisms
- The basic idea of FEC
	- add additional information to data to *verify* that data arrives correctly and to correct errors, if possible 
	- think hamming codes!

![[Pasted image 20240919103707.png]]

Block and Convolutional Error Codes
- the 2 types of FEC techniques satisfy separate needs:
- *Block* error codes
	- it divides the data to be sent into a set of blocks
	- it attackes *redundancy* to each block
	- the encoding mechanism does not carry state information across blocks -> *no memory* required
- *Convolutional* Error Codes
	- it treats data as a series of bits, and computers a code over a *continuous series*
	- the code computed for a set of bits depends on
		- the current input and some of the previous bits in the stream
	- Convolutional codes need *memory*

Error detection and correction
- error detection -
	- send additional information so incorrect data can be detected and rejected (Automatic Repeat reQuest (ARQ) mechanism)
	- Determine changed bits exactly and to compute correct values
- Error correction -
	- send additional information so incorrect data can be corrected and accepted (Forward Error Correction (FEC) mechanism)
	- Sender and receiver exchange messages to ensure that all data arrives correctly

Parity Checking
- *Parity* refers to the number of bits set to 1 in the data item
	- *Even parity* - an even number of bits are 1
	- *Odd parity* - an odd number of bits are 1
- A *Parity bit* is an extra bit transmitted with a data item, chose to give the resulting bits even or odd parity
![[Pasted image 20240919104236.png]]
