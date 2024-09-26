exam next week
"topics we went over about definitions and understanding of equipment & transmission mode"

"all GPT based"?

![[Pasted image 20240926093208.png]]![[Pasted image 20240926093423.png]]
![[Pasted image 20240926093433.png]]
![[Pasted image 20240926093501.png]]
![[Pasted image 20240926093541.png]]
![[Pasted image 20240926093559.png]]
![[Pasted image 20240926093625.png]]
![[Pasted image 20240926093742.png]]
![[Pasted image 20240926093806.png]]

-------------
# Modulation and Modems

![[Pasted image 20240926094009.png]]

Analog Modulation Schemes
- Modulation: Changes made in a carrier
	- according to the information being sent
- modulation takes 2 inputs
	- a carrier
	- a signal
- fundamental characteristics of the wave must be changed to encode signal
- primary techniques:
	- amplitude modulation
	- frequency modulation
	- phase shift modulation

![[Pasted image 20240926094122.png]]

Amplitude Modulation (AM)
- results in the change in the amplitude of the wave

![[Pasted image 20240926094159.png]]

Frequency Modulation (FM)
- in FM, frequency changes according to the signal:
	- for stronger signal, the carrier frequency increases
	- for weaker signal, the carrier frequency decreases
- FM is more difficult to visualize
	- slight changes in frequency may not be clearly visible

![[Pasted image 20240926094313.png]]

Phase Modulation (PM)(what we use)
- one property of sine wave is its *phase*
	- *offset* is used to represent reference time from beginning
- Changes in phase are possible -> phase shift
- phase shift after cycle *k*
	- slight delay between cycle *k* completion and next sine wave
	- the delay resembles a change in frequency
- PM: A special form of frequency modulation

Amplitude Modulation and Shannon's Theorem
- the amplitude of a carrier changes based on *modulation index*
- modulation signal cannot be 0
- Shannon's Theorem
	- if noise is constant:
		- the *signal-to-noise ratio* will become 0 if the signal approaches 0
- To get high data rate:
	- the carrier wave must be near maximum
	- the signal-to-noise ratio remains as large as possible

Modulation, Digital Input, and Shift Keying
- digital schemes use discrete values
- to distinguish between analog and digital modulation
	- *shift keying* is used rather than *modulation*
- similar to analog modulation
	- digital shift keying has a fixed set instead of a continuum of possible values
	- AM allows the amplitude of a carrier to vary by arbitrarily small amounts in response to a change in the signal
		- amplitude shift keying uses a fixed set of possible amplitudes

![[Pasted image 20240926094830.png]]

Phase Shift Keying (PSK)
- Amplitude and frequency modulations require at least one cycle of a carrier wave to send a single bit
	- with an exception of a special encoding scheme
- more bits encoded in a single cycle
	- more bits can be sent per unit time
- PSK changes the phase of the carrier wave *abruptly* called a phase shift

![[Pasted image 20240926094957.png]]
Phase Shift and a Constellation Diagram
- data encoding using phase shifts
	- a sender & receiver agree on # of bits per second
	- no phase shift may denote logical 0 and presence of phase shift logical 1
- Constellation diagram
	- the exact assignment of data bits to specific phase changes
- Many variations of PSK exist
	- binary *Phase Shift Keying* (BPSK) or 2-PSK in fig 10.6
	- Notation of 2-PSK may represent 2 possible values

![[Pasted image 20240926095155.png]]

More phase shift keying
- more data rate
	- measure the amount a carrier shifted
	- can recognize sets of phase shifts
		- each phase shift can represent specific values of data
- a power of 2 possible shifts
	- a sender can use bits of data to select among the shifts
- 4 possible phase shifts in fig 10.7
	- a sender can use 2-bits of data to select among the 4-possible shift values -> 4-PSK mechanism

![[Pasted image 20240926095333.png]]

In theory, it is possible to increase the data rate by increasing the range of phase shifts
Thus, a 16-PSK mechanism can send twice as many bits per second as a 4-PSK mechanism
Limiting factors: noise and distortion

