# Blockchain and Machine Learning for Communications and Networking Systems
![[Blockchain_and_Machine_Learning_for_Communications_and_Networking_Systems.pdf]]
Highlights:

>Blockchain offers new opportunities for coordinating multiple untrustful parties and enabling decentralized governance in current networks. The main features of blockchain are summarized as follows, including decentralization, transparency, immutability, security, auditability, anonymity, and autonomy. (p. 6)

**Decentralization**: records are stored in a P2P network. No central controller -> no bottleneck from central controller

**Transparency**: Every node has access to the ledgers complete ledger, giving it credibility

**Immutability**: all records are irreversible unless one person controls >50% of voters (improbable on large networks)

**Security**: each transaction is broadcasted, checked, validated, and linked by nodes in the entire network. Any tampering is easily detected

**Auditable**:  Can iterate thru transaction history with timestamps

**Automomy**: each node sends/receives transactions independently thru consensus mechanisms and public/private key pairs

**Pseudonymity**: nodes given a pseudonym address to avoid identity exposure. Allows for use in spaces that need high privacy.
![[Pasted image 20241108115308.png]]
![[Pasted image 20241108115344.png]]
![[Pasted image 20241108115502.png]]

>Currently, there are a lot of consensus protocols being applied in blockchain systems, which could be roughly divided into consensus protocols with proof of concept (e.g., 
 - Proof of Work (PoW) [1],
 >- Proof of Stake (PoS) [72],
 - Delegated Proof of Stake (DPoS) [73],
 >- Proof of Authority (PoA) [74]) and
 - Byzantine fault-tolerant replication protocols (e.g., 
	 >- Practical Byzantine Fault Tolerance (PBFT) [75],
	 - Delegated Byzantine Fault Tolerance (dBFT) [76],
	 >- Ripple [77]) [42].
According to the different types of blockchains, consensus protocols are selected differently (p. 8)

![[Pasted image 20241108120223.png]]
public vs private vs consortium blockchains

> "the application of blockchain in communications and networking systems brings significant benefits. First, blockchain-based systems provide direct communication among users in a P2P way without relying on any intermediary agents, which reduces the communication cost and improve security and privacy. In addition, more useful data restored on blockchain could be provided over the communication networks for optimizing the network operations since the blockchain is trustworthy, secure, and cannot be tampered with. Last, the decentralization of blockchain also enables flexible management and achieves the desired level of security and trustworthiness in the future heterogeneous network connected together by 5G, satellite network, ocean-based networks (supporting networking and communications in ocean), and so on." (p. 10)

## Blockchain in IoT:
Traditional IoT:
- centralized servers
	- may suffer security attacks
	- high operational cost

Blockchain IoT:
- PoW inappropriate
	- hard puzzles
	- needs high bandwidth
	- needs lots of energy
- *LightChain* is proposed as an alternative consensus mechanism
	- multiple proof consensus
		- multiple standards & dynamic difficulty
	- reduced occupied storage

## Blockchain in Vehicular Networks:
because cars move a lot, we need security, privacy, and trust management
	allows for safe, efficient, and intelligent transportation

consortium based data sharing and storage with digital signature in Vehicular ad-hoc network (VANET) proposed
- Roadside Unit (RSU) hands out smart contracts to set data sharing conditions with vehicles
- trustless, traceable, privacy aware VANETs with "blockchain-based vehicular public key infrastructure (VPKI) to support membership establishment and privacy."

## Blockchain in Mobile Edge Computing:
essentially mobile users offload work to an edge server to do work for them??
def do external research here

##  Blockchain in wireless networks:
theres papers on blockchain in:
- computing
- fog radio access network (RAN)
- grant-free uplink access
- IoT

>Specifically, the consensus mechanism of blockchain may be applied to manage tight synchronization among networking resources in different locations.

>Blockchain could also be applied to avoid the potential collision in RAN.

^^ how?

> The authors in [110] propose a blockchain RAN (B-RAN) architecture to enable network authentication and access control in a decentralized, secure, and efficient manner among a number of trustless network entities.

>Although blockchain technique provides a feasible way to guarantee data immutability and protect user/data privacy for securing communications and networking systems. Employing blockchain mechanisms in communication networks has some 5In Stackelberg game model, one player (leader) has announces its strategy first, and then other followers make them choice accordingly. technical challenges and limitations

ie:
- how to efficiently and reliably achieve interoperability between different blockchains
- how to reduce the resource consumption and improve the management efficiency and when using blockchains

>On top of these challenges, the intelligence of blockchain in communication and networking systems is still in its infancy and requires designing a concrete consensus for the same.

![[Pasted image 20241108123609.png]]

## Open Issues, Research Challenges, and Broader Perspectives
### Open Issues & Research Challenges
#### Big Data Processing
>large data sets usually require large storage and enormous amounts of computing resources to process them. There are some issues with moving data and computing power onto blockchain

- how to store large-scale distributed data in a decentralized manner
- how to discover and use data in huge data markets
- how to incentivize consumers to share their data on blockchain

#### Scalability of Integration of Blockchain and ML Applications
>As we discussed in Section VI-B, the scalability of blockchain becomes a key bottleneck and limits various aspects, especially in communications and networking systems, where thousands of users need to be served and the network scales up fast.

> 	For instance, in the case of achieving consensus in blockchain-based IoT networks, it not only requires high computing capabilities for handling large-scale transactions but also needs to have huge storage to record these transactions.


> *Fetch* combines elements of blockchain and DAG technologies with built-in AI, a consensus mechanism, and a data architecture that “can support millions of agents transacting together”.

> the small capacity of blocks may result in huge delay for many transactions. Increasing block size will also slow down the propagation speed and lead to blockchain branches. It is difficult for handling the mass of transactions and balancing the storage size and process time

#### Security and Privacy
Blockchain still suffers attacks in the application layer.

#### Efficient Consensus Protocols:
theres ongoing work to develop more efficient consensus protocols, like
- Proof of learning
- proof of DL
- proof of training quality
- proof of useful work
- etc

#### Resource Management
need to effectively allocate and schedule resources like:
- computing resource
- storage resource
- communication resource
in underlying network

since some methods share these resources, need to coordinate and incentivize properly

maximize access control for revenue of systems and guarantee QoS of users (which can vary)

### Broader Perspectives
#### IoT

> Blockchain technology makes IoT systems more secure, private, and resilient.

#### Big Data
defined by having large:
- Volume (tera, peta, exabytes)
- Variety (unstructured, semi structured, structured data)
- Velocity (generated at a rapid pace)

in Blockchains:
> Conventional data storage systems are not capable of storing these large data at a low cost.

> Big data analysis could also be used to identify fraudulent operations on blockchain.

#### Edge Computing
edge computing -> parallel processing on blockchain consensus
MEC is a promising paradigm

> MEC operates at the edge of networks, including end devices, base stations, edge servers, and micro data centers. As compared to traditional cloud computing, Authorized licensed use limited to: Towson University. Downloaded on November 08,2024 at 16:01:39 UTC from IEEE Xplore. Restrictions apply. LIU et al.: BLOCKCHAIN AND ML FOR COMMUNICATIONS AND NETWORKING SYSTEMS 1425 MEC could significantly reduce the resource cost and energy consumption for broad applications


-----------

