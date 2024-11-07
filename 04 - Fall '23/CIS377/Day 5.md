Quiz 5 + HW 5 up
 
FINAL PROJECT  
Due 11/29/23  
Includes a paper AND slides
 
Topic selection

Email the topic selection details

2. Groups of 3
    
    1. Names of everyone in the group
    2. If cant get a group, see teacher
3. Topic selection
    
    1. Relevant topic to cybersecurity
    2. Explain the relevancy
4. Project Scope
    
    1. What are you investigating/studying
5. Apstract paragraph
    
    1. What and why are you investigating/studying? This is a summary of what you are investigating, why its relevant to cyber, and what are the contributions that your project will add to the current state-of-the-art.

PAPER  
8-10 pages  
Excluding references  
No large images/tables  
50 references  
A minimum of 50 references  
Thoroughly read the literature to understand the state-of-the-art  
Only scholarly articles (journal articles, conference proceedings, dissertations, and reports).  
Wikipedia = auto 0 lol  
Plagiarism will not be tolerated  
Because the final project is 25% of the grade, any plagiarism will result in an automatic failure of the class.
 
Presentation

1. 10 minute presentation
    
    1. Going under/over the 10 minutes will cost points
2. Followed by a 5 minute QA
    
    1. Be prepared to answer queestions from other students as
    2. Inability to answer questions regarding your topics will cost points. This is meant to expand your knowledge on your topic, not simply copy pasting some facts from different articles
 
RUBRIC

|   |   |
|---|---|
|IEEE format|10%|
|Intro and motivation|10%|
|Thorough related literature review (what has and hasn't been done).|30%|
|Comparison of different approaches|10%|
|Lessons learned|10%|
|Challenges and perspectives|20%|
|Properly written abstract and conclusion|5%|
|Properly formatted references|5%|
 
Use Overleaf for references?  
Use EndNote 20 for word?  
Or mendeley?  
Just a LaTeX editor?
 
IEEE is single spaced, double columned?
 
Final exam on 12/18 10:15-12:15  
Comprehensive
 
Midterm online, 2 weeks from now  
Everything either from book or from slides
 
Open notes, but don’t google  
Just control-F forehead
 
Average in the entire class last semester was an 86
 
-------------------------------------------------------------------------------------------------------------------------------
 
The following are some common network attacks:

1. DoS
2. DDoS
3. MitM
4. Syn Flood
5. Network Sniffing
6. Spoofing
7. Ping of Death   

Short for Denial of Service, is a form of attack where a server is overwhelmed by bogus requests, preventing legitimate users from access to the server's resources.  
Short for Distributed Denial of Service, a form of DoS where a server is flooded by attacks from several machines at once  
Occurs when an illegitimate user interrupts the communication between a server and a client in order to steal important info or redirect the traffic  
An attacker sends multiple SYN packets to a server, but doesn’t respond to the SYN/ACK, keeping the server busy  
Listening to traffic on a network. Lets an attacker learn about a network in order to attack it  
Impersonating a trusted user in order to get access to a network system  
When an attacker sends a request, such as an IP packet, that is ill-formed
   

Web/application attacks/vulnerabilities

1. buffer overflow
2. Cross-site Scripting (XSS)
3. SQL '
4. XML Injection
5. Active X
6. Java Applet and Javascript

Occurs when an application receives more input than it can handle or a different input from what its expecting...  
A web based attack to inject scripts into a webpage viewed by a user. This could contain malicious codes or access cookies with sensitive info  
Reflected XSS and Stored XSS  
A database attack that occurs when an attacker manipulates a query entered into a database thru a web page. If the input is improperly validated by the database it could result in the attacker getting access to sensitive info on the database  
Developed by Microsoft to let users play multimedia content directly from a browser  
Downloaded to user's hard drive and could be accessed again by an active process..  
A code that runs from the browser. May be used to perform malicious operations like executing malicious codes on a vulnerable system
 
Port Scanning and 0-day attacks  
Most common type of scans  
Ping scan – block ICMP port 53  
Connect scan – common but easily detected  
SYN scan – stealthy only send SYN/ACK and don’t respond  
FIN scan – connection finished target
 
Rootkit – a collection of tools used to cover-up an intrusion that gains administrative (root level) access with utilities to:

- …
- ….
- …
 
Human Centered Attacks

- These types of attacks have something to do with human interaction
    
    - Social engineering
    - Email attacks
        
        - Phishing
            
            - Spear phishing
            - Whaling
        - Spam
    - Tailgating
    - Dumpster diving
    - Shoulder surfing
 
Social Engineering  
People are the weakest link  
Social engineering is the art of manipulating people so they give up confidential info
 
SPAM

- Unsolicited email
- Productivity drain
- Sometimes illegitimate
- Resources bogged down
- TIME!
 
Watering Hole Attack

- Injecting malicious code into the public Web visit
- Attackers compromise websites within a specific sector that are ordinary visited by specific individuals of interest for the attackers
- …
 
Wireless Attacks

- Wireless Replay Attack
- WPS attacks
- Wireless jamming
- Rogue Access points/Evil Twin
- War driving/ War chalking
- Bluetooth attacks
    
    - Bluesnarfing – theft thru intercepting bluetooth connection
    - Bluejacking – sending unwanted messages over bluetooth
- Mobile phone attacks
    
    - Vishing – phone form of phishing
    - Smishing – uses text messages to lure people with phone # or URL
 
CYBER-KILL CHAIN  
ON MIDTERM!!!
 
1. Reconnaissance  
Research, ID, and selection of targets

1. Weaponization
2. Delivery
3. Exploitation
4. Installation
5. Command & Control
6. Actions on Objective

Pairing remote access malware with exploit into a delvierable payload (eg Adobe PDF and Microsoft Office files)  
Transmission of weapon to target (eg via email attachments, websites, or USB drives)  
Once delivered, the weapon's code is triggered, exploiting vulnerable...
   

Originally published by Lockheed Martin as part of the Intelligence Driven Defense model  
For the ID and prevention of cyber intrusions activity  
Identifies what the adversaries must complete...
 
Thanks to this, stopping attackers at ANY step breaks the chain of attack  
Adversaries must completely progress thru all phases for success  
We, the defenders, just need to block them at any stage for success  
The earlier the better  
A better understanding of adversaries...
   

Recon

- Target selection
- ID of org details
- Industry-vertical-legislative requirements
- Info on tech choices, social network activity or mailing lists
- The adversary is trying to answer:
    
    - Which attack methods work …
    - …

A recon attack:

- …
- …
- …
 
Types of recon attacks:

- Passive
    
    - Looks for info not related to victim domain
- Active
    
    - Uses system info to gain unauthorized access to protected digital materials, and may go around routers or even firewalls to get it
 
The goal of recon is to identify weak points of the target
 
|   |   |
|---|---|
|Network Info||
|Host Info||
|Sec policies||
|Human info||
 
Adversary:  
In the planning phase. Trying to understand which targets enable them to meet objective  
Defender:  
Detecting recon as it happens can be v difficult, but when defenders discover recon – even whell after the fact...
 
Weaponization

- Threat actor develops malware specifically crafted to the vulnerabilities discovered during the recon phase
- Based on intel gathered, attacker tailors their toolset to meet the requirements of target network
 
Delivery

- Transmitting APT code to target system
 
Exploitation

- APT malware code is executed on target network thru remote/ local mechanisms...
 
Installation

- APT malware code installs itself...
 
C&C

- APT lets attacker do what he wants...
 
Actions on Obj

- Mission specific
- Can be stealing PII
- Can be destruction