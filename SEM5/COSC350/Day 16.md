software development is very complicated
you first need to be clear about the requirements

on the detailed reqs doc:
	theres 2 different types of sockets: TCP socket and UDP socket
	"when you ask my TA you need to be very detailed"
	choose a language you can understand for when chatGPT breaks
	wireframe is unnecessary, but helpful
	avoid rework lol

phase 1: decisions
	TCP vs UDP
	extra credit vs regular

---------

# Wired LAN

|        |         |          |     |
| ------ | ------- | -------- | --- |
| Hub    | Layer 1 | Physical | ??? |
| Switch | Layer 2 | Link     | MAC |
| Router | Layer 3 | Network  | IP  |
Switch - Layer 2 - link - MAC
Router - Layer 3 - network - IP

We communicate bits with: 
	Unicast, Multicast, Broadcast

CSMA
	Carrier Sense Multiple Access

Contention Period:
	check if someone's using the ethernet cable. If not, send!
	if theres a message send during the contention period, you're in the *collision domain*

note Hub =/ Switch for the differences in the table

![[Pasted image 20241017100546.png]]

recall cmd > arp -a

if 10 computers are connected to a hub with total bandwidth of 100 Mbps, each computer only gets 10 Mbps

> each port is collision domain

note that Hubs can connect to more Hubs, not just computers

IP address + MAC address = address resolution

## Ethernet (IEEE 802.3)
- Widely used LAN technology 
	- Invented at Xerox PARC (Palo Alto Research Center) in 1970s 
	- Defined in a standard by Xerox, Intel and Digital - DIX standard 
	- Standard now managed by IEEE - defines formats, voltages, cable lengths, ... 
- Uses bus topology 
	- Single coax cable - the ether 
	- Multiple computers connect 
- One Ethernet cable is sometimes called a segment 
	- Limited to 500 meters in length (for 10base5)
		- 100 meters for Gigabit Ethernet and fast ethernet(over copper)
	- Minimum separation between connections is 3 meters 
![[Pasted image 20241017101114.png]]

When CAM memory is full, they collect Source Address ONLY, no destination address

## Ethernet Type Field and Demultiplexing
- the *type field* in an Ethernet frame
	- provides multiplexing and demultiplexing
	- allows multiple protocols operating simultaneously
- IP datagrams and ARP messages over Ethernet
	- hex *0800* for IP datagrams
	- hex *0806* for ARP messages
	- when transmitting a datagram in an Ethernet frame, the sender assigns a type *0800*
- Upon arrival at its destination:
	- examines the type field, and determine which software module should process the frame

![[Pasted image 20241017101547.png]]
![[Pasted image 20241017101557.png]]
^^ like a dog barking when it meets you for the first time going "Who are you!?"
	is used when a new IP address shows up

ARP is dynamic, uses DHCP


![[Pasted image 20241017101642.png]]

## IEEE's Version of Ethernet (802.3)
- IEEE developed a standard for Ethernet (1983) and attempted to redefine the Ethernet frame format
- IEEE 802.3 Ethernet
- The major difference is on the interpretation of the type field
	- The 802.3 Standart:
		- interprets "type" field as a packet length
		- 8-byte extra header is added
	- The extra header
		- *Logical Link Control* / *Sub-Network Attackment Point* (LLC/SNAP) header or simply SNAP header

![[Pasted image 20241017102207.png]]

- The frame size in 802.3 Ethernet:
	- *1514* bytes
	- the same as conventional Ethernet:
	- the maximum payload from *1500* bytes to *1492* bytes
	- SNAP header occupies the first *8* bytes of the payload
- To keep the two versions of Ethernet compatible, a convention is used:
	- if bytes *13-14* of a frame contain a numeric value less than *1500*:
		- The field is interpreted as a packet length and the 802.3 standard applies
	- otherwise, the field is interpreted as a type field

## LAN connections and NICs
- A NIC handles:
	- address recognition
	- CRC computation
	- frame *recognition*
	- sending/receiving frames
- A NIC consists of a *circuit board* with separate processor
- The NIC is independent from the rest of the computer
	- generally not replaceable (built-in)
	- Independent processing

## Twisted Pair Ethernet Wiring and Hubs
- A third generation:
	- Uses a central electronic device separate from the computers attached to the network
	- uses twisted pair wiring
