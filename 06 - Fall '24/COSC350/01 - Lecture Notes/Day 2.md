The Internet: a "nuts and bolts" view
- *Internet: network of networks"*
	- interconnected ISPs
- *protocols* are everywhere
	- control sending, receiving of messages
	- eg HTTP, streaming video, Skype, TCP, IP, WiFi, 4G/5G, Ethernet
- *Internet standards
	- RFC: request for comments
	- IETF: Internet Engineering Task Force

UDP is like watching a movie, you dont resubmit lost packets
TCP is like banking info, every bit matters so you resubmit

The Internet: a "services" view
* *infrastructure that provides services to applications:
	* web, streaming video, multimedia teleconferencing, email, games, e-commerce, social media, interconnected appliances,...
* provides *programming interface* to distributed applications:
	* "Hooks" allowing sending/receiving apps to "connect" to, use internet transport service
	* analogous to transport service

What's a protocol?
	Human protocols:
		Whats the time?
		I have a question
		Introductions
	Network Protocols:
		computers rather than humans
		all comm activity in Internet governed by protocols
	Rules for 
		specific messages sent
		specific actions taken when message received, or other events
	protocols define the format, order of messages sent and received among network entities, and actions taken on message transmission, receipt

![[Pasted image 20240829094749.png]]

A closer look at Internet structure
	be able to pick out what each is on the picture above lol
	*Network edge*:
		hosts: clients and servers
		servers often in data centers
	*Access networks, physical media:*
		Wired, wireless communication links
	*Network core:*
		interconnected routers
		network of networks\

dial up modems averaged 28.8 kbps
1 byte has 8 bits
1 megabyte had ~8,000,000 bits

*Q: How to connect end systems to edge router?*
- residential access nets
- institutional access networks (school, company)
- mobile access networks (WiFi, 4G/5G)

Access networks: cable-based access
![[Pasted image 20240829100551.png]]
*frequency division multiplexing (FDM)*: different channels transmitted in different frequency bands

*HFC: Hybrid fiber coax*
	asymmetric: up to 40 Mbps - 1.2 Gbps downstream transmission rate, 30-100 Mbps upstream transmission rate
*Network* of cable, fiber attaches homes to ISP router
	Homes *share access network* to cable headend

Access Networks: Digital Subscriber Line (DSL)
- use *existing* telephone line to central office DSLAM
	- data over DSL phone line goes to Internet
	- voice over DSL phone line goes to telephone net
- 24-52 Mbps dedicated downstream transmission rate
- 3.5-16 Mbps dedicated upstream transmission rate

Access networks: Home networks
![[Pasted image 20240829101640.png]]

what does a modem do?
	shorthand for Modulator and Demodulator
		converts digital signals to analog signals and vice versa
		think of the applications with radio comms

Wireless Access Networks
	Shared wireless access network connects end system to router
		via base station aka "access point"
	Wireless local area networks (WLANs)
		typically within or around building (~100 ft)
		802.11b/g/n/ac/ax (WiFi): 11, 54, 450 Mbps,..., 1 Gbps,... transmission rate
	Wide-area cellular access networks
		provided by  mobile, cellular network operator (10's KM)
		10's Mbps
		4G/5G cellular networks

![[Pasted image 20240829102324.png]]

Access networks: enterprise networks
	companies, universities, etc.
	mix of wired, wireless link technologies, connecting a mix of switches and router (we'll cover differences shortly)
		ethernet: wired access at 100 Mbps, 1 Gbps, 10 Gbps
		WiFi: wireless access points at 11, 54, 450 Mbps, ..., 1 Gbps, ...
![[Pasted image 20240829103010.png]]


Access networks: data center networks
	High bandwidth links (10s to 100s Gbps)
	connect hundreds to thousands of servers together, and to internet

we communicate with other continents with large, underwater cables

Host: sends *packets* of data
	host sending function:
		takes application message
			breaks into smaller chunks, known as *packets*, of length L bits
			transmits packet into access network at *transmission rate* R
				link transmission rate, aka link *capacity, aka link bandwidth*
		packet transmission delay = time needed to transmit L-bit packet into link
			= L (bits) / R (bits/sec) 
	![[Pasted image 20240829103338.png]]

Links: physical media:
	*bit*: propagates between transmitter/receiver pairs
	*physical link*: what lies between transmitter & receiver
	*guided media*: signals propagate in solid media: copper, fiber, coax
	*unguided media*: signals propagate freely, eg radio
	*Twisted pair (TP)*: 2 insulated copper wires
		category 5: 100 Mbps, 1  Gbps Ethernet
		Category 6: 10 Gbps Ethernet
		![[Pasted image 20240829103637.png]]
	*Coaxial Cable*: 2 concentric copper conductors
		bidirectional
		broadband
			multiple frequency channels on cable
			100's Mbps/ channel
			![[Pasted image 20240829103807.png]]
	*Fiber optic cable*: glass fiber carrying light pulses, each pulse a bit
		high-speed operation
			high-speed point-to-point transmission (10's to 100's Gbps)
		low error rate:
			repeaters spaced far apart
			immune to electromagnetic noise
			![[Pasted image 20240829103929.png]]
	*Wireless radio* 
		signal carried in various "bands" in electromagnetic spectrum
		no physical "wire"
		broadcast, "Half-duplex" (sender to receiver)
		propagation environment effects: reflection
			reflection
			obstruction by objects
			interference/noise
	*Radio link types*:
		*Wireless LAN (WiFi)*
			10's-100's Mbps; 10s of meters
		*Wide-area (eg 4G/5G cellular)*
			10's Mbps over ~10 KM
		*Bluetooth: cable replacement*
			short distances, limited rates
		*ZigBee*: home automation/sensors
		*Terrestrial Microwave*
			point-to-point; 45 Mbps channels
		*Satellite*
			up to 45 Mbps/channel
			270ms end to end delay
	