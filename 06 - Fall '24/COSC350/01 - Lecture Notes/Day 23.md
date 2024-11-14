---
aliases:
  - Data Communications
  - Networking
  - COSC350 11-14-2024
tags:
  - "#COSC350"
  - COSC350/IPProtocolAddress
cssclasses:
---
From: [[11-14-2024]]

---
# Day 23 (11-14-2024)


#  TU Datacenter tour and group homework Assignment

when we go there, behave
next Tuesday, meet in the basement of Cook library

divide this class into 2 groups
	groups 1, 2, 3 meet at 9:30
	groups 4, 5, 6 meet at 10:00

## What to Submit
- Summary of your findings
- list of equipment with specification
- diagram for the equipment location and used technology
- Storage and web server - equipment and IP addressing scheme (e.g., how to handle large network traffic), security related techniques (how it works)

## Grading factors
- Number of attendees and make sure there is no late comers
- Quality of the report
	- how well your report describes what we have in the Datacenter
	- Specification and functionality
	- Must be neatly organized - font, size, layout, etc.
-  Quality of questions during the tour
		- Not necessarily the number of questions but must show the willingness to learn

- Total points assigned: 2. Exceptional report may get extra credit up to 5 additional points


| Group Name | Task                     | Details                                                                  |
| ---------- | ------------------------ | ------------------------------------------------------------------------ |
| 4          | TU Backbone architecture | Equipment, cable, speed, location                                        |
| 3 (us!!)   | Networking technologies  | Ethernet, wi-fi, etc (interactions between equipment), software as well? |
| 1          | Network Equipment        | Inside and outside of buildings                                          |
|            | Router/backup router     | USM (University System Maryland) interface, type, capacity, brand, etc.  |
| 5          | IP address structure     | Public, private                                                          |

## Due 11/24
---------

![[IP_Protocol_Addresses.pptx]]

why IP and MAC?
	MAC is structured differently depending on manufacturer (?)
# Properties of IP addresses cont
- Make sense *only when* it is converted to a binary number

![[Pasted image 20241114093239.png]]

# Designing the format of IP addresses
- IP designers chose 32-bit addresses
- allocate some bits for prefix, some for suffix
	- large prefix, small suffix - many networks, few hosts per network
	- small prefix, large suffix - few networks, many hosts per network
- Because of variety of technologies, need to allow for both large and small networks

# Classes of addresses
- Designers chose a compromise - multiple address formats that allow both large and small prefixes
- each format is called an address *class*
- class of an address is identified by first four bits

![[Pasted image 20241114093536.png]]

> prefix is network address
> host is machine on the network
# Using IP address classes
- Class A, B, and C are *primary classes*
- Used for ordinary host addressing
- Class D is used for multicast, a limited form of bradcast
	- internet hosts join a *multicast group*
	- packets are delivered to all members of group
	- routers manage delivery of single packet from source to all members of multicast group
	- used for *mbone* (multicast backbone)
- Class E is reserved
- the *first four bits* of an IP address determined the class to which the address belonged
	- it specifies how the remainder of the address was divided into prefix and suffix

# Dotted decimal notation
- Class A, B, and C all break between prefix and suffix on byte boundary
- *dotted decimal notation* is a convention for representing 32-bit internet addresses in decimal
- convert each byte of address into decimal; display separated by periods ("dots")
	![[Pasted image 20241114095311.png]]

# Towson's IP addresses
- Towson University has:
	- a total of 21,504 IPv4 addresses distributed across three main IP ranges
		- 136.160.128.0 / 18 (16,384 addresses)
		- 204.62.32.0 / 20 (4,096 addresses)
		- 204.62.48.0 / 22 (1,024 addresses)
		- No IPv6 registered
	- Most of end-user stations use private addresses which must be mapped to some public IP address to communicate with the stations located outside of LAN environment
- Suffix bytes are used to determine local network and host through subnetting

# Networks and hosts in each class
- Classing scheme does not yield equal number of networks in each class
- Class A: First bit must be 0
- 7 remaining bits identify Class A net
- $2^7 = 128$ possible class A nets - contains half of all addresses
- ![[Pasted image 20241114095632.png]]


# Internet address allocation
- Addresses in the Internet are not used efficiently
- Large organizations may not be able to get as many addresses in the Internet as they need
- Example - UPS needs addresses for **millions** of computers
-  Solution - set up *private internet* and allocate addresses from entire 32-bit address space
	-  connection to the Internet through IP masquerading

# Authority for Addresses
- Internet Corporation for Assigned Names and Numbers (ICANN) authority has been established
	- to handle address assignment and adjudicate disputes
- ICANN does not assign individual prefixes
	- instead, ICANN authorizes a set of *registrars* to do so
- Registrars make blocks of addresses available to ISPs
	- ISPs provide addresses to subscribers
- To obtain a prefix
	- a corporation usually contacts an ISP

# Subnet and Classless Addressing
- Classful addressing scheme became a limitation
- the demands for *class A* or *class B* exceed the capacity
- many class C addresses still remained but less demands
- two mechanisms to overcome the limitation:
	- subnet addressing
	- classless addressing
- the two mechanisms are closely related
	- multiple IP address classes can be combined by using prefix/suffix appropriately

- Subnet addressing: used within large organizations
- Classless addressing extended the approach to all Internet
- Consider a network that contains *55* hosts
	- classful addressing requires a complete *class C* prefix
	- in classless addressing:
		- a prefix that is 26 bits long
		- a suffix that is 6 bits long

- With classless addressing
	- divide the prefix into several longer prefixes
