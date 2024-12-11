---
aliases:
  - Data Communications
  - Networking
  - COSC350 11-21-2024
tags:
  - "#COSC350"
cssclasses:
---
From: [[2024/11/21]]

---
# Day 25 (11-21-2024)

Today's and Tuesday's lecture on IP addresses
then thanksgiving break
then term presentations!
	guidelines will be posted!
	will submit presentation file and research paper
	10 minutes! make sure you rehearse
Then 1 more class session
	part review 

---------


![[CH 21 IP_Protocol_Addresses.pptx]]

![[Pasted image 20241121093328.png]]
The last 2 written bits represent subnets!
this is an example of CIDR!
	x.x.x.x/26 specifically (x.x.x.x is the IP address, defined with 26 bits of prefix! these 26 bits specify the network, the other 6 define host on that network!)

in IP world, everything has to be in binary!
	otherwise you cant solve problems!

# Address Masks
- the classless and subnet addressing schemes require an additional piece of information:
	- a value that specifies the exact boundary
- To mark the boundary, IP uses a ==32-bit== value
	- known as an ==addressing mask==, also called a ==subnet mask==
- a mask makes processing efficient
- hosts and routers compare the network prefix portion of the address to a value in their forwarding tables
ex.
address:
125.62.140.26/26

subnet mask
255.255.255.192
(11111111.11111111.11111111.11/000000)
	26 bits of 1s lets you AND our just the address
#MEMORIZE > "will be on the final"

- Suppose a router is given
	- a destination address, ==D==
	- a network prefix represented as a ==32-bit== value, ==N==
	- a ==32-bit== address mask, ==M==
- Assume the top bits of ==N== contain a network prefix, and the remaining bits have been set to zero
- to test whether the destination lies on the specified network, the router tests the condition:
	- N == (D & M)
- The router
	- uses the mask with a "==logican and (&)==" operation to set the host bits of address ==D== to zero (0)
	- and then compares the result with the network prefix ==N==

consider IP address:
136.160.52.0/24
	since the last octet is 0, the address refers to the network itself (its classless(?))

consider IP address:
136.160.52.255
	since the last octet is 255 (ie all 1s), the address is the limited broadcast address - delivers to all machines on the subnet

![[Pasted image 20241121094659.png]]

# CIDR Notation
- Classless Inter-Domain Routing (CIDR)
	- make it easy for a human to specify a mask
- Consider the mask needed for the example in figure 21.4b
	- it has ==26== bits of ==1==s followed by ==6== bits of ==0==s
	- in dotted decimal, the mask is: 255.255.255.192
- The general form -> ==ddd.ddd.ddd.ddd\/m==
	- ==ddd== is the decimal value for an octet of the address
	- ==m== is the number of one bits in the mask
- E.g.: 192.5.48.69/26 specifies a mask of ==26== bits
![[Pasted image 20241121095042.png]]

consider x.x.x.111|00000/27
	8 subnets, 32 addresses each
		but actually 30 unique addresses bc 00000 and 11111 are network and broadcast addresses
	is x.x.x.100 allowed on this network?
	-> x.x.x.01100100
	using subnet mask
	X.X.X.011|00100 &
	X.X.X.111|00000 = 
	X.X.X.011|00000 -> invalid!!

	is x.x.x.90 allowed on this network?
	-> x.x.x.01011010
		01011010 &
		11100000 = 
		01000000 -> Valid!!

REVIEW!!!! ^^^ WILL BE ON FINAL #MEMORIZE


# A CIDR Example
- Assume an ISP has the following block ==128.211.0.0/16==
- Suppose the ISP has ==2== customers
	- one customer needs ==12== IP addresses and the other needs ==9==
- The ISP can assign
	- customer1 CIDR: ==128.211.0.16/28==
	- customer2 CIDR: ==128.211.0.32/28==
	- both customers have the same mask size (28 bits), the prefixes differ
- The binary value assigned to customer1 is:
	- 10000000  11010011  00000000  0001|0000
- The binary value assigned to customer2 is:
	- 10000000  11010011  00000000  0010|0000
- There is no ambiguity
	- each customer has a unique prefix
	- more important, the ISP retains most of the original address block
		- it can then allocate to other customers
# CIDR Host Addresses
- once CIDR prefix is given
	- the customer can assign host addresses
	- e.g. ==128.211.0.16/28==
- Figure 21.6 illustrates ==4-bit== host address field
	- avoid assigning the all ==1s== and all ==0s== host addresses
- Figure 21.6 illustrates a disadvantage of classless addressing
	- the host suffix can start on an arbitrary boundary
	- e.g.
		- decimal values from ==128.211.0.17== through ==128.211.0.30==

![[Pasted image 20241121100552.png]]
![[Pasted image 20241121100605.png]]
![[Pasted image 20241121100612.png]]
![[Pasted image 20241121100618.png]]
![[Pasted image 20241121100624.png]]
![[Pasted image 20241121100629.png]]
![[Pasted image 20241121100637.png]]
this computer = 00000000.00000000.0000000.0000000

![[Pasted image 20241121100656.png]]
![[Pasted image 20241121100703.png]]
![[Pasted image 20241121100731.png]]

# Special IP addresses

| Prefix  | Suffix | Type of Address    | Purpose'                   |
| ------- | ------ | ------------------ | -------------------------- |
| all 0s  | all 0s | this computer      | used during bootstrap      |
| network | all 0s | network            | identifies a network       |
| network | all 1s | directed broadcast | broadcase on specified net |
| all 1s  | all 1s | limited broadcast  | broadcast on local net     |
| 127     | any    | loopback           | testing                    |

