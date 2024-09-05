
HW1
1.  TCP/IP layers, and what happens in each
2. do whats written i guess (whats a medium??) (stuff like fiber optic, radio, etc)
3.  cam.ac.uk (cambridge university)

no length requirement, do your best

![[Pasted image 20240905094515.png]]
(DO THIS FOR HW)

![[Pasted image 20240905094817.png]]
 here's another "answer"


Quiz dates listed in syllabus (or not?)

--------------
*traceroute* program: provides delay measurement from source to router along end-end Internet path towards destination. For all i:
* sends 3 packets that will reach router *i* on path towards destination (with time-to-live field value of i)
* router *i* will return packets to sender
* sender measures time interval between transmission and reply

think of TTL not as an actual measurement of time, but of how many nodes it can hit before reporting

Tracert uses the ICMP protocol
	must see message "tracert complete"


--------------
Security!

- Internet not originally designed with (much) security in mind
	- original vision: "a group of mutually trusting users attached to a transparent network" :)
	- Internet protocol designers playing "catch-up"
	- security considerations in all layers!
- We now need to think about:
	- how bad guys can attack computer networks
	- how we can defend networks against attacks
	- how to design architectures that are immune to attacks

Bad guys: packet interception
	packet "*sniffing*":
		broadcast media (shared Ethernet, wireless)
		promiscuous network interface reads/records all packets (eg including passwords!) passing by
		![[Pasted image 20240905100425.png]]

Bad guys: fake identity
	IP *spoofing:* injection of packet with false source address
	![[Pasted image 20240905101048.png]]
	note that C is sending A traffic claiming to be from B

Bad guys: denial of service
	Denial of Service (*DoS*): attackers make resources (server, bandwidth) unavailable to legitimate traffic by overwhelming resource with bogus traffic
		1. select target
		2. break into hosts around the network (see botnet)
		3. send packets to target from compromised hosts
		![[Pasted image 20240905101324.png]]

Lines of defense:
- authentication: proving you are who you say you are
	- cellular networks provides hardware identity via SIM card; so such hardware assist in traditional Internet
- confidentiality: via encryption
- integrity checks: digital signatures prevent/detect tampering
- access restrictions: password-protected VPNs
- firewalls: specialized "middleboxes" in access and core networks:
	- off-by-default: filter incoming packets to restrict senders, receivers, applications
	- detecting/reacting to DOS attacks

...lots more on security (throughout, ch 8)

-----------------
Protocol layers, service models

Protocol "layers" and reference models
*Networks are complex, with many "pieces":*
- hosts
- routers
- links of various media
- applications
- protocols
- hardware, software

*Question:* is there any hope of organizing structure of network?
	- and/or discussion of networks?

EX: organization of air travel
![[Pasted image 20240905101904.png]]
![[Pasted image 20240905102103.png]]

Why layering?
Approach to designing/discussing complex systems:
- explicit structure allows identification, relationship of system's pieces
	- layered *reference model* for discussion
- modularization eases maintenance, updating of system
	- change in layer's service *implementation*: transparent to rest of system
	- e.g., change in gate procedure doesn't affect rest of system\

TCP/IP protocol stack, MUST #MEMORIZE!!!!
![[Pasted image 20240905102322.png]]

HTTP: hypertext transfer protocol
IMAP: for mail (how does it relate to POP?)
SMTP: Simple mail transfer protocol
DNS: Domain Name System
FTP: File transfer protocol
Telnet

TCP: resubmit on lost packet
UDP: ignore lost packet

IP: Internet Protocol
ICMP: Internet Control Message Protocol
ARP: Address Resolution Protocol
routing protocols: not the routers business to see if packet is UDP or TCP, just focus on where to send it next

Ethernet:  "knows the secrets of 0's and 1's" and the physical medium
802:11 (WiFi)/ cellular:
PPP:

(IP address is a logical one, like how 2 private planes can have the same name if they dont interact)
	with address alone we cant deliver
	like sending mail to "Joe" in a small town, we need their "MAC address"

![[Pasted image 20240905103110.png]]
![[Pasted image 20240905103223.png]]

![[Pasted image 20240905103230.png]]
![[Pasted image 20240905103244.png]]
![[Pasted image 20240905103259.png]]
![[Pasted image 20240905094817.png]]

"think of a frame as a container for IP datagram (packet)"
Packet =/ Frame
	Frame is bigger

-----------
History


