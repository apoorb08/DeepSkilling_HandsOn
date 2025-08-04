E-commerce Platform Search Function (Java Version)
This project demonstrates and compares two fundamental search algorithms, Linear Search and Binary Search, in the context of an e-commerce platform using Java.

Description
The program defines a Product class and then implements both search algorithms in the ECommerceSearch class to find products by their productId. It runs several examples to show the step-by-step process of each search and highlights the performance differences between them.

Files in this Project
ECommerceSearch.java: The main Java file containing the Product class, search algorithms, and the main method for demonstration.

How to Run
Save the code as ECommerceSearch.java.

Open a terminal or command prompt.

Navigate to the directory where you saved the file.

Compile the Java code:

javac ECommerceSearch.java

Run the compiled program:

java ECommerceSearch

Concepts Covered
Big O Notation: The program helps visualize the difference between O(n) (Linear Search) and O(log n) (Binary Search) complexity by printing the number of steps taken for each search.

Linear Search: A simple algorithm that iterates through a list from start to finish. It does not require the data to be sorted.

Binary Search: A highly efficient algorithm that works on sorted data. It repeatedly divides the search interval in half to quickly narrow down the location of the target item.

Java Collections & Comparators: The code demonstrates the use of ArrayList to store objects and a Comparator to sort the list based on an object's attribute (productId).