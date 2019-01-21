Code is written in Java

File to compile and execute - Main.java
1.When u compile this file you will find this output to enter the commands

Please enter 'exit' to quit
Waiting for input...

input command : create_parking_lot 6
output        : Created a parking lot with 6 slots

input command : park KA-01-HH-1234 White
output        : Allocated slot number: 1

input command : park KA-01-HH-9999 White
output        : Allocated slot number: 2

input command : park KA-01-BB-0001 Black
output        : Allocated slot number: 3

input command : park KA-01-HH-7777 Red
output        : Allocated slot number: 4

input command : park KA-01-HH-2701 Blue
output        : Allocated slot number: 5

input command : park KA-01-HH-3141 Black
output        : Allocated slot number: 6

input command : leave 4
output        : Slot number 4 is free

input command : status
output        :  Slot No.	Registration No. 	Colour
					1		KA-01-HH-1234		White
					2		KA-01-HH-9999		White
					3	    KA-01-BB-0001		Black
					5		KA-01-HH-2701		Blue
					6		KA-01-HH-3141		Black


We can give command line inputs here

2.While compiling the file we can give the file path as the commands input file

javac Main.java input_file.txt

Unit tests are written using Junit


All the parking lot methods are in parkingLot.java
Mapping of commands and method name is done in InputCommands.java
