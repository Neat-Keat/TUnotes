Assignment #3 live  
Due 9/27  
Quiz #3 5 questions
 
-----------------------------------------------------------------------------------------------------  
Intro to Network Security:  
Network Basics and Threats
 
Topics  
Basics of network (OSI Model)  
Network Attacks  
DoS Attacks  
DDoS attacks  
Zombies and Botnets
 
SWBAT:  
Understand network basics  
Describe DoS attacks  
Explain DDoS attacks  
Define Zombies and Botnets
 
Network basics  
Network - Systems implemented with a collection of interconnected components

- A component (or host) can be anything capable of sending and/or receiving data from other components on the network
- Interconnect link: can be a cable, air, optical fiber, or any medium which can transport a signal carrying info

Background  
How do data networks work?

- Systems communicate over a shared communication medium according to an agreed upon convention (standard)
- Sever sets of standards currently exist
    
    - DoD: TCP/IP
    - ISO: OSI model
    - Commercial: SNA, IPX, X.25, …
    - Proprietary
 
TCP/IP protocol suite  
Transmission Control Protocol/ Internet Protocol is a suite of comm protocols used to interconnect net devices on the internet

- Application Layer: SMTP, HTTP, FTP, etc
- Transport Layer: TCP, UDP
- Network Layer, IP, ICMP, IGMP
- Data Link layer: Device Drivers (ethernet, WiFi), ARP
- Physical Layer: network adapters
 
Network Transmission Media  
Data travels either on wire or wirelessly, both of which are vulnerable

- Cable
- Optical fiber
- Microwave
- Radio (wifi, satellite)

When data leaves a protected environment, others along the way can view or intercept the data

- Eavesdrop
- Wiretap
- Sniff

Transmission Control Protocol (TCP)  
Connection Oriented

- Explicit setup and tear down of TCP session

Reliable, in-order delivery

- Checksums to detect corrupted data
- Acknowledgements and retransmissions for reliable delivery
- Sequence numbers to detect losses and reorder data

Flow Control

- Prevent overflow of the receiver's buffer space
 
User Datagram Protocol (UDP)  
UDP

- IP plus port #s to support (de)multiplexing
- Optional error checking on the packet contents

No delay for connection establishment

- UDP just blasts away without any former preliminaries

Unreliable Message Delivery service  
Good for multimedia streaming
 
OSI Reference Model  
The open systems interconnection
 
Introduced in 1983 and adopted by ISO as an international standard in 1984
 
7 layers that comp systems use to comm over a network

- 1st standard model for net comm adopted in early 80s
 
OSI 7-layer model is still widely used, helps visualize and comm how networks work, and helps isolate and troubleshoot networking problems
 
Application Layer:  
Human-computer interaction layer, where apps can access the network services  
Presentation Layer:  
Ensures that data is in a usable format and is where data encryption occurs  
Session Layer:  
Maintains connections and is responsible for controlling ports and sessions  
Transport Layer:  
Transmits data using transmission protocols including TCP and UDP  
Network Layer:  
Decides which physical path the data will take  
Data Link Layer:  
Defines the format of data on the network  
Physical Layer:  
Transmits raw bit stream over the physical medium
 ![Exported image](Exported%20image%2020240525212945-0.png)  

Easier to defend an OSI system
 
Internet Control Message Protocol (ICMP)
 
Used by net devices, such as routers, to send error messages and operational info
 
Ping is a computer network admin software utility used to test the reachability of a host on the network

- Ping sends ICMP echo request packets to the target host and waiting for an ICMP Echo Reply
- The program reports errors, packet loss, and a statistical summary of the results
 
Security Attacks  
A passive attack attempts to learn or make use of info from the system but does not affect system resources

- Eg eavesdropping on, or monitoring of, transmissions to obtain info that’s being transmitted
- 2 types of passive attacks are:
    
    - The release of message contents
    - Traffic analysis

