![Visitors](https://komarev.com/ghpvc/?username=jmdb9mk67v-beep&repo=Lam_Java_2&color=0066cc)

# 🍱 Lunch Order Tracker - Chef Lamsey's LUNCHBOX
### triOS College - Java Development Assignment #2

A robust, console-based order management system built with **Java**. This application simulates a real-world cafeteria environment, allowing users to manage a stack of digital "Lunch tickets" using object-oriented principles.

## 🚀 Features
* **Dynamic Order Entry:** Capture customer names, main items, quantities, and custom pricing.
* **Blueprint Architecture:** Utilizes a `Lunchbox` class (POJO) with full encapsulation (private fields, getters/setters).
* **Smart Receipt System:** Includes custom logic to translate raw boolean data into human-readable "Yes/No" delivery statuses.
* **SecureRandom Rewards:** Automatically assigns a random dessert (from Newton Fig Bars to Peach Cobblers) to every new order.
* **Financial Tracking:** Real-time calculation of grand totals across all active orders.

## 🛠️ Tech Stack
* **Language:** Java 21
* **Tools:** Scanner (Input handling), SecureRandom (Logic randomization), PrintStream (Formatted console UI).
* **Version Control:** Git/GitHub.

## 🏗️ Architecture
The project follows a strict **Separation of Concerns**:
1. **`LunchBox.java`**: The Data Model. Handles the state of an individual order, math for costs, and the logic for displaying individual receipts.
2. **`Lunch.java`**: The Driver Class. Manages the main application loop, the array of objects, and user interactions via the terminal.

## 📝 Key Learnings
* **Object Instantiation:** Moving from simple variables to an array of custom objects (`LunchBox[]`).
* **Control Flow:** Mastering `switch` statements and `break;` logic to prevent "fall-through" bugs.
* **Data Translation:** Implementing `if/else` logic within display methods to improve User Experience (UX).
* **Platform Independence:** Using `%n` in formatted strings to ensure the app runs smoothly across different Operating Systems.

---

### How to Run
1. Clone this repository.
2. Compile the files:
   ```bash
   javac *.java
