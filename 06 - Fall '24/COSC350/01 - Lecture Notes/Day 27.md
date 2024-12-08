---
aliases:
  - Data Communications
  - Networking
  - COSC350 12-05-2024
tags:
  - "#COSC350"
cssclasses:
---
From: [[2024/12/05]]

---
# Day 27 (12-05-2024)

today:
- finish supporting protocols: TCP & UDP
- go over study guide

![[Support Protocols.pptx]]

final exam covers from midterm II to what we cover today

-------


![[Pasted image 20241205093157.png]]

### How to deliver IP packet to a host on a subnet?

assume you're the packet arriving at the subnet:
- you need a destination IP address
does the router/switch know where to send you? How do they know?

![[Pasted image 20241205093439.png]]

Switch sends out an ARP request to all computers
recall broadcast address is all 1s

theoretically every packet needs to do this!
ie)
1) ARP request
2) ARP reply
3) IP Datagram

but doing this every time is cumbersome, so we cache IP address + MAC address
as a result, once cached, communication only needs
1) IP datagram

A
T 
N - IP
L - MAC
P

-> this process is on upper part of Link layer

--------

on tracert:
when TTL = 0, router sends a message back to sender via ICMP protocol
- nicknamed the Bad News Messenger (BNM)

IP datagram carries ICMP message in it!

------

## Address translation

IPv6 created bc IPv4 is not enough; we have billions of devices & not enough IPv4 addresses

but its pretty useless bc of IPv4 private addre

![[Pasted image 20241205094727.png]]

When left sends a message to right, how does the router know which computer to send to on the right?
- Based on used port number!
- IP and Port saved in a NAT table!

NAT: Network Address Translation

![[Pasted image 20241205094738.png]]

![[Pasted image 20241205094744.png]]
![[Pasted image 20241205094749.png]]
![[Pasted image 20241205094755.png]]
![[Pasted image 20241205094804.png]]
![[Pasted image 20241205094811.png]]
![[Pasted image 20241205094815.png]]
> Need to understand not the detailed information but the information they contain


![[Pasted image 20241205094901.png]]
![[Pasted image 20241205094907.png]]
![[Pasted image 20241205094918.png]]
![[Pasted image 20241205094925.png]]
ARP needs to be carried by Ethernet frame

![[Pasted image 20241205094959.png]]
![[Pasted image 20241205095110.png]]
3 frames are needed:
1) ARP request
2) ARP reply
3) IP datagram
![[Pasted image 20241205095116.png]]
![[Pasted image 20241205095122.png]]
![[Pasted image 20241205095126.png]]
![[Pasted image 20241205095130.png]]
![[Pasted image 20241205095138.png]]
![[Pasted image 20241205095142.png]]
![[Pasted image 20241205095153.png]]
> not 100% bad neews but mostly

![[Pasted image 20241205095211.png]]
![[Pasted image 20241205095256.png]]
ICMP message carried by IP datagram

ARP =/= ICMP

![[Pasted image 20241205095301.png]]
![[Pasted image 20241205095305.png]]
![[Pasted image 20241205095309.png]]
![[Pasted image 20241205095313.png]]
![[Pasted image 20241205095319.png]]
![[Pasted image 20241205095325.png]]
![[Pasted image 20241205095329.png]]
![[Pasted image 20241205095333.png]]
![[Pasted image 20241205095337.png]]![[Pasted image 20241205095358.png]]
![[Pasted image 20241205095402.png]]
![[Pasted image 20241205095405.png]]
![[Pasted image 20241205095409.png]]
![[Pasted image 20241205095412.png]]
![[Pasted image 20241205095417.png]]
![[Pasted image 20241205095421.png]]
![[Pasted image 20241205095424.png]]
![[Pasted image 20241205095427.png]]
![[Pasted image 20241205095431.png]]
![[Pasted image 20241205095434.png]]
Router sees old (incoming) value and replaces it with new number (internal address)

![[Pasted image 20241205095539.png]]
![[Pasted image 20241205095543.png]]
![[Pasted image 20241205095546.png]]

----

# TCP/UDP
![[UDP_TCP.pptx]]

A
T - decide whether to use UDP/TCP
N
L
P

