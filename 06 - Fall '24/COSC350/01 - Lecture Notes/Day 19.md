Midterm next Tuesday

today we review previous chapters to prep for midterm
	then discuss WANs today
	covers LANS all the way to WAN technologies and routing
	content covered today will ALSO be on midterm

expect MC, T/F, and essay Qs

------

list of topics to know (incomplete):

from: 	![[CH 13 LANs.pptx]]
- Circuit Switching
- Packet Switching
	- the difference between the two
	- characteristics of packet switching
	- various org's standards for them
		- ![[Pasted image 20241031095151.png]]
		- and their layers!!
- LLC vs MAC in IEEE 802 model and standards
	- main functionality of LLC
	- error checking in LLC
- IEEE standards, esp for wireless (Key Wifi Standards)
	- ![[Pasted image 20241031095338.png]]
	- ![[Pasted image 20241031095351.png]]
	- > dont memorize the list, but know when to use what
- LAN topologies
	- about the technology, not just the shape
	- ie when to use bus topology (basically ethernet)
	- ![[Pasted image 20241031095451.png]]
	- ![[Pasted image 20241031095511.png]]
- MAC addresses and their 48 bit addresses
- different types of casting
	- unicast
		- one computer on a network receives
	- broadcast
		- all computers on a network receive
	- multicast
		- a selected subset of computers on a network receive
	- ![[Pasted image 20241031095746.png]]
- Frames and Framing
	- ethernet frame
- Bit and Byte stuffing
	- why and how

from:![[CH 14 The_IEEE_MAC_Sub-Layer.pptx]]
- Overview
	- ![[Pasted image 20241031100146.png]]
- which technology belongs to which category
- channel allocation
	- static or dynamic
- Channelization protocols
	- FDMA
	- TDMA
	- CDMA
- Random Access Protocols
	- ALOHA
		- phased out
	- CSMA/CD (collision detection)
		- ethernet
	- CSMA/CA (collision avoidance)
		- wi-fi
	- we use these a LOT
- layer 2 switch port is a separate collision domain
	- because ...
	- not covered here lololol
- how does collision avoidance work?
	- hidden station problem
	- request to send to receiver is unicast
		- if receiver is ready, send a ready to receive unicast
		- delay of 2D
- ALOHA and Collision avoidance is pretty similar
- how CSMA works
	- will have Qs on it
	- ![[Pasted image 20241031100704.png]]
	- ![[Pasted image 20241031100719.png]]
- on collision, we recover by waiting a random amount of time
	- 51.2us * K
	- ![[Pasted image 20241031100831.png]]
- Collisions
	- ![[Pasted image 20241031101003.png]]
	- know what it takes to recover

From:
![[CH 15 Wired_LAN_(IEEE802.3).pptx]]

- Ethernet
	- ethernet frame format:
	- ![[Pasted image 20241031101130.png]]
	- vs IEEE frame format (be able to tell the difference)
	- max payload size is 1500 bytes
- Demultiplexing
	- ![[Pasted image 20241031101232.png]]
- Address Resolution Protocol (ARP)
	- ![[Pasted image 20241031101251.png]]
	- understand this algorithm!
- IEEE Ethernet
	- ![[Pasted image 20241031101336.png]]
- NICs
	- have independent processors to examine inbound traffic and whether or not to send to CPU
- Twisted Pair Ethernet and Technologies
	- ![[Pasted image 20241031101449.png]]
	- ![[Pasted image 20241031101457.png]]
	- know when to use what, like earlier

Finish for other PPTXs lmfaoo

----------

# WAN Technologies and Routing

## Introduction
- LANs cannot be extended arbitrarily far or handle arbitrarily many computers
	- Distance limitations even with extensions
	- broadcast a problem
- Need other technologies for larger networks

## Characterizations of networks
- Personal Area Network (PAN) -spans a region near an individual
- Local Area Network (LAN) - single building or a campus
- Metropolitan Area Network (MAN) - intra city
- Wide Area Network (WAN) - inter-city, country, continent, planet

## Large Spans and WANs
- the key issue that separates WAN technologies from LAN technologies is *scalability*
- a WAN must be able to grow as needed to connect many sites
	- spread across large geographic distances
- a technology is not classified as a WAN unless it can deliver reasonable performance for a large scale network
	- a WAN does not merely connect to many computers at many sites
		- it must provide sufficient capacity to permit all computers to communicate
		- a satellite bridge that connects a pair of PCs and printers is merely an *extended LAN*

## Packet switches
- to span long distances or many computers, network must replace *shared medium* with *packet switches*
	- each switch moves an *entire packet* from one connection to another
	- a small computer with network interfaces, memory and program dedicated to packet switching function
