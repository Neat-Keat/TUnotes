![[cosc350 syllabus.doc]] 

ysong@towson.edu
office YR472

read textbook before classes

grades:
midterms: 40%
term project: 15%
HW: 10%
Final Exam: 30%
Attendance: 5%

A is 95-100%

Midterms 10/1, 11/5
Final 12/12 (8am-10am)

"if you know binary then you know half the class"

read the book and bring questions

group project is research based, has a presentation component, groups of 3-4


"only the pure heart can see the packets floating through the air"

------------
lecture notes

Intro to data communication

![[KRChapter_1.pptx]]
goals:
* get "feel", "big picture" intro to terms
* more depth, detail later

overview/roadmap
* what is the internet? whats a protocol?
* network edge: hosts, access network, physical media
* network core: packet/circuit switching, internet structure
* performance: loss, delay, throughput
* protocol layers, service models
* security
* history

The Internet: a "nuts and bolts" view:
	billions of connected computing devices:
		hosts= end systems
		running network apps at internet's "edge"
	packet switches: forward packets (chunks of data)
		routers, switches
	communication links
		fiber, copper, radio, satellite
		transmission rate: bandwidth
	networks
		collection of devices, routers, links: managed by an organization

internet: "network of networks"
	interconnected ISPs
protocols are everywhere
	control sending, receiving of messages
	eg HTTP (web), streaming video, skype, TCP IP, WiFi, 4G/5G, Ethernet
Internet standards
	RFC: request for Comments
	IETF: Internet Engineering Task Force

look into the book "Where Wizards Stay Up Late: The Origins of the Internet"

The Internet: a "services" view
	*Infrastructure* that provides services to applications:
		web, streaming video, multimedia teleconferencing, email, games, e-commerce, social media, interconnected appliances
	provides *programming interface* to distributed applications:
		"hooks" allowing sending/receiving apps to "connect" to, use Internet transport service
		provides service options, analogous to postal service

What's a protocol?
	*Human protocols:*
		"whats the time?"
		"I have a question"
		introductions
	*Network Protocols:*
		computers (devices) rather than humans
		all communication activity in Internet governed by protocols
	Rules for: 
		... specific messages sent
		...specific actions taken when message received, or other events
	*Protocols* define the *format, order* of *messages sent and received* among network entities, and *actions taken* on message transmission, receipt

A closer look at Internet structure
	*Network edge:*
		- hosts: clients and servers
		-  servers often in data centers
	*Access networks, physical media:*
		- wired, wireless communication links
	*Network core:*
		- interconnected routers
		- network of networks

*Q: How to connect end systems to edge router?*
	residential access nets
	institutional access networks (school, company)
	mobile access networks (wifi, 4G/5G)