on HW 1
traceroute -> you have some sense on what packet flow is all about
if you didnt get the full credit, you either didnt do traceroute, or didnt explain it
	it wasnt a dictionary HW lol

---------------

The conceptual pieces of a communication system
- multiple sources of information and allows each source to send to a separate destination
- each source needs a mechanism to
	- *gather* the information
	- *prepare* the information for transmission
	- *transmit* the information across the shared physical medium
- Each destination needs a mechanism to
	- *extracts* the information
	- *delivers* the information
- Figure 5.2 illustrates the simplistic view
	![[Pasted image 20240912094241.png]]

The Conceptual Pieces of a Communication System
- More complexity
	- Different sources of information
	- Digitization needed for the transmission
	- Extra data must be added to protect against *channel errors*
	- May need to be *encrypted* for secure transmission
	- To send *multiple streams* of information across a shared media
		- the information from each source must be *identified*
		- data from all the sources must be *intermixed* for transmission

![[Pasted image 20240912094523.png]]
![[Pasted image 20240912094532.png]]
![[Pasted image 20240912094612.png]]

The Subtopics
- each of the boxes in Figure 5.3 corresponds to one subtopic of data communications
- Information sources
	- either *analog* or *digital*
	- *Characteristics of signals*
		- *amplitude, frequency*, and *phase*
		- *periodic* or *aperiodic*
	- Source Encoder and Decoder
		- once *digitized*, digital representations can be transformed and converted
		- concepts include data *compression* and consequences for communication
	- Encryptor and Decryptor
		- Information can be *encrypted* and *decrypted*
			- *Cryptographic* techniques and algorithms
		- Channel Encoder and Decoder
			- Channel coding is used to *detect* and *correct* transmission *errors*
				- *Parity* checking, *checksums*, and *Cyclic redundancy codes*
	- Multiplexor and Demutiplexor
		- *Multiplexing:* information from multiple sources is combined for transmission across a *shared medium*
		- *Simultaneous sharing* or *taking turns* when using the medium
	- Modulator and Demodulator
		- *Modulation* refers to the way electromagnetic radiation is used to send information
			- analog and digital modulation schemes
			- modems
	- Physical Channel and Transmission
		- transmission *media*
		- transmission *modes*, such as *serial* and *parallel*
		- channel *bandwidth*
		- electrical *noise* and *interference*
		- channel *capacity*

Checksum demo
	Message = "Hello"
		add the ASCII values of all the characters
			say the sum is 214
			at the receiving end, you add the values up to check if it matches 214 to check for tampering

-----------------------

Information Sources and Signals

Data Signals
- Analog: characterized by continuous mathematical function
- Digital: has a fixed set of valid levels
- Periodic signals have repetitive patterns and aperiodic ones don't

Sine Waves
- natural phenomena produce sine waves
- four main chaaracteristics
	- Frequency
	- Amplitude
	- Phase: shifted amount of the start of sine wave from a reference time
	- Wavelength: length of a cycle as it propagates across a medium

![[Pasted image 20240912095737.png]]
clock speed = number of times computers process per second

![[Pasted image 20240912100039.png]]

The Importance of Composite Signals and Sine Functions
- utilized in data communication
	- natural phenomena produce sine waves as a function of time
- *Modulation* and *Demodulation*
	- modulation produces composite signals
- From Fourier, it is possible to decompose a composite signal into its constituent parts
	- if the composite signal is periodic, the constituent parts will also be periodic

Time and Frequency Domain Representations
- a graph of a signal as a function of time is known as *time domain* representation
- the other representation is known as a *frequency domain*
	- a composite function can be shown as a set of *simple sine waves*
- The function *A * sin(2 pi t)* is represented by a single line of height A that is positioned at x = t

![[Pasted image 20240912100511.png]]

A frequency domain representation 
- useful with periodic signals
- Compactness
- both small and easy to read occupies only a single point along the x-axis
- the advantage becomes clear when a composite signal contains many simple signals


Bandwidth of an Analog Signal
- the definition of bandwidth varies; one definition of *analog bandwidth*
	- the difference between the highest and lowest frequencies of the constituent parts
	- the highest and lowest frequencies obtained by Fourier analysis

![[Pasted image 20240912100650.png]]

Digital Signals and Signal Levels
- when voltage is used
	- positive: logical one
	- zero: logical zero
- When 2 levels of voltage are used
	- each level corresponds to one data bit (0 or 1)
-  When multiple digital levels are available
	-each level can represent multiple bits
	-E.g. four levels of voltage:
		-5 volts, -2 volts, +2 volts, and +5 volts

![[Pasted image 20240912100821.png]]

