Factory Method Pattern Example
This project is a practical demonstration of the Factory Method design pattern in Java. The pattern provides a way to create objects without specifying the exact class of the object that will be created.

Scenario
Imagine a document management system that needs to handle different file types like Word, PDF, and Excel. Using the Factory Method pattern, we can add new document types in the future without changing the existing code that uses the documents. This makes the system more maintainable and scalable.

Files in this Project
You can save all the Java classes from the code blocks above into their respective .java files in the same directory.

Document.java: The interface that all document types must implement.

WordDocument.java, PdfDocument.java, ExcelDocument.java: Concrete implementations of different document types.

DocumentFactory.java: The abstract factory class that defines the createDocument() method.

WordDocumentFactory.java, PdfDocumentFactory.java, ExcelDocumentFactory.java: Concrete factories that know how to create a specific type of document.

FactoryMethodPatternExample.java: The main class that shows how to use the factories to create documents.

How to Run
Save all the Java classes into their corresponding .java files in a single folder.

Open a terminal or command prompt and navigate to that folder.

Compile all the Java files. A simple way to do this is:

javac *.java

Run the main test program:

java FactoryMethodPatternExample

The output will show that different document types are being created and used, each instantiated by its specific factory.