Phone > Switch > Router (edge router -> regional ISP -> global ISP)
	how you communicate

today we'll talk about mediums
	typically we use things like air, copper wire, fiber optics, etc
	communication takes time, this is measured in ms (called ping)
	speed of light is  ~3.0 x 10^8 m/s

------------------

today we talk about packet/circuit switching, internet structure

The network core
- mesh of interconnected routers
- *packet-switching*: hosts break application-layer messages into packets
	- network *forwards* packets from 1 router to the next, across links on path from source to destination

2 key network-core functions
	![[Pasted image 20240903094141.png]]

ideally, we want to choose the path with the lowest delay

![[Pasted image 20240903094542.png]]

![[Pasted image 20240903094551.png]]

"we make local decisions about the global situation"

![[Pasted image 20240903094906.png]]

packet switching: store and forward
- packet transmission delay: takes L/R seconds to transmit (push out) L-bit packet into link at R bits/sec
- store and forward: entire packet must arrive at router before it can be transmitted on next link

1-hop numerical example
	L = 10 Kbits
	R = 100 Mbps
	1-hop transmission delay = 0.1 ms


when buffer is full, packet gets ignored, solved with queueing

packet switching: queueing
![[Pasted image 20240903094941.png]]

Packet queuing and loss: if arrival rate (in bps) to link exceeds  
transmission rate (bps) of link for some period of time:  
- packets will queue, waiting to be transmitted on output link  
- packets can be dropped (lost) if memory (buffer) in router fills up


Alternative to packet switching: circuit switching
	end-to-end resources allocated to, reserved for "call" between source and destination
		in diagram, each link has 4 circuits.
			call gets 2nd circuit in top link and 1st circuit in right link
		dedicated resources: no sharing
			circuit like (guaranteed) performance
		circuit segment idle if not used by call (no sharing)
		commonly used in traditional telephone networks (landline!)
	![[Pasted image 20240903095607.png]]

circuit switching: FDM and TDM
	Frequency Division Multiplexing (FDM)
		optical, electromagnetic frequencies divided into (narrow) frequency bands
		each call allocated its own band, can transmit at max rate of that narrow band
	Time Division Multiplexing (TDM)
		time divided into slots
		each call allocated periodic slot(s), can transmit at maximum rate of (wider) frequency band (only) during its time slot(s)
	![[Pasted image 20240903100025.png]]

![[Pasted image 20240903100046.png]]

then is packet switching a "slam dunk winner"?
- great for "bursty" data - sometimes has data to send, but at other times not
	- resource sharing
	- simpler, no call setup
- excessive congestion possible: packet delay and loss due to buffer overflow
	- protocols needed for reliable data transfer, congestion control
- Q: how to provide circuit-like behavior with packet-switching?
	- "Its complicated". We'll study various techniques that try to make packet switching as "circuit-like" as possible.
- Q: human analogies of reserved resources (circuit switching) versus on-demand allocation (packet switching)?

Internet structure: a "network of networks"
- hosts connect to Internet via access ISPs
- access ISPs in turn must be interconnected
	- so that any 2 hosts (anywhere!) can send packets to each other
- resulting network of networks is very complex
	- evolution driven by economics, national policies
Lets take a stepwise approach to describe current Internet structure

Q: given millions of access ISPs, how to connect them together
![[Pasted image 20240903100849.png]]
![[Pasted image 20240903100902.png]]
![[Pasted image 20240903100910.png]]
![[Pasted image 20240903100921.png]]
![[Pasted image 20240903100927.png]]
![[Pasted image 20240903100937.png]]
![[Pasted image 20240903100944.png]]

------------------
Performance: loss, delay, throughput

How do packet delay and loss occur?
	packets *queue* in router buffers, waiting for turn for transmission
		queue length grows when arrival rate to link (temporarily) exceeds output link capacity
	packet *loss* occurs when memory to hold queued packets fills up
	![[Pasted image 20240903101621.png]]

packet delay: 4 sources
![[Pasted image 20240903101640.png]]
![[Pasted image 20240903101657.png]]
you send a bit out is transmission
the bit's travel time to destination is propagation

![[Pasted image 20240903101712.png]]
![[Pasted image 20240903102215.png]]
![[Pasted image 20240903102507.png]]
![[Pasted image 20240903102638.png]]
![[Pasted image 20240903103610.png]]
![[Pasted image 20240903103756.png]]
![[Pasted image 20240903103858.png]]
![[Pasted image 20240903104005.png]]
![[Pasted image 20240903104123.png]]

