# Documentation

**Name:** Sabău Emanuela Cristina  


---

## Table of Contents

1. [Objective of the Assignment](#1-objective-of-the-assignment)
   - 1.1. [Main Objective](#11-main-objective)
   - 1.2. [Secondary Objectives](#12-secondary-objectives)
2. [Problem Analysis, Modeling, Scenarios, Use Cases](#2-problem-analysis-modeling-scenarios-use-cases)
   - 2.1. [Functional Requirements](#21-functional-requirements)
   - 2.2. [Non-functional Requirements](#22-non-functional-requirements)
   - 2.3. [Use Cases](#23-use-cases)
3. [Design](#3-design)
4. [Implementation](#4-implementation)
   - 4.1. [Implemented Classes](#41-implemented-classes)
   - 4.2. [User Interface (GUI)](#42-user-interface-gui)
5. [Results](#5-results)
6. [Conclusions](#6-conclusions)
7. [References](#7-references)

---

## 1. Objective of the Assignment

### 1.1. Main Objective

The main objective of this project is to simulate the arrival of *N* clients seeking service, who join *Q* queues, wait, are served, and finally leave the queues. The simulation also calculates the average waiting time, the average service time, and the peak hour.

### 1.2. Secondary Objectives

- Analyzing the problem and identifying the requirements  
- Designing the simulation application  
- Implementing the simulation application  
- Testing the simulation application

---

## 2. Problem Analysis, Modeling, Scenarios, Use Cases

### 2.1. Functional Requirements

- **Client Arrival and Service Simulation:**
  - The system must simulate the arrival of a specific number of clients to the queues.
  - It should simulate the service of clients by employees in the queues.
  - The system should be able to calculate the average waiting time and average service time for clients.
  
- **Queue Management:**
  - The system must allow the creation of a specified number of queues to serve the clients.
  - Clients should be added to the queues dynamically.
  - The system must allow clients to be removed from the queues once they are served.

### 2.2. Non-functional Requirements

- **Performance:**
  - The application must be able to simulate systems with a large number of clients and queues within a reasonable time.
  - The user interface must be responsive and provide fast feedback.
  
- **Reliability:**
  - The application must be robust and handle all situations correctly, including exceptions.
  - Data must be stored and manipulated securely to prevent information loss.

### 2.3. Use Cases

1. **Client Arrival Simulation:**
   - The user enters the number of clients to arrive.
   - The application generates the arrival of clients to the queues based on the specified distribution.

2. **Client Service Simulation:**
   - Employees in the queues serve the clients in the order they arrived.
   - The service time for each client is generated randomly based on the specified distribution.

3. **Calculate Average Waiting Time and Service Time:**
   - After the simulation, the application calculates the average waiting time and service time for clients.

These functional and non-functional requirements, along with the use cases, will guide the design and implementation of the queue-based simulation application.

---

## 3. Design

When the program runs, a window with the user interface appears. It includes several text fields for the user to fill in. The simulation is executed with the entered data.

![Screenshot 2025-03-02 124920](https://github.com/user-attachments/assets/97cdd9e4-2807-4b6f-8a6c-b05456f193be)


There is also a class distribution in three major packages, and UML diagrams are provided for them.

### GUI Package

This package contains the class that handles the user interface program logic.
![Screenshot 2025-03-02 124941](https://github.com/user-attachments/assets/e950ff44-7405-442a-9c66-056692a1d710)


### LOGIC Package

Here, we use an interface called *Strategy*, which defines a strategy. In our case, two strategies are used: *ConcreteStrategyTime* and *ConcreteStrategyQueue*.
![Screenshot 2025-03-02 124947](https://github.com/user-attachments/assets/038884d9-0e47-4d28-8037-7c7c1efeeecb)


### MODEL Package

This package defines the structure of a task and a server to facilitate their use in the program's logic.
![Screenshot 2025-03-02 124953](https://github.com/user-attachments/assets/4e420b84-9ed0-441a-a406-7cf7c16a9e8d)


---

## 4. Implementation

### 4.1. Implemented Classes

- **SimulationManager Class:**

  **Attributes:**
  - timeLimit: Time interval for the simulation.
  - maxProcessingTime: Maximum service time.
  - minProcessingTime: Minimum service time.
  - minArrivalTime: Minimum client arrival time.
  - maxArrivalTime: Maximum client arrival time.
  - numberOfServers: Number of available servers (queues).
  - numberOfClients: Total number of clients.
  - generatedTasks: List of tasks generated for the simulation.
  - averageWaitingTime: Average waiting time.
  - averageServiceTime: Average service time.
  - peakHour: Peak hour during the simulation period.

  **Methods:**
  - `calculateTimesFromSimulation(int serviceTime)`: Calculates the average service time.
  - `generateNRandomTasks(...)`: Generates random tasks for the simulation.
  - `calculateAverageWaitingTime()`: Calculates the average waiting time.
  - `getPeakHourFromSimulation(...)`: Retrieves the peak hour from the simulation.
  - `dispatchTasks(int currentTime)`: Distributes tasks to servers based on arrival time.
  - `run()`: Implements the `run()` method from the Runnable interface, which initiates and manages the simulation.

- **Scheduler Class:**

  **Attributes:**
  - servers: List of available servers.
  - maxNoServers: Maximum allowed number of servers.
  - maxTaskPerServer: Maximum tasks each server can handle.
  - strategy: Task distribution strategy.

  **Methods:**
  - `changeStrategy(SelectionPolicy policy)`: Changes the task distribution strategy.
  - `dispatchTask(Task t)`: Distributes a task to servers using the specified strategy.

- **Server Class:**

  **Attributes:**
  - tasks: Blocking queue of tasks for this server.
  - waitingPeriod: Total waiting period for tasks in this server.

  **Methods:**
  - `Server()`: Constructor to initialize the task queue and waiting period.
  - `addTask(Task newTask)`: Adds a task to the server's task queue.
  - `run()`: Implements the `run()` method from the Runnable interface to manage the task processing.
  - `getQueueSize()`: Retrieves the size of the server's task queue.

- **Task Class:**

  **Attributes:**
  - id: Unique identifier for the task.
  - arrivalTime: Time of arrival for the task.
  - processingTime: Time needed to process the task.

---

### 4.2. User Interface (GUI):

**Components:**
- Text fields for entering simulation parameters (number of clients, number of queues, time intervals, etc.).
- Dropdown menu to select queue selection policy.
- Button to generate and start the simulation.
- Possibly a panel to display the evolution of the queues in real-time.

**Interaction:**
- The user enters parameters and selects desired options.
- Presses the button to generate the simulation.
- The application initiates the simulation and displays results or the evolution of the queues in the user interface.

---

## 5. Results

For testing the problem, three examples were available, specifically the ones shown in the figure below.


For these examples, text files named *Test 1.txt*, *Test 2.txt*, and *Test 3.txt* were saved in the project directory.
![Screenshot 2025-03-02 124930](https://github.com/user-attachments/assets/34fbc026-797f-407d-83eb-bd28370167a0)

---

## 6. Conclusions

In completing this assignment, I learned how to work with threads. The functionality of the program depended heavily on this aspect, as it allowed us to work with multiple queues in parallel. Without using threads, this would likely have been impossible.

Regarding potential developments of the application, there are some aspects to consider, such as implementing a more interactive and intuitive user interface that provides more options for viewing simulation results and allows real-time parameter modification.

Another possible development would be optimizing the application's performance to efficiently handle a large number of clients and queues, possibly by using parallelization techniques or optimizing algorithms.

---

## 7. References

1. Concurrency - [docs.oracle.com/javase/tutorial/essential/concurrency/](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
2. Brian Goetz, Tim Peierls, Joshua Bloch, Joseph Bowbeer, David Holmes, and Doug Lea, *Java Concurrency in Practice*, Addison Wesley, Pearson Education
3. K. Sharan, *Beginning Java 8 Language Features: Lambda Expressions, Inner Classes, Threads, I/O, Collections, and Streams*, 1st Edition, APRESS, 2014
4. Java Thread Pool Example - [http://www.javacodegeeks.com](http://www.javacodegeeks.com)
