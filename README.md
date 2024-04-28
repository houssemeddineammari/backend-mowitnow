# BackendMowItNow

## Overview
BackendMowItNow is a Java-based application developed by MowItNow for automating lawn mowing on rectangular surfaces.
The mower can be programmed to traverse the entirety of the surface using a simple set of commands.
It navigates a grid-like lawn, maintaining its position and orientation based on cardinal directions (N, E, S, W).

## Features
- **Automated Navigation:** The mower moves according to a sequence of instructions without human intervention.
- **Boundary Awareness:** The mower stops if it moves outside the designated lawn area, maintaining its current orientation.
- **Sequential Operation:** Multiple mowers can operate sequentially on the same lawn, each starting after the previous one has finished.

## How to Setup and Run

### Prerequisites
- Java JDK 8 minimum
- Maven

### Installation
Clone the repository to your local machine:
git clone [repository-url]
cd backendmowitnow

### Compilation
cd src/main/java
javac com/mowitnow/backendmowitnow/*.java

### Running the program
java -cp "path_to_classes_directory" com.mowitnow.backendmowitnow.MainController "path_to_input_file"