- Informally known as twisted pair Ethernet
	- in general Ethernet means twisted pair Ethernet
- The electronic device known as a hub
	- various size of hubs available, but recently replaced with switches

![[Pasted image 20241017102647.png]]

- A hub emulates a physical cable
	- making the entire system operate like a convential Ethernet
- A system that uses a hub in CSMA/CD
	- receives a copy of each frame
	- uses the address to determine
	- whether to process or ignore the frame
- Twisted pair Ethernet retains the same frame format as the previous versions
- Software on a computer cannot distinguish between thick Ethernet, thin Ethernet, and twisted pair Ethernet
	- the NIC handles the details and hides any differences

## Physical and Logical Ethernet Topology
- Twisted pair Ethernet
	- physically follows a star topology
	- hub emulates physical cable
	- logically "*bus in a box*"

## Wiring in an Office Building

- The type of wiring makes a major difference in terms of 
	- the type
	- number of wires needed
	- the distance spanned
	- the cost
- The three versions of Ethernet wiring illustrate the three principal forms that LANs use
- Figure 15.7 depicts wiring on a floor of an office building
	- Twisted pair Ethernet requires many individual cables to go between offices and a central point (wiring closet)
	- Thus, twisted pair Ethernet requires careful labeling of cables

![[Pasted image 20241017103018.png]]

## Variants of Twisted Pair Ethernet and Speeds
- higher-speed Ethernet technologies use an electronic device known as a *switch* rather than a *hub*
- to remain *backwards compatible*
	- standards for the higher-speed versions specify how to determine speed automatically
	- slow down, if necessary, to accommodate older devices
	- for example, if an old device uses *10BaseT* and a new device uses *1000BaseT*, the new device will *autosense*

![[Pasted image 20241017103208.png]]
## Twisted Pair Connectors and Cables
- Twisted pair Ethernet uses *RJ45* connectors
	- telephones use *RJ11* connectors
- Two different cablings:
	- A *straight* cable
		- used between a computer and a switch
		- connects each pin of the RJ45 directly to the corresponding pin on the RJ45 at the other end
	- A *crossed* cable
		- used to connect two switches
		- connects each pin on one end to a different pin on the other end in reverse order
- To help technicians make the correct connections:
	-  individual wires in a *Category 5* or *category 6* cable are coated with colored plastic
- Figure 15.9 lists the color codes used with a straight cable
![[Pasted image 20241017103515.png]]

----------
# Wireless Networking Technologies

Wireless networks include:
- LAN
- MAN
- WAN
- PAN
- WSN (sensor networks)
- Cellular Networks
- Ad-Hoc Networks

## Personal Area Networks (PANs)
- intended for a single user
	- Bluetooth:
		- short distance comm. between small devices
	- Infrared:
		- line-of-sight required, between small devices
	- ZigBee:
		- ZigBee is the only open, global wireless standard to provide the foundation for the IoT by enabling simple and smart objects to work together
	- UWB (Ultra-wide band)
		- PC peripherals, radar, imaging
	- ISM wireless:
		- frequencies set aside for Industrial, Scientific, and Medical devices, 3 ranges of freq.

## ISM Wireless Bands Used by LANs and PANs
- a region of electromagnetic spectrum is reserved for use by *Industrial, Scientific, and Medical* (ISM) groups
	- known as ISM wireless
- Not licensed to specific carriers
	- available for LANs and PANs
![[Pasted image 20241017104048.png]]

## Wireless LAN technologies and Wi-Fi
- A variety of wireless LAN technologies utilizing:
	- frequencies
	- modulation techniques
	- data rates
- Standardized by IEEE as *IEEE 802.11*
- *Wi-Fi Alliance*
	- a non-profit organization that tests and certifies wireless equipment using the 802.11 standards

![[Pasted image 20241017104204.png]]

# Spread Spectrum Techniques
- *Spread spectrum*
	- the sender spreads data across multiple frequencies
	- the receiver combines the information obtained from multiple frequencies to reproduce the original data
- Goals
	- increase overall performance
	- make transmission more *immune* to noise
- The three key multiplexing techniques used in Wi-Fi wireless networks
	- FHSS
	- DSSS
	- OFDM

![[Pasted image 20241017104451.png]]