- Early packet switches were constructed from conventional computers

![[Pasted image 20241031102136.png]]
![[Pasted image 20241031102143.png]]

## Forming a WAN
- the details of the interconnections depend on:
	- the data rate needed
	- the distance spanned
	- and the delay
- Many WANs use leased data circuits
	- other forms also exist
		- microwave, satellite channels
- A network designer must choose a topology
	- for a given set of sites, many topologies are possible

## Connections to packet switches
- Packet switches may connect to computers and to other packet switches
- typically high speed connections to other packets switches, lower speed to computers
- technology details depend on desired speed (T3 circuit, OC-12, etc)
- packet switches can be linked together to form WANs (scalability)
![[Pasted image 20241031102404.png]]
![[Pasted image 20241031102412.png]]

## Store-and-forward switch
- *stores* incoming packets in the input buffer and *forwards* the packets to another switch or computer
	- I/O hardware places a copy of packet in memory
	- when forwarding, the processor:
		- examines the packet
		- determines its destination
		- sends it to appropriate I/O interface

## Physical addressing in a WAN
- similar to LAN
	- data transmitted in *packets* (equivalent to frames)
	- each packet has format with header
	- packet header includes destination and source addresses
- Many WANs use *hierarchical addressing* for efficiency
	- one part of address identifies destination switch
	- other part of address identifies port on switch
- in practice, an address is represented as a single binary value with some bits of the binary value
	- used to represent a packet switch
	- and others used to identify a computer
![[Pasted image 20241031102706.png]]

# Next-hop forwarding
- outgoing connection for forwarding
	- direct packet delivery for a local computer
	- to another switch, forwards packets only to *next hop*
- Choice based on destination address in packet
- each packet switch contains a *forwarding table or routing table*
	- all possible packet switches
	- a next hop info for each switch

![[Pasted image 20241031102828.png]]

## Choosing next hop
- packet switches
	- keep the next hop info
	- examine destination address in each packet and forwards to next hop if not nocal
	- use a 2-part hierarchical addressing scheme
		- the 1st part of the destination address to the *final switch*
		- the 2nd part of the address is used to deliver the packet to a specific computer

![[Pasted image 20241031102951.png]]

## Source independence
- next hop to destination does not depend on source of packet
- allows fast, efficient routing
- packet switch keeps only next hop
	- reduces the size of information to keep
	- increases dynamic robustness - network can continue to function even if topology changes *without* notifying entire network

## Dynamic Routing Updates in a WAN
- Forwarding table must guarantee the following:
-  Universal communication
	◦Must contain a valid next-hop route for each possible destination address
- Optimal routes
	◦The next-hop value must point to the shortest path to the destination
- In case of Network failures
	◦Forwarding should be changed to alternate available path
	◦Static values may not be used for flexibility
	◦Reconfigures the forwarding tables automatically

- Routing software is used to reconfigure forwarding tables
- Route computation utilizes a graph that models the network
	◦Compute the shortest path to all possible destinations
- Each node in the graph corresponds to a packet switch in the network
- An edge between two nodes represents a direct connection between a pair of packet switches

![[Pasted image 20241031103225.png]]
![[Pasted image 20241031103238.png]]
![[Pasted image 20241031103244.png]]

## Routing in a WAN
- both interior and exterior switches:
	- forward packets
	- need routing tables
- must have:
	- *universal routing* - next hop for each possible destination
	- *optimal routes* - next hop in table must be on shortest path to destination

![[Pasted image 20241031103343.png]]
![[Pasted image 20241031103352.png]]

## Default routes
- can collapse routing table entries with a *default route*
- if destination does not have an explicit routing table entry, use the default route:
![[Pasted image 20241031103458.png]]

## Building routing tables
- how to enter information into routing tables:
	- *manual entry* - initialization file
	- *dynamically* - through runtime interface
- How to compute routing table information:
	- *static routing* at boot time
	- *dynamic routing* - allow automatic updates by a program
- Static is simpler; doesn't accommodate changes to network topology
- dynamic requires additional protocol(s); can work around network failures

## Computation of shortest path in a graph
- assume graph representation of network at each node
- use *Dijkstra's algorithm* to compute the *shortest path* from each node to every other node
- extract next-hop information from resulting path information
- insert next-hop information into routing tables

![[Pasted image 20241031103805.png]]
![[Pasted image 20241031103813.png]]
![[Pasted image 20241031103826.png]]
![[Pasted image 20241031103832.png]]
proper initialization:
![[Pasted image 20241031104238.png]]
in process:
![[Pasted image 20241031105150.png]]
Dijkstra will NOT be on midterm
study guide will be available by friday
midterm pushed back to Th