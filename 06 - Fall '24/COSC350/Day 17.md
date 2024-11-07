Midterm 2 on 11/5

"the course isnt math related, just need to understand how things work and what's available, when to use right technology, things like that"

last exam was T/F, now expect multiple choice Qs

be able to explain how sender and receiver communicate

have a clear understanding of how routers work

will be a guide for the midterm next week

send professor a data comm advanced topic not covered in textbook. Ask chatGPT for topic ideas
description of final project published later this week

-------

# Key wireless standards
![[Pasted image 20241022094015.png]]

# Spread Spectrum Techniques
- *Spread spectrum*
	- the sender spreads data across multiple frequencies
	- the receiver combines the information obtained from multiple frequencies to reproduce the original data
- Goals
	- increase overall performance
	- make transmission more *immune* to noise
- The three key multiplexing techniques used in Wi-Fi wireless networks
	- FHSS
	- DSSS
	- OFDM

![[Pasted image 20241022094237.png]]
# Other wireless standards
802.11e: improved QoS – low jitter
802.11i: enhanced security
802.11k: radio source management
802.11n: data rate over 100Mbps (multimedia)
802.11p: comm. Among  vehicles on a highway
802.11r: improved roaming capability
802.11s: proposed for mesh network
802.11ac: use of 5GHz band. Max single link of 500megabits (up to 256 QAM)
802.11ad: “WiGig” use of 60GHz, up to 7Gbps
- “microwave Wi-Fi”, ranges from 1 to 10 meters

IEEE 802.11ah and 802.11af, runs at just 900MHz and will offer very poor data speeds, but works across huge areas. While WiGig will supercharge homes, it's IEEE 802.11ah that will fuel what should probably be renamed the Wi-Fi Internet of Everything

![[Pasted image 20241022094319.png]]
#MEMORIZE which use case to which standard 
# Wireless LAN architecture
- the three building blocks:
	- *Access Points (AP)* - base station
	- an interconnection mechanism
	- a set of wireless hosts
- two types of wireless LANs are possible:
	- *Ad hoc*
	- *Infrastructure based*
- Application: AP throughout buildings

![[Pasted image 20241022094433.png]]

# Overlap, Association, and 802.11 Frame Format
- more than one access point - overlap
- area not covered by any access point - deadzone
- associate with only one access point
- for internet access - needs router's MAC address
![[Pasted image 20241022094527.png]]
- CTL: Frame control (protocol version, type, etc)
- DUR: Duration ID

![[Pasted image 20241022094555.png]]

# Contention and Contention-Free Access
- the original 802.11 standard defined 2 general approaches for channel access
	- Point Coordinated Function (PCF)
	- Distributed Coordinated Function (DCF) for contention-based service
	- BSS uses a random access protocol
- *Hidden station problem*
- 802.11 networks use CSMA/CA
	- Exchange *RTS* and *CTS* messages before transmission

- the 802.11 standard defines 3 timing parameters as follows:
- *Short Inter-Frame Space* (SIFS) of *10* (or 16 in 11n and 11ac) microseconds
	- time to wait before sending an ACK or other response
- *Distributed Inter-Frame Space* (DIFS) of *50* (or 34 in 11n and 11ac) microseconds
	- Time to idle before a station can attempt transmission
	- 2 slot time plus SIFS
- *Slot Time* of *20* (or 9 in 11a, 11n, 11ac) microseconds
![[Pasted image 20241022094925.png]]

# Wireless MAN tech and WiMax
- IEEE standard 802.16
	- fixed WiMAX - informally 802.16d
		- Doesn't provide handoff among APs (service to a fixed location)
	- Mobile WiMAX - 802.16e-2005
- Potential Usage
	- access
		- Last mile alternative to DSL or cable modem
		- as a backup for a site's Internet connection
	- Interconnect
		- Backhaul (conn. between a service provider and remote cell tower)
		- private connection (multiple sites of a company)
		- connection between small and large ISPs

- *Comparison between WiMAX and LTE*
	- WiMAX: low cost, 4G based on the IEEE 802.16, largely overtaken by LTE and 5G
	- LTE-A: backward compatible, true 4G technology (max of 1Gbps)

![[Pasted image 20241022095225.png]]