UDP is "dumb" protocol
- doesnt do anything on msg lost, delivered, etc
- no mechanism to recover lost packets
- Used when you dont want to receive late packets, but rather discard them

Use TCP when every bit matters
- like banking info!

![[Pasted image 20241205095750.png]]
![[Pasted image 20241205095903.png]]
UDP does "best effort", but not responsible for lost, out-of-order, duplicate packets
- only security feature is an opti checksum
![[Pasted image 20241205100004.png]]
![[Pasted image 20241205100010.png]]

![[Pasted image 20241205100402.png]]
![[Pasted image 20241205100409.png]]
![[Pasted image 20241205100413.png]]

# TCP
> Notoriously complicated protocol
> provides reliable data delivery, but using unreliable datagram delivery
> best effort again lol

![[Pasted image 20241205100606.png]]
![[Pasted image 20241205100631.png]]
uses 3-way handshake
uses graceful shutdown

![[Pasted image 20241205100800.png]]

How does the left know if their battle plans made it to the right?
	they dont!

![[Pasted image 20241205101047.png]]

![[Pasted image 20241205101214.png]]
think about Macy's in the Towson Mall:
- they're having a huge sale on shoes!
you cant walk up to the mall and demand shoes, you have to go to the Macys in the mall!

your PC is the mall, services are the stores

![[Pasted image 20241205101444.png]]
![[Pasted image 20241205101449.png]]
P2P communication
![[Pasted image 20241205101538.png]]
recall duplicate packets come from a packet "killing a dragon"

![[Pasted image 20241205101705.png]]
SEND/ACK with timer basically
![[Pasted image 20241205101814.png]]
on Host 1:
- vertical distance between send message 3 and retransmission timer expires is the time-out window
![[Pasted image 20241205101852.png]]
![[Pasted image 20241205101913.png]]
![[Pasted image 20241205101917.png]]
too short -> duplicate packets -> inefficient
too long -> communication slows down

![[Pasted image 20241205102015.png]]
RTO -> Retransmission TimeOut

![[Pasted image 20241205102038.png]]

#MEMORIZE
> to set timeout value:
> 	we measure ==Round-Trip Time==

![[Pasted image 20241205102229.png]]
need to be aware of which packet is being acknowledged, but we use TCP sliding window to figure this out!

![[Pasted image 20241205102407.png]]
Suppose you're managing a Greyhound bus:
- you have 6 packets to take care of
As a sender, you only send packets 1,2,3 at first
- receiver only gets 2

![[Pasted image 20241205102841.png]]
![[Pasted image 20241205102844.png]]
![[Pasted image 20241205103019.png]]
"all the magic is in the header"
	source and destination is identical to UDP
	sequence & ack number are unique
	"not that complicated as you can see"
"if you understand sliding window youll understand all that"

![[Pasted image 20241205103121.png]]
#MEMORIZE 3-way handshake

note that handshake also uses random sequence numbers to label each communication

| Host 1 | Host 2 |
| ------ | ------ |
| Syn    |        |
|        | Ack    |
| Ack    |        |
![[Pasted image 20241205103224.png]]
code part of header determines if Syn, Ack, or Ack
if client denied, just retry with new random numbers!

![[Pasted image 20241205103438.png]]

windows terminal > netstat
lets you see what you're communicating with and state of communications
![[Pasted image 20241205103646.png]]

![[Pasted image 20241205103718.png]]
![[Pasted image 20241205103849.png]]

Thats it!
We've covered all the course material!

study guide for final:
![[final study guide.docx]]

given a subnet, how to divide into 16 further subnets?
	4 bits = 16, last 4 bits determine new subnets

given 2 IP addresses, see if theyre in the same network?
	use subnet mask, see if its the same

pass MTU? #MEMORIZE
- multiple networks, each has a max size of packet that can go through
- set IP = dont fragment
- if MTU doesnt allow that size, then ICMP will report "I cant go through!"
- smallest MTU across all networks

![[Pasted image 20241205104514.png]]
if A sends a packet of size 1200, MTU wont allow it, ICMP reports back to fragment
same with MTU 700, needs to be < smallest MTU to be successful

