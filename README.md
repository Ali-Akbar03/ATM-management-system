# ATM-management-system
# ATM Management System in Java

A simple console-based ATM management system implemented in Java, demonstrating core Object-Oriented Programming (OOP) concepts such as encapsulation, abstraction, and modularity.

---

## Features

- Secure user authentication with PIN validation  
- Check account balance  
- Deposit money  
- Withdraw money with balance validation  
- View transaction history with timestamps  

---

## System Design Overview

The system is designed using the following main classes:

| Class Name     | Responsibility                          |
|----------------|---------------------------------------|
| `BankAccount`  | Holds account details and manages balance operations  |
| `User`         | Represents the user and associates with a bank account |
| `Transaction`  | Records each deposit or withdrawal with timestamp       |
| `ATM`          | Handles user interaction and transaction processing     |
| `ATMSystem`    | Main application entry point with `main` method         |

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or above installed  
- Terminal or command prompt access  

### How to Run

1. Clone the repository or download the source code files.  
2. Open terminal/command prompt and navigate to the project directory.  
3. Compile the program using:  
   ```bash
   javac ATMSystem.java
