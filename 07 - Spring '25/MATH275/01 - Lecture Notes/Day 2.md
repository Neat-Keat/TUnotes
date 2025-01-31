---
aliases:
  - Calc
  - Calculus III
  - MATH275 01-30-2025
  - Calc III
  - Calc 3
tags:
  - MATH275
cssclasses:
---
From: [[2025/01/30]]

------
# Day 2 ([[01-30-2025]]) 

today: multiplications of vectors

last time: we introduced vectors
	vectors have 2 components:
	1. direction
	2. magnitude

expressing a vector in 2D space:
	$\overrightarrow{v}$ = <a,b>
expressing a vector in 3D space:
	$\overrightarrow{v}$ =<a,b,c>

let $\alpha$ be a number
	$\alpha$$\overrightarrow{v}$ = < $\alpha a, \alpha b, \alpha c$>


# Multiplication of vectors
2 different types
1. Dot Product
2. Cross Product


### Dot Product
in 2D:
	given $\overrightarrow{u}$ = <$a_1,b_1$> & $\overrightarrow{v}$ = <$a_2,b_2$>
		$\overrightarrow{u}$ * $\overrightarrow{v}$ = $a_1a_2 + b_1b_2$
	geometrically:
		$\overrightarrow{u}$ * $\overrightarrow{v}$ = |$\overrightarrow{u}$||$\overrightarrow{v}$|$\cos(\theta)$

in 3d:
	given  $\overrightarrow{u}$ = <$a_1,b_1,c_1$> &  $\overrightarrow{v}$ = <$a_2,b_2, c_2$>
		$\overrightarrow{u}$ * $\overrightarrow{v}$ = $a_1a_2 + b_1b_2 + c_1c_2$
	geometrically:
		$\overrightarrow{u}$ * $\overrightarrow{v}$ = |$\overrightarrow{u}$||$\overrightarrow{v}$|$\cos(\theta)$

ex.
$\overrightarrow{u}$ = <2,4,5>, $\overrightarrow{v}$ = <1,2,-6>
	$\overrightarrow{u}$ * $\overrightarrow{v}$ = 2(1) + 4*2 + 5 (-6)
	= 2+8-30
	= -20

supose $\overrightarrow{u}$$\perp$$\overrightarrow{v}$
$\implies$$\overrightarrow{u}$ * $\overrightarrow{v}$ = 0

in 2D:
	suppose $\overrightarrow{op}$ = <1,2> and $\overrightarrow{oq}$ = <4,1>, find $\theta$ between them
	$\overrightarrow{op}$ * $\overrightarrow{oq}$ = (1 * 4) + (2 * 1)	= 6
		|$\overrightarrow{op}$| = $\sqrt{1^2 + 2^2}$ = $\sqrt5$
		|$\overrightarrow{oq}$| = $\sqrt{4^2 + 1^2}$ = $\sqrt{17}$
	by definition $\overrightarrow{op}$ * $\overrightarrow{oq}$ = |$\overrightarrow{op}$||$\overrightarrow{oq}$|*$\cos{\theta}$
		6 = $\sqrt5$$\sqrt{17}$*$\cos{\theta}$
		$\theta$ = $\arccos({6/\sqrt5 * \sqrt{17}})$

extends to 3D just as you'd expect

>think geometrically, write algebraically

#### Finding the determinant of 2 * 2 matrix
$$
det 
\begin{bmatrix}  
a & b \\
c & d  
\end{bmatrix}
= ad - bc
$$
#### Finding the determinant of 3 * 3 matrix
$$
det
\begin{bmatrix}  
a & b & c\\  
d & e & f\\
g & h & i 
\end{bmatrix}
= a * det
\begin{bmatrix}  
e & f \\
h & i  
\end{bmatrix} - b * det \begin{bmatrix}  
d & f \\
g & i  
\end{bmatrix} + c * det \begin{bmatrix}  
d & e \\
g & h  
\end{bmatrix}
$$

ex
$$
det
\begin{bmatrix}  
1 & 2 & 3\\  
4 & 5 & 6\\
7 & 8 & 9 
\end{bmatrix}
= 1 * det
\begin{bmatrix}  
5 & 6 \\
8 & 9  
\end{bmatrix} - 2 * det \begin{bmatrix}  
4 & 6 \\
7 & 9  
\end{bmatrix} + 3 * det \begin{bmatrix}  
4 & 5 \\
7 & 8  
\end{bmatrix}
$$
$$= 1 * (5 * 9 - 8 * 6) - 2 (4 * 9 - 7 * 6) + 3 * (4 * 8 - 7 * 5)$$
$$ = 1 * (45 - 48) - 2 * (36 - 42) + 3 * (32 - 35)$$
$$ = 1 * (-3) - 2 * (-6) + 3 * (-3)$$
$$ = -3 + 12 - 9$$
$$ \fbox{= 0}$$
### Cross Product
in 3D space only!!

