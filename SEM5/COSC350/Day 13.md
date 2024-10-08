roughly group 4 is my row
on BB
groups of 5 people

today we need to choose group lead, who'll communicate with prof on behalf of your group
send bro an email bc im group leader

group HW doc on BB
	due 10/27

textbook ch3 has the figures referenced in the doc
you can use ChatGPT lol

not a programming class lmfao

code takes less than 1 minute

the important thing is to understand how 2 machines communicate
	but source code must be running properly

same group for final paper
	i need to email prof with our topic so he can check it

----

# LANs

Local Area Networks: Packets, Frames, and Topologies

why do we distinguish between WAN and LAN?
	technologies used in them are different!

# Circuit Switching
- *Circuit Switching*
	- creates a path between sender and receiver
	- guaranteed *isolation* between paths
	- circuit switching networks use electronic devices to establish circuits
	- multiple circuits are multiplexed over shared media
		- the result is known as a *virtual circuit*
		- improving reliability and reducing the chances of packet reordering or loss
- Telephone technology uses circuit switching
	- they offer a *dedicated* connection between 2 telephones
![[Pasted image 20241008100522.png]]
3 general properties:
1. Point-to-pont cmmunication
2. Three steps:
	1. circuit creation, use, and termination
	2. *switched* or *permanent*
3. Performance equivalent to an isolated physical path
	1. established communication not affected by other
	2. circuit switching must provide the *illusion* of an isolated path
# Packet Switching
![[Pasted image 20241008100658.png]]
- Each message divided into *packets*
	- variable size
	- *maximum packet size* for each packet-switching technology
- Arbitrary, asynchronous communication
	- allows one-to-many communication
	- communication can occur at any time
- No set-up required
	- system always in ready to deliver state
	- no need to notify termination
- Performance varies
	- due to statistical multiplexing among packets
	- multiplexing occurs among packets

- Advantage: low cost due to resource sharing
- To provide communication among *N* computers
	- With a circuit-switched network
	- at least *N/2* independent paths
- With packet switcing, a network must have:
	- only one connection for each computer

# Local and Wide Area Packet Networks
- Packet switching technologies classified by the distance
	- short distance costs less (eg inside a single building)
	- long distances more expensive (eg across several cities)
![[Pasted image 20241008101110.png]]

# Standards for Packet Format and Identification
- Each packet must have the *identification* of the intended recipient
- must agree on how to identify a recipient and where to place the identification in a packet
- standards organizations
	- institute for Electrical and Electronic Engineers (*IEEE*)
- In 1980, IEEE organized the *Project 802* LAN/MAN Standards Committee to produce standards for networking

- IEEE covers the lower 2 layers of the protocol
- Figure 13.4 gives an illustration of a protocol as viewed by various standards organizations, such as:
	- Institure for Electrical and Electronic Engineers (*IEEE*)
	- World Wide Web Consortium (W3C)
	- Internet Engineering Task Force (IETF)

![[Pasted image 20241008101517.png]]

# IEEE 802 Model and Standards
- IEEE divides *Layer 2* of the protocol stack into 2 conceptual sub-layers, as figure 13.5 (below) illustrates
	- The *Logical Link Control* (LLC)
		- sublayer specifies addressing and the use of addresses for demultiplexing
	- the *Media Access Control* (MAC)
		- sublayer specifies how multiple computers share underlying medium
![[Pasted image 20241008101727.png]]

- IEEE assigns a multi-part identifier of the form *XXX.YYY.ZZZ*
	- *XXX* denotes the category of the standard
	- *YYY* denotes a subcategory
- IEEE has many working groups
	- Each working group consists of representatives from the industrial and academic communities
	- IEEE allows a working group to remain active provided the group makes progress and the technology is still deemed important
	- if a technology under investigation is no longer relevant, the group can decide to *disband*

![[Pasted image 20241008102022.png]]
![[Pasted image 20241008102220.png]]

# Point-to-Point and Multi-Access Networks
- LAN technologies are for sharing
	- any computer on the LAN can communicate with any other
	- A LAN is a multi-access network
	- fair use of a network
- LAN technologies can provide direct connection among communicating entities
- LANs connect computers along with peripheral devices

Orthogonal Frequency Division Multiplexing Access - OFDMA

# LAN Topologies
- Many LAN technologies exist
- each network is classified into a category according to its *topology* or *general shape*
- this section describes 4 basic topologies that are used to construct:
	- 13.8.1 Bus Topology
	- 13.8.2 Ring Topology
	- 13.8.3 Mesh Topology
	- 13.8.4 Star Topology
![[Pasted image 20241008103327.png]]

Bus Topology:
	- bus topology usually consists of a single cable to which computers attach
	- the ends of a bus network must be *terminated*
		- to prevent electrival signals from *reflecting* back along the bus
	- Any computer attached to a bus can send on the cable
		- and all computers receive the signal
	- Because all computers attach directly to the cable
		- any computer can send data to any other computer
	- The computers attached to a bus network must *coordinate*
		- to ensure that only one computer sends a signal at any time