---
aliases:
  - Data Communications
  - Networking
  - COSC350 11-19-2024
tags:
  - "#COSC350"
cssclasses:
---
From: [[2024/11/19]]

---
# Day 24 (11-19-2024)

Data Tour day!
heres some questions to ask:

# Ethernet & Cabling
1. What types of Ethernet (e.g., 10G, 40G, 100G) are used in this data center? How do you decide which to deploy?
2. What cabling standards are used (CAT6, CAT7, fiber optic) and why?
3. How do you handle cable management to ensure airflow and reduce signal interference?
4. Are there plans to upgrade to newer Ethernet standards? What challenges would that pose?

# Network Redundancy and Failover
5. How is network redundancy managed here? Is there a multi-path network configuration for failover?
6. How do you minimize downtime in case of a network failover?
7. What mechanisms are in place to detect and respond to network congestion or bottlenecks?

# Network Security
8. What network security protocols (e.g., firewall, intrusion detection) are in place?
9. How do you monitor and protect the network against DDoS attacks?
10. Is network segmentation used to enhance security? How are sensitive or critical systems protected?

# Wi-Fi
11. How is Wi-Fi deployed in a data center, given the need for low interference and high security?
12. What steps are taken to ensure reliable Wi-Fi coverage for administrative tasks or visitor access?
13. How do you address Wi-Fi signal interference caused by dense server racks and other equipment?

# Data Transmission and Latency
14. What methods are used to reduce latency for critical applications?
15. Are there specific protocols or configurations that optimize data transmission efficiency?
16. How do you handle Quality of Service (QoS) for high-priority traffic within the network?

# Network Monitoring and Management
17. What tools or software are used for real-time network monitoring and management?
18. How often is network performance reviewed and optimized?
19. What strategies do you use for identifying and diagnosing network issues?

# Power and Cooling Impacts on Networking
20. How does cooling infrastructure impact network cabling and layout?
21. What are the power requirements for networking equipment, and how is power redundancy managed?

# Future-Proofing and Scalability
22. What challenges do you face with scaling network capacity as the data-center grows?
23. How are emerging technologies (e.g., 400G Ethernet, software-defined networking) considered for future upgrades?


-----------

# Recall:
TU Datacenter tour and group homework Assignment

when we go there, behave
next Tuesday, meet in the basement of Cook library

divide this class into 2 groups
	groups 1, 2, 3 meet at 9:30
	groups 4, 5, 6 meet at 10:00

## What to Submit
- Summary of your findings
- list of equipment with specification
- diagram for the equipment location and used technology
- Storage and web server - equipment and IP addressing scheme (e.g., how to handle large network traffic), security related techniques (how it works)

## Grading factors
- Number of attendees and make sure there is no late comers
- Quality of the report
	- how well your report describes what we have in the Datacenter
	- Specification and functionality
	- Must be neatly organized - font, size, layout, etc.
-  Quality of questions during the tour
		- Not necessarily the number of questions but must show the willingness to learn

- Total points assigned: 2. Exceptional report may get extra credit up to 5 additional points


| Group Name | Task                      | Details                                                                  |
| ---------- | ------------------------- | ------------------------------------------------------------------------ |
| 4          | TU Backbone architecture  | Equipment, cable, speed, location                                        |
| 3 (us!!)   | Networking technologies   | Ethernet, wi-fi, etc (interactions between equipment), software as well? |
| 1          | Network Equipment         | Inside and outside of buildings                                          |
| 6          | Router/backup router      | USM (University System Maryland) interface, type, capacity, brand, etc.  |
|            | IP address structure      | Public, private                                                          |
| 5          | Cloud Storage, web server | Capacity, speed, backup...                                               |
