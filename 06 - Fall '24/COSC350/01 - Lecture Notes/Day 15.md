each group needs to .... (never answered)

before you make plan, 
list all tasks needed to complete hw
	assign tasks to members
	giving credit for the plan itself
		"if plan is lousy, then the outcome cannot be good"
	plan must include:
		detailed level tasks
		duration, things like that
	list of tasks, and then assignment of tasks, and then GUI for application
	each one has a separate due date
	plan, gui, and other details, as well as final submission, are all graded separately

also term project will be posted soon, will be "choosing your own term for this topic"
	advanced topic for data communication
	write a research paper on it

examples of tasks:
	"what you need to complete the assignment"

Plan will be turned in thru a BB link

------------

# Lans PPTX ctd
use command: arp -a
	lets you see how IP addresses in your LAN map to MAC addresses

be able to tell which type each MAC address belongs to:
	Unicast, Broadcast, Multicast
		All FFs = broadcast

![[Pasted image 20241015095356.png]]

Frames come from the 5 layer model

on wireshark, verify that sender and target MAC addresses match for HW

![[Pasted image 20241015095655.png]]

byte stuffing =/ bit stuffing
	byte is replacing special characters with alt characters
	bit is adding non-informational bits (0000 0000 -> 0000 1 0000)

-----------
# The IEEE MAC sublayer

![[CH 14 The_IEEE_MAC_Sub-Layer.pptx]]
# Introduction
- multiple, independent computers must coordinate to access a shared medium
- Three approaches:
	- modified form of Multiplexing
	- Controlled access
	- Random access

Taxonomy of mechanisms for multi-access:
1. Multi-Access Protocols
	1. Controlled Access Protocols
		1. Reservation
			like placing one at a restaurant. Useful for traffic that takes a long time to get there.
		2. Polling
			rarely used, but centralized control accesses your machine, and polls services to see what needs to access
		3. Token Passing
			closed loop, ring topology, token = talking stick. Token never leaves the loop, can only transmit with the token
	1. Random Access Protocols
		1. ALOHA
			Developed in Hawaii bc they needed to communicate with mainland badly. not super efficient bc messages have to send to a central tower, and THEN their destination
		2. CSMA/CD
			transmit when shared medium is idle. Collision prone, gobbling up message. On collision, wait a random amount of time before retrying. (Collision Detection)
		3. CSMA/CA
			Collision Avoidance
	1. Channelization Protocols
		1. FDMA
			Frequency Division Multiple Access
		2. TDMA
			Time Division Multiple Access
		3. CDMA
			Code Division Multiple Access
			range of frequencies, i use this band. After a random amount of time, i switch to another random band! this change is synced between devices

# Channel Allocation
- a mapping between a given communication and a channel in the underlying transmission system
- Static Channel Allocation
	- fixed frequency for a set of communicating entities
- ...

# Channelization Protocols
- FDMA
	- extension of FDM
	- allow independent stations to choose carrier frequencies
- TDMA
	- extension of TDM
	- time slice is allocated dynamically - first come first serve
- CDMA

# Controlled Access Protocols
- Polling: Use of centralized controller
	- Round Robin Order
	- Priority Order: eg higher order for IP phone than PC
- Reservation: submit a request for the next round
	- often used with satellite transmission
	- form a list of stations and allow them to transmit
- Token Passing:
	- ...

# Random Access Protocols
- ALOHA
	- historical, used in early radio network, not now
	- use of inbound and outbount frequencies
- CSMA/CD
	- basis for ethernet
- CSMA/CA
	- basis for wifi

# CSMA (Carrier Sense Multiple Access)
- No central control managing when computers transmit on ether
- ethernet employs CSMA to coordinate transmission among multiple attached computers
- *Carrier Sense with Multiple Access*
	- Multiple access - multiple computers are attached and any can be transmitter
	- Carrier sense - computer wanting to transmit tests ether for carrier before transmitting

