Last class:
- Composite Signals
	- natural phenomenon we want to use to transmit data
	- we can combine sine waves to store data more compactly
- Fourier Transformation

Bandwidth: difference between highest and lowest frequency

when you read from more than 1 level of voltage, you can store data more compactly
	related to baud
	$bits per second = baud * floor(log_2(levels)$
\
to exactly encode with fourier transforms, we need infinite sine waves
	we cant do that, so we approximate!

how to solve synchronization error?
	line coding!
		cuts transmission rate in 1/2
	or alternatively  Manchester coding
		detect changes in voltage

![[Pasted image 20240917094224.png]]
![[Pasted image 20240917094231.png]]

Differential Manchester encoding depends on the previous bit

Converting Analog Signal to Digital
1. sampling
	- 2* max frequency= # of samples
2. quantization
3. encoding

we only hear from 0-4000Hz
	-> only need 8000 samples
	this is what defined the bandwidth of dial-up modems

digitized voice call = 8000 samples/second * 8 bits/sample = 64,000 bits/second

VoIP
	uses your phone number as a kind of Domain name
	 area code irrelevant
	1 number multiple devices
	any device
	called the ENUM standard (IETF RFC 2916)
	 Translates telephone numbers (E164 numbers) into internet addresses (DNS)
	- SIP/H.323 VoIP addresses
	- IP FAX servers
	- Voice Mail Servers
	- Email Addresses
	- PSTN services (redirect)
		PSTN used as the inter-VoIP network

Encoding and Data Compression
- data *compression* reduces the number of bits required to represent data
- data compression:
	- reduces travel time
	- a communication system can be optimized
- there are 2 types of compression:
	- *Lossy*
	- *Lossless*
Action movie vs News parable
	easier to compress the news because the background doesnt change much

consider a 1000 * 1000 screen
	each pixel holds 3 bytes of data (RGB)
		1000000 pixels
		3M * 30 -> 90 MB/sec burden
			or subtract frames and only transmit the differences!

Encoding and Data Compression
- Lossy compression
	- some info is lost (eg images, video/audio)
	- preserve details to the level of *human perception*
	- JPEG (used for images) compression or MPEG-3 (abbreviated MP3 and used for audio recordings)
- Lossless compression
	- presereves the original data without change
	- forms a *dictionary* for repeated strings (keeps reference to the string in the dictionary)
	- Sender *must send dictionary* with compressed data

try picturing mom, you have a "compressed" image, as you cant picture every wrinkle, but you have the big idea

-------------
Transmission Media

Introduction
- transmission media, including wired, wireless, and optical media
- taxonomy of media types
- basic concepts of electromagnetic propagation
- the effect of shielding with respect to interference and noise
- the concept of capacity

Guided and Unguided Transmission
- categorization of transmission media
- 2 approaches:
	- by *type of path*
	- by *form of energy*
- Physical Media
	- guided (wired): copper wiring, optical fibers
	- unguided (wireless): radio
		- "airplanes dont have turn signals (they're free!)"

![[Pasted image 20240917100723.png]]

Background Radiation and Electrical Noise
- electrical current needs a complete *circuit*
	- 2 wires to form a circuit: send and return
- the simplest form of wiring
	- a cable with two copper wires
- each wire needs plastic coating for insulation
- the outer coating put 2 wires together for easy connection
	- 2 wires, white and black, black is hot lol

- Computer networks use an alternative form of wiring
- Facts related to Noise
	- Noise (random electromagnetic radiation) may present in normal operation
	- random noise can interfere with signals
	- Metal acts as a *shield* (may absorb noise)

Twisted Pair Copper Wiring
- Type of wiring
	 - Unshielded Twisted Pair (UTP)
		- also known as twisted pair wiring 
	 - Coaxial Cable
	 - Shielded Twisted Pair (STP)
- Twisting two wires may help reduce noise as shown in Figure 7.2
![[Pasted image 20240917101431.png]]

twisting cancels out background radiation

Shielding: Coaxial Cable and Shielded Twisted Pair
- limitations on twisted pair wiring
	- strong electrical noise
	- high frequencies used for communication
- interference may occur
	- on top of a fluorescent light fixture
- distinguishing *valid signals from* noise can be difficult

Extra metal shielding wiring
- coax cable: the wiring has a thick metal shield formed from *braided wires* that completely surround a *center (inner* wire that carries the signal
- a coax cable can stand electrical noise and high frequencies
	- the shield provides a barrier to electromagnetic radiation

![[Pasted image 20240917101745.png]]

Braided wire makes coaxial cable flexible
- one variation -> shielded twisted pair (STP)
	- thinner
	- flexible metal shield surrounding 1 or more twisted pairs of wires
	- the shield contains metal foil
	![[Pasted image 20240917101908.png]]

Standards organizations
- American National Standards Institute (ANSI)
- Telecommunications Industry Association (TIA)
- Electronics Industries Alliance (EIA)

![[Pasted image 20240917102032.png]]
Token ring is like a talking stick

we largely use CAT 5 and CAT 6 in homes

chat GPT has 3 billion parameters (7 billion if you pay)
	calling to that data center requires a large bandwidth lol

Media Using Light Enegy and Optical Fibers
- 3 forms of media
	- Optical fibers: most widely used
	- InfraRed transmission
	- point-to-point lasers
- Each fiber consists of:
	- a thin *strand of glass* or
	- transparent plastic encased in a plastic cover
- An optical fiber for a single direction
	- *two-way* communication -> two fibers
		- one for transmission
		- one for receiving

Light can change direction
- the *boundary* between two substances
For a given pair of substances
- there exists a critical angle $\Theta$
- if (the *angle of incidence* = the critical angle)
	- travel along the boundary
- if (the angle of incidence <  $\Theta$)
	- refracted
- if (the angle >  $\Theta$)
	- reflected

![[Pasted image 20240917103151.png]]

- Reflection is not perfect
	- reflection absorbs some energy
	- a *photon* may take a zig-zag path
	- Dispersion over time
		- *Dispersion* is a serious problem for long optical fibers

![[Pasted image 20240917103304.png]]

Types of Fiber and Light Transmission
- Three forms of optical fibers:
	- *Multimode, Step Index*
		- used when performance is unimportant
		- reflect frequently, high dispersion
	- *Multimode, Graded Index*
		- increase density near the edge -> reduce reflection and lower dispersion
	- *Single Mode*
		- provides the least dispersion
		- smaller diameter and properties that help reduce reflection
		- used for long distances and higher bit rates

- Single mode fiber: focus light
	- can travel long distances without becoming dispersed
	- minimal dispersion could increase the bit rate
- Transmission: LED or Injection Laser Diode (ILD)
- Reception: *photo-sensitive* cell or *photodiode*
	- LEDs and photo-sensitive cells
		- short distances and slower bit rates
		- common with multimode fiber;
	- Single mode fiber
		- long distance with high bit rates
		- requires ILDs and photodiodes

Comparison between Optical fiber and copper wiring
- optical fiber
	- immune to electrical noise
	- higher bandwidth
	- travelling light does not *attenuate* as much as electrical signals travelling across copper
- Copper wiring
	- less expensive
	- installation is easy
	- copper wires are less likely to break if accidentally pulled or bent

Infrared (IR) Communication Technologies
- IR (eg TV remote)
	- a form of electromagnetic radiation
	- behaves like visible light but not visible to a human eye
- Disperses quickly
- Can reflect from a smooth, hard surface
- any *opaque* object can block the signal
- IR commonly used to connect to a nearby peripheral
- the wireless aspect of infrared can be attractive for laptop computers

![[Pasted image 20240917104059.png]]

Point-to-Point Laser Communication
- requires *line-of-sight*
- Laser follows line-of-sight
	- the beam is only a few centimeters wide
	- the sending and receiving equipment must be *aligned*
	- used for outdoors and offers great distances
	- useful in cities to transmit from building to building
- weather can throw it off lol

Electromagnetic Communication (Radio)
- most common form of *unguided* communication
	- *Radio Frequency* (RF) range
- RF energy
	- *Traverse* long distances
	- *Penetrate* solid objects
- the properties depend on the frequency
- regulating organization
	- Federal Communications Commission (FCC) sets rules for how frequencies

![[Pasted image 20240917104414.png]]
