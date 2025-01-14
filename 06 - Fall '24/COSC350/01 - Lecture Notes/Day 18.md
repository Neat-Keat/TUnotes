send prof topic for final research paper
	clearly defined work for each member
	narrow down blockchain as to how it relates to data communications
	send topic name and justification and make sure its not covered by textbook

way to write proposal
	a brief survey of example papers on the topic
	once we've selected a topic, use google scholar/ IEEE library to find sample research papers
	we'll compile those and the relevancy should be agreed upon by all team members
	each member should have at least 1 research paper to work on
	read, summarize, then all group members have a meeting to discuss how to put all the summaries together and make sense of the combined knowledge
	utilize ALL summaries
	proposal page doesnt have to be complete
	write enough so that prof knows the outcome of final paper
	use IEEE for project proposal

send email on topic

on  midterm, hoping to cover extending LANs, WANs, and Routing PPTXs covered this week

on Th, will probably have a recorded lecture, but might be real time

2nd midterm is a similar format:
	need to understand:
		repeater operates on physical layer, so it *does not understand packets or signal coding*
		how bridges operate will be covered!!

----------
# Extending LANs: Fiber Modems, repeaters, Bridges, and Switches

# Introduction
- LAN provides services from the link layer (Layer 2 network)
	- node-to-node communication
	- Framing: each frame has physical address
	- link access; MAC protocol handles transport over the link
	- Reliable delivery: normally not provided
	- Flow control: limited at data link layer
	- Error detection/ correction
	- Half-duplex/ full duplex

- LAN technologies are designed with constraints of speed, distance, and costs
- typical LAN technology can span, at most, a few hundred meters
- factors considered when designing a network technology:
	- capacity
	- max delay
	- distance
![[Pasted image 20241029095652.png]]


# LAN design for distance
- Many LANs use shared medium
- Length of medium affects fair, shared access to medium
- CSMA/CD - delay between frames, minimum frame length
- length of medium affects strength of electrical signals and noise immunity

# LAN extensions
- several techniques extend diameter of LAN medium
- Most techniques use additional hardware
- LAN signals relayed between LAN segments
- Resulting mixed technology stays within original engineering constraints while spanning greater distance
# Fiber optic extensions
- The simplest LAN extension mechanism:
	- an optical fiber and a pair of fiber modems
	- connect a computer to a remote Ethernet
![[Pasted image 20241029095028.png]]

- Fiber modems:
	- accept packets over the Ethernet interface and send them over the optical fiber
	- accept packets that arrive over the optical fiber and send them over the Ethernet interface
- Typically connect 2 LANs in different buildings through a bridge

![[Pasted image 20241029095131.png]]

# Repeaters
- A *repeater*:
	- an analog device used to propagate LAN signals over long distances
	- does not understand packets or signal coding
	- amplifies the signal received
![[Pasted image 20241029095216.png]]

# Bridges 
#MEMORIZE
- Connect 2 LAN segments
- retransmit frames from one segment on other segment(s)
- Handle *complete frame*
	- recognize not only the signal but also the address of each frame
	- perform some processing on frames
- Invisible to other attached computers

# Bridged LAN segments
- Relatively easy to use - just plug in
- isolate collisions, noise
![[Pasted image 20241029095340.png]]

# Filtering bridges
- Bridges can do additional processing
	- Don't forward collisions, noise
	- only forward frames where necessary
- *Frame filtering*
	- uses MAC addresses to perform filtering
	- learns location of stations by watching frames
	- forwards all broadcast and multicast packets

# Frame filtering
- Bridge checks destination of each incoming frame
- looks up destination in list of known stations
	- forwards frame to next interface on path to destination
	- *Doesn't* forward frame if destination on LAN segment from which frame was received

# How does bridge set up table?
- Bridge examines *source* address in each frame
- Adds entry to list for LAN segment from which frame was received
- must forward any frame whose *destination* is not in the list on *every* interface
![[Pasted image 20241029102307.png]]