# Collision Detection - CD (IEEE 802.3)
- Even with CSMA, 2 computers may transmit simultaneously
	- 3 states are possible: contention, transmit, idle
		- contention period is 2x the time that the signal travels 2 farthest stations
	- Both check ether at the same time, find it idle, and begin transmitting
	- Window for transmission depends on speed of propagation in ether

- Signals from 2 computers will interfere with each other
- Overlapping frames is called a *collision*
	- no harm to hardware
	- data from both frames is garbled
	- send out collision presence signal
# Ethernet CD
- Ethernet interfaces include hardware to detect transmission
- monitors outgoing signal
- garbled signal is interpreted as a collision
- after collision is detected, computer stops transmitting

# Recovery from collision
- computer that detects a collision sends special signal to force all other interfaces to detect collision
- computer then waits for Ether to be idle before transmitting
- if both computers wait same length of time, frames will collide again
- standard specifies maximum delay, and both computers choose random delay less than maximum

- after waiting, computers use carrier sense to avoid subsequent collision
	- computer with shorter delay will go first
	- other computers may transmit first

# Binary Exponential backoff
- even with random delays, collisions may occur
- Especially likely with busy segments
- computers double delay with each subsequent collision
- reduces likelihood of sequence of collisions
- after i collisions, a random num between 0 and $2^i - 1$ is chosen
	- K * 51.2 microseconds, where k is the random number between 0 and $2^i - 1$
	- when i = 3, k is between 0 and 7

# Limited connectivity with wireless
In contrast with wired LAN, not all participants may be able to reach each other
- low signal strength
- propagation blocked by walls, etc.
	- cant depend on CD; not all participants may hear
- Wireless LANs use a modified access protocol known as CSMA with *Collision Avoidance* (CSMA/CA)
# CSMA/CA
- for computer 1, computer 3 may not be visible. So when computer 1 and computer 3 transmit at the same time to computer 2, it will detect a collision. It is called the "hidden station" problem.
![[Pasted image 20241106202249.png]]

Wireless uses *collision avoidance* rather than collision detection
- transmitting computer sends very short message to receiver
- receiver responds with short message reserving slot for transmitter
- response from receiver is *broadcast* so all potential transmitters receive reservation
![[Pasted image 20241106202313.png]]

# Collisions
- Receiver may receive simultaneous requests
	- results in collision at receiver
	- *Both* requests are lost
	- neither transmitter receives reservation; both use backoff and retry
- Receiver may receive closely spaced requests
	- selects one
	- selected transmitter sends message
	- transmitter not selected uses backoff and retries

-------------
# Wired Lan PPTX

# Ethernet (IEEE 802.3)
- widely used LAN technology
	- invented at Xerox PARC in 1970s
	- defined in a standard by Xerox, Intel, and digital - DIX standard
	- standard now managed by IEEE - defines formats, voltages, cable lengths, ...
- uses bus topology
	- single coax cable - the *ether*
	- multiple computers connect
- one Ethernet cable is sometimes called a *segment*
	- limited to 500 meters in length (for $10_5$)
		- 100 meters for Gigabit Ethernet and fast ethernet (over copper)
	- Minimum separation between connections is 3 meters

![[Pasted image 20241015103556.png]]

# Ethernet Type Field and Demultiplexing
- the *type field* in an Ethernet frame
	- provides multiplexing and demultiplexing
	- allows multiple protocols operating simultaneously
- IP datagrams and ARP messages over Ethernet
	- hexadecimal *0800* for IP datagrams
	- hexadecimal *0806* for ARP messages
	- when transmitting a datagram in an Ethernet frame, the sender assigns a type *0800*
- Upon arrival at its destination
	- examines the type field, and determine which software module should process the frame 
![[Pasted image 20241015103837.png]]
![[Pasted image 20241015103852.png]]
![[Pasted image 20241015103907.png]]