recall our 3 special vectors:
	$\overrightarrow{i}$ = <1,0,0>
	$\overrightarrow{j}$ = <0,1,0>
	$\overrightarrow{k}$ = <0,0,1>

suppose you have 2 vectors
	$\overrightarrow{u}$ = <$a_1,b_1,c_1$>
	$\overrightarrow{v}$ = <$a_2,b_2,c_2$>

Algebraic way to solve:
$$\overrightarrow{u} * \overrightarrow{v} = det
\begin{bmatrix}  
\overrightarrow{i} & \overrightarrow{j} & \overrightarrow{k}\\  
a_1 & b_1 & c_1\\
a_2 & b_2 & c_2 
\end{bmatrix}
= \overrightarrow{i} * det
\begin{bmatrix}  
b_1 & c_1 \\
b_2 & c_2  
\end{bmatrix} - \overrightarrow{j} * det \begin{bmatrix}  
a_1 & c_1 \\
a_2 & c_2  
\end{bmatrix} + \overrightarrow{k} * det \begin{bmatrix}  
a_1 & b_1 \\
a_2 & b_2  
\end{bmatrix}
$$
1. ==$\overrightarrow{u}$ * $\overrightarrow{v}$ is vector!!!== 

ex.
	$\overrightarrow{u}$ = <4,0,1>
	$\overrightarrow{v}$ = <2,-1,0>
	$\overrightarrow{u}$ * $\overrightarrow{v}$

$$= \overrightarrow{u} * \overrightarrow{v} = det
\begin{bmatrix}  
\overrightarrow{i} & \overrightarrow{j} & \overrightarrow{k}\\  
4 & 0 & 1\\
2 & -1 & 0 
\end{bmatrix}
= \overrightarrow{i} * det
\begin{bmatrix}  
0 & 1 \\
-1 & 0  
\end{bmatrix} - \overrightarrow{j} * det \begin{bmatrix}  
4 & 1 \\
2 & 0  
\end{bmatrix} + \overrightarrow{k} * det \begin{bmatrix}  
4 & 0 \\
2 & -1  
\end{bmatrix}
$$
$$
= \overrightarrow{i} * (0 * 0 - 1 * (-1)) - \overrightarrow{j} * (4 * 0 - 2 * 1) + \overrightarrow{k} * (4 * -1 - 2 * 0)
$$


Geometric way to solve

$$|\overrightarrow{u} * \overrightarrow{v}| = |\overrightarrow{u}||\overrightarrow{v}| \sin\theta$$
= area of the parallelogram formed by $\overrightarrow{u}$ and $\overrightarrow{u}$

The cross product of $\overrightarrow{u}$ * $\overrightarrow{v}$ is orthogonal to the parallelogram formed by $\overrightarrow{u}$ and $\overrightarrow{v}$ 

note that each plane has 2 sides, one pointing "up" and one pointing "down"
$\overrightarrow{u}$ x $\overrightarrow{v}$ is orthogonal to the plane containing $\overrightarrow{u}$ and $\overrightarrow{v}$ (normal vector)

Right hand rule:
![[Pasted image 20250130122718.png]]

NOTE: $$\overrightarrow{u} * \overrightarrow{v} = - \overrightarrow{v} * \overrightarrow{u}$$

ex
in 3D
	given
		A = (-3,2,5)
		B = (2,-1,0)
		C = (1,0,1)
	find the area of $\triangle$ABC
strategy is to find the cross product (ie area of parallelogram) of |$\overrightarrow{AB} * \overrightarrow{AC}$, then divide by 2 to get $\triangle$ABC
	$\overrightarrow{AB}$ = <5,-3,-5> (by head - tail)
	$\overrightarrow{AC}$ = <4,-2,-4>
$$det
\begin{bmatrix}  
\overrightarrow{i} & \overrightarrow{j} & \overrightarrow{k}\\  
5 & -3 & -5\\
4 & -2 & -4 
\end{bmatrix}
= \overrightarrow{i} * det
\begin{bmatrix}  
-3 & -5 \\
-2 & -4  
\end{bmatrix} - \overrightarrow{j} * det \begin{bmatrix}  
5 & -5 \\
4 & -4  
\end{bmatrix} + \overrightarrow{k} * det \begin{bmatrix}  
5 & -3 \\
4 & -2  
\end{bmatrix}
$$
$$
= \overrightarrow{i}(12-10) - \overrightarrow{j}(-20-(-20))+ \overrightarrow{k}(-10+12)
$$
$$
\overrightarrow{i}(2) - \overrightarrow{j}(0)+ \overrightarrow{k}(2)
$$
$$
<2,0,2> \text{(this is the vector orthogonal to the plane)}
$$
$$
|\overrightarrow{AB} * \overrightarrow{AC}| = \sqrt{2^2 + 2^2} = \sqrt{8} =\text{parallelogram}
$$
$$
\triangle ABC \text{area} = \sqrt{8}/2
$$
$$
\fbox{$\sqrt{2}$} 
$$