An active attack attempts to alter system resources or affect their operations

- Involve some modification of the data stream or the creation of a false stream
- ![Exported image](Exported%20image%2020240525212945-1.png)

Denial of Service (DoS)  
DoS - the prevention of authorized access to resources or the delaying of time-critical operations (may be ms or hours)
 
Denial of service ranges from complete loss of access to unacceptable slowing of service
 
**The source of a DoS attack is typically difficult to determine**
 
Video on BB presentation  
[https://www.youtube.com/watch?v=AYdF7b3nMto](https://www.youtube.com/watch?v=AYdF7b3nMto)
 
DoS attack: Ping of Death  
In ping of death attack, a flood of ping commands will be sent to the victim
 
Ping required the recipient to respond to the packet
 
If the victim has smaller bandwidth, the response to the flood of ping commands may exhaust the victim's bandwidth
 
DoS attack: SYN flood  
In SYN flood attacks, TCP packets with a spoofed source IP address request a connection to the victim's network
 
The victims network responds, but there will be no response from the source address
 
However, the victim will wait with an open connection. This will eventually overwhelm it.
 
Think of ding-dong ditching
 
Video on BB presentation
 
DoS Attack: DNS Spoofing  
A DNS is a table that converts domain names like [www.google.com](http://www.google.com) into net addresses like 211.217.174.130; this process is called resolving the domain name
 
In DNS spoofing attacks, the attacker acts as the DNS server and quickly responds to a DNS lookup request with an attacker's network address. Therefore redirect the user to malicious sites.
 
DDoS  
A DoS technique that uses numerous hosts to perform the attack  
Attackers need to:  
Plant a trojan on a target machine, and repeat with many targets. These are called zombies
 
If a victim's choses, the attacker tells all the zombies to attack the victim  
Bots & Botnets

- Zombie/bot - a compromised computer under an attackers control
- Bot code: malware installed on a bot that comms with attacker's server and performs malicious activities
- Botnets: a network of controlled bots for malicious activity
    
    - Often used to execute DDoS attacks
 
Botnets command & control  
People who infect machines are called botmasters  
Called a command-&-control center. It controls the individual bots, sends commands to the bots, such as when to start/stop and attack against which victim
 
Network encryption and protocols:
 
Warm up:  
How to protect the data while it's transferring over the network?
 
Encryption for network  
Link encryption

- Data is encrypted right before the transfer over the physical comms link and is decrypted when they arrive at the destination system
- Encryption occurs at lower levels in the network
- Link encryption protects the message in transit between 2 computers, but its in plaintext inside the hosts
 
End-To-End Encryption

- Provides security from 1 end of a transmission to the other
- Performed at the highest levels (usually at the application layer)
- Can be done by software running on the host computer
- Decryption will be done by the software on the other end

Which is better?  
Link encryption (cheaper)

- Faster
- Easier for the user
- Uses fewer keys
- Encrypts all traffic

End-to-End encryption (computationally expensive)

- More flexible
- Can be used selectively
- Done at the user level
- Can be integrated with the application
- More secure
 
Browser Encryption  
Browsers can encrypt data for protection during transmission
 
The browser and the server negotiate a common  
….
 
Secure Shell (SSH)

- Originally for UNIX, now on all
- Provides an authenticated, encrypted path to the shell over the network
- Involves negotiation between local and remote sites to agree on encryption algorithm and authentication
- Protects against spoofing attacks and modification of data in comms  
SSL and TLS

- Secure Sockets Layer (SSL) dev'd in 1990s to protect comms
- ……..
 
HTTPS (HTTP over SSL)

- Combo of HTTP and SSL
- Built into all modern web browsers
- http**s**://
 
Onion Routing

- Both link encryption and end-to-end encryption, the transferred data was secured by encryption. However, the addressing data were exposed
- Onion routing prevents an eavesdropper from learning source, destination, or content of data in transit in a network
    
    - Intermediate host that sends the message to the final destination cant determine the original sender
    - Host that received the message from the original sender cant determine ultimate destination
 
IP Addresses  
32 bit (4 byte) addressing  
4,294,967,296 total addresses  
Format: nnn.nnn.nnn.nnn, each n is a decimal digit
 
IPv6  
128 bits long (16 bytes)
 
IPSec

- IP security protocol suite
- Designed to address IPv4 drawbacks, like spoofing, eavesdropping, session hijacking
- Implemented at the IP layer
 
Goals:

- Prevent IP spoofing
- Protect integrity and/or confidentiality of packets
- Prevent replay attack
    
    - An attack that involves the capture of transmitted auth …..
- Provide sec for upper layer protocols and apps
 
IPSec modes

- Transport mode
    
    - Sec prot provided end-to-end
- Tunnel mode
    
    - Sec prot (VPN?)

VPN  
Provides secure comms tunnel between networks  
Reduces overall telecomms infrastructure, and cost of management, maintenance of equipment
 
Summary

![Exported image](Exported%20image%2020240525212945-2.png)  

Intro to network security
 
Network defense techs
 
Topics:

- Different types of firewalls and their advantages
- IDS
- Honeypots
 
Firewall - a device/program that controls the flow of network traffic between networks or hosts that employ differing security postures
 
Firewalls implement security policies, or set of rules that determine what traffic can or cannot pass thru it

![Exported image](Exported%20image%2020240525212945-3.png)  

Capabilities:

- Defines a single point to check net traffic
- Provides a location for monitoring sec events
- Logs can be used
- Provides net address translation
 
Limitations:

- Firewall can't protect traffic thru the wall
- Misconfigurations may not provide enough protection
- can't protect internal attacks
 
Types of firewalls:  
Packet filtering Gateways:

- Applies rules to each in and out IP packet
- Decisions made per-packet
- No state info saved

Stateful inspection firewalls

- Specific rules ……

Application-level gateways (proxies)

- …..

Personal/ host-based firewalls

- Controlls traffic between PC and internet
- Available in OS or add-on
- Less complex
 
Intrusion  
Unauthorized bypassing the sec mechanisms of a system  
Class of intruders:

- Cyber criminals (financial reward)
- Motivated by social or political causes
- National states
- Hackers with other motivations
 
Examples of intrusion

- Web server defacement
- Guessing passwords
- Man in the middle attack
- Copying databases with PID
- Viewing unauthorized info
- …

￼IDS  
Hardware/software product that gathers and analyzes info from various areas with in a comp or network to identify possible security breaches
 
IDS components

- Sensors (net packets, etc.)
- Analyzers
- User Interface
 
Can be effective against known, less sophisticated attacks. They are less likely to be effective against more sophisticated, targeted attacks, or 0-day exploits  
Types of IDS  
Detection method  
Signature-based  
Heuristic based  
Scope  
Host IDS  
Network IDS  
Capability  
Passive  
Active
 
Sig vs heuristic IDSs  
Sig

- Perform simple pattern matching and report situations that match known attacks

Heuristic

- Looks for unordinary behaviors
- Build a model of acceptable behavior, flag others
- Learn unacceptable behavior over time
 
HIDS vs NIDS  
HIDS

- Monitors 1 host for sus activity
- Protect 1 machine

NIDS

- Monitors net traffic and analyzes net, transport, and app protocols
- Protect whole network

Hybrid

- …
 
IPS  
Systems which detect intrusive activity and also attempt to stop the activity  
Extension of IDS
 
Honeypot

- A system or resource that’s designed to be attractive to potential crackers and has no authorized users other than its admin
- Designed to:
    
    - Lure attackers away from crit systems
    - Collect info about their activity
    - Encourage them to stay on long enough to be acted on by admin
    - ..
    - …
   
![Exported image](Exported%20image%2020240525212945-4.png)