![[Pasted image 20241121101220.png]]

![[Pasted image 20241121101226.png]]

# The default gateway
- the basic IP configuration:
	- the IP address
	- the subnet mask
	- the default gateway

# Assigning IP addresses
- All devices on a subnet must share the same network ID
- subnets must have different network Ids than each other
- nodes on a local subnet must have unique node Ids
- Node Ids on a remote subnet can duplicate node Ids on the local subnet
- 127.0.0.1 is reserved for loopback testing and can't be used
- the node address can't be all 1s or all 0s

- Non routable IP address ranges:
	- 10.0.0.0. ~ 10.255.255.255
	- 168.254.0.0 ~ 168.254.255.255
	- 172.16.0.0 ~ 172.31.255.255
	- 192.168.0.0 ~ 192.168.255.255

TU doesnt like IPv6 bc of private IP
	- most computers (99%) dont need to be accessed from outside the network
	-  networks can use private IPs to "extend" the number of IP addresses they can use
	- when discoverable from outside, you're more susceptible to attack!

# Subnetting example
1. Subnetting 192.168.10.0 into 4 subnets
	1. subnet mask? -> 255.255.255.192
2. calculating base network Ids
	1. 203.121.45.6/22 = 203.121.44.0
	2. 224.210.100.5/18 = 224.210.64.0

# Multi-homed hosts
- Can a host connect to multiple networks? Yes
- a host computer with multiple network connections is said to be ==multi-homed==
- multi-homing is sometimes used to increase ==reliability==
	- if one network fails, the host can still reach the Internet through the second connection
- Alternatively, multi-homing is used to increase ==performance==
	- connections to multiple networks can make it possible to send traffic directly and avoid routers, which are sometimes congested
- like a router, a multi-homed host has multiple protocol addresses
	- one for each network connection
-----------

# IP Datagrams & Datagram Forwarding

![[CH 22 IP_Datagrams.pptx]]


# Introduction
- Fundamental Internet communication service
- format of packets
- processing of packets by routers
	- forwarding
	- delivery

# Conenctionless service
- end-to-end delivery service is *connectionless*
- extension of LAN abstraction
	- universal addressing
	- data delivered in packets (frames), each with a header
- Combines collection of physical networks into single, virtual network
- Transport protocols use this connectionless service to provide connectionless data delivery (UDP) and connection-oriented data delivery (TCP)

# Virtual packets
- *packets* service same purpose in internet as frames on LAN
- each has a header
- *Routers* (formerly *gateways*) forward between physical networks
- Packets have a uniform, hardware-independent format
	- includes header and data
	- can't use format from any particular hardware
- Encapsulated in hardware frames for delivery across each physical network

> packet IS virtual packet!

# IP datagram format
- formally, the unit of IP data delivery is called a *datagram*
- includes header area and data area

![[Pasted image 20241121102951.png]]

- Datagrams can have different sizes
	- header area usually fixed (20 octets) but can have options
	- data area can contain between 1 octet and 65,535 octets ($2^{16}-1$)
	- usually, data area much larger than header

# Forwarding datagrams
- header contains all information needed to deliver datagram to destination *computer*
	- destination address
	- source address
	- identifier
	- other delivery information
- router examines header of each datagram and forwards datagram along path to destination
![[Pasted image 20241121103214.png]]

# Routing table
- for efficiency, information about forwarding is stored in a *routing table*
- initialized at system initialization
- must be updated as network topology changes
- contains list of destination networks and *next hop* for each destination

![[Pasted image 20241121103351.png]]

# Default routes
- routing table kept small by listing destination networks rather than hossts
- can be further reduced through *default* route
- entry used if destination network not explicitly listed in routing table

# Routing tables and address masks
- in practice, additional information is kept in routing table
- destination stored as *network address*
- next hop stored as IP address of router
- *address mask* defines how many bits of addresses are in prefix
- prefix defines how much of address used to identify network
- E.g., class A mask is 255.0.0.0
- Used for subnetting

# Address masks
- to identify destination network, apply *address mask* to *destination address* and compare to *network address* in routing table
- Can use Boolean and
	- if((Mask\[i] & D) == Dest\[i]) forward to NextHop\[i]
- Consider a datagram with 192.4.10.3 as destination arrived at the center router:
	- first entry fails
	- second and third entry fail
	- last entry: 255.255.255.0 & 192.4.10.2 == 192.4.10.0
		- so the next hop would be 128.1.0.9
![[Pasted image 20241121103858.png]]

# Forwarding, destination address, and next-hop
- *Destination address* in IP datagram is always ultimate destination
- router looks up *next-hop address* and forwards datagram
- *Network interface layer* takes two parameters:
	- IP datagram
	- Next-hop address
- Next-hop address *never* appears in IP datagram

# Best-effort delivery
- IP provides service equivalent to LAN
- Does *NOT* guarantee to prevent
	- duplicate datagrams
	- delayed or out-of-order delivery
	- corruption of data
	- datagram loss
- *Reliable delivery* provided by *transport layer*
	- *Network layer* - IP - can *detect* and *report* errors without actually *fixing* them
	- Network layer focuses on datagram delivery
	- Application layer not interested in differentiating among delivery problems at intermediate routers


![[Pasted image 20241121104611.png]]
![[Pasted image 20241121104617.png]]
