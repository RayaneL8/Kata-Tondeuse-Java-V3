# Kata Tondeuse – Java / Maven

## Overview

This repository contains an implementation of the **Mower Kata**, written in Java with a clean architecture and JUnit 5 tests.  
The solution was developed following a **Test-Driven Development (TDD)** approach to ensure correctness and maintainability of the domain logic.
It reads an input file describing lawn dimensions and mower instructions, then simulates the final positions of all mowers.

## Building

You can build or run the project using Maven:

```bash
mvn clean package
```
Run the program with the sample input file:

```bash
java -cp target/kata-tondeuse-1.0-SNAPSHOT.jar com.github.rayanel8.kata.tondeuse.Main src/main/resources/input.txt
```

If no argument is provided, the program will try to load "input.txt" from the root.
