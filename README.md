# galaxy-challenge
This repository is meant to test my skill to solve at "Galaxy Merchant Trading Guide" challenge by ProSpace Analytics. I used Java as primary language.

# problem description
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot). Buying and selling over the galaxy
requires you to convert numbers and units, and you decided to write a program to help you. The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them. Roman numerals are based on seven symbols:
Symbol Value  
I 1  
V 5  
X 10  
L 50  
C 100  
D 500  
M 1,000  
Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944. The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated. "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted. Only one small-value symbol may be subtracted from any large-value symbol. A number written in Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.

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

# system design solution
The flowchart as part of the system design can be seen with this link  
https://drive.google.com/open?id=1tJLaw87oA3Jn1XxHw1mAW2wn7aUbKem2

# my assumptions
- the inputs are from the file .txt that is placed inside the project that contains test input.  
- the input string are also defined by 4 different types that are placed in order. First, define the galaxy number and associate it with roman number. Then, define the credits by calculating item value with its quanity. Next, a "how much is" type of question, and lastly a "how many credits" question. 
If the input string is not matched in any of the input types above, then the program will print out an error message.  
- the inputs are galaxy number that are ranging from roman numeral I to L (based on the example input)  
- since roman numerals cannot be negative, so I will assume that the input will also be positive number.  

# instruction on how to run the program
Since the program is created using IntelliJ IDE, there are 2 types of running the program.  
with IntelliJ :  
1. Clone the repository  
2. just run the program by clicking "run" button in the toolbar  
with Command Prompt (cmd)/Terminal :  
1. Clone the repository  
2. Open the ProspaceChallenge_jar folder inside "/out/artifacts/" directory  
3. Copy the input.txt file from the root folder to the ProspaceChallenge_jar   folder.  
4. Open cmd in that folder and run "java -jar ProspaceChallenge.jar"  