- Figure 21.4 illustrates how to divide a class C prefix into four (4) longer prefixes
	- each one contains up to *62* hosts
- The original class C address has *8* bits of suffix
	- the classless addresses have *6* bits of suffix
- ISP can assign each of the *four (4)* classless prefixes to a subscriber

![[Pasted image 20241114100528.png]]

> prefix is network address
> host is machine on the network


> class A subnet mask:
> 255.0.0.0

> Class B subnet mask:
> 255.255.0.0

> Class C subnet mask:
> 255.255.255.0
# Address Masks
- the classless and subnet addressing schemes require an additional piece of information:
	- a value that specifies the exact boundary
- to mark the boundary, IP uses a *32-bit* value
	- known as an *address mask*, also called a *subnet mask*
- A mask makes processing efficient
- hosts and routers compare the network prefix portion of the address to a value in their forwarding tables

- Suppose a router is given
	- a destination address , *D*
	- a network prefix represented as a *32-bit* value, *N*
	- a *32-bit* address mask, *M*
- Assume the top bits of *N* contain a network prefix, and the remaining bits have been set to zero
- to test whether the destination lies on the specified network, the router tests the condition:
	- N \==(D & M)
- The router
	- uses the mask with a =="logical and (&)"== operation to set the host bits of address ==D== to zero(0)
	- and then compares the result with the network prefix ==N==

As an example:
- consider the following ==32-bit== network prefix:
	10000000  00001010  00000000  00000000  = 128.10.0.0 (class B!)
	
- consider a 32-bit mask:
  11111111  11111111  00000000  00000000  =  255.255.0.0 (class B!)
  
- Consider a 32-bit destination address, which has a :
  10000000  00001010  00000010  00000011  =  128.10.2.3 

- A logical and between the destination address and the address mask extracts the high order - ==16-bits== (extracts the prefix!)
  10000000  00001010  00000000  00000000  =  128.10.0.0

# CIDR Notation
- Classless Inter-Domain Routing (CIDR)
	- Make it easy for a human to specify a mask
- Consider the mask needed for the example in Figure 21.4b
	- it has ==26== bits of ==1==s followed by ==6== bits of ==0==s
	- in dotted decimal, the mask is: 255.255.255.192
- The general form -> ==ddd.ddd.ddd.ddd\/m==
	- ==ddd== is the decimal value for an octet of the address
	- ==m== is the number of one bits in the mask
- E.g.: 192.5.48.69/26 specifies a mask of ==26== bits

![[Pasted image 20241114101753.png]]
http://www.techrepublic.com/blog/data-center/ip-subnetting-made-easy-125343/
http://www.subnet-calculator.com/
# A CIDR Example #MEMORIZE (exam Q)
- Assume an ISP has the following block:
	==128.211.0.0\/16==

- suppose the USP has ==2== customers
	- one customer needs ==12== IP addresses and the other needs ==9==
- The ISP can assign
	- customer1 CIDR: ==128.211.0.16/28==
	- customer2 CIDR: ==128.211.0.32/28==
	- both customers have the same mask size (28 bits), the prefixes differ
- The binary value assigned to customer1 is:
	- 10000000  11010011  00000000  0001  0000
- The binary value assigned to customer2 is:
	- 10000000  11010011  00000000  0010  0000
- There is no ambiguity
	- each customer has a unique prefix
	- more important, the ISP retains most of the original address block
		- it can then allocate to other customers

# CIDR Host Addresses
- Once CIDR prefix is given
	- the customer can assign host addresses
	- e.g. ==128.211.0.16/228==
- Figure 21.6 illustrates ==4-bit== host address field
	- avoid assigning the all ==1==s and all ==0==s host addresses
- Figure 21.6 illustrates a disadvantage of classless addressing
	- the host suffix can start on an arbitrary boundary
	- E.g.
		- Decimal values from ==128.211.0.17== through ==128.211.0.30==

![[Pasted image 20241114102722.png]]

# Special IP Addresses
- IP defines a set of special address forms that are ==reserved==
	- that is, special addresses are never assigned to hosts
- This section describes both the ==syntax== and ==semantics== of each ==special address== form
	- 21.14.1 Network Address
	- 21.14.2 Direct Broadcast Address
	- 21.14.3 Limited Broadcast Address
	- 21.14.4 This Computer Address
	- 21.14.5 Loopback Address

# Network Address
- IP reserves host address ==zero== to denote a network
- E.g., the address ==128.211.0.16/28== denotes a network
- A network address should never appear as the destination address in a packet

# Directed Broadcast Address
- To simplify broadcasting (send to all)
	- IP defines a directed broadcast address for each physical network
- When a packet is sent to a network's directed broadcast
	- a single copy of the packet travels across the Internet
		- until it reaches the specified network
	- the packet is then delivered to all hosts on the network
- The directed broadcast address for a network is formed by adding a suffix that consists of all ==1== bits

- How does broadcast work?
- If network hardware supports broadcast
	- a directed broadcast will be delivered using the hardware broadcast capability
- If a particular network does not have hardware support for broadcast
	- software must send a separate copy of the packet to each host on the network

# Limited Broadcast Address
- ==Limited broadcast== refers to a broadcast on a directly-connected network
- Limited broadcast is used during ==system startup==
- IP reserves the address consisting of ==32-bits== of ==1==s
- IP will broadcast any packet sent to the all-1s address across the local network

# This computer Address
- A computer needs to know its IP address
- When the computer boots
	- the ==startup protocols== also use an IP to communicate
- When using such startup protocols
	- IP reserves the address that consists of all ==0==s to mean ==this computer==