![[Pasted image 20241029095635.png]]
C pops up for no reason lol
# Startup behavior of filtering bridges
- initially, the forwarding tables in all bridges are empty
- first frame from each station on LAN is forwarded to *all* LAN segments
- after all stations have been identified, frames are only forwarded as needed
- may result in burst of traffic after, e.g., power failure

# Designing with filtering bridges
- Filtering bridge allows concurrent use of different LAN segments *if* traffic is local
- *U* and *V* can exchange frames at the same time *X* and *Y* exchange frames

![[Pasted image 20241029095858.png]]
- Designers identify patterns of local communication and isolate groups of communicating computers with bridges

# Bridges and cycles
- Four LAN segments currently connected by three bridges and a fourth bridge about to be inserted
![[Pasted image 20241029095957.png]]
- The fourth bridge:
	- creates a *loop*
- the loop forwards broadcasts indefinitely
	- creates broadcast flooding
- *Distributed Spanning Tree* (DST)
	- create a tree to prevent a cycle

# Distributed Spanning Tree
- Initially (DEC in 1985) designed for Ethernet networks
	- *Spanning Tree Protocol* (STP)
- STP consists of three steps:
	- *Root* election
	- *Shortest path* computation
	- Forwarding
- Ethernet bridges communicate amongst themselves using a multicast address that is reserved for STP

- IEEE created a standard named *802.1d* (in 1990)
- IEEE standard 802.1q
	- provides a way to run STP on a set of logically independent networks
	- share a physical medium
- Cisco created *Per-VLAN Spanning Tree* (PVST) for use on a VLAN switch
- IEEE standard 802.1w introduced the *Rapid STP* (RSTP) has been incorporated in 801.1d-2004 (in 1998), and now replaces STP, some versions are
	- Multiple Instance STP (MISTP)
	- Multiple STP (MSTP)

# Switching and Layer 2 Switches
- An *Ethernet switch (a Layer 2 switch)*
	- a switch provides multiple ports
	- a switch allows computers to send frames to one another
- The difference between a hub and a switch:
	- a hub operates as an analog device that forwards signals among computers
	- a switch is a digital device that forwards packets
	- a hub as simulating a shared transmission medium
	- a switch as simulating a bridged network
![[Pasted image 20241029100612.png]]

# Switches and hubs
- a switch consists of an *intelligent interface* attached to each port
	- a *central fabric* that provides simultaneous transfers
- An interface contains
	-  a processor, memory, and other hardware needed to accept a packet
	- a forwarding table
- An interface can buffer arriving packets when an output port is busy
- Advantage of using a switched LAN
	- a hub can only support one transmission at a time
	- a switch permits *multiple transfers* to occur at the same time, provided the transfers are independent

![[Pasted image 20241029100847.png]]
# Switched Ethernet
- contention moved from bus to "single point"
- ethernet switch emulates CSMA/CD
- upon buffer overflow -> collision signal
- medium-haul GigE/10GigE (802.3ae): 500m, 5km, 40km
	- Disable CSMA/CD  //because the delay can be too long, causing collisions!
	- Purely point-to-point
- QoS: IEEE 802.3p
- Today's Ethernet: switch, CSMA/CD, short- and long-distance LAN -> a result of incremental legacy-respecting changes

# VLAN Switches
- allows a manager to configure a single switch to emulate multiple, independent switches using VLAN tag (defined as 802.1Q by IEEE)
- a set of ports on the switch can be specified as virtual LAN 1 and so on
- When a computer on virtual LAN 2 broadcasts a packet
	- only those computers on the virtual LAN 2 receive a copy

![[Pasted image 20241029101225.png]]

- It is important to guarantee that a set of computers can communicate
- for example, a company may choose to provide a firewall between computers in the CEO's office and other computers in the company
- E.G. Computers *A, C, F* can be assigned as VLAN 1
![[Pasted image 20241029101425.png]]