- The key features of WiMAX can be summarized as follows:
	- Uses licensed spectrum (ie offered by carriers)
	- each cell can cover a radius of *3* to *10* Km
	- uses scalable *orthogonal* FDM
	- guarantees quality of services (for voice or video)
	- can transport *70* Mbps in each direction at short distances
	- provides *10* Mbps over a long distance (*10* Km)

# PAN tech and Standards
- IEEE has assigned the number *802.15* to PAN standards
	- 802.15.1a: Bluetooth (1Mbps, 2.4GHz)
	- 802.15.2-2003: coexistance among WPANs – task group went into “hibernation”
	- 802.15.3: High rate PAN (55Mbps, 2.4GHz)
	- 802.15.3a: Ultra Wideband(UWB) (110Mbps, 2.4GHz)
	- 802.15.4: Zigbee tech – low data rate for remote
	- 802.15.4a: alternative – low power

- Bluetooth
	- short distance - usually up to 5 meters
	- device is master or slave
	- master grants permission to slave
	- data rate is up to 721Kbps
- UWB (Ultra-wide band) - PC peripherals, radar, imaging
	- wide spectrum of frequencies
	- short distance (2 to 10 meters)
	- data rate 110 Mbps at 10 meters, up to 500 at 2 meters

- *Zigbee*
	- Wireless standard for remote control, not data
	- Industry/home automation
	- 3 frequencies (*868* MHz, *915* MHz, and *2.4* GHz)
	- Data rate 20, 40, 250 Kbps
	- low power consumption
	- three levels of security
# Other Short Distance Comm. Tech
- InfraRED - wavelength longer than visible light
	- the infrared data association (IrDA) has a set of standards
		- Data rates between 2.4Kbps (control) and 16Mbps (data)
		- range of 1 to several meters
	- Military: target acquisition, surveillance, night vision
	- Civillian: remote temperature sensing, remote control

- Radio Frequency Identification (RFID) - A small tag contains ID info and a receiver can "pull" from the tag
	- over 140 RFID standards exist
	- passive RFID draw power from the signal sent by the reader
	- uses frequencies from less than 100MHz to 868-954MHz
	- Uses for inventory, sensors, passports, etc

- Radio Frequency Identification (*RFID*)
	- a small *tag* contains identification information
- some features of RFID:
	- over *140* RFID standards exist for a variety of applications
	- *Passive RFIDs* draw power from the signal sent by the reader
	- *Active RFIDs* contain a battery (last up to 10 years)
	- Limited distance
		- passive: 2ft ~ 20ft
		- active: up to 1500ft
	- Frequencies from less than *100* MHz to *858-954* MHz
	- used for inventory control, sensors, passports, and other applications

# Wireless WAN Technologies
- Wireless WAN technologies can be divided into two categories:
	- Cellular communication systems
	- Satellite communication systems

### Cellular Communication Systems
- voice services to mobile customers
	- interconnect cells to the public telephone
- cellular systems provide data services and Internet connectivity
- in terms of architecture
	- each *cell* contains a tower
	- a group of (usually adjacent) cells is connected to a *Mobile Switching Center (MSC)*
- the center tracks a mobile user
	- manages handoff

![[Pasted image 20241022100511.png]]

- Perfect cellular coverage occurs if each cell is a *hexagon*
	- the cells can be arranged in a honeycomb
	- in practice, cellular coverage is imperfect
- Most cell towers use *omnidirectional* antennas
	- transmit in a circular pattern
	- obstructions and electrical interference can attenuate a signal or cause an irregular pattern
![[Pasted image 20241022100704.png]]

# Cell Clusters and Frequency Reuse
- cellular communication follows a key principle:
	- an *adjacent pair* of cells do not use the same frequency
- To implement the principle
	- a *cluster approach*
		- a small pattern of cells
- clusters of size *3, 4, 7, and 12* that are commonly used

![[Pasted image 20241022100837.png]]

- Clusters can cover an entire area without leaving any gaps
- each cell is assigned a *unique frequency*
	- adjacent cells will not have the same frequency
- Figure 16.17 illustrates a replication of the *7-cell* cluster
![[Pasted image 20241022100938.png]]

# Generations of Cellular Technologies
- four generations in cellular technologies
	- *1G, 2G, 3G, 4G, and 5G*
	- intermediate versions: *2.5G* and *3.5G*
- 1G
	- began in the late 1970s, and extended through the 1980s
	- originally called cellular mobile radio telephones
		- used analog signals to carry voice
