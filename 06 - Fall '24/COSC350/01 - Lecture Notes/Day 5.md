Quiz after each chapter, which means one after NEXT CLASS!!

review:
	Services, Layering, and Encapsulation
	TCP/IP Layers:
		1. Application
			1. sends a *message* to transport
		2. Transport
			1. sends a *segment* to network, adding a header
		3. Network
			1. sends a *datagram* to link, adding a second header
		4. Link
			1. sends a *frame* to physical, adding a third
		5. Physical
	![[Pasted image 20240910094234.png]]
	
MAC address is for the link layer, allows  switches  to identify the correct target device
IP address is for the network layer, allows routers to identify the correct target device
![[Pasted image 20240910094434.png]]

------------
Internet history
*1961-1972*: Early packet-switching principles
	*1961*: Kleinrock - queueing theory shows effectiveness of packet-switching
	*1964*: Baran - packet-switching in military nets
	*1967*: ARPAnet conceived by Advanced Research Projects Agency
	*1969*: first ARPAnet code operational
	*1972*: ARPAnet public demo
		NCP (Network Control Protocol) first host-host protocol
		first e-mail program
		ARPANET has 15 nodes

*1972-1980*: Internetworking, new and proprietary networks
	*1970*: ALOHAnet satellite network in Hawaii
	*1974*: Cerf and Kahn - architecture for interconnecting networks
	*1976*: Ethernet at Xerox PARC
	*Late 70's*: proprietary architectures: DECnet, SNA, XNA
	*1979:* ARPAnet has 200 nodes
	
	![[Pasted image 20240910095626.png]]

*1980-1990:* new protocols, a proliferation of networks
	*1983:* deployment of TCP/IP
	*1982*: smtp e-mail protocol defined
	*1983*: DNS defined for name-to-IP-address translation
	*1985* :ftp protocol defined
	*1988*: TCP congestion control
	- New national networks: CSnet, BITnet, NSFnet, Minitel
	- 100,000 hosts connected to confederation of networks
	![[Pasted image 20240910095950.png]]

*1990, 2000s:* commercialization, the Web, new applications
*early 1990s:* ARPAnet decommissioned
*1991*: NSF lifts restrictions on commercial use of NSFnet (decommissioned, 1995)
*early 1990s:* Web
	- hypertext (Bush 1945, Nelson 1960's)
	- HTML, HTTP: Berners-Lee
	- *1994*: Mosaic, later Netscape
	- *late 1990s*: commercialization of the Web
*late 1990s - 2000s:* 
	- more killer apps: instant messaging, P2P file sharing
	- network security to forefront
	- est. 50 million host, 100 million+ users
	- backbone links running at Gbps

*2005-present:* scale, SDN, mobility, cloud
- aggressive deployment of broadband home access (10-100's Mbps)
- 2008: software-defined networking (SDN)
- increasing ubiquity of high-speed wireless access: 4G/5G, Wifi
- service providers (Google, FB, Microsoft, Tesla) create their own networks
	- bypass commercial Internet to connect "close" to end user, providing "instantaneous" access to social media, search, video content,...
- enterprises run their services in "cloud" (eg Amazon Web Services, Microsoft Azure)
- rise of smartphones: more mobile than fixed devices on Internet (2017)
- ~18B devices attached to Internet (2017)

IP address + Port number
	FTP uses port 21
	HTTP uses port 80

port numbers under 1000 are typically occupied by popular protocols
look into PIM - processor in memory
	and "neuromorphic"

"my recommendation to use AI as much as you can"
	"using AI on HW is fine as long as you understand"(?)


CH1 Summary
we've covered:
- Internet overview
- What's a protocol?
- network edge, access network, core
	- packet-switching vs circuit-switching
	- internet structure
- performance: loss, delay, throughput
- layering, service models
- security
- history

You now have: 
- context, overview, vocabulary, "feel" of networking
- more depth, detail, and *fun* to follow!

Additional Ch1 slides
![[Pasted image 20240910102734.png]]
![[Pasted image 20240910102740.png]]

"Download Wireshark and start using it"

---------------
Start of new slideshow "Overview of Data Communications"

The Essence of Data Communications
- the subject is a combination of ideas and approaches from 3 disciplines as in 5.1
- Involves the transmission of information over *physical media*
- the subject draws on ideas about electric *current*, *light*, and other forms of *electromagnetic radiation*
- information is *digitized* and digital data is transmitted
- Data communications uses mathematics and includes various forms of analysis
	- goal is to develop practical ways to design and build transmission systems

![[Pasted image 20240910103323.png]]

Motivation and Scope of the Subject
	Three main ideas
		1. The *sources of information* can be of arbitrary types
		2. *transmission* uses a physical system
		3. *Multiple sources* of information can *share* the underlying medium
	The first point (multimedia):
		- information is not restricted to bits that have been stored in a computer
		- information can also be derived from the physical world, including audio and video
		- various sources and forms of information available and one form can be transformed into another
	The second point (use of natural phenomena)
		- electricity and electromagnetic radiation, etc. to transmit information
		Important issues:
			- the types of available media
			- the properties of each media
			- how physical phenomena can be used to transmit information over each medium
			- the relationship between data communications and the underlying transmission
			- the limits of physical systems
			- the problems that can arise during transmission
			- techniques that can be used to detect or solve the problems
	The third point (sharing)
		- a network usually permits multiple pairs of communicating entities to communicate over a given physical medium
		- there are possible ways underlying facilities can be shared
		- there are advantages and disadvantages of each sharing method