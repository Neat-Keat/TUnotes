---
aliases:
  - Data Communications
  - Networking
  - COSC350 11-14-2024
tags:
  - "#COSC350"
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
	- it s