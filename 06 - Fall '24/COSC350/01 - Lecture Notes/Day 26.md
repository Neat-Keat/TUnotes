---
aliases:
  - Data Communications
  - Networking
  - COSC350 11-26-2024
tags:
  - "#COSC350"
cssclasses:
---
From: [[2024/11/26]]

---
# Day 26 (11-26-2024)

On the Term Project:
- final paper should "make some kind of theory"
- cohesion
- abstract is the salesperson for your theory
	- it should describe everything
- Intro is topic at high level
- "Im looking for nicely shaped"
- conclusion = your findings

- rewrite rough draft to have a more conclusive statement on whether or not it's a good idea to implement

On presentation day, must submit presentation file one day before!
- presentation is 4 points
- Peer evaluation 
	- all 5s and all 1s will be discarded
	- one per group, collaborate with team and I submit
- assess other groups
- paper is 11 points

We present 2nd

decide who's covering what
	divide and conquer
	10 minute presentations
		really 9 minutes & QNA
	


--------
![[CH 22 IP_Datagrams.pptx]]

recall 135.62.150.3/26

the network address is found with a 26 bit subnet mask!
123.62.150.4
11111111.11111111.11111111.11000000 = 255.255.255.192

# Address masks
- To identify destination network, apply *address mask* to *destination address* and compare to *network address* in routing table
- Can use Boolean and
	- if ((Mask\[i] & D) == Dest[i]) forward to NextHop\[i]
- Consider a datagram with 192.4.10.3 as destination arrived at the center router:
	- first entry fails
	- second and third entry fail
	- last entry: 255.255.255.0 & 192.4.10.3 == 192.4.10.0
		- so the next hop would be 128.1.0.9

![[Pasted image 20241126093935.png]]

# Forwarding, destination address and next-hop
- *Destination address* in IP datagram is always ultimate destination
- Router looks up *next-hop* address and forwards datagram
- *Network interface layer* takes two parameters:
	- IP datagram
	- Next-hop address
- Next-hop address *never* appears in IP datagram

# Best-effort delivery
- IP provides service equivalent to LAN
- Does *not* guarantee to prevent
	- Duplicate datagrams
	- Delayed or out-of-order delivery
	- Corruption of data
	- Datagram loss
- *Reliable delivery* provided by *transport layer*
	- *Network layer* - IP - can *detect* and *report* errors without actually *fixing* them
	- Network layer focuses on datagram delivery
	- Application layer not interested in differentiating among delivery problems at intermediate routers

| A   |         |
| --- | ------- |
| T   | TCP/UDP |
| N   | IP      |
| D   |         |
| P   |         |

> datagram is IP packet

![[Pasted image 20241126094405.png]]

# IP datagram header fields
- VERS - version of IP (currently 4)
- H.LEN - header leangth (in units of 32 bits)
- SERVICETYPE - sender's preference for low latency, high reliability (rarely used)
- TOTAL LENGTH - total octets in datagram
- IDENT, FLAGS, FRAGMENT OFFSET - used with fragmentation
- TTL - *time to live*; decremented in each router; datagram discarded when TTL = 0
- TYPE - type of protocol carried in datagram; e.g., TCP, UDP
- HEADER CHECKSUM - 1s complement of 1s complement sum
	- adding value of each ASCII character
- SOURCE, DEST IP ADDRESS - IP addresses of *original* source and *ultimate* destination

# IP datagram options
- Several options can be added to IP header:
	- Record route
	- Source route
	- Timestamp
- Header with no options has H.LEN field value 5; data begins immediately after DESTINATION IP ADDRESS
- Options added between DESTINATION IP ADDRESS and data in multiples of 32 bits
- Header with 96 bits of options has H.LEN field value 8

ICMP: reports TTL=0 casualties back to original sender
	nickname: bad news messenger

UDP is a dumb protocol because it doesnt do anything different

CRC > checksum in critical cases like banking

> need to understand whats in the IP header

# IP Encapsulation
- in a physical network, frame is used to deliver IP datagram
- the technique is called IP encapsulation

![[Pasted image 20241126095502.png]]

# Transmission across an internet
- Networks may use different technologies
- Header format may be different
- Each hardware technology specifies the maximum amount of data for a frame to carry (MTU)
	- ex: Ethernet MTU is 1500 octets
	- think of it like a weight limit on cargo trucks
- If the amount of data bigger than current MTU, fragmentation may occur - IDENTIFICATION field and OFFSET field are used to reassemble

PathMTU - finding the path between routers with the smallest MTU (think min-cut from cosc336), and designing all payloads to be smaller than it