Quadrature Amplitude Modulation (What we use)
- Motivation: more data rate
- Change two characteristics of a carrier at the same time
- Combination of ASK and PSK
	- Quadrature Amplitude Modulation (QAM) or Quadrature Amplitude Shift Keying (QASK)
- QAM on a constellation diagram
	- distance from the origin as a measure of amplitude
	- Figure 10.8 shows 16QAM with dark gray areas indicating the amplitudes
	- 64QAM and 256QAM are typically used for digital cable television and cable modem applications. 
	- 256QAM delivers up to 38Mbps, Wi Fi 5 uses 256QAM and Wi-Fi 6 uses 1014QAM
	- 4096QAM is used for high speed 

![[Pasted image 20240926095506.png]]

recall bit rate of modems: 28.8 Kbps -> based on the 8000 packets we need to fully capture the 4000hz range of our voices (each of the 8000 slices take 8 bits to represent)= 64 Kbps??
	VoIP lets us achieve 4096 QAM

Modem Hardware for Modulation and Demodulation
- Carrier and a sequence of bits
	- *modulator*
	- *demodulator*
- Transmission of data requires a modulator and a demodulator
- most communication systems are *full duplex*

Modem
- Used for long-distance communication
	- contains separate circuitry for:
		- modulation of outgoing signal
		- demodulation of incoming signal
	- separate wires carry signals in each direction
	- modulator on one modem connects to demodulator on another

![[Pasted image 20240926100229.png]]

Optical and radio frequency modems
- can be used with other media
	- *Radio Frequency (RF)
	- *optical fibers*
- a pair of RF modems over radio
- a pair of optical modems over optical fibers
- regardless of media, the principle remains the same:
	- modulates a carrier signal with data
	- data is extracted from the modulated carrier

![[Pasted image 20240926100400.png]]
![[Pasted image 20240926100406.png]]

QAM applied to Dialup
- QAM is used with dialup modems for maximized data rate
- available frequencies between 300 and 3300 Hz
- the *extremes* may not be handled well
	- use frequencies between *600* and *3000* Hz
	- the available bandwidth becomes *2400* Hz
- A QAM scheme can increase the data rate dramatically

![[Pasted image 20240926100600.png]]
splitters split high frequency and voice frequency
	lets you use devices and talk on the same wire by segregating their signals

V.32 and V.32bis Dialup Modems
- consider the V.32 and V.32bis standards
- 10.12 and 10.13 illustrate QAM constellation for:
	- a V.32 modem: 32 combinations of ASK and PSK
		- a data rate of 9600 bps in each direction
	- A V.32bis modem: 128 combinations of ASK and PSK
		- a data rate of 14,400 bps in each direction
- Sophisticated signal analysis may be needed to reveal the minor change

![[Pasted image 20240926100849.png]]
![[Pasted image 20240926100856.png]]
![[Pasted image 20240926100902.png]]
Modem application - Cable networks
- Cable networks nowadays provide combined TV and data service using hybrid fiber coax (HFC) cabling architecture
- Trunk coaxial cable of legacy networks are replaced by fibers that terminate in fiber nodes
- Homes are connected to fiber nodes through coaxial cables fitted with bidirectional amplifiers.
- Traditional cable networks were targeted at TV distribution (one-way) and are not suited for 2-way data service – data upstream was provided by dial-up phone but proved not a viable solution.
- Digital signaling, two-way amplifiers on coax cables and fiber trunks with greatly increased capacity were introduced in the course of upgrading. Two-way cable networks provide an ‘extended Ethernet’ network that can span up to 100 miles.

we still have COAX to each residential network

![[Pasted image 20240926101001.png]]
![[Pasted image 20240926101007.png]]
- DOCSIS 3.0 (2006)
	- downstream data rate of 160Mbps or higher
		- channel bonding
		- 4 or more channels
		- 256 QAM => ~40 Mbps
		- 8x256 QAM => ~320 Mbps
	- upstream data rates of 120 Mbps or higher
		- 64 QAM => ~30 Mbps
		- 4x64 QAM => ~120 Mbps
- DOCSIS 4.0 (2020)
	- Downstream data rate of 10 Gbps
		- channel bonding
		- 4 or more channels
		- 4096 QAM
	- Upstream data rates of 6 Gbps

-------------

