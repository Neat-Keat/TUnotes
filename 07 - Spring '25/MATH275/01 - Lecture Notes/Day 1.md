---
aliases:
  - Calc
  - Calculus III
  - MATH275 01-28-2025
  - Calc III
  - Calc 3
tags:
  - MATH275
  - Syllabus
  - 3DCoordinateSystems
  - Vectors
cssclasses:
---
From: [[2025/01/28]]

------
# Day 1 ([[01-28-2025]]) 

Sub lecturer first week

# Syllabus
Tuesdays we meet here, Thursdays, in a different room
Tu in YR 128
Th in YR 217

instructor email: jtian@towson.edu
instructor office: YR 335

Office Hours: Tu/Th 2pm-3pm or by appointment

first week guy:
zhengzhang@towson.edu, YR 362, M/W 3:30-4:30

> what is difficult about calc III is that you need to visualize what's going on
> if you can visualize it its very easy


# Textbook
The Stewart's Calculus, Early Transcendentals (9th edition)

# Topics
- 3D space
- Partial Derivatives
- Multiple Integrals (double AND triple)
- Vector Calculus

# Grading
| A: x>= 93%        | C+: 77% <=  x < 80% |
| ----------------- | ------------------- |
| A-: 90% <= x <93% | C: 70% <= x < 70%   |
| B+: 87% ≤ x < 90% | D+: 67% ≤ x <70%    |
| B: 83% ≤ x < 87%  | D: 60% ≤ x <67%     |
| B-: 80% ≤ x < 83% |  F: x < 60%         |
Two midterms:
	- higher = 25%
	- lower = 15%
HW/ Quizzes: 20%
Lab 10%
Final 30%

HW through WebAssign, no late submissions

lowest 2 HW/quiz grades will be dropped

Exam 1: March 6th
Exam 2: April 10th (CONFLICTS WITH OLD LINE!!)

# Resources
- Towson tutoring offered, but not super helpful for calc III?
- Paul's online notes

----------

# (12.1) 3D Coordinate System


## Surface
2D: an equation involving x,y represents a curve
3D an equation involving x, y, z represents a surface

![[Pasted image 20250128114311.png]]
![[Pasted image 20250128114332.png]]
![[Pasted image 20250128114345.png]]
![[Pasted image 20250128114356.png]]
## Distance
Given $$P({x_1}, {y_1}, {z_1})$$ and $$ Q({x_2}, {y_2}, {z_2})$$
the distance between the two points is calculated as: $$|PQ| = \sqrt{(x_2 - x_1)^2+ (y_2 - y_1)^2 + (z_2 - z_1)^2}$$
## Equation of a sphere
Given
- a center (a,b,c)
- a radius r
the equation for a sphere at center (a,b,c) with radius r is:
$$(x-a)^2 + (y-b)^2 + (z-c)^2 = r^2 $$
# (12.2) Vectors
A vector is a mathematical object with 2 components:
- Direction
- Magnitude (length)

NOTE! $$ 0 \neq \overrightarrow{0}$$
NOTE!
Location of a vector does NOT matter

Examples:
- Force
- Velocity
- Displacement
- Acceleration
## Combining Vectors
Parallelogram law
Triangle law

## Multiplications
given a number $\alpha$ & a vector $\overrightarrow{v}$,
	then $\alpha \overrightarrow{v}$ is a ==vector== who's length is |$\alpha$| times the length of $\overrightarrow{v}$.
	if $\alpha$ > 0, then the direction of $\alpha \overrightarrow{v}$ is the same direction of $\overrightarrow{v}$.
	if $\alpha$ < 0, then the direction of $\alpha \overrightarrow{v}$ is the opposite direction of $\overrightarrow{v}$.
	
$$\overrightarrow{v} - \overrightarrow{u} = \overrightarrow{v} + -\overrightarrow{u}$$
if the head of a vector is connected to the tail of another vector:
	connect the tail of the first to the head of the second!
	called the triangle rule!
## Components of a vector

given head A($x_1,y_1, z_1$) and tail B($x_2,y_2, z_2$)
$$\overrightarrow{AB} = < x_2 - x_1, y_2-y_1, z_2-z_1>$$

Vector length:
given $$\overrightarrow{v} = <a,b,c>$$
v's length = $$ |\overrightarrow {v}| = \sqrt{a^2+b^2+c^2}$$
ex. find the vector represented by the line segment with A(2,-3,4), B(-2,1,1)
	$$
	\overrightarrow{AB} = < (-2) - 2, 1 - (-3), 1-4>
	$$
	$$
	\overrightarrow{AB} - < -4,4,-3>
	$$

## Adding 2 vectors
given $\overrightarrow{u} = <a,b,c>$ and $\overrightarrow{v} = <d,e,f>$:
$$\overrightarrow{u} +\overrightarrow{v} = <a+d, b+e, c+f> $$
$$\overrightarrow{u} -\overrightarrow{v} = <a-d, b-e, c-f> $$
given a constant c:
$$c\overrightarrow{v} = <cd, ce, cf>$$ 
ex
given $\overrightarrow{u}$ = < 4, 0, 3>, $\overrightarrow{v}$ = < -2, 1, 5>
$$\overrightarrow{u}+\overrightarrow{v} = <2,1,8>$$
$$2\overrightarrow{u} + 5\overrightarrow{v} = < 8+(-10), 0 + 5, 6+25>$$ $$= < -2,5,31>$$
## Properties of vectors
1. $\overrightarrow{u}$ + $\overrightarrow{v}$ = $\overrightarrow{v}$ + $\overrightarrow{u}$
2. c($\overrightarrow{u}$ + $\overrightarrow{v}$)= c$\overrightarrow{u}$ + c$\overrightarrow{v}$
3. (a+b)$\overrightarrow{v}$ = a$\overrightarrow{v}$ + b$\overrightarrow{v}$
4. 0 * $\overrightarrow{v}$ = $\overrightarrow{0}$
## 3 special vectors

$\overrightarrow{i}$ = <1,0,0>
$\overrightarrow{j}$ = <0,1,0>
$\overrightarrow{k}$ = <0,0,1>