# IP Fragmentation Flags Field


| Bit position | Field Name          | Meaning                                         |
| ------------ | ------------------- | ----------------------------------------------- |
| 0            | Reserved            | Always 0                                        |
| 1            | Don't Fragment (DF) | 1 = no fragmentation, 0 = Fragmentation allowed |
| 2            | More Fragments (MF) | 1 = More fragments to follow, 0 = last fragment |

# Transmission across an internet cont'
- Consider a 1500-octet datagram sent from H1 to H2 in the following network

![[Pasted image 20241126100122.png]]

- Datagram can reach router R but cannot draverse Net 2
- ==pathMTU== discovery: a standardized technique in computer networking for determining the maximum transmission unit (MTU) size on the network path between two Internet Protocol (IP) hosts, usually with the goal of avoiding IP fragmentation. If doesn't fit, an ICMP message is sent to the sender - DF field must be set to 1

![[Pasted image 20241126100320.png]]

# Datagram Fragmentation
- Technique for accommodating heterogeneous MTUs
- Needed if datagram exceeds MTU
- Original datagram divided into smaller datagrams called fragments
- Header of fragment derived from original datagram header
- Each fragment is forwarded independently
- IPv4 requires sending host to perform fragmentation

![[Pasted image 20241126100601.png]]

# Datagram Fragmentation cont'
- Datagram header contains fixed fields that control fragmentation
- a bit in FLAGS field specifies whether given datagram is a fragment or complete datagram
- an additional FLAGS bit specified whether the fragment carries the tail of the original datagram
- OFFSET field specifies where the payload belongs in the original datagram


# Collecting fragments
- Destination collects incoming fragments
- IDENTIFICATION field used to group related fragments
- OFFSET field allows receiver to recreate the original payload
- LAST FRAGMENT bit allows receiver to know when all fragments have arrived
- If a fragment fails to arrive within a timeout period, entire datagram is discarded

# Hardware and protocol addressing
- Underlying network hardware
	- Only understands MAC addresses
	- Requires each outgoing frame to contain the MAC address of the next hop
	- IP forwarding
		- Deals only with IP addresses
		- Computes the IP address of the next hop
	- The IP address of the next hop must be translated to a MAC address before a frame can be sent

- Recall ARP that fetches the address of computers connected to a network
	- #MEMORIZE for final
# Address Resolution
- Translates IP address to equivalent MAC address that the hardware address understands (ARPing)
- IP address is said to be resolved
- Restricted to a single physical network at a time
![[Pasted image 20241126101039.png]]
- A MAC address is needed at each hop in the above example

![[Pasted image 20241126101054.png]]

ARP request is broadcast
Reply is unicast
# Summary
- basic unit of delivery in TCP/IP is *IP datagram*
- Routers use *destination address* in IP datagram header to determine *next-hop*
- Forwarding information stored in *routing table*
- IP datagram header has 40 octets of fixed field information and (possibly) options

------

![[CH 23 Support Protocols.pptx]]

# Support Protocols and Technologies

# Introduction
Four key support technology
- Address binding
- Error reporting
- Bootstraping
- Address translation

TU doesnt need IPv6 because we can reuse private IPs in subnets!

# Address Resolution
- A crucial step of the forwarding process requires a translation:
	- forwarding uses IP addresses
	- a frame MUST contain the MAC address of the next hop
	- IP must be translated into a MAC address
- The principle is:
	- IP addresses are ==logical addresses=
	- IP address cannot uniquely identify a computer
		- needs equivalent MAC address
	- ==Address resolution==
		- When an IP address obtains MAC address
	- Address resolution is local to a network

![[Pasted image 20241126103511.png]]
#MEMORIZE ARP: Broadcast -> Unicast -> Delivery 

![[Pasted image 20241126103713.png]]
![[Pasted image 20241126103725.png]]
![[Pasted image 20241126103732.png]]
![[Pasted image 20241126103739.png]]
![[Pasted image 20241126103745.png]]
![[Pasted image 20241126103833.png]]
![[Pasted image 20241126103842.png]]
![[Pasted image 20241126103849.png]]
![[Pasted image 20241126104024.png]]
recall broadcast address is all 1s


![[Pasted image 20241126104123.png]]
![[Pasted image 20241126104132.png]]
ARP: Broadcast -> Unicast -> Delivery


![[Pasted image 20241126104243.png]]
![[Pasted image 20241126104249.png]]
![[Pasted image 20241126104402.png]]
![[Pasted image 20241126104407.png]]
![[Pasted image 20241126104414.png]]
