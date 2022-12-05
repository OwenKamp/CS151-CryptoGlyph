# Project Title: CryptoGlyph

### Group Number
1

### Group Members: 
Cian Kelly, David Warshawsky, Owen Kamp

### Team Members working on the proposal and their contributions:
Cian Kelly:
- [x] Created Class Diagram
- [x] Created State Diagram
- [x] Contributed evenly to readme file


David Warshawsky:
- [x] Created Timing Diagram
- [x] Contributed to Class Diagram
- [x] Contributed evenly to readme file


Owen Kamp:
- [x] Created Use Case Diagram
- [x] Contributed evenly to readme file

### Team Members working on the project presentation and their contributions:
Cian Kelly:
- [x] Created the entire Powerpoint Presentation.

### Team Members working on the project and report and their contributions:
Cian Kelly:
- [x] Version one of graphical interface - implemented a minimum viable product
- [x] A5/1 Algorithm
- [x] Caesar's Cipher
- [x] Conversion Class
- [x] Unit testing for implemented algorithms
- [x] Wrote the report itself for the project

David Warshawsky:
- [x] Knapsack Algorithm
- [x] Version two of graphical interface - improved structure of existing code
- [x] Implemented inheritance through NewGUI extending JFrame meanwhile AlgorithmScreen and AlgorithmOptions extend ComponentScreen
- [x] Created Navigation MVC. Controller is encrypt/decrypt button. Model is cryptographyWindow. View is the AlgorithmScreen
- [x] Unit testing for Knapsack
- [x] Helped others understand overflow issues emerging
- [x] Made the diagrams for the report

## Problems / Issues:
Our main issue with this project was the conversion of data to alternate formats. Cryptographic algorithms require data to be converted between Hexadecimal, Binary and Decimal. Within these bases there was also the problem of converting data between int, long, byte, String etc. Implementing this successfully proved difficult for group members.
Other problems arose during the creation of the GUI due to the limitations of the Java Swing framework. Some of these were resolved but others weren't as they required use of a different framework.
Generating prime numbers and choosing a subset of them such as to avoid an overflow also proved difficult. 

## The problem we want to resolve:
Our program will hope to encrypt and decrypt messages. All messages given and returned will be strings. Conversion of these strings into alternate formats (like images) will be up to the users. We want to create a program capable of being used both as a standalone program, and as something easily implemented into other projects. This means that we will have a GUI, but it will be something that interacts with the core code just as any other project would.


## Previous works we draw inspiration from:
Kleopatra is a certificate manager and GUI for GnuPG. The software stores your OpenPGP certificates and keys, and allows you to encrypt and decrypt data using them. Within the application, you can also generate new key pairs.


## Assumptions:
Messages to be encrypted or decrypted will be in string form. Keys (if applicable) will also be in string form. 
  
Operating environments: For this project, we intend to employ the use of a Java web app. The users can then access the web app to encrypt and decrypt data.
  
Intended usage: Encrypting and decrypting strings, expected to be used in messaging apps, or sending private data through a public space.

## Diagrams:

Diagrams
|--------------------------------------------------|
|[**State Diagram: "CrytoGlyph State Diagram.pdf"**](https://github.com/OwenKamp/CS151-CryptoGlyph/blob/main/diagrams/CryptoGlyph%20State%20Diagram.pdf) | 
|This state diagram shows the process the program goes through when the user is interacting with it. There are two types of encryption algorithms thatreceive input and based on whether or not the proper input is placed to complete the computation, it will continue or go backwards.|
|[**Class Diagram: "CryptoGlyph UML Diagram.html"**](https://github.com/OwenKamp/CS151-CryptoGlyph/blob/main/diagrams/CryptoGlyph%20UML%20Diagram.html) |
|The class diagram shows the relationships that exist between the different classes of cryptography. We employed the use of multilevel inheritance in this project. We also created utility classes which are used by some of the cryptographic algorithms. |
|[**Use Case Diagram: "Use Case Diagram.pdf"**](https://github.com/OwenKamp/CS151-CryptoGlyph/blob/main/diagrams/Use%20Case%20Diagram.pdf)      |
|This use case diagram shows at a high level how the users interact with the program. The user interacts with the gui and a developer interacts with the methods that are public to them to decrypt and encrypt using different algorithms.|
|[**Timing Diagram: "timing diagram.pdf"**](https://github.com/OwenKamp/CS151-CryptoGlyph/blob/main/diagrams/timing%20diagram.pdf)|
|This timing diagram shows the flow of components interacted with by the user. What order the user goes in to achieve the desired computation of encryption.|

## Functionality:
All users will be able to feed information, such as messages and keys, into the machine, to which it will return either the encrypted or decrypted version of the original message. Programmers will be able to access the methods and classes directly, to make implementation into other projects easier.
Please cite us in your work.


## Operations:
Users can first select a category of algorithms; symmetric or asymmetric. They are then able to select an algorithm from the category they have chosen. Upon selection, the user will then be able to encrypt and decrypt strings with valid keys.

## Solution:


## Steps to run code:
1. Be running openjdk version "14" 2020-03-17 and OpenJDK Runtime Environment (build 14+36-1461)
2. Change to the **src** directory.
3. Run **javac NewGUI.java**
4. Run **java NewGUI**



## Snapshot of running program:


References:
[1]https://www.openpgp.org/software/kleopatra/