---
aliases:
  - Data Communications
  - Networking
  - COSC350 11-12-2024
tags:
  - "#COSC350"
  - "#COSC350/IPProtocolAddress"
---
From: [[12]]

---
# Day  (11-12-2024)

on the midterm:
- average: 64%
- highest: 90%
"problem with low score is attendance"

> I went over the exact question, but many of you didnt quite get that"
> 	- on Djikstra



one more major thing in the course:
- Term Project
	- he was expecting a summary on each paper on proposal lolol
	- proposal and final project will be combined
	- remember that we have to present!
		- grading criteria is:
			- cohesiveness of each members work
			- general intro of technology used
			- investigate papers
			- what conclusions can be drawn
		- Grading Guidelines will be posted!!
			- look at audience lol
			- rehearse :vomit:
			- make speaker notes
			- conciseness
			- intro all the way to conclusion
			- presentation is no more than 10 minutes!

Field trip to "secret room!"
- not just a tour!
- "purpose is to find out the secret"
	- group HW associated with it
	- less members that show up -> less points
	- during class time
	- ~ 10 minutes -> limited # of Qs
- depending on quality of report, you'll get extra credit (up to 5 points)
	- who's eligible?
		- "exceptional reports"
		- basic info about topic, but add as much as possible
		- come up with own details within your group
		- kind of guess and fill in blanks based on answers given
		- "you need to impress me"
- Tour is next Tuesday! (meet in basement of Cook Library)

HW weight: we only have 2 points left

| Group Name | Task                      | Details                                                                 |
| ---------- | ------------------------- | ----------------------------------------------------------------------- |
|            | TU Backbone architecture  | Equipment, cable, speed, location                                       |
| Us!!!      | Networking technologies   | Ethernet, wi-fi, etc                                                    |
|            | Network Equipment         | Inside and outside of buildings                                         |
|            | Router/backup router      | USM (University System Maryland) interface, type, capacity, brand, etc. |
|            | IP address structure      | Public, private                                                         |
|            | Cloud storage, web server | Capacity, speed, backup,..                                              |

group leader needs to prepare:
- [ ] #COSC350 list of questions to ask to accomplish this task
- [ ] group meeting to decide which 


![[CH 21 IP_Protocol_Addresses.pptx]]


# IP Protocol Addresses

# Motivation
- One key aspect of virtual network is single, uniform address format -> seamless communication
- Cant use hardware (MAC) addresses because different technologies have different address formats
- address format must be independent of any particular hardware address format
- sending host puts destination internet address in packet
- destination address can be interpreted by any intermediate router
- routers examine address and forward packet on to the destination

# TCP/IP address
- addressing in TCP/IP is specified by the *Internet Protocol* (IP)
- Each host is assigned a 32-bit number
- called the *IP address* or *Internet address*
- Unique adross entire Internet
- When sending a packet across the Internet, sender's protocol software must specify:
	- its own 32-bit IP address (the source address)
	- and the address of the intended recipient (the destination address)
be able to fill in:

why cant we broadcast to the entire network?
- 16 billion internet enabled devices
- if everyone could broadcast, $16,000,000,000^{15,999,999,999}$  concurrent messages possible
	- everything would be a DDoS attack
# IP address hierarchy
- each IP address is divided into a prefix and a suffix
	- prefix identifies network to which computer is attached -> network ( + sub network) address
	- Suffix identifies computer within that network -> host address
- Address format makes routing efficient
	- routers look for network address

memory address & offset is like a box of potato chips from Sam's Club
- address is bag of chips in box
- offset is chip in bag

# Network and Host numbers
- every network (LAN) in a TCP/IP internet is assigned a unique *network number* that must be coordinated globally
- Each host on a specific network is assigned a *host number* or *host address* that is unique *within that network*
- host address may be reused and should be managed locally

# Properties of IP addresses
- network numbers are unique
- IP address = Network number (prefix) + Host address (suffix)
- Host addresses may be reused on different networks
- Assignment of network numbers must be coordinated *globally*
- assignment of host addresses can be manages *locally*

- makes sense *only when* it is converted to a binary number
> "Binary is the key to survive"

$183_{10}$ to binary? 128 + 32 + 16 + 4 + 2 + 1
$10110111_2$ 

![[Pasted image 20241112100629.png]]

# Designing the format of IP addresses
- IP designers chose 32-bit addresses
- allocate some bits for prefix, some for suffix
	- large prefix, small suffix - many networks, few hosts per network
	- small prefix, large suffix - few networks, many hosts per network
- Because of variety of technologies, need to allow for both large and small networks

# Classes of addresses
- designers chose a compromise - multiple address formats that allow both large and small prefixes
- each format is called an address *class*
- class of an address is identified by first four bits
#MEMORIZE
![[Pasted image 20241112100808.png]]

# Using IP address classes
- Class A, B, and C are *primary classes*
- Used for ordinary host addressing
- class D is used for multicast, a limited form of broadcast
	- Internet hosts join a *multicast group*
	- Packets are delivered to all members of group
	- Routers manage delivery of single packeet from source to all members of multicast group
	- used for *mbone* (multicast backbone)
- Class E is reserved
- the *first four bits* of an IP address determined the class to which the address belonged
	- it specifies how the remainder of the address was divided into prefix and suffix

# Dotted decimal notation
- Class A, B, and C all break between prefix and suffix on byte boundary
- *dotted decimal notation* is a convention for representing 32-bit internet addresses in decimal
- convert each byte of address into decimal; display separated by periods ("dots")
![[Pasted image 20241112101126.png]]

# Towson's IP addresses
- Towson University has:
	- a total of 21,504 IPv4 addresses distributed across 3 main IP ranges
		- 136.160.128.0 / 18 (16,384 addresses) ->  to binary = 10 001000.* ->Class B 
		- 204.62.32.0 / 20 (4,096 addresses)
		- 204.62.48.0 / 22 (1,024 addresses)
		- No IPv6 registered
	- Most of end-user stations use private addresses which must be mapped to some public IP address to communicate with the stations located outside of LAN environment
- Suffix bytes are used to determine local network and host through subnetting

# Networks and hosts in each class
- classing scheme does not yield equal number of networks in each class
- Class A:
	- first bit must be 0, (Max = 01111111, min = 00000001)
	- 7 remaining bits identify Class A net
	- $2^7 - 1 = 127$ possible class A nets - contains half of all addresses

![[Pasted image 20241112101505.png]]

# Internet address allocation
- Addresses in the Internet are not used efficiently
- large organizations may not be able to get as many addresses in the Internet as they need
- Example - UPS needs addresses for *millions* of computers
- Solution - set up *private internet* and allocate addresses from entire 32-bit address space
	- connection to the internet through IP masquerading