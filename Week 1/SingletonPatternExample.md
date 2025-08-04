Singleton Pattern Example
This project demonstrates the Singleton design pattern in Java. The purpose of the Singleton pattern is to ensure that a class has only one instance and to provide a single, global point of access to it.

Description
This example implements a Logger class that can only be instantiated once. This is a common use case for services like logging, configuration management, or connection pools, where a single, coordinated point of control is required throughout an application.

The implementation is thread-safe using a technique called double-checked locking. This approach ensures the pattern works correctly in multi-threaded environments while avoiding the performance cost of unnecessary synchronization.

Files in this Project
Logger.java: The Singleton class. It features a private constructor and a public static method, getInstance(), to control the single instantiation.

SingletonTest.java: A test class to verify the pattern. It requests the Logger instance multiple times and confirms that the same object is returned each time by comparing their memory addresses.

How to Run
Save the two files (Logger.java and SingletonTest.java) in the same directory.

Open a terminal or command prompt and navigate to that directory.

Compile the Java files:

javac Logger.java SingletonTest.java

Run the test program:

java SingletonTest

The output will clearly show that the "Logger instance created" message appears only once, and the verification check will confirm that both variables point to the identical object.