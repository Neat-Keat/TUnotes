for group lead:
	need to have 1st group meeting ASAP
	group leaders need to assign tasks for each group member
	need to know what it takes to do HW
		is a precursor to term project
	project needs to be done incrementally
		if you follow the plan incrementally you get full credit
		if you do it all the night before maybe not lmfaoo
	need a schedule lololol
	no schedule = deductions
	have members log their own progress so they dont lose points

he recommends
	1 person to be wireshark guy
extra credit (20% each) for
	1. analysis of TCP/IP layers in packet transmission 
		1. how it works (switching/forwarding equipment)
		2. thoroughness and completeness
	2. make the program N-way communication as opposed to 2-way
		1. doesn't need fancy functionality, only barebones in this case

since everyone gets the same grade, have a QA guy

term project assigned next week, same decomposition concept will apply
	he wants to make sure there's no free rides

send schedule to professor, and if you want to work on extra credit
	will be an assignment on BB

-------

LANs pptx

![[Pasted image 20241010094900.png]]

![[Pasted image 20241010095209.png]]


# IEEE 802 Model and Standards
- IEEE divides *Layer 2* of the protocol stack into two conceptual sublayers, as Figure 13.5 (below) illustrates
	- the *Logical Link Control* (LLC)
		- provides flow control, error detection (use of checksum and CRC) to the frames, multiplexing, and addressing between higher and lower layers
		- supports multiple network protocols by adding LLC headers and using service access points (DSAP and SSAP) - which network protocol the frams belongs to
	- The *Media Access Control* (MAC)
		- sublayer specifies how multiple computers share underlying medium
![[Pasted image 20241010095450.png]]

- IEEE assigns a multi-part identifier of the form *XXX.YYY.ZZZ*
	- *XXX* denotes the category of the standard
	- *YYY* denotes a subcategory
- IEEE has many working groups
	- Each working group consists of representatives from the industrial and academic communities
	- IEEE allows a working group to remain active provided the group makes progress and the technology is still deemed important
	- if a technology under investigation is no longer relevant, the group can decide to *disband*
![[Pasted image 20241010095652.png]]
![[Pasted image 20241010095701.png]]

# Point-to-Point and Multi-Access Networks
- LAN technologies are for sharing
	- any computer on the LAN can communicate with any other
	- A LAN is a multi-access network
	- fair use of a network
- LAN technologies can provide direct connection among communicating entities
- LANs connect computers along with peripheral devices

# LAN Topologies
- Many LAN technologies exist
- Each network is classified into a category according to its *topology* or *general shape*
- this section describes 4 basic topologies that are used to construct
	- 13.8.1 Bus Topology
	- 13.8.2 Ring Topology
	- 13.8.3 Mesh Topology
	- 13.8.4 Star Topology
	- Tree topology - scalable & flexible but root note failure disrupts the network
	- Hybrid topology - combination of topologies, flexible, complex design and management
![[Pasted image 20241010100018.png]]

*Bus Topology*
- Bus topology usually consists of a single cable to which computers attach
- The ends of a bus network must be *terminated*
	- to prevent electrical signals from *reflecting* back along the bus
- Any computer attached to a bus can send on the cable
	- and all computers receive the signal
- Because all computers attach directly to the cable
	- any computer can send data to any other computer
- The computers attached to a bus network must *coordinate*
	- to ensure that only one computer sends a signal at any time

*Ring Topology*
- Ring topology arranges for computers to be connected in a closed *loop*
	- name *ring* arises because one can imagine the computers and the Ring topology requires a computer to connect to a small device that forms the ring
	- this is needed for the ring to continue operation even if some of the computers are disconnected

*Mesh Topology*
- A network that uses a *mesh* topology provides a direct connection between each pair of computers
- the chief disadvantage of a mesh arises from the cost:
	- a mesh network connecting *n* computers requires:
		- Connections in a mesh network = $$ n!/((n-2)!2!) = (n^2-n)/2$$ 
		- The important point is that the number of connections needed for a mesh network grows faster than the number of computers
	- Because connections are expensive
		- few LANs employ a mesh topology in special circumstances

*Star Topology*
- In *star* topology, all computers attach to a *central point*
- the center of a star network is often called a *hub*
- a typical hub:
	- accepts data from a sending computer and delivers it to the appropriate destination
- Star networks seldom have a symmetric shape
	- a hub often resides in a location separate from the computers attached to it
- for example, computers can be in offices, while the hub resides in a location where general access is not allowed

*The Reason for Multiple Topologies*
- a *ring* makes it easy for computers to coordinate access and to detect whether the network is operating correctly
	- one cut in the connection may disable entire network
- A *star* helps protect the network from damage to a single cable because each cable connects only one machine
- a *bus* requires fewer wires than a star, but has the same disadvantage as a ring
![[Pasted image 20241010100932.png]]
# Packet Identification, Demultiplexing, MAC Addresses
- IEEE has created a standard for *addressing*
- Consider packets traversing a shared medium as Figure 13.2 (below) illustrates
![[Pasted image 20241010101027.png]]