Digital Signals and Signal Levels
- for each possible combination of bits => 1 signal level
- there are 2^n combinations (number of levels) possible with n bits
- One could achieve arbitrary numbers of levels by dividing voltage into arbitrarily small increments
	- but the system may not *distinguish* between signals

Baud and Bits per Second
- the rate at which data can be sent depends on
	- the number of signal levels
	- the amount of time the system remains at a given level before moving to the next
- Figure 6.8a shows time along the x-axis, and the time is divided into 8 segments
- if the communication system is modified to use half as much time for a given bit
	- 2x as many bits will be sent in the same amount of time
![[Pasted image 20240912101147.png]]
![[Pasted image 20240912101157.png]]

Converting a Digital Signal to Analog
- a composite of sine waves
	- represented by arbitrary wave
	- each sine wave in the set has a specific amplitude, frequency, and phase
- Fourier's theorem
	- to a digital signal requires an *infinite* set of sine waves
	- Infinite bandwidth?
- Engineers adopt a compromise:
	- conversion of a signal from digital to analog is *approximate*
	- generate analog waves that closely approximate the digital signal
	- approximation involves building a composite signal from only a few sine waves
	![[Pasted image 20240912101512.png]]

Synchronization and Agreement about Signals
- The electronics at both ends of a physical medium must have circuitry to measure time precisely
- Building electronic systems that agree at the high speeds used in modern networks is extremely difficult
- A fundamental problem: *synchronization* of sender/receiver
- Missing a bit creates misinterpretation

![[Pasted image 20240912101700.png]]

Line Coding
- how to avoid synchronization errors:
	1. Uses a known pattern of bits before the transmission - typically a set of alternating 0s and 1ss, for receiver to synchronize
	2. Systematic data representation to avoid confusion about the meaning
- *Line coding*: the way data is encoded in a signal
- Multiple signal elements for a single bit means fewer bits can be transmitted per *unit time*
- Would like to transmit multiple bits per signal element
- A variety of line coding techniques are available that differ in
	- how they handle synchronization
	- the bandwidth used
unfortunately, this cuts the transmission rate in half D:
![[Pasted image 20240912101941.png]]
![[Pasted image 20240912102242.png]]

Manchester Encoding
- *Manchester Encoding* used with *Ethernet*
- detect a *transition* in signal level
- detecting transition is easier than measuring signal level
- 1 corresponds to a transition from *negative* voltage level to a *positive* voltage level and vice versa
![[Pasted image 20240912102527.png]]

Differential Manchester Encoding
- relative transitions
- depends on the previous bit
- Always a transition in middle of interval
	- 0 = transition at beginning of interval
	- 1 = no transition at beginning of interval
- The encoding works correctly even if the 2 wires carrying signal are reversed

Converting an Analog Signal to Digital
- Analog signals must be converted to digital form
- Two basic approaches:
	- Pulse code modulation (PCM)
	- Delta modulation (DM)
- In PCM,  the level of an analog signal is measured repeatedly at fixed time intervals and converted to digital form

The 3 steps used in PCM
- 1st stage is *Sampling*
	- each measurement is known as a sample
- A sample is *Quantized*
	- a small integer value
	- not a measure of voltage or any other property of the signal
	- the range of the signal from the minimum to maximum levels is divided into a set of slots, typically a power of 2
- then encoded into a specific format
![[Pasted image 20240912102759.png]]

![[Pasted image 20240912102952.png]]

Converting an Analog Signal to Digital
- Delta modulation (DM)
	- DM sends one quantization value followed by a string of values (differences)
- requires fewer bits
- the main tradeoff with DM is the effect of an *error*
	- any missing or damaged item causes misinterpretation

The Nyquist Theorem and Sampling Rate
- sampled in PCM or DM
	- *undersampling*
	- *oversampling*
- Proper sampling is given by *Nyquist* theorem:
	``` sampling rate = 2 * f(max)```
* Where f(max) is the highest frequency in the composite signal

Nyquist Theorem and Telephone System Transmission
- frequencies between 0 - 4000 Hz considered acceptable *audio quality* for human
- Sampling rate of 8000 samples per second
- The PCM standard quantifies each voice sample into an 8 bit value for quality
- the rate generated for a single telephone call is:
		![[Pasted image 20240912103631.png]]
***this is the speed of dial-up modems!!***
	(28.8 kbps)

VoIP
- area code irrelevant
- one number multiple devices
- any device
- ENUM (an IETF standard - RFC 2916)
	- translates telephone numbers (E164 numbers) into internet addresses (DNS)
		- SIP/H.323 VoIP addresses
		- IP FAX servers
		- Voice Mail Servers
		- Email addresses
		- PSTN services (redirect)
	- PSTN used as the inter-VoIP network