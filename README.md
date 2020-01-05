# galaxy-challenge
This repository is meant to test my skill to solve at "Galaxy Merchant Trading Guide" challenge. I used Java as primary language.

*ps: by the time I am writing this readme, I still haven't fully solve the challenge. Although I know that there are many developers that have already shared their answer/solution about this problem, but I am trying my best to not copycat their solutions even though I won't finish it in time. I know it's too naive for me to do this by myself and not relying on anybody. However, I still want to do this for the sake of my skills, integrity, and my capabilities as a professional programmer/developer. I still hope that my process will worth it in the future.

# problem description
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's
population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your
account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell
common metals and dirt (which apparently is worth a lot). Buying and selling over the galaxy
requires you to convert numbers and units, and you decided to write a program to help you.The
numbers used for intergalactic transactions follows similar convention to the roman numerals and
you have painstakingly collected the appropriate translation between them. Roman numerals are
based on seven symbols:
Symbol Value
I 1
V 5
X 10
L 50
C 100
D 500
M 1,000
Numbers are formed by combining symbols together and adding the values. For example, MMVI is
1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the
largest values. When smaller values precede larger values, the smaller values are subtracted from
the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 −
100) + (50 − 10) + (5 − 1) = 1944.
The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They
may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.)
"D", "L", and "V" can never be repeated.
"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can
be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
Only one small-value symbol may be subtracted from any large-value symbol.
A number written in Arabic numerals can be broken into digits. For example, 1903 is composed of
1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately.
In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.

# test input
glob is I
prok is V
pish is X
tegj is L 
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?

# expected output
pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about

# my pseudocode/algorithm for solving the conversion of galactic numbers to arabic numbers is
0. create global constant key-value list of roman numerals. (ex: I->1, V->5, etc)
1. if input mathes pattern "x is z" then save x with value z which is has a value of v (from the constant list of roman numerals)
2. if input matches pattern "a...z Metals is v Credits" then save the Metal name and calculate its value based on totalCredits divided by totalUnitValue (a + ... + z).
3. create a string pattern that matches "how much is ... ?" and "how many Credits is ... ?" input as question.
4. create an error handling for the questions.

# assumptions
- the inputs are from the file .txt that is placed inside the project that contains test input.