- 2G and 2.5G
	- Began in the early 1990s and continues to be used
	- 2G uses digital signals to carry voice
	- 2.5G
		- some 3G features
- 3G and 3.5G
	- Began in the 2000s
	- higher-speed data services
	- download rates of *400* Kbps to *2* Mbps
		- web browsing and photo sharing
	- roam across the world
- 4G
	- began around 2008 - "IMT-Advanced" by ITU-R
	- Support for real-time multimedia
	- 100Mbps while moving rapidly, 1Gbps while moving slowly
	- All-IP based mobile broadband
	- multiple connection technologies
		- Wi-Fi and satellite
- 5G
	- Peak data rate of 10Gbps but typically 100Mbps and 1Gbps
	- low latency - under 1 millisecond
	- Support 100 times more devices per square kilometer than 4G
	- Network slicing

- A variety of standards have evolved
	- the European Conference of Postal and Telecommunications Administrators selected Global System for Mobile Communications (*GSM*)
	- Motorola invented a TDMA system known as *iDEN*
	- Most US and Asian carriers adopted a CDMA approach that was standardized as *IS-95A*
	- Japan created a TDMA technology known as PDC (personal digital cellular)
![[Pasted image 20241022101554.png]]

- Basic communication mechanism
	- *General Packet Radio Service* (GPRS) for Internet access
		- for 2G and 3G GSM, packet oriented best effort, 56-114 kbps
	- *Short Message Service* (SMS) is used for texting
	- *Wireless Application Service* (WAP) is used to access Internet
		- WAP browser for cell phones, email, stocks, sports, etc
	- *Multimedia Messaging service* (MMS) is used for multi-media
- GPRS technologies evolved further (higher data rate):
	- *Enhanced Data rate for GSM Evolution* (EDGE)
		- known as Enhanced GPRS (EGPRS)
		- EDGE Evolution, 236.8 kbps
		- For any packet switched application

- *Interoperability*
	- a few key standards from 2G
	- IS-136, PDC, IS95-A, and EDGE all influenced the design of UMTS, a technology that uses *Wideband CDMA* (WCDMA)
	- IS-95B was extended to produce *CDMA 2000*
- Standards for 33G data services
	- EVDO (Evolution Data Optimized or Evolution Data Only) and EVDV
		- combined CDMA and FDM
	- High-speed downlink Packet Access (HSDPA) offers download speeds of *14* Mbps

# VSAT Satellite Technology
- the key to satellite communication is a *parabolic dish antenna*
	- Very Small Aperture Terminal (VSAT) allows 2-way satellite communication (mostly 75cm ~ 1.2m)
	- electromagnetic energy arriving from a distant satellite is reflected to a single focus point
	- by aiming the dish at a satellite (geosynchronous) and placing a detector at the focus point

![[Pasted image 20241022102317.png]]

- VSAT satellites use 3 frequency ranges that differ in
	- the strength of the signal delivered
	- the sensitivity to rain and other atmospheric conditions
	- the area of the earth's surface covered (satellite's *footprint*)
![[Pasted image 20241022102418.png]]

# GPS Satellites
- *Global Positioning System* (GPS)
	- *Navigation, location-based services (LBS)* for POI
- the key features are:
	- Accuracy between *2-20* meters
	- 24 total satellites orbit the earth
	- satellites arranges in *six* (6) orbital planes
	- provides time synchronization

- Obtaining position information
	- All GPS satellites orbit in well-known positions
		- use the distance to 3 satellites

# Software Radio and the Future of Wireless
- Special-purpose radio hardware
	- the antenna, transmitter, and receiver in a given device using predetermined frequencies

- A cell phone with GSM, Wi-Fi, and CDMA
	- must have 3 completely separate radio systems
- Traditional radios are being replaced by radios that follow a programmable paradigm
	- features are controlled by software running on a processor

![[Pasted image 20241022102935.png]]

- the key technologies:
	- *Tunable* analog filters and multiple antenna management
		- analog chips -> tunable analog filters
	- *Digital Signal Processors* (DSPs)
	- *Miltiple-Input Multiple-Output* (MIMO)
		- multiple antennas for both transmission and reception -> spatial multiplexing
	- *Universal Software Radio Peripheral* (USRP) and *GNU Radio*
		- uses software defined components such as mixers, filters, amplifiers, modulators/ demodulators, detectors, etc.


look into John Kim