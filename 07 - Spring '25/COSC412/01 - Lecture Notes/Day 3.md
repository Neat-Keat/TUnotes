---
aliases:
  - SWEN
  - Software Engineering
  - COSC412 02-03-2025
tags:
  - COSC412
  - COSC412/SoftwareProcessAndProcessModels
  - COSC412/CH2
cssclasses:
---
From: [[2025/02/03]]

------
# Day 3 ([[02-03-2025]]) 

# Ch. 2: Software Process and Process Models

![[Chp2 Process and Process Models.pdf]]
> The day I release the teams is the day i go over the project guidelines for the 1st sprint

![[Pasted image 20250203110225.png]]
 we'll be looking at the general templates and procedures we follow in SWEN and their corresponding process models

last class the main motivator to continue to develop was the customer's changing needs

![[Pasted image 20250203110402.png]]
> first steps are identifying components you need, and how those components line up with team member's strengths

![[Pasted image 20250203110612.png]]

We need to define every step in the process so that different people don't make different assumptions

![[Pasted image 20250203110806.png]]
requires you to come up with activities and tasks and assigning tasks to members while planning each component including documentation

Framework Activities: The mandatory things you need to do regardless of model

Umbrella Activities: Support tools that you use to support the Framework activities

![[Pasted image 20250203111022.png]]
Activity is the highest level of granularity

not bothering with application domain, project size, different complexities, etc

identifying high level features, components, etc

![[Pasted image 20250203111155.png]]

actions are integrated into activities

one of the actions would be making an architectural model

more defined than activities

![[Pasted image 20250203111316.png]]

ex.
1. build the frontend components
	1. character assets
	2. level design
	3. UI
	4. etc
2. Build the backend components
	1. ...
	2. ...

![[Pasted image 20250203111508.png]]

![[Pasted image 20250203111531.png]]
also called requirements gathering
	understanding customer's needs
	understanding working restrictions
	etc

![[Pasted image 20250203111621.png]]

making a workflow based on gathered info and restrictions

the next 3 stages are the core of SWEN:
![[Pasted image 20250203111705.png]]

#MEMORIZE 
	1. Communication
	2. Planning
	3. Modeling
	4. Construction
	5. Deployment

in this class we'll be using UML diagrams lol

these 5 framework activities **ABSOLUTELY** need to be present

![[Pasted image 20250203112000.png]]

## Umbrella Activities

![[Pasted image 20250203112030.png]]
measurement is reviewing current resources and the timeline and axing features you cant finish in time or negotiating for more time/ resources

reusability management:
	how can we reuse existing code to save time?
	how can we design new code to be reused later?

work product prep and production:
	what you do before putting your code into production
	checking everything
	reviewing documentation
	etc

the importance of each umbrella activity varies based on the nature of your product

#MEMORIZE 
	framework activities: mandatory
	umbrella activities: auxilliary

![[Pasted image 20250203112751.png]]
well defined vs flexible
	WD - hits everything you want it to
	flexible - has a buffer to adapt to changing requirements from customers, engineers

think of how different developing a fire alarm system vs developing a video game would be

![[Pasted image 20250203112900.png]]
![[Pasted image 20250203113250.png]]
work bottom-up!

![[Pasted image 20250203113844.png]]

![[Pasted image 20250203113924.png]]
![[Pasted image 20250203113941.png]]
choose a process flow that's appropriate to the situation you find yourself in.

it is possible to mix and match parts of multiple process flows!

#MEMORIZE be able to identify which process model is most applicable to a given scenario

![[Pasted image 20250203114500.png]]

## Waterfall Model

![[Pasted image 20250203114812.png]]
originally introduced in a manufacturing environment

![[Pasted image 20250203114842.png]]
kind of sucks for scenarios where stuff changes a lot
leads to stagnation

mistakes later on in the model cost more time, because you have to go back to requirements each time you want to change an earlier step

mostly useful for projects with simple tasks, like a metronome
	usually used for safety critical systems, like a fire alarm

![[Pasted image 20250203115328.png]]
![[Pasted image 20250203115338.png]]
![[Pasted image 20250203115344.png]]
making an early commitment to the waterfall method has customers asking for too many features bc they may not know exactly what they want.

The model also doesn't really allow for real time feedback from customers.


![[Pasted image 20250203115351.png]]
![[Pasted image 20250203115357.png]]
a combination of linear and iterative
think of embedded systems!