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
	