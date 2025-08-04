Financial Forecasting with Recursion (Java Version)
This project demonstrates how to use recursion to develop a financial forecasting tool that predicts the future value of an investment based on a constant growth rate, implemented in Java.

Description
The script provides two implementations for calculating future value:

A naive recursive function.

An optimized recursive function using memoization (a form of dynamic programming).

By running the script, you can see the call stack of a recursive function and understand how memoization can be used to store and reuse results.

Files in this Project
FinancialForecasting.java: The main Java file containing the forecasting logic and the main method for demonstration.

How to Run
Save the code as FinancialForecasting.java.

Open a terminal or command prompt.

Navigate to the directory where you saved the file.

Compile the Java code:

javac FinancialForecasting.java

Run the compiled program:

java FinancialForecasting

Concepts Covered
Recursion: A function solves a problem by calling itself with a smaller version of the problem until it reaches a simple "base case."

Time Complexity: The naive recursive solution has a time complexity of O(n), where n is the number of periods.

Memoization: The optimized solution introduces memoization using a HashMap to cache the results of function calls. This avoids redundant computations and is a crucial technique for more complex recursive algorithms where subproblems overlap.