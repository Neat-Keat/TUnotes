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