- Each packet has a specific *recipient*
	- only the intended recipient should process the packet
- Demultiplexing uses an identifier known as an address
- each computer is assigned a unique address
- each address consists of *48* bits; IEEE uses the term *Medis Access Control* address (or simply MAC address)
	- same as *Ethernet address*
- IEEE allocates a *unique* address for each piece of interface
	- each *Network Interface Card* (NIC) contains a unique IEEE address

- IEEE assigns a block of addresses to each vendor
	- allows the vendor to assign a unique value to each device
	- there is a *3-byte Organizationally Unique ID (OUI)*
		- OUI identifies the equipment vendor
		- a 3-byte block that identifies a particular NIC
![[Pasted image 20241010101324.png]]

# Unicast, Broadcast, and Multicast Addresses
- the IEEE addressing supports 3 types of addresses
![[Pasted image 20241010101404.png]]

- The IEEE address format reserves a bit to distinguish between *unicast* and *multicast*
	- nothing for a broadcast address
- *Broadcast address* consists of *48* bits that are all *1*s
	- a broadcast address has the multicast bit set
- Broadcast can be viewed as a special form of multicast
	- each multicast address corresponds to a group of computers
	- Multicast addressing can be used in the link layer, such as Ethernet multicast, and the Internet layer for IPv4 and IPv6
	- Broadcast address corresponds to a group that includes all computers on the network

# Broadcast, Multicast, and Efficient Multi-Point Delivery
- Broadcast and multicast addresses permit efficient delivery to many computers
- the efficiency comes from a shared medium
- in a typical LAN
	- each computer on the LAN *monitors* the shared medium
	- *extraces* a copy of each packet and determines the address
	- determine whether the packet should be *processed* or *ignored*
- Algorithm 13.1 gives the algorithm a computer uses to process packets

![[Pasted image 20241010101806.png]]
![[Pasted image 20241010101838.png]]
FFFFFFFFF is a broadcast address (all 1s!)
# Frames and Framing
- *Framing*
	- the structure added to a sequence of bits or bytes that allows a sender and receiver to agree on the exact format of the message
- in a packet-switched network, each frame corresponds to a packet
- a frame consists of two conceptual parts:
	- *Header* that contains *metadata*, such as an address
		- Information used to process the frame
	- *Payload* that contains the data being sent
		- the message being sent

- A message is *opaque*
	- the network only examines the frame header
	- the payload only meaningful to the sender and receiver
- some technologies *delineate* each frame by sending a short *prelude* before the frame and a short *postlude* after it
![[Pasted image 20241010102127.png]]
- Assume that a packet header consists of *6* bytes
	- the payload consists of an arbitrary number of bytes
- We can use ASCII character set to specify:
	- Beginning: the Start of Header (*SOH*) character
	- End: the End of Transmission (*EOT*) character
![[Pasted image 20241010102244.png]]

# Byte and Bit Stuffing
*"Like Chicage stuffed Pizza!"*
- in the ASCII character set
	- SOH has hex value *201*
	- EOT has the hex value 204
- An important question arises
	- what happens if the payload of a frame includes one or more bytes with value *201* or *204*?
- The answer lies in a technique known as *byte stuffing*
	- that allows transmission of arbitrary data without confusion

- To distinguish data from control information
	- sender replaces each control byte with a sequence
	- receiver replaces the sequence with the original one
	- the underlying system never confuses data with control information
- Known as byte stuffing
	- the terms *data stuffing* and *character* stuffing are sometimes used
- A related technique with systems that transfer a bit stream is known as *bit stuffing*

- *SOH* and *EOT* must not appear in the payload (reserved)
- Byte stuffing reserves a third character to represent reserved characters in the data
	- e.g. the ASCII character *ESC* may be used as the third character
	- each occurrence of the reserved <- replaced by two character sequence
- One possible mapping can be:
![[Pasted image 20241010102700.png]]

- As the figure specifies
	- the sender replaces each occurrence of *SOH* by the two characters *ESC + A
	- each occurrence of *EOT* by the characters  *ESC + B*
	- and each occurrence of *ESC* by the two characters *ESC + C*
- A receiver reverses the mapping
	- by looking for *ESC* followed by one of *A, B, or C* and replacing the *2*-character combination with the appropriate single character
- Figure 13.13 shows an example payload and the same payload after byte stuffing has occurred
	- note that once byte stuffing has been performed, neither *SOH* nor *EOT* appears anywhere in the payload
![[Pasted image 20241010102926.png]]

# Bit stuffing
- not to be confused with control signals
- Maintains synchronization: prevent long sequences of the same bit value
- inserting extra, non-informational bits into the data stream to prevent misunderstanding, e.g., after 5 consecutive 1, insert one zero. Then the receiver removes it