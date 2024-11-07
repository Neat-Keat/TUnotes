on group projects:
	we need to show prof that it works in person
	come during office hours T/TH 1pm
	or after class

--------

last class on routing in WANS
![[WAN_and_Routing.pptx]]

# Routing in a WAN
- both interior and exterior switches:
	- forward packets
	- need routing tables
- Must have:
	- *universal routing* - next hop for each possible destination
	- *optimal routes* - next hop in table must be on shortest path to destination
# Modeling a WAN
- uses a graph
- nodes model switches
- edges model direct connections between switches
- captures essence of network, ignoring attached computers
![[Pasted image 20241105094305.png]]
![[Pasted image 20241105094319.png]]

# Default Routes
- can collapse routing table entries with a *default route*
- if destination does not have an explicit routing table entry, use the default route:
![[Pasted image 20241105094405.png]]

# Building routing tables
- how to enter information into routing tables:
	- *manual entry* - initialization file
	- *dynamically* - thru runtime interface
- how to compute routing table information:
	- *static routing* - at boot time
	- *dynamic routing* - allow automatic updates by a program
- static is simpler; doesn't accommodate changes to network topology
- dynamic requires additional protocol(s); can work around network failures

# Computation of shortest path in a graph
- Assume graph representation of network at each node
- use *Dijkstra's algorithm* to compute *the shortest path* from each node to every other node
- extract next-hop information from resulting path information
- insert next-hop information into routing tables

# Weighted graph
- Dijkstra's algorithm can accommodate *weights* on edges in graph
- shortest path is then the path with lowest total weight (sum of weights of all edges)
- shortest path not necessarily fewest edges (or hops)

![[Pasted image 20241105094737.png]]
![[Pasted image 20241105094746.png]]
![[Pasted image 20241105094753.png]]


Initialization table:

| Node:                 | S   | a        | b        | c        | d        |
| --------------------- | --- | -------- | -------- | -------- | -------- |
| D (min found dist.)   | 0   | $\infty$ | $\infty$ | $\infty$ | $\infty$ |
| $\pi$ (previous node) | NiL | NiL      | NiL      | NiL      | NiL      |

after processing D(min that hasn't been processed) (here its "S")

| Node:                 | S   | a   | b        | c   | d   |
| --------------------- | --- | --- | -------- | --- | --- |
| D (min found dist.)   | 0   | 2   | $\infty$ | 4   | 8   |
| $\pi$ (previous node) | NiL | S   | NiL      | S   | S   |
after processing D(min that hasn't been processed) (here its "a")

| Node:                 | S   | a   | b   | c   | d   |
| --------------------- | --- | --- | --- | --- | --- |
| D (min found dist.)   | 0   | 2   | 4   | 3   | 8   |
| $\pi$ (previous node) | NiL | S   | a   | a   | S   |

After Processing D(min)

| Node:                 | S   | a   | b   | c   | d   |
| --------------------- | --- | --- | --- | --- | --- |
| D (min found dist.)   | 0   | 2   | 4   | 3   | 6   |
| $\pi$ (previous node) | NiL | S   | a   | a   | c   |
note that from here, going through the rest of D(min) doesn't change the graph, but you should do it for completeness's sake

# Distance metrics
- weights on graph edges reflect "cost" of traversing edge
	- time (delay)
	- cost
	- hop count (weight = 1 )
- resulting shortest path may not have fewest hops
![[Pasted image 20241105101211.png]]

# Dynamic route computation
- Network topology may change dynamically
	- switches may be added
	- connections may fail
	- costs for connections may change
- switches must update routing tables based on topology changes

# Distributed route computation
- pass information about network topology between nodes
- update information periodically
- each node recomputes shortest paths and next hops
- inject changes into routing tables

# Distance-vector Routing (DVR)
- knowledge about the whole network:
	- each packet switch(router) sends out information about the entire network (whatever it has)
- routing only to neighbors
	- DVR messages are not broadcast
	- sends out information only to the packet switches that have direct link
- Information sharing at regular intervals
	- sharing occurs whether or not the network has changed

# Link-state Routing
- Knowledge about the neighborhood
	- each packet switch sends out information about its neighborhood only
- to all packet switches
	- sends information to every other packet switch on the internet (flooding)
- information sharing when there is a change
	- sends out information only when there is a change

# Comparison
- Distance-vector algorithm
	- very simple to implement
	- may have convergence problems
	- used in *RIP* (routing information protocol)
- Link-state algorithm
	- much more complex
	- switches perform independent computations
	- Used in *OSPF* (open shortest path first)

![[Pasted image 20241105102013.png]]

# Routing Problems
- Most practical routing mechanisms contains constraints and *heuristics* to prevent problems like routing loops
- some solutions:
	- DVR schemes employ *split horizon* (preventing routing loop)
		- a switch does not send information back to its origin
	- most practical routing systems introduce *hysteresis*
		- prevents the software from making many changes in a short time
- However, in a large network where many links fail and recover frequently, routing problems can occur

![[Pasted image 20241105102427.png]]
![[Pasted image 20241105102435.png]]
note that gigabit ethernet needs to disable CSMA/CD bc there will def be collisions on such a long cable

#MEMORIZE 
> "Extremely important!"
![[Pasted image 20241105102443.png]]

know the difference between IP routing and MPLS routing
# Summary
- WAN can span aribitrary distances and interconnect arbitrarily many computers
- uses packet switches and point-to-point connections
- packets switches use store-and-forward and routing tables to deliver packets to destination
- WANs use hierarchical addressing (2 part address)
- graph algorithms can be used to compute routing tables
- two basic routing algorithm
	- distance vector
	- link state

---------

previous chapter:
	we talked about bridges
		when you connect 2 collision domains, the bridge filters a lot
		whats important is the source address
			bridges learn the source address

on the study guide:
	its posted!!
	go read it!!

essay Q material:
	djikstra algorithm lol